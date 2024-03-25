/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.antlr.v4.runtime.CommonToken;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.CommentBlock;
import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.format.primitives.WsBlock;
import test.TestUtils.FormatTokenTestProperties;

/**
 * Tests the SourceFile class.
 */
class TestSourceFile 
{
	
/////////////////////////////// Lines and Tokens ////////////////////////////

	/**
	 * Tests if the source file constructor can get the number of lines right
	 * when in the source code there is no empty line (i.e. lines of only line terminators).
	 */
	@Test
	void testCtorLinesNoEmptyLine() 
	{
		final String file_path_1 = "test_data/no_empty_lines1.txt";
		final String file_path_2 = "test_data/no_empty_lines2.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		assertEquals(4, s1.numLines());
		assertEquals(9, s2.numLines());
	}
	
	/**
	 * Tests if the source file constructor can get the number of lines right
	 * when in the source code there are some empty lines (i.e. lines of only line terminators).
	 */
	@Test
	void testCtorLinesEmptyLines() 
	{
		final String file_path_1 = "test_data/empty_lines1.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		final String file_path_2 = "test_data/empty_lines2.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		// Nothing. The file is empty
		assertEquals(1, s1.numLines());
		assertTrue(s1.getFormatTokens().get(0).isEmpty());
		// Some lines...
		assertEquals(16, s2.numLines());
	}
	
	/**
	 * Tests if getLine() will throw an exception with an out of bound index
	 */
	@Test
	void testGetLineIndexOutOfBound()
	{
		final String file_path_2 = "test_data/empty_lines2.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		// Boundary cases
		assertThrows(ArrayIndexOutOfBoundsException.class, ()->{s2.getLine(0);});
		assertThrows(ArrayIndexOutOfBoundsException.class, ()->{s2.getLine(17);});
			
		// Other cases
		assertThrows(ArrayIndexOutOfBoundsException.class, ()->{s2.getLine(-1);});
		assertThrows(ArrayIndexOutOfBoundsException.class, ()->{s2.getLine(20);});
	}

	/**
	 * Tests if the source file constructor can construct the tokens and lines correctly.
	 * From a file of minimal tokens.
	 */
	@Test
	void testCtorTokensLinesMinimal() 
	{
		// This file has a few lines.
		final String file_path_1 = "test_data/no_empty_lines1.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// Testing tokens
		var s1_tokens = s1.getFormatTokens();
		ArrayList<ArrayList<FormatTokenTestProperties>> expected_tokens = new ArrayList<>();
		{
			ArrayList<FormatTokenTestProperties> line1 = new ArrayList<>();
			line1.add(new FormatTokenTestProperties(CommentBlock.class, "// ABC", 0, 0, 1, 0));
			expected_tokens.add(line1);
		}
		{
			ArrayList<FormatTokenTestProperties> line2 = new ArrayList<>();
			line2.add(new FormatTokenTestProperties(CodeBlock.class, "public", 0, 0, 2, 0));
			line2.add(new FormatTokenTestProperties(WsBlock.class, " ", 6, 6, 2, 1));
			line2.add(new FormatTokenTestProperties(CodeBlock.class, "class", 7, 7, 2, 2));
			line2.add(new FormatTokenTestProperties(WsBlock.class, " ", 12, 12, 2, 3));
			line2.add(new FormatTokenTestProperties(CodeBlock.class, "ABC", 13, 13, 2, 4));
			line2.add(new FormatTokenTestProperties(WsBlock.class, " ", 16, 16, 2, 5));
			line2.add(new FormatTokenTestProperties(CodeBlock.class, "{", 17, 17, 2, 6));
			expected_tokens.add(line2);
		}
		{
			ArrayList<FormatTokenTestProperties> line3 = new ArrayList<>();
			line3.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 3, 0));
			line3.add(new FormatTokenTestProperties(CodeBlock.class, "int", 4, 4, 3, 1));
			line3.add(new FormatTokenTestProperties(WsBlock.class, " ", 7, 7, 3, 2));
			line3.add(new FormatTokenTestProperties(CodeBlock.class, "abc", 8, 8, 3, 3));
			line3.add(new FormatTokenTestProperties(WsBlock.class, " ", 11, 11, 3, 4));
			line3.add(new FormatTokenTestProperties(CodeBlock.class, "=", 12, 12, 3, 5));
			line3.add(new FormatTokenTestProperties(WsBlock.class, " ", 13, 13, 3, 6));
			line3.add(new FormatTokenTestProperties(CodeBlock.class, "1", 14, 14, 3, 7));
			line3.add(new FormatTokenTestProperties(CodeBlock.class, ";", 15, 15, 3, 8));
			expected_tokens.add(line3);
		}
		{
			ArrayList<FormatTokenTestProperties> line4 = new ArrayList<>();
			line4.add(new FormatTokenTestProperties(CodeBlock.class, "}", 0, 0, 4, 0));
			expected_tokens.add(line4);
		}
		
		TestUtils.assertTokenLinesEqual(expected_tokens, s1_tokens);	
		
		// Testing lines
		TestUtils.assertLinesEquals(expected_tokens, s1);
	}
	
	/**
	 * Tests if the source file constructor can construct the tokens and lines correctly.
	 * From a file of a more complete set of tokens.
	 */
	@Test
	void testCtorTokensLinesComplete()
	{
		// This file has a bit of everything.
		final String file_path_2 = "test_data/mixture1.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		var s2_tokens = s2.getFormatTokens();
		ArrayList<ArrayList<FormatTokenTestProperties>> expected_tokens = new ArrayList<>();
		{
			ArrayList<FormatTokenTestProperties> line1 = new ArrayList<>();
			line1.add
			(new FormatTokenTestProperties
				(
					JavaDocBlock.class,
					"/**\r\n"
					+ " * Has a bit of everything.\r\n"
					+ " * @author Guanyuming He\r\n"
					+ " */", 
					0, 0, 1, 0
				)
			);
			// Empty lines. 2--4 are resulted by the multi-line comment.
			// 5 is just an empty line.
			ArrayList<FormatTokenTestProperties> line2 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line3 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line4 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line5 = new ArrayList<>();
			
			expected_tokens.add(line1);
			expected_tokens.add(line2);
			expected_tokens.add(line3);
			expected_tokens.add(line4);
			expected_tokens.add(line5);
		}
		{
			int i = 0;
			ArrayList<FormatTokenTestProperties> line6 = new ArrayList<>();
			line6.add(new FormatTokenTestProperties(CodeBlock.class, "package", 0, 0, 6, i++));
			line6.add(new FormatTokenTestProperties(WsBlock.class, " ", 7, 7, 6, i++));
			line6.add(new FormatTokenTestProperties(CodeBlock.class, "edu", 8, 8, 6, i++));
			line6.add(new FormatTokenTestProperties(CodeBlock.class, ".", 11, 11, 6, i++));
			line6.add(new FormatTokenTestProperties(CodeBlock.class, "xjtlu", 12, 12, 6, i++));
			line6.add(new FormatTokenTestProperties(CodeBlock.class, ".", 17, 17, 6, i++));
			line6.add(new FormatTokenTestProperties(CodeBlock.class, "guany", 18, 18, 6, i++));
			line6.add(new FormatTokenTestProperties(CodeBlock.class, ";", 23, 23, 6, i++));
			
			ArrayList<FormatTokenTestProperties> line7 = new ArrayList<>();
			
			ArrayList<FormatTokenTestProperties> line8 = new ArrayList<>();
			i = 0;
			line8.add(new FormatTokenTestProperties(CodeBlock.class, "import", 0, 0, 8, i++));
			line8.add(new FormatTokenTestProperties(WsBlock.class, " ", 6, 6, 8, i++));
			line8.add(new FormatTokenTestProperties(CodeBlock.class, "java", 7, 7, 8, i++));
			line8.add(new FormatTokenTestProperties(CodeBlock.class, ".", 11, 11, 8, i++));
			line8.add(new FormatTokenTestProperties(CodeBlock.class, "io", 12, 12, 8, i++));
			line8.add(new FormatTokenTestProperties(CodeBlock.class, ".", 14, 14, 8, i++));
			line8.add(new FormatTokenTestProperties(CodeBlock.class, "IOException", 15, 15, 8, i++));
			line8.add(new FormatTokenTestProperties(CodeBlock.class, ";", 26, 26, 8, i++));
			
			ArrayList<FormatTokenTestProperties> line9 = new ArrayList<>();
			i = 0;
			line9.add(new FormatTokenTestProperties(CodeBlock.class, "import", 0, 0, 9, i++));
			line9.add(new FormatTokenTestProperties(WsBlock.class, " ", 6, 6, 9, i++));
			line9.add(new FormatTokenTestProperties(CodeBlock.class, "java", 7, 7, 9, i++));
			line9.add(new FormatTokenTestProperties(CodeBlock.class, ".", 11, 11, 9, i++));
			line9.add(new FormatTokenTestProperties(CodeBlock.class, "util", 12, 12, 9, i++));
			line9.add(new FormatTokenTestProperties(CodeBlock.class, ".", 16, 16, 9, i++));
			line9.add(new FormatTokenTestProperties(CodeBlock.class, "List", 17, 17, 9, i++));
			line9.add(new FormatTokenTestProperties(CodeBlock.class, ";", 21, 21, 9, i++));
			
			ArrayList<FormatTokenTestProperties> line10 = new ArrayList<>();
			
			expected_tokens.add(line6);
			expected_tokens.add(line7);
			expected_tokens.add(line8);
			expected_tokens.add(line9);
			expected_tokens.add(line10);	
		}
		{
			ArrayList<FormatTokenTestProperties> line11 = new ArrayList<>();
			line11.add
			(new FormatTokenTestProperties
					(JavaDocBlock.class,
					"/**\r\n"
					+ " * Some comments for the class.\r\n"
					+ " */", 
					0, 0, 11, 0
				)
			);
			// Empty lines that are resulted by the multi-line comment.
			ArrayList<FormatTokenTestProperties> line12 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line13 = new ArrayList<>();
			
			expected_tokens.add(line11);
			expected_tokens.add(line12);
			expected_tokens.add(line13);
		}
		{
			ArrayList<FormatTokenTestProperties> line14 = new ArrayList<>();
			int i = 0;
			line14.add(new FormatTokenTestProperties(CodeBlock.class, "public", 0, 0, 14, i++));
			line14.add(new FormatTokenTestProperties(WsBlock.class, " ", 6, 6, 14, i++));
			line14.add(new FormatTokenTestProperties(CodeBlock.class, "class", 7, 7, 14, i++));
			line14.add(new FormatTokenTestProperties(WsBlock.class, " ", 12, 12, 14, i++));
			line14.add(new FormatTokenTestProperties(CodeBlock.class, "MixtureClass", 13, 13, 14, i++));
			line14.add(new FormatTokenTestProperties(WsBlock.class, " ", 25, 25, 14, i++));
			line14.add(new FormatTokenTestProperties(CodeBlock.class, "extends", 26, 26, 14, i++));
			line14.add(new FormatTokenTestProperties(WsBlock.class, " ", 33, 33, 14, i++));
			line14.add(new FormatTokenTestProperties(CodeBlock.class, "ABC", 34, 34, 14, i++));
			line14.add(new FormatTokenTestProperties(WsBlock.class, " ", 37, 37, 14, i++));
			
			ArrayList<FormatTokenTestProperties> line15 = new ArrayList<>();
			line15.add(new FormatTokenTestProperties(CodeBlock.class, "{", 0, 0, 15, 0));
			// Note that here I deliberately put a tab in the empty line.
			ArrayList<FormatTokenTestProperties> line16 = new ArrayList<>();
			line16.add(new FormatTokenTestProperties(WsBlock.class, "\t", 0, 0, 16, 0));
			
			expected_tokens.add(line14);
			expected_tokens.add(line15);
			expected_tokens.add(line16);
		}
		{
			ArrayList<FormatTokenTestProperties> line17 = new ArrayList<>();
			line17.add(new FormatTokenTestProperties(WsBlock.class, "\t", 0, 0, 17, 0));
			line17.add(new FormatTokenTestProperties(CommentBlock.class, "// A field", 4, 1, 17, 1));
			
			ArrayList<FormatTokenTestProperties> line18 = new ArrayList<>();
			int i = 0;
			line18.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, "public", 4, 4, 18, i++));
			line18.add(new FormatTokenTestProperties(WsBlock.class, " ", 10, 10, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, "final", 11, 11, 18, i++));
			line18.add(new FormatTokenTestProperties(WsBlock.class, " ", 16, 16, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, "int", 17, 17, 18, i++));
			line18.add(new FormatTokenTestProperties(WsBlock.class, " ", 20, 20, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, "m", 21, 21, 18, i++));
			line18.add(new FormatTokenTestProperties(WsBlock.class, " ", 22, 22, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, "=", 23, 23, 18, i++));
			line18.add(new FormatTokenTestProperties(WsBlock.class, " ", 24, 24, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, "0", 25, 25, 18, i++));
			line18.add(new FormatTokenTestProperties(CodeBlock.class, ";", 26, 26, 18, i++));
			
			ArrayList<FormatTokenTestProperties> line19 = new ArrayList<>();
			i = 0;
			line19.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 19, i++));
			line19.add(new FormatTokenTestProperties(CommentBlock.class, "/* Some key */", 4, 4, 19, i++));
				
			ArrayList<FormatTokenTestProperties> line20 = new ArrayList<>();
			i = 0;
			line20.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 20, i++));
			line20.add(new FormatTokenTestProperties(CodeBlock.class, "private", 4, 4, 20, i++));
			line20.add(new FormatTokenTestProperties(WsBlock.class, " ", 11, 11, 20, i++));
			line20.add(new FormatTokenTestProperties(CodeBlock.class, "static", 12, 12, 20, i++));
			line20.add(new FormatTokenTestProperties(WsBlock.class, " ", 18, 18, 20, i++));
			line20.add(new FormatTokenTestProperties(CodeBlock.class, "final", 19, 19, 20, i++));
			line20.add(new FormatTokenTestProperties(WsBlock.class, " ", 24, 24, 20, i++));
			line20.add(new FormatTokenTestProperties(CodeBlock.class, "String", 25, 25, 20, i++));
			line20.add(new FormatTokenTestProperties(WsBlock.class, " ", 31, 31, 20, i++));
			line20.add(new FormatTokenTestProperties(CodeBlock.class, "SOME_KEY", 32, 32, 20, i++));
			line20.add(new FormatTokenTestProperties(WsBlock.class, " ", 40, 40, 20, i++));
			line20.add(new FormatTokenTestProperties(CodeBlock.class, "=", 41, 41, 20, i++));
			line20.add(new FormatTokenTestProperties(WsBlock.class, " ", 42, 42, 20, i++));
			
			ArrayList<FormatTokenTestProperties> line21 = new ArrayList<>();
			line21.add(new FormatTokenTestProperties(WsBlock.class, "        ", 0, 0, 21, 0));
			line21.add(new FormatTokenTestProperties(CodeBlock.class, "\"I know this isn\\'t a key. \\n\"", 8, 8, 21, 1));
			
			ArrayList<FormatTokenTestProperties> line22 = new ArrayList<>();
			i = 0;
			line22.add(new FormatTokenTestProperties(WsBlock.class, "\t    ", 0, 0, 22, i++));
			line22.add(new FormatTokenTestProperties(CodeBlock.class, "+", 8, 5, 22, i++));
			line22.add(new FormatTokenTestProperties(WsBlock.class, " ", 9, 6, 22, i++));
			line22.add(new FormatTokenTestProperties(CodeBlock.class, "\"It is just a test string.\"", 10, 7, 22, i++));
			line22.add(new FormatTokenTestProperties(CodeBlock.class, ";", 37, 34, 22, i++));
			
			ArrayList<FormatTokenTestProperties> line23 = new ArrayList<>();
			// I deliberately put the spaces in the line.
			line23.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 23, 0));
			
			expected_tokens.add(line17);
			expected_tokens.add(line18);
			expected_tokens.add(line19);
			expected_tokens.add(line20);
			expected_tokens.add(line21);
			expected_tokens.add(line22);
			expected_tokens.add(line23);
		}		
		{
			ArrayList<FormatTokenTestProperties> line24 = new ArrayList<>();
			line24.add(new FormatTokenTestProperties(CommentBlock.class, "////////////////////// Methods ///////////////////////", 0, 0, 24, 0));
			
			ArrayList<FormatTokenTestProperties> line25 = new ArrayList<>();
			
			ArrayList<FormatTokenTestProperties> line26 = new ArrayList<>();
			line26.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 26, 0));
			line26.add(new FormatTokenTestProperties(JavaDocBlock.class, "/**\r\n"
					+ "     * Some method\r\n"
					+ "     * @param param\r\n"
					+ "     * @return something\r\n"
					+ "     */", 4, 4, 26, 1));
			
			ArrayList<FormatTokenTestProperties> line27 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line28 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line29 = new ArrayList<>();
			ArrayList<FormatTokenTestProperties> line30 = new ArrayList<>();
			
			expected_tokens.add(line24);
			expected_tokens.add(line25);
			expected_tokens.add(line26);
			expected_tokens.add(line27);
			expected_tokens.add(line28);
			expected_tokens.add(line29);
			expected_tokens.add(line30);
		}
		{
			ArrayList<FormatTokenTestProperties> line31 = new ArrayList<>();
			int i = 0;
			line31.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "protected", 4, 4, 31, i++));
			line31.add(new FormatTokenTestProperties(WsBlock.class, " ", 13, 13, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "boolean", 14, 14, 31, i++));
			line31.add(new FormatTokenTestProperties(WsBlock.class, " ", 21, 21, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "someMethod", 22, 22, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "(", 32, 32, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "List", 33, 33, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "<", 37, 37, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "Integer", 38, 38, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, ">", 45, 45, 31, i++));
			line31.add(new FormatTokenTestProperties(WsBlock.class, " ", 46, 46, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, "list", 47, 47, 31, i++));
			line31.add(new FormatTokenTestProperties(CodeBlock.class, ")", 51, 51, 31, i++));
			
			ArrayList<FormatTokenTestProperties> line32 = new ArrayList<>();
			line32.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 32, 0));
			line32.add(new FormatTokenTestProperties(CodeBlock.class, "{", 4, 4, 32, 1));
			
			ArrayList<FormatTokenTestProperties> line33 = new ArrayList<>();
			i = 0;
			line33.add(new FormatTokenTestProperties(WsBlock.class, "    	", 0, 0, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "for", 8, 5, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "(", 11, 8, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "int", 12, 9, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 15, 12, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "i", 16, 13, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 17, 14, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "=", 18, 15, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 19, 16, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "0", 20, 17, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, ";", 21, 18, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 22, 19, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "i", 23, 20, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 24, 21, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "<", 25, 22, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 26, 23, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "list", 27, 24, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, ".", 31, 28, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "size", 32, 29, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "(", 36, 33, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, ")", 37, 34, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, ";", 38, 35, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 39, 36, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "++", 40, 37, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "i", 42, 39, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, ")", 43, 40, 33, i++));
			line33.add(new FormatTokenTestProperties(WsBlock.class, " ", 44, 41, 33, i++));
			line33.add(new FormatTokenTestProperties(CodeBlock.class, "{", 45, 42, 33, i++));
			
			ArrayList<FormatTokenTestProperties> line34 = new ArrayList<>();
			line34.add(new FormatTokenTestProperties(WsBlock.class, "        ", 0, 0, 34, 0));
			line34.add(new FormatTokenTestProperties(CommentBlock.class, "// Do something", 8, 8, 34, 1));
		
			ArrayList<FormatTokenTestProperties> line35 = new ArrayList<>();
			i = 0;
			line35.add(new FormatTokenTestProperties(WsBlock.class, "        	", 0, 0, 35, i++));
			line35.add(new FormatTokenTestProperties(CodeBlock.class, "int", 12, 9, 35, i++));
			line35.add(new FormatTokenTestProperties(WsBlock.class, " ", 15, 12, 35, i++));
			line35.add(new FormatTokenTestProperties(CodeBlock.class, "a", 16, 13, 35, i++));
			line35.add(new FormatTokenTestProperties(WsBlock.class, " ", 17, 14, 35, i++));
			line35.add(new FormatTokenTestProperties(CommentBlock.class, "/* ... */", 18, 15, 35, i++));
			line35.add(new FormatTokenTestProperties(WsBlock.class, " ", 27, 24, 35, i++));
			line35.add(new FormatTokenTestProperties(CodeBlock.class, "=", 28, 25, 35, i++));
			line35.add(new FormatTokenTestProperties(WsBlock.class, " ", 29, 26, 35, i++));
			line35.add(new FormatTokenTestProperties(CodeBlock.class, "3", 30, 27, 35, i++));
			line35.add(new FormatTokenTestProperties(CodeBlock.class, ";", 31, 28, 35, i++));
			
			ArrayList<FormatTokenTestProperties> line36 = new ArrayList<>();
			line36.add(new FormatTokenTestProperties(WsBlock.class, "        ", 0, 0, 36, 0));
			line36.add(new FormatTokenTestProperties(CodeBlock.class, "}", 8, 8, 36, 1));
			
			ArrayList<FormatTokenTestProperties> line37 = new ArrayList<>();
			
			ArrayList<FormatTokenTestProperties> line38 = new ArrayList<>();
			line38.add(new FormatTokenTestProperties(WsBlock.class, "        ", 0, 0, 38, 0));
			line38.add(new FormatTokenTestProperties(CodeBlock.class, "return", 8, 8, 38, 1));
			line38.add(new FormatTokenTestProperties(WsBlock.class, " ", 14, 14, 38, 2));
			line38.add(new FormatTokenTestProperties(CodeBlock.class, "true", 15, 15, 38, 3));
			line38.add(new FormatTokenTestProperties(CodeBlock.class, ";", 19, 19, 38, 4));
			
			ArrayList<FormatTokenTestProperties> line39 = new ArrayList<>();
			line39.add(new FormatTokenTestProperties(WsBlock.class, "    ", 0, 0, 39, 0));
			line39.add(new FormatTokenTestProperties(CodeBlock.class, "}", 4, 4, 39, 1));
			
			ArrayList<FormatTokenTestProperties> line40 = new ArrayList<>();
			line40.add(new FormatTokenTestProperties(CodeBlock.class, "}", 0, 0, 40, 0));
			
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
		
		TestUtils.assertTokenLinesEqual(expected_tokens, s2_tokens);
		
		// Testing lines
		TestUtils.assertLinesEquals(expected_tokens, s2);
	}
	
	/**
	 * Token type test
	 */
	@Test
	void testCtorTokensTypes()
	{
		final String file_path_1 = "test_data/empty_lines2.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.getFormatTokens();
		
		assertTrue(s1.getFormatToken(1, 0) instanceof JavaDocBlock);
		assertTrue(s1.getFormatToken(8, 1) instanceof WsBlock);
		assertTrue(s1.getFormatToken(8, 2) instanceof CodeBlock);
		assertTrue(s1.getFormatToken(9, 0) instanceof WsBlock);
		assertTrue(s1.getFormatToken(9, 1) instanceof CommentBlock);
		assertTrue(s1.getFormatToken(10, 8) instanceof CodeBlock);
		assertTrue(s1.getFormatToken(16, 0) instanceof CodeBlock);
	}
	
	/**
	 * Tests the method that returns the number of format tokens
	 */
	@Test
	void testNumFormatTokens()
	{
		// The boundary case: 0 format tokens.
		final String file_path_1 = "test_data/empty_lines1.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		assertEquals(0, s1.numFormatTokens(), 
				"Should contain 0 format tokens from an empty file (excluding new lines)");
		
		// Other cases
		final String file_path_2 = "test_data/empty_lines2.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		// I counted this by hand.
		assertEquals(39, s2.numFormatTokens());
		
		final String file_path_3 = "test_data/no_empty_lines1.txt";
		var s3 = TestUtils.createSourceFileNoError(file_path_3);
		// I counted this by hand.
		assertEquals(18, s3.numFormatTokens());
	}
	
	/**
	 * Tests if getPrevFormatToken can correctly return the previous token
	 * if there is one
	 */
	@Test
	void testGetPrevFormatTokenExists()
	{
		final String file_path_1 = "test_data/prev_next_test_exists.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// When in the same line there is some token before it.
		assertEquals
		(
			"public",
			s1.getPrevFormatToken(s1.getFormatToken(11, 1)).characters()
		);
		
		// When there is some in the previous line
		assertEquals
		(
			"// ...",
			s1.getPrevFormatToken(s1.getFormatToken(13, 0)).characters()
		);
		
		// When there is some in a not immediately previous line.
		assertEquals
		(
			"// Exists",
			s1.getPrevFormatToken(s1.getFormatToken(4, 0)).characters()
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
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.getFormatTokens();
		assertEquals(null, s1.getPrevFormatToken(s1_tokens.get(0).get(0)));
		
		// When the token isn't in the first line, but all
		// previous lines are empty.
		final String file_path_2 = "test_data/prev_next_test.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);

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
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// When in the same line there is some token after it.
		assertEquals
		(
			"class",
			s1.getNextFormatToken(s1.getFormatToken(11, 1)).characters()
		);
		
		// When there is some in the previous line
		assertEquals
		(
			"}",
			s1.getNextFormatToken(s1.getFormatToken(18, 1)).characters()
		);
		
		// When there is some in a not immediately previous line.
		assertEquals
		(
			"// Exists.",
			s1.getNextFormatToken(s1.getFormatToken(19, 0)).characters()
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
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		var s1_tokens = s1.getFormatTokens();
		assertEquals(null, s1.getNextFormatToken(s1_tokens.get(s1_tokens.size()-1).get(0)));
		
		// When the token isn't in the last line, but all
		// following lines are empty.
		final String file_path_2 = "test_data/next_no_token_test.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		assertEquals(null, s2.getNextFormatToken(s2.getFormatToken(9, 0)));
	}
	
	/**
	 * Tests the random access version of getFormatToken(),
	 * when the tokens exist.
	 */
	@Test
	void testGetFormatTokenRAExists()
	{
		// Need a source file with some tokens.
		final String file_path_1 = "test_data/mixture2.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// Boundary cases:
		// the first token
		assertEquals
		(
			"/**\r\n"
			+ " * Has a bit of everything,\r\n"
			+ " * but more declarations and modifiers\r\n"
			+ " * @author Guanyuming He\r\n"
			+ " */", 
			s1.getFormatToken(0).characters()
		);
		// the last token
		assertEquals
		(
			"}",
			s1.getFormatToken(s1.numFormatTokens()-1).characters()
		);
		
		// Other cases:
		FormatTokenTestProperties tp1 = new FormatTokenTestProperties
		(
			WsBlock.class, " ", 7, 7, 7, 1
		);
		FormatTokenTestProperties tp2 = new FormatTokenTestProperties
		(
			CodeBlock.class, "abstract", 7, 7, 12, 2
		);
		
		assertTrue(tp1.formatTokenEquals(s1.getFormatToken(2)));
		assertTrue(tp2.formatTokenEquals(s1.getFormatToken(12)));
	}
	
	/**
	 * Tests if the constructor throws an exception on encountering a syntax error 
	 */
	@Test
	void testThrowsOnSyntaxError()
	{
		// Can't test all kinds of syntax errors
		// but here syntax_error2 can be recovered by Antlr,
		// while the other two cannot.
		
		assertThrows
		(
			UnsupportedOperationException.class, 
			() -> {new SourceFile("test_data/syntax_error1.txt");}
		);
		
		assertThrows
		(
			UnsupportedOperationException.class, 
			() -> {new SourceFile("test_data/syntax_error2.txt");}
		);
		
		assertThrows
		(
			UnsupportedOperationException.class, 
			() -> {new SourceFile("test_data/syntax_error3.txt");}
		);
	}
	
	/**
	 * When a source file does include a format token.
	 */
	@Test
	void testIncludesTrue()
	{
		// Need a source file with some tokens,
		// preferably on different lines.
		
		final String file_path_1 = "test_data/prev_next_test_exists.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// Some tokens in the middle
		assertTrue(s1.includes(s1.getFormatToken(11, 1)));
		assertTrue(s1.includes(s1.getFormatToken(13, 2)));
		
		// Some boundary cases
		// first/last token in a line
		assertTrue(s1.includes(s1.getFormatToken(11, 0)));
		assertTrue(s1.includes(s1.getFormatToken(17, 4)));
		// first/last line
		assertTrue(s1.includes(s1.getFormatToken(1, 0)));
		assertTrue(s1.includes(s1.getFormatToken(22, 0)));
	}
	
	/**
	 * When a source file does not include a token
	 */
	@Test
	void testIncludesFalse()
	{
		// Need a source file with some tokens.
		final String file_path_1 = "test_data/prev_next_test_exists.txt";
		final var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// Need some other to see if they include each other's
		// (they should not, even if they are created from the same file.).
		final var s1_prime = TestUtils.createSourceFileNoError(file_path_1);
		final String file_path_2 = "test_data/mixture1.txt";
		final var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		
		// Boundary cases
		// null
		assertFalse(s1.includes(null));
		assertFalse(s1_prime.includes(null));
		assertFalse(s2.includes(null));
		
		// Other cases:
		// format tokens from other sfs
		assertFalse(s1.includes(s1_prime.getFormatToken(0)));
		assertFalse(s1.includes(s1_prime.getFormatToken(3)));
		assertFalse(s1_prime.includes(s1.getFormatToken(2)));
		assertFalse(s1_prime.includes(s1.getFormatToken(4)));
		assertFalse(s2.includes(s1_prime.getFormatToken(22, 0)));
		assertFalse(s2.includes(s1_prime.getFormatToken(11, 2)));
		assertFalse(s1_prime.includes(s2.getFormatToken(9)));
		assertFalse(s1_prime.includes(s2.getFormatToken(14, 5)));
		
		// format tokens created out of nowhere:
		final var antlrT1 = new CommonToken(0, "shit");
		final var nowhere1 = new CodeBlock(antlrT1, 0, 0);
		assertFalse(s1.includes(nowhere1));
		assertFalse(s1_prime.includes(nowhere1));
		assertFalse(s2.includes(nowhere1));
	}
}
