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
import edu.guanyfyp.format.FormatToken;

/**
 * This class contains utilities and helper methods for all the tests.
 */
public final class TestUtils 
{
	
/////////////////////////////// FormatToken Testing Helpers ////////////////////////////
	
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
}
