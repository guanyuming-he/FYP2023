/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.primitives.CodeBlock;

/**
 * 
 */
class TestSyntaxStructureBuilder {

	/**
	 * I assume that the parser shares the same token stream with the lexer,
	 * and therefore the tokens there should have the same indices as the lexer
	 * even if the parser ignores the comments and white spaces.
	 */
	@Test
	void testParserTokenIndex() 
	{
		// See if the indices of the tokens in the parse tree are what I expected them to be.
		
		var src = TestUtils.createSourceFileNoError("test_data/many_declarations.txt");
		
		var builder = src.getSyntaxStructureBuilder();
		var additional_tokens_attributes = builder.getAdditionalTokenAttributes();
		
		// class ABC
		assertTrue(additional_tokens_attributes.containsKey(5));
		assertEquals(CodeBlock.Type.CLASS_NAME, additional_tokens_attributes.get(5).getType());
		
		// int a
		assertTrue(additional_tokens_attributes.containsKey(12));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(12).getType());
		// int b
		assertTrue(additional_tokens_attributes.containsKey(15));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(15).getType());
		// int c
		assertTrue(additional_tokens_attributes.containsKey(18));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(18).getType());
		
		// Constructor ABC
		assertTrue(additional_tokens_attributes.containsKey(27));
		assertEquals(CodeBlock.Type.CONSTRUCTOR_NAME, additional_tokens_attributes.get(27).getType());
		
		// method abc
		assertTrue(additional_tokens_attributes.containsKey(39));
		assertEquals(CodeBlock.Type.METHOD_NAME, additional_tokens_attributes.get(39).getType());
		
		// enum EABC
		assertTrue(additional_tokens_attributes.containsKey(54));
		assertEquals(CodeBlock.Type.ENUM_NAME, additional_tokens_attributes.get(54).getType());
	}

	/**
	 * Tests if after the syntax and partial semantical analysis
	 * the code blocks in a source file gets more accurate types
	 */
	@Test
	void testAdditionalAttributesType()
	{
		var src = TestUtils.createSourceFileNoError("test_data/mixture2.txt");
		
		// a global class
		var a_class = (CodeBlock)src.getFormatToken(12, 6);
		assertEquals(CodeBlock.Type.CLASS_NAME, a_class.additionalAttr.getType());
		
		// defined inside the first class
		var another_class = (CodeBlock)src.getFormatToken(14, 9);
		assertEquals(CodeBlock.Type.CLASS_NAME, another_class.additionalAttr.getType());
		
		// A field in the inner class
		var a_field = (CodeBlock)src.getFormatToken(16, 5);
		assertEquals(CodeBlock.Type.FIELD_NAME, a_field.additionalAttr.getType());
		
		// an enumeration
		var an_enum = (CodeBlock)src.getFormatToken(19, 5);
		assertEquals(CodeBlock.Type.ENUM_NAME, an_enum.additionalAttr.getType());
		
		// a method
		var a_method = (CodeBlock)src.getFormatToken(25, 7);
		assertEquals(CodeBlock.Type.METHOD_NAME, a_method.additionalAttr.getType());
		
		// another field, but in the global class
		var another_field = (CodeBlock)src.getFormatToken(28, 7);
		assertEquals(CodeBlock.Type.FIELD_NAME, another_field.additionalAttr.getType());
		
		// another method, more complex
		var another_method = (CodeBlock)src.getFormatToken(36, 5);
		assertEquals(CodeBlock.Type.METHOD_NAME, another_method.additionalAttr.getType());
		
		// some parameters
		var par1 = (CodeBlock)src.getFormatToken(36, 12);
		assertEquals(CodeBlock.Type.PARAMETER_NAME, par1.additionalAttr.getType());
		var par2 = (CodeBlock)src.getFormatToken(36, 17);
		assertEquals(CodeBlock.Type.PARAMETER_NAME, par2.additionalAttr.getType());
		var par3 = (CodeBlock)src.getFormatToken(36, 22);
		assertEquals(CodeBlock.Type.PARAMETER_NAME, par3.additionalAttr.getType());
		
		// a local variable
		var a_local_var = (CodeBlock)src.getFormatToken(38, 3);
		assertEquals(CodeBlock.Type.VARIABLE_NAME, a_local_var.additionalAttr.getType());
		
		// a for-loop variable
		var a_for_var = (CodeBlock)src.getFormatToken(40, 5);
		assertEquals(CodeBlock.Type.FOR_VARIABLE_NAME, a_for_var.additionalAttr.getType());
		
		// another local variable, which is inside a for loop
		var another_local_var = (CodeBlock)src.getFormatToken(42, 3);
		assertEquals(CodeBlock.Type.VARIABLE_NAME, another_local_var.additionalAttr.getType());
	}
}
