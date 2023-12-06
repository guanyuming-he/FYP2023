/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.HashMap;

import org.antlr.v4.runtime.Token;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.CodeBlock;
import edu.guanyfyp.format.CodeBlock.AdditionalAttributes;
import edu.guanyfyp.format.FormatToken;
import edu.guanyfyp.generated.JavaParser;
import edu.guanyfyp.generated.JavaParserBaseListener;

/**
 * Builds a SyntaxContext by walking the parse tree
 */
public class SyntaxStructureBuilder extends JavaParserBaseListener {

	public SyntaxStructureBuilder(SourceFile sf) 
	{
		this.source_file = sf;
		this.additional_token_attributes = new HashMap<>();
	}
	
	/**
	 * Reference to the SourceFile that produced this listener.
	 * The listener will attach more information to the tokens of the source_file.
	 */
	private final SourceFile source_file;
	/**
	 * The syntax structure the listener will build during a walk.
	 * It should be complete after a walk.
	 */
	private final SyntaxStructure syntax_structure = new SyntaxStructure();
	public SyntaxStructure get_syntax_structure()
	{
		return syntax_structure;
	}
	
	
	// A list of additional attributes for the format tokens is built during a walk.
	// token index (in the token stream, getTokenIndex()) -> additional information
	// Because the tokens that the parser processes are only CodeBlocks,
	// only this Type information is needed.
	private final HashMap<Integer, CodeBlock.AdditionalAttributes> additional_token_attributes;
	public HashMap<Integer, CodeBlock.AdditionalAttributes> get_additional_token_attributes()
	{
		return additional_token_attributes;
	}
	
	/**
	 * TypeDeclaration is defined as 
	 * modifiers* AND XXXDeclaration
	 * Therefore I have to enter TypeDeclaration to get the modifiers first
	 * and then enter XXXDeclaration to apply the pending modifiers.
	 * If there are no type modifiers pending, the field is null.
	 */
	private AdditionalAttributes pending_type_modifiers = null;
	
	/**
	 * Because I care about the modifiers, I have to explore here
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx)
	{
		pending_type_modifiers = new AdditionalAttributes();
		var modifiersList = ctx.classOrInterfaceModifier();
		for(var modifier : modifiersList)
		{
			switch(modifier.getText())
			{
			case "public" -> 
				pending_type_modifiers.set_OOP_modifier(AdditionalAttributes.OOP_MODIFIER_PUBLIC);
			case "protected" ->
				pending_type_modifiers.set_OOP_modifier(AdditionalAttributes.OOP_MODIFIER_PROTECTED);
			case "private" ->
				pending_type_modifiers.set_OOP_modifier(AdditionalAttributes.OOP_MODIFIER_PRIVATE);
			case "static" -> 
				pending_type_modifiers.set_other_modifier(AdditionalAttributes.MODIFIER_STATIC);
			case "abstract" ->
				pending_type_modifiers.set_OOP_modifier(AdditionalAttributes.OOP_MODIFIER_ABSTRACT);
			case "final" ->
				pending_type_modifiers.set_other_modifier(AdditionalAttributes.MODIFIER_FINAL);
			case "strictfp" -> 
				pending_type_modifiers.set_other_modifier(AdditionalAttributes.MODIFIER_STRICTFP);
			}
		}
	}
	
	/**
	 * According to the comments above, I only need a type after I have the pending modifiers.
	 * @param type the type of the type declaration (e.g. class, interface, enum)
	 * @param tokenInd the index of the type name token
	 */
	private void setAdditionalAttributesForTypeDeclaration(CodeBlock.Type type, int tokenInd)
	{
		AdditionalAttributes attr = new AdditionalAttributes();
		attr.setType(type);
		// modifiers (from the type declaration)
		// can be empty but can't be null.
		assert pending_type_modifiers != null;
		attr.assign_OOP_modifiers(pending_type_modifiers.get_OOP_modifiers());
		attr.assign_other_modifiers(pending_type_modifiers.get_other_modifiers());
		
		additional_token_attributes.put(tokenInd, attr);
		// reset the pending type modifiers.
		pending_type_modifiers = null;
	}

	/**
	 * When a declaration of a class is encountered
	 */
	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx)
	{
		// the class name token.
		Token token = ctx.identifier().getStart();
		
		// additional attributes
		setAdditionalAttributesForTypeDeclaration(CodeBlock.Type.CLASS_NAME, token.getTokenIndex());
	}
	
	/**
	 * When a declaration of an enumeration is encountered
	 */
	@Override
	public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx)
	{
		// the enumeration name token.
		Token token = ctx.identifier().getStart();

		// additional attributes
		setAdditionalAttributesForTypeDeclaration(CodeBlock.Type.ENUM_NAME, token.getTokenIndex());
	}
	
	/**
	 * When a declaration of an interface is encountered
	 */
	@Override
	 public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx)
	 {
		// the interface name token.
		Token token = ctx.identifier().getStart();

		// additional attributes
		setAdditionalAttributesForTypeDeclaration(CodeBlock.Type.INTERFACE_NAME, token.getTokenIndex());
	 }
	
	/**
	 * When a declaration of a class method is encountered
	 */
	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx)
	{
		// the method name token.
		Token token = ctx.identifier().getStart();
	
		// TODO
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
