/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.CodeBlock;

/**
 * 
 */
class TestContextBuilder {

	/**
	 * I assume that the parser shares the same token stream with the lexer,
	 * and therefore the tokens there should have the same indices as the lexer
	 * even if the parser ignores the comments and white spaces.
	 */
	@Test
	void testParserTokenIndex() 
	{
		// See if the indices of the tokens in the parse tree are what I expected them to be.
		
		var src = TestSourceFile.createSourceFileNoError("test_data/many_declarations.txt");
		
		var context_builder = src.get_syntax_context_builder();
		var additional_tokens_attributes = context_builder.get_additional_token_attributes();
		
		// class ABC
		assertTrue(additional_tokens_attributes.containsKey(5));
		assertEquals(CodeBlock.Type.CLASS_NAME, additional_tokens_attributes.get(5));
		
		// int a
		assertTrue(additional_tokens_attributes.containsKey(12));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(12));
		// int b
		assertTrue(additional_tokens_attributes.containsKey(15));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(15));
		// int c
		assertTrue(additional_tokens_attributes.containsKey(18));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(18));
		
		// Constructor ABC
		assertTrue(additional_tokens_attributes.containsKey(27));
		assertEquals(CodeBlock.Type.CONSTRUCTOR_NAME, additional_tokens_attributes.get(27));
		
		// method abc
		assertTrue(additional_tokens_attributes.containsKey(39));
		assertEquals(CodeBlock.Type.METHOD_NAME, additional_tokens_attributes.get(39));
		
		// enum EABC
		assertTrue(additional_tokens_attributes.containsKey(54));
		assertEquals(CodeBlock.Type.ENUM_NAME, additional_tokens_attributes.get(54));
	}

}
