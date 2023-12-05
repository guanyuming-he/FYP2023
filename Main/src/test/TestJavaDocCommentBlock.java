/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.JavaDocCommentBlock.Tag;
import edu.guanyfyp.format.JavaDocCommentBlock;
import edu.guanyfyp.format.JavaDocCommentBlock.AttrTag;

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
		assertEquals("whatever", t1.tag_name);
		assertTrue(t1.tag_text.isEmpty());
		
		Tag t2 = new Tag("@author");
		assertEquals("author", t2.tag_name);
		assertTrue(t2.tag_text.isEmpty());
	}
	
	/**
	 * Only one line of original text
	 */
	@Test
	void testParseTagOneLine() 
	{	
		Tag t1 = new Tag("@whatever abcd");
		assertEquals("whatever", t1.tag_name);
		assertEquals("abcd", t1.tag_text);
		
		Tag t2 = new Tag("@author Guanyuming He ");
		assertEquals("author", t2.tag_name);
		assertEquals("Guanyuming He ", t2.tag_text);
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
		assertEquals("author", t1.tag_name);
		assertEquals
		(
				"Guanyuming He"
				+ "Copyright (C) 2023", t1.tag_text
		);
		
		
		Tag t2 = new Tag
		(
				"@implNote blahblah... j8d92ihe1892\r\n"
				+ "dj9182hnre 12308hn1lk2\r\n"
				+ "12u8340b nel1"
		);
		assertEquals("implNote", t2.tag_name);
		assertEquals
		(
				"blahblah... j8d92ihe1892"
				+ "dj9182hnre 12308hn1lk2"
				+ "12u8340b nel1", t2.tag_text
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
		assertEquals("abc", t1.attr_name);
		assertTrue(t1.attr_text.isEmpty());
		
		// Line breaks should be removed
		AttrTag t2 = new AttrTag
		(
			"@throws \n"
			+ "shitCode"
		);
		assertEquals("shitCode", t2.attr_name);
		assertTrue(t2.attr_text.isEmpty());
	}
	
	/**
	 * Only one line of original text
	 */
	@Test
	void testParseAttrTagOneLine() 
	{	
		AttrTag t1 = new AttrTag("@whatever abcd efgh");
		assertEquals("abcd", t1.attr_name);
		assertEquals("efgh", t1.attr_text);
		
		// multiple spaces
		AttrTag t2 = new AttrTag("@param it the number of items");
		assertEquals("it", t2.attr_name);
		assertEquals("the number of items", t2.attr_text);
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
		assertEquals("Guanyuming_He", t1.attr_name);
		assertEquals
		(
				"Copyright (C) 2023", t1.attr_text
		);
		
		
		AttrTag t2 = new AttrTag
		(
				"@param abc This is def \n"
				+ "wheithiowniofi2j39jp ih18h3in\n"
				+ "j80qhjdin ij0981n"
		);
		assertEquals("abc", t2.attr_name);
		assertEquals
		(
				"This is def "
				+ "wheithiowniofi2j39jp ih18h3in"
				+ "j80qhjdin ij0981n", t2.attr_text
		);
	}
	
	/**
	 * When the JavaDoc String is empty ignoring the *'s
	 * or blank
	 */
	@Test
	void testParseJavaDocEmptyOrBlank()
	{
		var b1 = new JavaDocCommentBlock("/***/", 0, 0, 0, 0);
		assertTrue(b1.main_text.isEmpty());
		assertTrue(b1.tags.isEmpty());
		
		// The comment is this:
		/**
		 * 
		 */
		var b2 = new JavaDocCommentBlock
		(
			"/**\r\n"
			+ " * \r\n" 
			+ " */", 0, 0, 0, 0
		);
		assertTrue(b2.main_text.isEmpty());
		assertTrue(b2.tags.isEmpty());
		
		var b3 = new JavaDocCommentBlock
		(
			"/**\r\n"
			+ " *                  \r\n" 
			+ " */", 0, 0, 0, 0
		);
		assertEquals("                 ", b3.main_text);
		assertTrue(b3.tags.isEmpty());
	}
	
	/**
	 * When the JavaDoc String has only the main description text, 
	 * not any tags
	 */
	@Test
	void testParseJavaDocMainTextOnly()
	{
		// The comment is this
		/**
		 * abcde
		 */
		var b1 = new JavaDocCommentBlock("/**\r\n"
				+ " * abcde\r\n"
				+ " */", 0, 0, 0, 0);
		assertEquals("abcde", b1.main_text);
		assertTrue(b1.tags.isEmpty());
		
		// The comment is this:
		/**
		 * abcde pknsd190n 12mjd.
		 */
		var b2 = new JavaDocCommentBlock
		(
			"/**\r\n"
			+ "		 * abcde pknsd190n 12mjd.\r\n"
			+ "		 */", 0, 0, 0, 0
		);
		assertEquals("abcde pknsd190n 12mjd.", b2.main_text);
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
		var b3 = new JavaDocCommentBlock
		(
			"/**\r\n"
			+ "		 * abcde pknsd190n 12mjd. \r\n"
			+ "		 * jwu091nn89i.\r\n"
			+ "		 * \r\n"
			+ "		 * m90jo1\r\n"
			+ "		 * \r\n"
			+ "		 * \r\n"
			+ "		 * w9je91n2h0 d12.\r\n"
			+ "		 */", 0, 0, 0, 0
		);
		assertEquals("abcde pknsd190n 12mjd. jwu091nn89i.m90jo1w9je91n2h0 d12.", b3.main_text);
		assertTrue(b3.tags.isEmpty());
	}
	
	/**
	 * When the JavaDoc String has the main text and tags
	 */
	@Test
	void testParseJavaDocAll()
	{
		var b1 = new JavaDocCommentBlock("/**\r\n"
				+ " * abcde pknsd190n 12mjd. \r\n"
				+ " * jwu091nn89i.\r\n"
				+ " * \r\n"
				+ " * @author Guanyuming He\r\n"
				+ " * @param abc def\r\n"
				+ " */", 0, 0, 0, 0);
		assertEquals("abcde pknsd190n 12mjd. jwu091nn89i.", b1.main_text);
		
		var expectedTags = List.of
		(
			new Tag("@author Guanyuming He"),
			(Tag)(new AttrTag("@param abc def"))
		);
		assertEquals(expectedTags, b1.tags);
		
		assertEquals(List.of(Integer.valueOf(1)), b1.param_tags);
		assertTrue(b1.throws_tags.isEmpty());
		
		var b2 = new JavaDocCommentBlock("/**\r\n"
				+ " * abc\r\n"
				+ " * \r\n"
				+ " * @author Guanyuming He\r\n"
				+ " * @param abc def\r\n"
				+ " * @param bbb ddd \r\n"
				+ " * eee fff\r\n"
				+ " * @throws Exception when \r\n"
				+ " * this and that and this and that\r\n"
				+ " */", 0, 0, 0, 0);
		assertEquals("abc", b2.main_text);
		
		var expectedTags2 = List.of
		(
			new Tag("@author Guanyuming He"),
			(Tag)(new AttrTag("@param abc def")),
			(Tag)(new AttrTag("@param bbb ddd eee fff")),
			(Tag)(new AttrTag("@throws Exception when this and that and this and that"))
		);
		assertEquals(expectedTags2, b2.tags);
		
		assertEquals(List.of(Integer.valueOf(1),Integer.valueOf(2)), b2.param_tags);
		assertEquals(List.of(Integer.valueOf(3)), b2.throws_tags);
	}
}
