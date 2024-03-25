/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.antlr.v4.runtime.CommonToken;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.format.primitives.JavaDocBlock.AttrTag;
import edu.guanyfyp.format.primitives.JavaDocBlock.Tag;

/**
 * Tests how this class handles JavaDoc
 */
class TestJavaDocCommentBlock 
{

	/**
	 * When there is no space after a tag's name
	 */
	@Test
	void testParseTagNoTagText() 
	{
		// Only tag name is here
		
		Tag t1 = new Tag("@whatever");
		assertEquals("whatever", t1.tagName);
		assertTrue(t1.tagText.isEmpty());
		
		Tag t2 = new Tag("@author");
		assertEquals("author", t2.tagName);
		assertTrue(t2.tagText.isEmpty());
	}
	
	/**
	 * Only one line of original text
	 */
	@Test
	void testParseTagOneLine() 
	{	
		Tag t1 = new Tag("@whatever abcd");
		assertEquals("whatever", t1.tagName);
		assertEquals("abcd", t1.tagText);
		
		Tag t2 = new Tag("@author Guanyuming He ");
		assertEquals("author", t2.tagName);
		assertEquals("Guanyuming He ", t2.tagText);
	}

	/**
	 * Multiple lines of text
	 */
	@Test
	void testParseTagMultiLines() 
	{
		// Note that the line breaks should be correctly removed.
		
		Tag t1 = new Tag
		(
			"@author Guanyuming He\r\n"
			+ "Copyright (C) 2023\r\n"
		);
		assertEquals("author", t1.tagName);
		assertEquals
		(
				"Guanyuming He"
				+ "Copyright (C) 2023", t1.tagText
		);
		
		
		Tag t2 = new Tag
		(
				"@implNote blahblah... j8d92ihe1892\r\n"
				+ "dj9182hnre 12308hn1lk2\r\n"
				+ "12u8340b nel1"
		);
		assertEquals("implNote", t2.tagName);
		assertEquals
		(
				"blahblah... j8d92ihe1892"
				+ "dj9182hnre 12308hn1lk2"
				+ "12u8340b nel1", t2.tagText
		);
	}
	
	/**
	 * When there is no space after a tag's attribute
	 */
	@Test
	void testParseAttrTagNoAttrText() 
	{
		// Only attribute is here
			
		AttrTag t1 = new AttrTag("@param abc");
		assertEquals("abc", t1.attrName);
		assertTrue(t1.attrText.isEmpty());
		
		// Line breaks should be removed
		AttrTag t2 = new AttrTag
		(
			"@throws \n"
			+ "shitCode"
		);
		assertEquals("shitCode", t2.attrName);
		assertTrue(t2.attrText.isEmpty());
	}
	
	/**
	 * Only one line of original text
	 */
	@Test
	void testParseAttrTagOneLine() 
	{	
		AttrTag t1 = new AttrTag("@whatever abcd efgh");
		assertEquals("abcd", t1.attrName);
		assertEquals("efgh", t1.attrText);
		
		// multiple spaces
		AttrTag t2 = new AttrTag("@param it the number of items");
		assertEquals("it", t2.attrName);
		assertEquals("the number of items", t2.attrText);
	}

	/**
	 * Multiple lines of text
	 */
	@Test
	void testParseAttrTagMultiLines() 
	{
		// Note that the line breaks should be correctly removed.
		
		
		AttrTag t1 = new AttrTag
		(
			"@author Guanyuming_He\r\n"
			+ " Copyright (C) 2023\r\n"
		);
		assertEquals("Guanyuming_He", t1.attrName);
		assertEquals
		(
				"Copyright (C) 2023", t1.attrText
		);
		
		
		AttrTag t2 = new AttrTag
		(
				"@param abc This is def \n"
				+ "wheithiowniofi2j39jp ih18h3in\n"
				+ "j80qhjdin ij0981n"
		);
		assertEquals("abc", t2.attrName);
		assertEquals
		(
				"This is def "
				+ "wheithiowniofi2j39jp ih18h3in"
				+ "j80qhjdin ij0981n", t2.attrText
		);
	}
	
	/**
	 * When the JavaDoc String is empty ignoring the *'s
	 * or blank
	 */
	@Test
	void testParseJavaDocEmptyOrBlank()
	{
		// A JavaDocCommentBlock requires an ANTLR token to create.
		var t = new CommonToken(0, "/***/");
		var b1 = new JavaDocBlock(t, 0, 0);
		assertTrue(b1.mainText.isEmpty());
		assertTrue(b1.tags.isEmpty());
		
		// The comment is this:
		/**
		 * 
		 */
		t = new CommonToken(0, "/**\r\n"
				+ " *\r\n" 
				+ "*/");
		var b2 = new JavaDocBlock(t, 0, 0);
		assertTrue(b2.mainText.isEmpty());
		assertTrue(b2.tags.isEmpty());
		
		// The comment is this:
		/**
		 * spaces.....
		 */
		t = new CommonToken(0, "/**\r\n"
				+ "   *                 \r\n" 
				+ "    */");
		var b3 = new JavaDocBlock(t, 0, 0);
		assertEquals("                     ", b3.mainText);
		assertTrue(b3.tags.isEmpty());
	}
	
	/**
	 * When the JavaDoc String has only the main description text, 
	 * not any tags
	 */
	@Test
	void testParseJavaDocMainTextOnly()
	{
		// A JavaDocCommentBlock requires an ANTLR token to create.
		var t = new CommonToken(0, "/**\r\n"
				+ " * abcde\r\n"
				+ " */");
		
		// The comment is this
		/**
		 * abcde
		 */
		var b1 = new JavaDocBlock(t, 0, 0);
		assertEquals(" abcde ", b1.mainText);
		assertTrue(b1.tags.isEmpty());
		
		// The comment is this:
		/**
		 * abcde pknsd190n 12mjd.
		 */
		t = new CommonToken(0, "/**\r\n"
				+ "		 * abcde pknsd190n 12mjd.\r\n"
				+ "		 */");
		var b2 = new JavaDocBlock(t, 0, 0);
		assertEquals(" abcde pknsd190n 12mjd.		 ", b2.mainText);
		assertTrue(b2.tags.isEmpty());
		
		// The comment is this:
		/**
		 * abcde pknsd190n 12mjd. 
		 * jwu091nn89i.
		 * 
		 * m90jo1
		 * 
		 * 
		 * w9je91n2h0 d12.
		 */
		t = new CommonToken(0, "/**\r\n"
				+ "		 * abcde pknsd190n 12mjd. \r\n"
				+ "		 *jwu091nn89i.\r\n"
				+ "		 *\r\n"
				+ "		 * m90jo1\r\n"
				+ "		 *\r\n"
				+ "		 *\r\n"
				+ "		 *w9je91n2h0 d12.\r\n"
				+ "		 */");
		var b3 = new JavaDocBlock(t, 0, 0);
		assertEquals(" abcde pknsd190n 12mjd. jwu091nn89i. m90jo1w9je91n2h0 d12.		 ", b3.mainText);
		assertTrue(b3.tags.isEmpty());
	}
	
	/**
	 * When the JavaDoc String has the main text and tags
	 */
	@Test
	void testParseJavaDocAll()
	{
		// A JavaDocCommentBlock requires an ANTLR token to create.
		var t = new CommonToken(0, "/**\r\n"
				+ " *abcde pknsd190n 12mjd. \r\n"
				+ " * jwu091nn89i.\r\n"
				+ " *\r\n"
				+ " * @author Guanyuming He\r\n"
				+ " *@param abc def\r\n"
				+ " */");
		
		var b1 = new JavaDocBlock(t, 0, 0);
		assertEquals("abcde pknsd190n 12mjd.  jwu091nn89i.", b1.mainText);
		
		var expectedTags = List.of
		(
			new Tag("@author Guanyuming He"),
			(Tag)(new AttrTag("@param abc def "))
		);
		assertEquals(expectedTags, b1.tags);
		
		assertEquals(List.of(Integer.valueOf(1)), b1.paramTags);
		assertTrue(b1.throwsTags.isEmpty());
		
		t = new CommonToken(0, "/**\r\n"
				+ " *abc\r\n"
				+ " *\r\n"
				+ " *@author Guanyuming He\r\n"
				+ " *@param abc def\r\n"
				+ " *@param bbb ddd \r\n"
				+ " * eee fff\r\n"
				+ " *@throws Exception when \r\n"
				+ " *this and that and this and that\r\n"
				+ " */");
		var b2 = new JavaDocBlock(t, 0, 0);
		assertEquals("abc", b2.mainText);
		
		var expectedTags2 = List.of
		(
			new Tag("@author Guanyuming He"),
			(Tag)(new AttrTag("@param abc def")),
			(Tag)(new AttrTag("@param bbb ddd  eee fff")),
			(Tag)(new AttrTag("@throws Exception when this and that and this and that "))
		);
		assertEquals(expectedTags2, b2.tags);
		
		assertEquals(List.of(Integer.valueOf(1),Integer.valueOf(2)), b2.paramTags);
		assertEquals(List.of(Integer.valueOf(3)), b2.throwsTags);
	}
	
	/**
	 * Bug 1: when space was found before @ in a line,
	 * the parsing would fail.
	 */
	@Test
	void testPreviousBug1()
	{
		// A JavaDocCommentBlock requires an ANTLR token to create.
		var t = new CommonToken(0, "/**\n @param abc*/");
		var b1 = new JavaDocBlock(t, 0, 0);
		assertEquals("", b1.mainText);
		var expectedTags = List.of
		(
			new Tag("@param abc")
		);
		assertEquals(expectedTags, b1.tags);
	}
}
