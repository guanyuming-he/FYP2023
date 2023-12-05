/**
 * 
 */
package edu.guanyfyp;

import org.antlr.v4.runtime.Token;

import edu.guanyfyp.format.CodeBlock;
import edu.guanyfyp.format.FormatToken;
import edu.guanyfyp.generated.JavaParser;
import edu.guanyfyp.generated.JavaParserBaseListener;

/**
 * Builds a SyntaxContext by walking the parse tree
 */
public class ContextBuilder extends JavaParserBaseListener {

	/**
	 * Reference to the SourceFile that produced this listener.
	 * The listener will attach more information to the tokens of the source_file.
	 */
	private final SourceFile source_file;
	/**
	 * The syntax context the listener will build during a walk.
	 * It should be complete after a walk.
	 */
	private final SyntaxContext context = new SyntaxContext();
	
	public ContextBuilder(SourceFile sf) 
	{
		this.source_file = sf;
	}

	/**
	 * When a declaration of a class is encountered
	 */
	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx)
	{
		// the class name token.
		Token token = ctx.identifier().getStart();
		CodeBlock cb = (CodeBlock)source_file.getFormatToken(token);
		
		cb.setType(CodeBlock.Type.CLASS_NAME);
		
		// TODO: Maybe maintain a list of additional information for each token walked
		// then update the additional information in one iteration of the format tokens.
	}
	
}
