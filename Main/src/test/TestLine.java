package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.Line;

/**
 * Tests if the immutable class Line will correctly establish its invariants
 * after creation.
 */
public class TestLine 
{
	/**
	 * Test when the arguments given the a constructor of Line are illegal.
	 */
	@Test
	void testBadLineConstruction()
	{
		// I need at least two different source file instances.
		// And I have designed a special test file for tokens appears to be in the same line but are not.
		final String file_path_1 = "test_data/bad_tokens_in_the_same_line.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		final String file_path_2 = "test_data/mixture1.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		// 1. Only 1 token is null.
		assertThrows(IllegalArgumentException.class, ()-> {new Line(null, s2.getFormatToken(3), s2);});
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(0), null, s1);});
		
		// 2. At least one token is not from the given source file.
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(9, 0), s2.getFormatToken(9, 7), s2);});
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(9, 0), s2.getFormatToken(9, 7), s1);});
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(3, 0), s1.getFormatToken(3, 7), s2);});
		
		// 3. First and last are not in the same line.
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s2.getFormatToken(8, 1), s2.getFormatToken(9, 1), s2);});
		// the file for s1 is specially designed so that the following tokens may appear to be in the same line but are not.
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(1, 0), s1.getFormatToken(3, 0), s1);});
		
		// 4. First is not the first token in the line.
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(3, 1), s1.getFormatToken(3, 7), s1);});
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s2.getFormatToken(26, 1), s2.getFormatToken(26, 1), s2);});
		
		// 5. Last is not the last token in the line.
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s1.getFormatToken(5, 0), s1.getFormatToken(5, 2), s1);});
		assertThrows(IllegalArgumentException.class, ()-> {new Line(s2.getFormatToken(18, 0), s2.getFormatToken(18, 0), s2);});
	}
	
	/**
	 * Test when a Line has no Token.
	 */
	@Test
	void testEmptyLine()
	{
		Line l1 = new Line(null, null, null);
		assertEquals(null, l1.firstToken, "All tokens should be null now.");
		assertEquals(null, l1.lastToken, "All tokens should be null now.");
		assertEquals(null, l1.firstVisibleToken, "All tokens should be null now.");
		assertEquals(null, l1.lastVisibleToken, "All tokens should be null now.");
		assertEquals(0, l1.indentationLevel, "The indentation level should be 0 now.");
		assertEquals(0, l1.visualLength, "The visual length should be 0 now.");
		assertEquals(false, l1.hasToken(), "Does not have any token.");
		assertEquals(false, l1.hasVisibleToken(), "Does not have any token.");
		assertEquals(0, l1.visualOffset(), "Visual offset should be 0 now.");
		
		// The source file parameter is unused under this condition,
		// so the following results should be exactly the same as above.
		final String file_path_1 = "test_data/empty_lines1.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		l1 = new Line(null, null, s1);
		assertEquals(null, l1.firstToken, "All tokens should be null now.");
		assertEquals(null, l1.lastToken, "All tokens should be null now.");
		assertEquals(null, l1.firstVisibleToken, "All tokens should be null now.");
		assertEquals(null, l1.lastVisibleToken, "All tokens should be null now.");
		assertEquals(0, l1.indentationLevel, "The indentation level should be 0 now.");
		assertEquals(0, l1.visualLength, "The visual length should be 0 now.");
		assertEquals(false, l1.hasToken(), "Does not have any token.");
		assertEquals(false, l1.hasVisibleToken(), "Does not have any token.");
		assertEquals(0, l1.visualOffset(), "Visual offset should be 0 now.");
	}
	
	/**
	 * Test when a Line has tokens but no visible token.
	 */
	@Test
	void testInvisibleLine()
	{
		// The only possible scenario is a line full of white spaces.
		// Hence one such line can only have one token.
		final String file_path_1 = "test_data/white_spaces.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		Line l1 = new Line(s1.getFormatToken(4, 0), s1.getFormatToken(4, 0), s1);
		Line l2 = new Line(s1.getFormatToken(5, 0), s1.getFormatToken(5, 0), s1);
		Line l3 = new Line(s1.getFormatToken(6, 0), s1.getFormatToken(6, 0), s1);
		
		assertEquals(s1.getFormatToken(4, 0), l1.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(4, 0), l1.lastToken, "The last should be set correctly");
		assertEquals(null, l1.firstVisibleToken, "No first visible token");
		assertEquals(null, l1.lastVisibleToken, "No last visible token");
		assertEquals(0, l1.indentationLevel, "No visible token, so 0");
		assertEquals(0, l1.visualLength, "No visible token, so 0");
		assertEquals(true, l1.hasToken(), "Has some token.");
		assertEquals(false, l1.hasVisibleToken(), "Does not have any visible token.");
		assertEquals(0, l1.visualOffset(), "No visible token, so 0");
		
		assertEquals(s1.getFormatToken(5, 0), l2.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(5, 0), l2.lastToken, "The last should be set correctly");
		assertEquals(null, l2.firstVisibleToken, "No first visible token");
		assertEquals(null, l2.lastVisibleToken, "No last visible token");
		assertEquals(0, l2.indentationLevel, "No visible token, so 0");
		assertEquals(0, l2.visualLength, "No visible token, so 0");
		assertEquals(true, l2.hasToken(), "Has some token.");
		assertEquals(false, l2.hasVisibleToken(), "Does not have any visible token.");
		assertEquals(0, l2.visualOffset(), "No visible token, so 0");
		
		assertEquals(s1.getFormatToken(6, 0), l3.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(6, 0), l3.lastToken, "The last should be set correctly");
		assertEquals(null, l3.firstVisibleToken, "No first visible token");
		assertEquals(null, l3.lastVisibleToken, "No last visible token");
		assertEquals(0, l3.indentationLevel, "No visible token, so 0");
		assertEquals(0, l3.visualLength, "No visible token, so 0");
		assertEquals(true, l3.hasToken(), "Has some token.");
		assertEquals(false, l3.hasVisibleToken(), "Does not have any visible token.");
		assertEquals(0, l3.visualOffset(), "No visible token, so 0");
	}
	
	/**
	 * Test when a line has visible tokens
	 */
	@Test
	void testVisibleLine()
	{
		// Need a source file with different kinds of visible lines.
		final String file_path_1 = "test_data/visible_lines.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		// Boundary case:
		// Has only one token, which is visible.
		Line l1 = new Line(s1.getFormatToken(3, 0), s1.getFormatToken(3, 0), s1);
		assertEquals(s1.getFormatToken(3, 0), l1.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(3, 0), l1.lastToken, "The last should be set correctly");
		assertEquals(s1.getFormatToken(3, 0), l1.firstVisibleToken, "The first visible should be set correctly");
		assertEquals(s1.getFormatToken(3, 0), l1.lastVisibleToken, "The last visible should be set correctly");
		assertEquals(0, l1.indentationLevel, "0");
		assertEquals(1, l1.visualLength, "1");
		assertEquals(true, l1.hasToken(), "Has some token.");
		assertEquals(true, l1.hasVisibleToken(), "Has some visible token.");
		assertEquals(1, l1.visualOffset(), "1");
		
		// Other normal cases
		Line l2 = new Line(s1.getFormatToken(5, 0), s1.getFormatToken(5, 4), s1);
		assertEquals(s1.getFormatToken(5, 0), l2.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(5, 4), l2.lastToken, "The last should be set correctly");
		assertEquals(s1.getFormatToken(5, 1), l2.firstVisibleToken, "The first visible should be set correctly");
		assertEquals(s1.getFormatToken(5, 4), l2.lastVisibleToken, "The last visible should be set correctly");
		assertEquals(4, l2.indentationLevel, "4");
		assertEquals(8, l2.visualLength, "8");
		assertEquals(true, l2.hasToken(), "Has some token.");
		assertEquals(true, l2.hasVisibleToken(), "Has some visible token.");
		assertEquals(12, l2.visualOffset(), "12");
		
		Line l3 = new Line(s1.getFormatToken(9, 0), s1.getFormatToken(9, 1), s1);
		assertEquals(s1.getFormatToken(9, 0), l3.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(9, 1), l3.lastToken, "The last should be set correctly");
		assertEquals(s1.getFormatToken(9, 1), l3.firstVisibleToken, "The first visible should be set correctly");
		assertEquals(s1.getFormatToken(9, 1), l3.lastVisibleToken, "The last visible should be set correctly");
		assertEquals(4, l3.indentationLevel, "4");
		assertEquals(1, l3.visualLength, "1");
		assertEquals(true, l3.hasToken(), "Has some token.");
		assertEquals(true, l3.hasVisibleToken(), "Has some visible token.");
		assertEquals(5, l3.visualOffset(), "5");
		
		// Abnormal case: invisible spaces after the last visible token.
		Line l4 = new Line(s1.getFormatToken(12, 0), s1.getFormatToken(12, 5), s1);
		assertEquals(s1.getFormatToken(12, 0), l4.firstToken, "The first should be set correctly");
		assertEquals(s1.getFormatToken(12, 5), l4.lastToken, "The last should be set correctly");
		assertEquals(s1.getFormatToken(12, 1), l4.firstVisibleToken, "The first visible should be set correctly");
		assertEquals(s1.getFormatToken(12, 4), l4.lastVisibleToken, "The last visible should be set correctly");
		assertEquals(4, l4.indentationLevel, "4");
		assertEquals(13, l4.visualLength, "13");
		assertEquals(true, l4.hasToken(), "Has some token.");
		assertEquals(true, l4.hasVisibleToken(), "Has some visible token.");
		assertEquals(17, l4.visualOffset(), "17");
	}

	/**
	 * Test when equals() should return false.
	 */
	@Test
	void testLineEqualsUnequal()
	{
		// Need at least two source files with empty and non-empty lines.
		final String file_path_1 = "test_data/visible_lines.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		final String file_path_2 = "test_data/mixture1.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		// null
		assertFalse(s1.getLine(1).equals(null));
		
		// Other objects
		assertFalse(s1.getLine(2).equals(s1));
		
		// Empty line vs non-empty line
		// line 4 is non-empty. line 10 and 6 are empty.
		assertFalse(s1.getLine(10).equals(s1.getLine(4)));
		assertFalse(s1.getLine(4).equals(s1.getLine(6)));
		
		// Different lines from the same source file
		assertFalse(s2.getLine(1).equals(s2.getLine(2)));
		
		// Lines with the same line number, but from two different SFs.
		assertFalse(s1.getLine(11).equals(s2.getLine(11)));
	}
	
	/**
	 * Test when equals() should return true.
	 */
	@Test
	void testLineEqualsEqual()
	{
		// Need at least two source files with empty and non-empty lines.
		final String file_path_1 = "test_data/visible_lines.txt";
		var s1 = TestUtils.createSourceFileNoError(file_path_1);
		
		final String file_path_2 = "test_data/mixture1.txt";
		var s2 = TestUtils.createSourceFileNoError(file_path_2);
		
		// Empty lines should equal to any empty line, even if that is from another source file.
		assertEquals(s1.getLine(10), s2.getLine(12));
		
		// Empty lines from the same sf
		assertEquals(s1.getLine(6), s1.getLine(10));
		
		// Two non-empty lines are equal iff they refer to the same line in the same source file.
		assertEquals(s1.getLine(5), s1.getLine(5));
		assertEquals(s2.getLine(11), s2.getLine(11));
	}
}
