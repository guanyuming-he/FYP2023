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
import edu.guanyfyp.format.JavaDocCommentBlock;
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
		
		assertEquals(4, s1.get_format_tokens().size());
		assertEquals(9, s2.get_format_tokens().size());
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
		assertEquals(1, s1.get_format_tokens().size());
		assertTrue(s1.get_format_tokens().get(0).isEmpty());
		// Some lines...
		assertEquals(16, s2.get_format_tokens().size());
	}

/////////////////////////////// Tokens ////////////////////////////
	
	/**
	 * Tells if the tokens in the line are expected.
	 * @param expected line of expected tokens.
	 * @param actual line of actual tokens.
	 */
	void assertTokenLineEquals
	(
		List<FormatToken> expected, List<FormatToken> actual,
		int line_number // For assertion information only
	) 
	{
		if (expected.size() != actual.size()) {
			assertTrue
			(
				false, 
				"The lines at " + Integer.toString(line_number) +
				" contain different number of tokens."
			);
		}
		
		for (int i = 0; i < expected.size(); ++i) {
			assertTrue
			(
				expected.get(i).__test_equals(actual.get(i)),
				"Tokens at index " + Integer.toString(i) + " differ," +
				" in line " + Integer.toString(line_number)
			);
		}
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
	
	/**
	 * Tests if the source file constructor can get each token's information right.
	 * From a file of minimal tokens.
	 */
	@Test
	void testCtorTokensMinimal() 
	{
		// This file has a few lines.
		final String file_path_1 = "test_data/no_empty_lines1.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.get_format_tokens();
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
	
	/**
	 * 
	 */
	@Test
	void testCtorTokensComplete()
	{
		// This file has a bit of everything.
		final String file_path_2 = "test_data/mixture1.txt";
		var s2 = createSourceFileNoError(file_path_2);
		
		var s2_tokens = s2.get_format_tokens();
		ArrayList<ArrayList<FormatToken>> expected_tokens = new ArrayList<>();
		{
			ArrayList<FormatToken> line1 = new ArrayList<>();
			line1.add
			(new JavaDocCommentBlock
				(
					"/**\r\n"
					+ " * Has a bit of everything.\r\n"
					+ " * @author Guanyuming He\r\n"
					+ " */", 
					0, 0, 1, 0
				)
			);
			// Empty lines. 2--4 are resulted by the multi-line comment.
			// 5 is just an empty line.
			ArrayList<FormatToken> line2 = new ArrayList<>();
			ArrayList<FormatToken> line3 = new ArrayList<>();
			ArrayList<FormatToken> line4 = new ArrayList<>();
			ArrayList<FormatToken> line5 = new ArrayList<>();
			
			expected_tokens.add(line1);
			expected_tokens.add(line2);
			expected_tokens.add(line3);
			expected_tokens.add(line4);
			expected_tokens.add(line5);
		}
		{
			int i = 0;
			ArrayList<FormatToken> line6 = new ArrayList<>();
			line6.add(new CodeBlock("package", 0, 0, 6, i++));
			line6.add(new WsBlock(" ", 7, 7, 6, i++));
			line6.add(new CodeBlock("edu", 8, 8, 6, i++));
			line6.add(new CodeBlock(".", 11, 11, 6, i++));
			line6.add(new CodeBlock("xjtlu", 12, 12, 6, i++));
			line6.add(new CodeBlock(".", 17, 17, 6, i++));
			line6.add(new CodeBlock("guany", 18, 18, 6, i++));
			line6.add(new CodeBlock(";", 23, 23, 6, i++));
			
			ArrayList<FormatToken> line7 = new ArrayList<>();
			
			ArrayList<FormatToken> line8 = new ArrayList<>();
			i = 0;
			line8.add(new CodeBlock("import", 0, 0, 8, i++));
			line8.add(new WsBlock(" ", 6, 6, 8, i++));
			line8.add(new CodeBlock("java", 7, 7, 8, i++));
			line8.add(new CodeBlock(".", 11, 11, 8, i++));
			line8.add(new CodeBlock("io", 12, 12, 8, i++));
			line8.add(new CodeBlock(".", 14, 14, 8, i++));
			line8.add(new CodeBlock("IOException", 15, 15, 8, i++));
			line8.add(new CodeBlock(";", 26, 26, 8, i++));
			
			ArrayList<FormatToken> line9 = new ArrayList<>();
			i = 0;
			line9.add(new CodeBlock("import", 0, 0, 9, i++));
			line9.add(new WsBlock(" ", 6, 6, 9, i++));
			line9.add(new CodeBlock("java", 7, 7, 9, i++));
			line9.add(new CodeBlock(".", 11, 11, 9, i++));
			line9.add(new CodeBlock("util", 12, 12, 9, i++));
			line9.add(new CodeBlock(".", 16, 16, 9, i++));
			line9.add(new CodeBlock("List", 17, 17, 9, i++));
			line9.add(new CodeBlock(";", 21, 21, 9, i++));
			
			ArrayList<FormatToken> line10 = new ArrayList<>();
			
			expected_tokens.add(line6);
			expected_tokens.add(line7);
			expected_tokens.add(line8);
			expected_tokens.add(line9);
			expected_tokens.add(line10);	
		}
		{
			ArrayList<FormatToken> line11 = new ArrayList<>();
			line11.add
			(new JavaDocCommentBlock
				(
					"/**\r\n"
					+ " * Some comments for the class.\r\n"
					+ " */", 
					0, 0, 11, 0
				)
			);
			// Empty lines that are resulted by the multi-line comment.
			ArrayList<FormatToken> line12 = new ArrayList<>();
			ArrayList<FormatToken> line13 = new ArrayList<>();
			
			expected_tokens.add(line11);
			expected_tokens.add(line12);
			expected_tokens.add(line13);
		}
		{
			ArrayList<FormatToken> line14 = new ArrayList<>();
			int i = 0;
			line14.add(new CodeBlock("public", 0, 0, 14, i++));
			line14.add(new WsBlock(" ", 6, 6, 14, i++));
			line14.add(new CodeBlock("class", 7, 7, 14, i++));
			line14.add(new WsBlock(" ", 12, 12, 14, i++));
			line14.add(new CodeBlock("MixtureClass", 13, 13, 14, i++));
			line14.add(new WsBlock(" ", 25, 25, 14, i++));
			line14.add(new CodeBlock("extends", 26, 26, 14, i++));
			line14.add(new WsBlock(" ", 33, 33, 14, i++));
			line14.add(new CodeBlock("ABC", 34, 34, 14, i++));
			line14.add(new WsBlock(" ", 37, 37, 14, i++));
			
			ArrayList<FormatToken> line15 = new ArrayList<>();
			line15.add(new CodeBlock("{", 0, 0, 15, 0));
			// Note that here I deliberately put a tab in the empty line.
			ArrayList<FormatToken> line16 = new ArrayList<>();
			line16.add(new WsBlock("\t", 0, 0, 16, 0));
			
			expected_tokens.add(line14);
			expected_tokens.add(line15);
			expected_tokens.add(line16);
		}
		{
			ArrayList<FormatToken> line17 = new ArrayList<>();
			line17.add(new WsBlock("\t", 0, 0, 17, 0));
			line17.add(new CommentBlock("// A field", 4, 1, 17, 1));
			
			ArrayList<FormatToken> line18 = new ArrayList<>();
			int i = 0;
			line18.add(new WsBlock("    ", 0, 0, 18, i++));
			line18.add(new CodeBlock("public", 4, 4, 18, i++));
			line18.add(new WsBlock(" ", 10, 10, 18, i++));
			line18.add(new CodeBlock("final", 11, 11, 18, i++));
			line18.add(new WsBlock(" ", 16, 16, 18, i++));
			line18.add(new CodeBlock("int", 17, 17, 18, i++));
			line18.add(new WsBlock(" ", 20, 20, 18, i++));
			line18.add(new CodeBlock("m", 21, 21, 18, i++));
			line18.add(new WsBlock(" ", 22, 22, 18, i++));
			line18.add(new CodeBlock("=", 23, 23, 18, i++));
			line18.add(new WsBlock(" ", 24, 24, 18, i++));
			line18.add(new CodeBlock("0", 25, 25, 18, i++));
			line18.add(new CodeBlock(";", 26, 26, 18, i++));
			
			ArrayList<FormatToken> line19 = new ArrayList<>();
			i = 0;
			line19.add(new WsBlock("    ", 0, 0, 19, i++));
			line19.add(new CommentBlock("/* Some key */", 4, 4, 19, i++));
				
			ArrayList<FormatToken> line20 = new ArrayList<>();
			i = 0;
			line20.add(new WsBlock("    ", 0, 0, 20, i++));
			line20.add(new CodeBlock("private", 4, 4, 20, i++));
			line20.add(new WsBlock(" ", 11, 11, 20, i++));
			line20.add(new CodeBlock("static", 12, 12, 20, i++));
			line20.add(new WsBlock(" ", 18, 18, 20, i++));
			line20.add(new CodeBlock("final", 19, 19, 20, i++));
			line20.add(new WsBlock(" ", 24, 24, 20, i++));
			line20.add(new CodeBlock("String", 25, 25, 20, i++));
			line20.add(new WsBlock(" ", 31, 31, 20, i++));
			line20.add(new CodeBlock("SOME_KEY", 32, 32, 20, i++));
			line20.add(new WsBlock(" ", 40, 40, 20, i++));
			line20.add(new CodeBlock("=", 41, 41, 20, i++));
			line20.add(new CodeBlock(" ", 42, 42, 20, i++));
			
			ArrayList<FormatToken> line21 = new ArrayList<>();
			line21.add(new WsBlock("        ", 0, 0, 21, 0));
			line21.add(new CodeBlock("\"I know this isn\\'t a key. \\n\"", 8, 8, 21, 1));
			
			ArrayList<FormatToken> line22 = new ArrayList<>();
			i = 0;
			line22.add(new WsBlock("\t    ", 0, 0, 22, i++));
			line22.add(new CodeBlock("+", 8, 5, 22, i++));
			line22.add(new WsBlock(" ", 9, 6, 22, i++));
			line22.add(new CodeBlock("\"It is just a test string.\"", 10, 7, 22, i++));
			line22.add(new CodeBlock(";", 37, 34, 22, i++));
			
			ArrayList<FormatToken> line23 = new ArrayList<>();
			// I deliberately put the spaces in the line.
			line23.add(new WsBlock("    ", 0, 0, 23, 0));
			
			expected_tokens.add(line17);
			expected_tokens.add(line18);
			expected_tokens.add(line19);
			expected_tokens.add(line20);
			expected_tokens.add(line21);
			expected_tokens.add(line22);
			expected_tokens.add(line23);
		}		
		{
			ArrayList<FormatToken> line24 = new ArrayList<>();
			line24.add(new CommentBlock("////////////////////// Methods ///////////////////////", 0, 0, 24, 0));
			
			ArrayList<FormatToken> line25 = new ArrayList<>();
			
			ArrayList<FormatToken> line26 = new ArrayList<>();
			line26.add(new JavaDocCommentBlock("    ", 0, 0, 26, 0));
			line26.add(new JavaDocCommentBlock("/**\r\n"
					+ "     * Some method\r\n"
					+ "     * @param param\r\n"
					+ "     * @return something\r\n"
					+ "     */", 4, 4, 26, 1));
			
			ArrayList<FormatToken> line27 = new ArrayList<>();
			ArrayList<FormatToken> line28 = new ArrayList<>();
			ArrayList<FormatToken> line29 = new ArrayList<>();
			ArrayList<FormatToken> line30 = new ArrayList<>();
			
			expected_tokens.add(line24);
			expected_tokens.add(line25);
			expected_tokens.add(line26);
			expected_tokens.add(line27);
			expected_tokens.add(line28);
			expected_tokens.add(line29);
			expected_tokens.add(line30);
		}
		{
			ArrayList<FormatToken> line31 = new ArrayList<>();
			int i = 0;
			line31.add(new WsBlock("    ", 0, 0, 31, i++));
			line31.add(new CodeBlock("protected", 4, 4, 31, i++));
			line31.add(new WsBlock(" ", 13, 13, 31, i++));
			line31.add(new CodeBlock("boolean", 14, 14, 31, i++));
			line31.add(new WsBlock(" ", 21, 21, 31, i++));
			line31.add(new CodeBlock("someMethod", 22, 22, 31, i++));
			line31.add(new CodeBlock("(", 32, 32, 31, i++));
			line31.add(new CodeBlock("List", 33, 33, 31, i++));
			line31.add(new CodeBlock("<", 37, 37, 31, i++));
			line31.add(new CodeBlock("Integer", 38, 38, 31, i++));
			line31.add(new CodeBlock(">", 45, 45, 31, i++));
			line31.add(new WsBlock(" ", 46, 46, 31, i++));
			line31.add(new CodeBlock("list", 47, 47, 31, i++));
			line31.add(new CodeBlock(")", 51, 51, 31, i++));
			
			ArrayList<FormatToken> line32 = new ArrayList<>();
			line32.add(new WsBlock("    ", 0, 0, 32, 0));
			line32.add(new CodeBlock("{", 4, 4, 32, 1));
			
			ArrayList<FormatToken> line33 = new ArrayList<>();
			i = 0;
			line33.add(new WsBlock("    	", 0, 0, 33, i++));
			line33.add(new CodeBlock("for", 8, 5, 33, i++));
			line33.add(new CodeBlock("(", 11, 8, 33, i++));
			line33.add(new CodeBlock("int", 12, 9, 33, i++));
			line33.add(new WsBlock(" ", 15, 12, 33, i++));
			line33.add(new CodeBlock("i", 16, 13, 33, i++));
			line33.add(new WsBlock(" ", 17, 14, 33, i++));
			line33.add(new CodeBlock("=", 18, 15, 33, i++));
			line33.add(new WsBlock(" ", 19, 16, 33, i++));
			line33.add(new CodeBlock("0", 20, 17, 33, i++));
			line33.add(new CodeBlock(";", 21, 18, 33, i++));
			line33.add(new WsBlock(" ", 22, 19, 33, i++));
			line33.add(new CodeBlock("i", 23, 20, 33, i++));
			line33.add(new WsBlock(" ", 24, 21, 33, i++));
			line33.add(new CodeBlock("<", 25, 22, 33, i++));
			line33.add(new WsBlock(" ", 26, 23, 33, i++));
			line33.add(new CodeBlock("list", 27, 24, 33, i++));
			line33.add(new CodeBlock(".", 31, 28, 33, i++));
			line33.add(new CodeBlock("size", 32, 29, 33, i++));
			line33.add(new CodeBlock("(", 36, 33, 33, i++));
			line33.add(new CodeBlock(")", 37, 34, 33, i++));
			line33.add(new CodeBlock(";", 38, 35, 33, i++));
			line33.add(new WsBlock(" ", 39, 36, 33, i++));
			line33.add(new CodeBlock("++", 40, 37, 33, i++));
			line33.add(new CodeBlock("i", 42, 39, 33, i++));
			line33.add(new CodeBlock(")", 43, 40, 33, i++));
			line33.add(new WsBlock(" ", 44, 41, 33, i++));
			line33.add(new CodeBlock("{", 45, 42, 33, i++));
			
			ArrayList<FormatToken> line34 = new ArrayList<>();
			line34.add(new WsBlock("        ", 0, 0, 34, 0));
			line34.add(new CommentBlock("// Do something", 8, 8, 34, 1));
		
			ArrayList<FormatToken> line35 = new ArrayList<>();
			i = 0;
			line35.add(new WsBlock("        	", 0, 0, 35, i++));
			line35.add(new CodeBlock("int", 12, 9, 35, i++));
			line35.add(new WsBlock(" ", 15, 12, 35, i++));
			line35.add(new CodeBlock("a", 16, 13, 35, i++));
			line35.add(new WsBlock(" ", 17, 14, 35, i++));
			line35.add(new CommentBlock("/* ... */", 18, 15, 35, i++));
			line35.add(new WsBlock(" ", 27, 24, 35, i++));
			line35.add(new CodeBlock("=", 28, 25, 35, i++));
			line35.add(new WsBlock(" ", 29, 26, 35, i++));
			line35.add(new CodeBlock("3", 30, 27, 35, i++));
			line35.add(new CodeBlock(";", 31, 28, 35, i++));
			
			ArrayList<FormatToken> line36 = new ArrayList<>();
			line36.add(new WsBlock("        ", 0, 0, 36, 0));
			line36.add(new CodeBlock("}", 8, 8, 36, 1));
			
			ArrayList<FormatToken> line37 = new ArrayList<>();
			
			ArrayList<FormatToken> line38 = new ArrayList<>();
			line38.add(new WsBlock("        ", 0, 0, 38, 0));
			line38.add(new CodeBlock("return", 8, 8, 38, 1));
			line38.add(new WsBlock(" ", 14, 14, 38, 2));
			line38.add(new CodeBlock("true", 15, 15, 38, 3));
			line38.add(new CodeBlock(";", 19, 19, 38, 4));
			
			ArrayList<FormatToken> line39 = new ArrayList<>();
			line39.add(new WsBlock("    ", 0, 0, 39, 0));
			line39.add(new CodeBlock("}", 4, 4, 39, 1));
			
			ArrayList<FormatToken> line40 = new ArrayList<>();
			line40.add(new CodeBlock("}", 0, 0, 40, 0));
			
			expected_tokens.add(line31);
			expected_tokens.add(line32);
			expected_tokens.add(line33);
			expected_tokens.add(line34);
			expected_tokens.add(line35);
			expected_tokens.add(line36);
			expected_tokens.add(line37);
			expected_tokens.add(line38);
			expected_tokens.add(line39);
			expected_tokens.add(line40);
		}
		
		assertTokenLinesEqual(expected_tokens, s2_tokens);	
	}
	
	/**
	 * Token type test
	 */
	@Test
	void testCtorTokensTypes()
	{
		final String file_path_1 = "test_data/empty_lines2.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.get_format_tokens();
		
		assertTrue(s1.getFormatToken(1, 0) instanceof JavaDocCommentBlock);
		assertTrue(s1.getFormatToken(8, 1) instanceof WsBlock);
		assertTrue(s1.getFormatToken(8, 2) instanceof CodeBlock);
		assertTrue(s1.getFormatToken(9, 0) instanceof WsBlock);
		assertTrue(s1.getFormatToken(9, 1) instanceof CommentBlock);
		assertTrue(s1.getFormatToken(10, 8) instanceof CodeBlock);
		assertTrue(s1.getFormatToken(16, 0) instanceof CodeBlock);
	}
	
	/**
	 * Tests if getPrevFormatToken can correctly return the previous token
	 * if there is one
	 */
	@Test
	void testGetPrevFormatTokenExists()
	{
		final String file_path_1 = "test_data/prev_next_test_exists.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		// When in the same line there is some token before it.
		assertEquals
		(
			"public",
			s1.getPrevFormatToken(s1.getFormatToken(11, 1)).characters
		);
		
		// When there is some in the previous line
		assertEquals
		(
			"// ...",
			s1.getPrevFormatToken(s1.getFormatToken(13, 0)).characters
		);
		
		// When there is some in a not immediately previous line.
		assertEquals
		(
			"// Exists",
			s1.getPrevFormatToken(s1.getFormatToken(4, 0)).characters
		);
	}
	
	/**
	 * Tests if getPrevFormatToken can correctly return null
	 * if there isn't one.
	 */
	@Test
	void testGetPrevFormatTokenNotExist()
	{
		// When the token is the first in the first line.
		final String file_path_1 = "test_data/empty_lines2.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.get_format_tokens();
		assertEquals(null, s1.getPrevFormatToken(s1_tokens.get(0).get(0)));
		
		// When the token isn't in the first line, but all
		// previous lines are empty.
		final String file_path_2 = "test_data/prev_next_test.txt";
		var s2 = createSourceFileNoError(file_path_2);

		assertEquals(null, s2.getPrevFormatToken(s2.getFormatToken(4, 0)));
	}
	
	/**
	 * Tests if getNextFormatToken can correctly return the next token
	 * if there is one
	 */
	@Test
	void testGetNextFormatTokenExists()
	{
		final String file_path_1 = "test_data/prev_next_test_exists.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		// When in the same line there is some token after it.
		assertEquals
		(
			"class",
			s1.getNextFormatToken(s1.getFormatToken(11, 1)).characters
		);
		
		// When there is some in the previous line
		assertEquals
		(
			"}",
			s1.getNextFormatToken(s1.getFormatToken(18, 1)).characters
		);
		
		// When there is some in a not immediately previous line.
		assertEquals
		(
			"// Exists.",
			s1.getNextFormatToken(s1.getFormatToken(19, 0)).characters
		);
	}
	
	/**
	 * Tests if getNextFormatToken can correctly return null
	 * if there isn't one.
	 */
	@Test
	void testGetNextFormatTokenNotExist()
	{
		// When the token is the last in the last line.
		final String file_path_1 = "test_data/empty_lines2.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.get_format_tokens();
		assertEquals(null, s1.getNextFormatToken(s1_tokens.get(s1_tokens.size()-1).get(0)));
		
		// When the token isn't in the last line, but all
		// following lines are empty.
		final String file_path_2 = "test_data/next_no_token_test.txt";
		var s2 = createSourceFileNoError(file_path_2);
		
		assertEquals(null, s2.getNextFormatToken(s2.getFormatToken(9, 0)));
	}
}
