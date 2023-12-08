/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.CodeBlock;
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
		CodeBlock cb = new CodeBlock("abc", 0, 0, 0, 0);
		
		// Some keywords
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.ABSTRACT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.IMPLEMENTS);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.INT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.CHAR);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.CLASS);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.PUBLIC);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.IMPORT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.VAR);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.additional_attr.getType());
		
		
		// Literals
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.DECIMAL_LITERAL);
		assertEquals(CodeBlock.Type.NUMBER_LITERAL, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.BINARY_LITERAL);
		assertEquals(CodeBlock.Type.NUMBER_LITERAL, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.CHAR_LITERAL);
		assertEquals(CodeBlock.Type.STRING_LITERAL, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.NULL_LITERAL);
		assertEquals(CodeBlock.Type.NULL_LITERAL, cb.additional_attr.getType());
		
		// Separators (punctuations)
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.RBRACK);
		assertEquals(CodeBlock.Type.R_SBRACKET, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.LBRACE);
		assertEquals(CodeBlock.Type.L_CBRACKET, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.SEMI);
		assertEquals(CodeBlock.Type.SEMICOLON, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.DOT);
		assertEquals(CodeBlock.Type.DOT, cb.additional_attr.getType());
		
		// Some operators
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.COLON);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.NOTEQUAL);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.DIV);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.ADD_ASSIGN);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.MOD);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.RSHIFT_ASSIGN);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.additional_attr.getType());
		
		// Identifier
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.IDENTIFIER);
		assertEquals(CodeBlock.Type.IDENTIFIER_UNCLASSIFIED, cb.additional_attr.getType());
		
		// Misc
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.ELLIPSIS);
		assertEquals(CodeBlock.Type.OTHERS, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.AT);
		assertEquals(CodeBlock.Type.OTHERS, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.ARROW);
		assertEquals(CodeBlock.Type.OTHERS, cb.additional_attr.getType());
		cb.additional_attr.setTypeFromLexerTokenType(JavaLexer.COLONCOLON);
		assertEquals(CodeBlock.Type.OTHERS, cb.additional_attr.getType());
	}

}
