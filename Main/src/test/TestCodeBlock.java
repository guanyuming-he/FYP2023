/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.antlr.v4.runtime.CommonToken;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.generated.JavaLexer;

/**
 * Test if this class works correctly.
 */
class TestCodeBlock 
{

	/**
	 * This test is here to hopefully catch
	 * missing break; or typos in the switch statement
	 */
	@Test
	void testSetTypeFromLexerTokenType() 
	{
		// A CodeBlock requires an ANTLR token to create.
		var t = new CommonToken(0, "abc");
		CodeBlock cb = new CodeBlock(t, 0, 0);
		
		// Some keywords
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.ABSTRACT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.IMPLEMENTS);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.INT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.CHAR);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.CLASS);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.PUBLIC);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.IMPORT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.VAR);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additionalAttr.getType());
		
		
		// Literals
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.DECIMAL_LITERAL);
		assertEquals(CodeBlock.Type.NUMBER_LITERAL, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.BINARY_LITERAL);
		assertEquals(CodeBlock.Type.NUMBER_LITERAL, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.CHAR_LITERAL);
		assertEquals(CodeBlock.Type.STRING_LITERAL, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.NULL_LITERAL);
		assertEquals(CodeBlock.Type.NULL_LITERAL, cb.additionalAttr.getType());
		
		// Separators (punctuations)
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.RBRACK);
		assertEquals(CodeBlock.Type.R_SBRACKET, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.LBRACE);
		assertEquals(CodeBlock.Type.L_CBRACKET, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.SEMI);
		assertEquals(CodeBlock.Type.SEMICOLON, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.DOT);
		assertEquals(CodeBlock.Type.DOT, cb.additionalAttr.getType());
		
		// Some operators
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.COLON);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.NOTEQUAL);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.DIV);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.ADD_ASSIGN);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.MOD);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.RSHIFT_ASSIGN);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additionalAttr.getType());
		
		// Identifier
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.IDENTIFIER);
		assertEquals(CodeBlock.Type.IDENTIFIER_UNCLASSIFIED, cb.additionalAttr.getType());
		
		// Misc
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.ELLIPSIS);
		assertEquals(CodeBlock.Type.OTHERS, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.AT);
		assertEquals(CodeBlock.Type.OTHERS, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.ARROW);
		assertEquals(CodeBlock.Type.OTHERS, cb.additionalAttr.getType());
		cb.additionalAttr.setTypeFromLexerTokenType(JavaLexer.COLONCOLON);
		assertEquals(CodeBlock.Type.OTHERS, cb.additionalAttr.getType());
	}
	
	/**
	 * Visibility test
	 */
	@Test
	void testVisibility()
	{
		// Let cb be any code block
		var t = new CommonToken(0, "abc");
		CodeBlock cb = new CodeBlock(t, 0, 0);
		
		assertTrue(cb.isVisible(), "Every code block should be visible.");
	}

}
