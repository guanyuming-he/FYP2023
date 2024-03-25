/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.FormatPrimitive;
import edu.guanyfyp.format.primitives.FormatToken;
import edu.guanyfyp.format.primitives.Line;
import edu.guanyfyp.format.primitives.PrimitiveContext;
import edu.guanyfyp.syntax.SyntaxScope;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * This class contains utilities and helper methods for all the tests.
 */
public final class TestUtils 
{
	
/////////////////////////////// SourceFile's FormatToken Testing Helpers ////////////////////////////
	
	public static final class FormatTokenTestProperties
	{
		public FormatTokenTestProperties
		(
			Class<?> type,
			String characters,
			int visualPos,
			int actualPos,
			int line,
			int indexInLine
		)
		{
			this.type = type;
			this.characters = characters;
			this.visualPos = visualPos;
			this.actualPos = actualPos;
			this.line = line;
			this.indexInLine = indexInLine;
		}
		
		// Type of the format token.
		final Class<?> type;
		final String characters;
		final int visualPos;
		final int actualPos;
		final int line;
		final int indexInLine;
		
		/**
		 * Used to test if the properties of a FormatToken are all expected.
		 * visualLength and numCharacters are not tested here, because they are calculated from characters.
		 * And the calculations are tested individually.
		 * 
		 * @param t
		 * @return true iff
		 * type.isInstance(t) &&
					  this.characters.equals(t.characters()) &&
					  this.visualPos == t.visualPos &&
					  this.actualPos == t.actualPos() &&
					  this.line == t.line() &&
					  this.indexInLine == t.indexInLine;
		 */
		public boolean formatTokenEquals
		(
			FormatToken t
		)
		{
			return type.isInstance(t) &&
					  this.characters.equals(t.characters()) &&
					  this.visualPos == t.visualPos &&
					  this.actualPos == t.actualPos() &&
					  this.line == t.line() &&
					  this.indexInLine == t.indexInLine;
		}
	}
	
	/**
	 * Asserts that the tokens in the line are expected.
	 * @param expected line of expected tokens.
	 * @param actual line of actual tokens.
	 */
	public static void assertTokenLineEquals
	(
		List<FormatTokenTestProperties> expected, List<FormatToken> actual,
		int line_number // For assertion information only
	) 
	{
		// Use fail() instead of assertTrue/Equals() here
		// So that I can place a break point on the fail()
		// After the condition check failed.
		
		if (expected.size() != actual.size()) {
			fail("\"The lines at \" + Integer.toString(line_number) +\r\n"
					+ "				\" contain different number of tokens.\"");
		}
		
		for (int i = 0; i < expected.size(); ++i) {
			if(!expected.get(i).formatTokenEquals(actual.get(i)))
			{
				fail("The two tokens do not match");
			}
		}
	}
	
	/**
	 * Convenient method to do this asserting procedural.
	 * It asserts the two lines of tokens contains exactly the same lines of same tokens.
	 * @param expected
	 * @param actual
	 */
	public static void assertTokenLinesEqual
	(
		ArrayList<ArrayList<FormatTokenTestProperties>> expected, 
		List<List<FormatToken>> actual
	) 
	{
		assertEquals
		(
			expected.size(), actual.size(), 
			"The two token lines have different number of lines."
		);
		
		for(int i = 0; i < expected.size(); ++i) {
			assertTokenLineEquals
			(
				expected.get(i), actual.get(i),
				i+1
			);
		}
	}
	
/////////////////////////////// SourceFile's Line Testing Helpers ////////////////////////////
	/**
	 * Asserts that the lines formed by the expected tokens are equal to s's lines
	 * @param expectedTokenProperties
	 * @param s the source file
	 */
	public static void assertLinesEquals
	(
		ArrayList<ArrayList<FormatTokenTestProperties>> expectedTokenProperties,
		SourceFile s
	)
	{
		var actual_lines = s.getLines();
		
		// create the expected lines
		List<Line> expected_lines = new ArrayList<Line>();
		for (int i = 0; i < expectedTokenProperties.size(); ++i)
		{
			var prop_line = expectedTokenProperties.get(i);
			if(prop_line.isEmpty())
			{
				expected_lines.add(new Line(i+1, null, null, s));
			}
			else
			{
				var token_line = s.getFormatTokens().get(i);
				
				assertEquals(prop_line.size(), token_line.size());
				
				expected_lines.add(new Line(i+1, token_line.get(0), token_line.get(prop_line.size()-1), s));
			}
		}
		
		assertEquals(expected_lines, actual_lines);
	}
	
	
/////////////////////////////// SourceFile Testing Helpers ////////////////////////////	

	/**
	 * Creates a new SourceFile, but calls JUnit's fail()
	 * if the creation fails.
	 * @return the SourceFile created, or null if the creation fails.
	 */
	public static SourceFile createSourceFileNoError(String file_path) 
	{	
		SourceFile s = null;
		try {
			s = new SourceFile(file_path);
		} catch (UnsupportedOperationException e) {
			fail("The source contains no syntax error yet the ctor says otherwise.");
		} catch (IOException e) {
			fail("Could not open the source file.");
		}
		return s;
	}

/////////////////////////////// FormatPrimitive Evaluation Testing Helpers ////////////////////////////	
	/**
	 * Convenient helper that calls p.evaluateFormat with necessary arguments.
	 * Also, it prevents reevaluation as some tokens are used by more than one tests.
	 * @param c
	 */
	public static void evalPrimitiveOnlyOnce(FormatPrimitive p, SourceFile sf, SyntaxStructure ss)
	{
		if(!p.isEvaluated())
		{
			var ctx = new PrimitiveContext(ss.getSyntaxContext(p));
			p.evaluateFormat(sf, ctx);
			// Must be true now.
			assert(p.isEvaluated());
		}
	}
	
/////////////////////////////// SyntaxScope Testing Helpers ////////////////////////////
	
	/**
	 * Asserts that s.startToken and s.endToken are those indicated by the arguments
	 * @param src the sourcefile where the scope is in.
	 * @param s the syntax scope
	 * @param stl line number of the expected start token
	 * @param sti index in the line of the expected start token
	 * @param etl line number of the expected end token
	 * @param eti index in the line of the expected end token
	 */
	public static void assertSyntaxScopeLocation(SourceFile src, SyntaxScope s, int stl, int sti, int etl, int eti)
	{
		assertEquals(src.getFormatToken(stl, sti), s.startToken, "Should have the start token right");
		assertEquals(src.getFormatToken(etl, eti), s.endToken, "Should have the end token right");
	}
}
