/**
 * 
 */
package edu.guanyfyp;

import java.util.HashMap;

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
	public SyntaxContext get_syntax_context()
	{
		return context;
	}
	
	// A list of additional attributes for the format tokens is built during a walk.
	// token index (in the token stream, getTokenIndex()) -> additional information
	// Because the tokens that the parser processes are only CodeBlocks,
	// only this Type information is needed.
	private final HashMap<Integer, CodeBlock.Type> additional_token_attributes;
	public HashMap<Integer, CodeBlock.Type> get_additional_token_attributes()
	{
		return additional_token_attributes;
	}
	
	public ContextBuilder(SourceFile sf) 
	{
		this.source_file = sf;
		this.additional_token_attributes = new HashMap<>();
	}

	/**
	 * When a declaration of a class is encountered
	 */
	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx)
	{
		// the class name token.
		Token token = ctx.identifier().getStart();

		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.CLASS_NAME);
	}
	
	/**
	 * When a declaration of an enumeration is encountered
	 */
	@Override
	public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx)
	{
		// the enumeration name token.
		Token token = ctx.identifier().getStart();

		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.ENUM_NAME);
	}
	
	/**
	 * When a declaration of an interface is encountered
	 */
	@Override
	 public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx)
	 {
		// the interface name token.
		Token token = ctx.identifier().getStart();

		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.ENUM_NAME);
	 }
	
	/**
	 * When a declaration of a class method is encountered
	 */
	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx)
	{
		// the method name token.
		Token token = ctx.identifier().getStart();
	
		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.METHOD_NAME);
	}
	
	/**
	 * When a declaration of a generic class method is encountered
	 */
	@Override
	public void enterGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx)
	{
		// the generic method name token.
		Token token = ctx.methodDeclaration().identifier().getStart();
	
		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.METHOD_NAME);
	}
	
	/**
	 * When a declaration of a constructor is encountered
	 */
	@Override
	public void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx)
	{
		// the constructor name token.
		Token token = ctx.identifier().getStart();
	
		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.CONSTRUCTOR_NAME);
	}
	
	/**
	 * When a declaration of a generic constructor is encountered
	 */
	@Override
	public void enterGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx)
	{
		// the generic constructor method name token.
		Token token = ctx.constructorDeclaration().identifier().getStart();
	
		additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.CONSTRUCTOR_NAME);
	}
	
	/**
	 * When a declaration of a field is encountered
	 */
	@Override 
	public void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx)
	{
		// A field declaration can declare multiple variables,
		// as in "int a, b, c;"
		var variable_declarator_list = ctx.variableDeclarators().variableDeclarator();
		for(var variable_declarator : variable_declarator_list)
		{
			// One variable token.
			Token token = variable_declarator.variableDeclaratorId().identifier().getStart();
			additional_token_attributes.put(token.getTokenIndex(), CodeBlock.Type.FIELD_NAME);
		}
	}
}
