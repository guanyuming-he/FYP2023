/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.CodeBlock;
import edu.guanyfyp.format.CommentBlock;
import edu.guanyfyp.format.FormatToken;
import edu.guanyfyp.format.WsBlock;

/**
 * Tests the SourceFile class.
 */
class TestSourceFile 
{
	
/////////////////////////////// Lines ////////////////////////////
	
	/**
	 * Creates a new SourceFile, but calls JUnit's fail()
	 * if the creation fails.
	 * @return the SourceFile created, or null if the creation fails.
	 */
	SourceFile createSourceFileNoError(String file_path) 
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

	/**
	 * Tests if the source file constructor can get the number of lines right
	 * when in the source code there is no empty line (i.e. lines of only line terminators).
	 */
	@Test
	void testCtorLinesNoEmptyLine() 
	{
		final String file_path_1 = "test_data/no_empty_lines1.txt";
		final String file_path_2 = "test_data/no_empty_lines2.txt";
		var s1 = createSourceFileNoError(file_path_1);
		var s2 = createSourceFileNoError(file_path_2);
		
		assertEquals(4, s1.__test_get_format_tokens().size());
		assertEquals(9, s2.__test_get_format_tokens().size());
	}
	
	/**
	 * Tests if the source file constructor can get the number of lines right
	 * when in the source code there are some empty lines (i.e. lines of only line terminators).
	 */
	@Test
	void testCtorLinesEmptyLines() 
	{
		final String file_path_1 = "test_data/empty_lines1.txt";
		var s1 = createSourceFileNoError(file_path_1);
		final String file_path_2 = "test_data/empty_lines2.txt";
		var s2 = createSourceFileNoError(file_path_2);
		
		// Nothing. The file is empty
		assertEquals(1, s1.__test_get_format_tokens().size());
		assertTrue(s1.__test_get_format_tokens().get(0).isEmpty());
		// Some lines...
		assertEquals(16, s2.__test_get_format_tokens().size());
	}

/////////////////////////////// Tokens ////////////////////////////
	
	/**
	 * Tells if the tokens in the line are expected.
	 * @param expected line of expected tokens.
	 * @param actual line of actual tokens.
	 * @return true iff each token in actual returns true on calling its __test_equals()
	 * with the token at the same index in expected.
	 */
	boolean tokenLineEquals(List<FormatToken> expected, List<FormatToken> actual) 
	{
		if (expected.size() != actual.size()) {
			return false;
		}
		
		for (int i = 0; i < expected.size(); ++i) {
			if(!expected.get(i).__test_equals(actual.get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Convenient method to do this asserting procedural.
	 * It asserts the two lines of tokens contains exactly the same lines of same tokens.
	 * @param expected
	 * @param actual
	 */
	void assertTokenLinesEqual
	(
		ArrayList<ArrayList<FormatToken>> expected, 
		ArrayList<ArrayList<FormatToken>> actual
	) 
	{
		assertEquals
		(
			expected.size(), actual.size(), 
			"The two token lines have different number of lines."
		);
		
		for(int i = 0; i < expected.size(); ++i) {
			assertTrue(tokenLineEquals
			(
				expected.get(i), actual.get(i)),
				"The two token lines at " + Integer.toString(i+1) +
				" do not contain the same tokens."
			);
		}
	}
	
	/**
	 * Tests if the source file constructor can get each token's information right.
	 */
	@Test
	void testCtorTokens() 
	{
		final String file_path_1 = "test_data/no_empty_lines1.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.__test_get_format_tokens();
		ArrayList<ArrayList<FormatToken>> expected_tokens = new ArrayList<>();
		{
			ArrayList<FormatToken> line1 = new ArrayList<>();
			line1.add(new CommentBlock("// ABC", 0, 0, 1, 0));
			expected_tokens.add(line1);
		}
		{
			ArrayList<FormatToken> line2 = new ArrayList<>();
			line2.add(new CodeBlock("public", 0, 0, 2, 0));
			line2.add(new WsBlock(" ", 6, 6, 2, 1));
			line2.add(new CodeBlock("class", 7, 7, 2, 2));
			line2.add(new WsBlock(" ", 12, 12, 2, 3));
			line2.add(new CodeBlock("ABC", 13, 13, 2, 4));
			line2.add(new WsBlock(" ", 16, 16, 2, 5));
			line2.add(new CodeBlock("{", 17, 17, 2, 6));
			expected_tokens.add(line2);
		}
		{
			ArrayList<FormatToken> line3 = new ArrayList<>();
			line3.add(new WsBlock("    ", 0, 0, 3, 0));
			line3.add(new CodeBlock("int", 4, 4, 3, 1));
			line3.add(new WsBlock(" ", 7, 7, 3, 2));
			line3.add(new CodeBlock("abc", 8, 8, 3, 3));
			line3.add(new WsBlock(" ", 11, 11, 3, 4));
			line3.add(new CodeBlock("=", 12, 12, 3, 5));
			line3.add(new WsBlock(" ", 13, 13, 3, 6));
			line3.add(new CodeBlock("1", 14, 14, 3, 7));
			line3.add(new CodeBlock(";", 15, 15, 3, 8));
			expected_tokens.add(line3);
		}
		{
			ArrayList<FormatToken> line4 = new ArrayList<>();
			line4.add(new CodeBlock("}", 0, 0, 4, 0));
			expected_tokens.add(line4);
		}
		
		assertTokenLinesEqual(expected_tokens, s1_tokens);		
	}
}
