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
class testCodeBlock 
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
		cb.setTypeFromLexerTokenType(JavaLexer.ABSTRACT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.IMPLEMENTS);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.INT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.CHAR);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.CLASS);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.PUBLIC);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.IMPORT);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.VAR);
		assertEquals(CodeBlock.Type.KEYWORD_UNCLASSIFIED, cb.getType());
		
		
		// Literals
		cb.setTypeFromLexerTokenType(JavaLexer.DECIMAL_LITERAL);
		assertEquals(CodeBlock.Type.NUMBER_LITERAL, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.BINARY_LITERAL);
		assertEquals(CodeBlock.Type.NUMBER_LITERAL, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.CHAR_LITERAL);
		assertEquals(CodeBlock.Type.STRING_LITERAL, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.NULL_LITERAL);
		assertEquals(CodeBlock.Type.NULL_LITERAL, cb.getType());
		
		// Separators (punctuations)
		cb.setTypeFromLexerTokenType(JavaLexer.RBRACK);
		assertEquals(CodeBlock.Type.R_SBRACKET, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.LBRACE);
		assertEquals(CodeBlock.Type.L_CBRACKET, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.SEMI);
		assertEquals(CodeBlock.Type.SEMICOLON, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.DOT);
		assertEquals(CodeBlock.Type.DOT, cb.getType());
		
		// Some operators
		cb.setTypeFromLexerTokenType(JavaLexer.COLON);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.NOTEQUAL);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.DIV);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.ADD_ASSIGN);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.MOD);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.RSHIFT_ASSIGN);
		assertEquals(CodeBlock.Type.OPERATOR_UNCLASSIFIED, cb.getType());
		
		// Identifier
		cb.setTypeFromLexerTokenType(JavaLexer.IDENTIFIER);
		assertEquals(CodeBlock.Type.IDENTIFIER_UNCLASSIFIED, cb.getType());
		
		// Misc
		cb.setTypeFromLexerTokenType(JavaLexer.ELLIPSIS);
		assertEquals(CodeBlock.Type.OTHERS, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.AT);
		assertEquals(CodeBlock.Type.OTHERS, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.ARROW);
		assertEquals(CodeBlock.Type.OTHERS, cb.getType());
		cb.setTypeFromLexerTokenType(JavaLexer.COLONCOLON);
		assertEquals(CodeBlock.Type.OTHERS, cb.getType());
	}

}
