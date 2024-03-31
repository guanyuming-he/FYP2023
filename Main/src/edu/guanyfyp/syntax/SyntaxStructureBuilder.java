/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.CodeBlock.AdditionalAttributes;
import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.format.primitives.JavaDocBlock.FollowingMethod;
import edu.guanyfyp.format.primitives.JavaDocBlock.FollowingType;
import edu.guanyfyp.generated.JavaParser;
import edu.guanyfyp.generated.JavaParserBaseListener;
import edu.guanyfyp.syntax.SyntaxScope.Type;
import edu.guanyfyp.generated.JavaParser.AnnotationContext;
import edu.guanyfyp.generated.JavaParser.ForInitContext;

/**
 * Builds a SyntaxContext by walking the parse tree.
 * In addition, it completes the syntactical information stored in the SourceFile
 * during the walk.
 */
public class SyntaxStructureBuilder extends JavaParserBaseListener {

	public SyntaxStructureBuilder(SourceFile sf) 
	{
		this.sourceFile = sf;
	}

	
///////////////////////////// SyntaxStructure related /////////////////////////
	/**
	 * Reference to the SourceFile that produced this listener.
	 * The listener will attach more information to the tokens of the source_file.
	 */
	private final SourceFile sourceFile;
	/**
	 * The syntax structure the listener will build during a walk.
	 * It should be complete after a walk.
	 */
	private final SyntaxStructure syntaxStructure = new SyntaxStructure();
	public SyntaxStructure getSyntaxStructure()
	{
		return syntaxStructure;
	}
	
	
///////////////////////////// additional attributes related /////////////////////////
	// A list of additional attributes for the format tokens is built during a walk.
	// token index (in the token stream, getTokenIndex()) -> additional information
	// Because the tokens that the parser processes are only CodeBlocks,
	// only this Type's information is needed.
	// defined as sorted map so I can get all keys in a range.
	private final SortedMap<Integer, CodeBlock.AdditionalAttributes> additionalTokenAttributes = new TreeMap<>();
	public SortedMap<Integer, CodeBlock.AdditionalAttributes> getAdditionalTokenAttributes()
	{
		return additionalTokenAttributes;
	}
	
	/**
	 * Should only be called after a complete walk on the parsing tree
	 * to apply the obtained additional attributes to the format tokens
	 * in the SourceFile
	 */
	public void applyAdditionalTokenAttributes()
	{
		var indices = additionalTokenAttributes.keySet();
		for(int ind : indices)
		{
			CodeBlock cb = (CodeBlock)sourceFile.getFormatToken(ind);
			// move the additional attributes to the code block's
			cb.additionalAttr.move(additionalTokenAttributes.get(ind));
		}
	}
	
	/**
	 * Here, during the syntax and potential semantic analysis,
	 * I will attach additional attributes to each identifier in the source code.
	 * 
	 * However, because of the structure of the Java grammar, the attributes may not
	 * be fully known at one place, but often needs information around the identifier.
	 * Hence, I create this pending attributes variable that waits to be applied to an identifier.
	 * 
	 * The pending attributes will be consumed by the first code block that uses it
	 * and be reset to nothing.
	 * 
	 * On a legal piece of Java code, this reset process should work without problems.
	 */
	private AdditionalAttributes pendingAttributes = new AdditionalAttributes();
	
	/**
	 * Resets pending_modifiers to having no additional information
	 * i.e. to a new AdditionalAttributes();
	 */
	private void resetPendingAttributes() 
	{ 
		pendingAttributes = new AdditionalAttributes();
	}
	
///////////////////////////// SyntaxScope building /////////////////////////
	/*
	 * After a walk, I must have a complete syntax scope tree.
	 * 
	 * 1. Because I want a SyntaxScope to be as immutable as possible, the tree can only
	 * be built bottom-up from the leaves (i.e. only the parent field can be set later)
	 * 2. Therefore, I propose using a stack. 
		 a. Because 
		 * 	i. the walk is from the beginning token to the end token in order,
		 * 	ii. a } always closes a scope
		 * , the corresponding walk on the scope tree is always a post-order. That is,
		 * any leaf will be closed during the walk before its parent is closed.
		 
		 b. Whenever a { is encountered, push a new block onto the stack. 
		 The stack should contain the information about the new scope. 
		 What are made available at this step:
		 	i. the token for the {
		 	ii. the scope's type.
		 
		 c. Whenever a } is encountered, pop the top block from the stack,
		 and conclude the information about the scope. 
		 What are made available at this step:
		 	i. the }
		 	ii. all of its children should have been created.
		 	iii. its level is the size of the stack after the pop
		 
		 d. Create the new scope with the info. 
		So also set their parent fields after the new scope is created.
		 
		 e.
		 If the stack is empty, the new scope is a root.
		 Otherwise, add the newly created scope to the top of the stack now as the corresponding scope's child.
		 
		 
	 * 3. the type of a scope will always be available before the {,
	 * unless the scope stands alone, in which case the type is GENERAL_STATMENT_SCOPE.
	 * Therefore,
	 * 	a. Initially, pendingType = Type.GENERAL_STATMENT_SCOPE.
	 * 	b. Whenever a syntax structure that contains a scope is encountered,
	 * set the pendingType to its type.
	 * 	c. Whenever a { is encountered, retrieve the pendingType and reset it back to Type.GENERAL_STATMENT_SCOPE.
	 * 
	 */
	
	private static class ScopeBuildingInfo
	{	
		SyntaxScope.Type type;
		// the {
		// the } does not need to be stored.
		// It's available when it's created.
		CodeBlock start;
		final List<SyntaxScope> children = new ArrayList<SyntaxScope>();
		// The level does not need to be stored.
		// It's available when it's created.
	}
	
	private final Stack<ScopeBuildingInfo> scopeBuildingStack = new Stack<ScopeBuildingInfo>();
	private SyntaxScope.Type pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
	
	/**
	 * Called when a { is encountered 
	 * 		 2.b. Whenever a { is encountered, push a new block onto the stack. 
			 The stack should contain the information about the new scope. 
			 What are made available at this step:
			 	i. the token for the {
			 	ii. the scope's type.
			 	
			3.c. Whenever a { is encountered, retrieve the pendingType and reset it back to Type.STANDALONE_SCOPE.
	 */
	private void onLBraceEncountered(CodeBlock lb)
	{
		ScopeBuildingInfo info = new ScopeBuildingInfo();
		info.start = lb;
		// 3.c. Whenever a { is encountered, retrieve the pendingType and reset it back to Type.STANDALONE_SCOPE.
		info.type = pendingScopeType;
		pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
		
		// push it onto the stack
		scopeBuildingStack.push(info);
	}

	/**
	 * Called when a } is encountered 
		 2.c. Whenever a } is encountered, pop the top block from the stack,
		 and conclude the information about the scope. 
		 What are made available at this step:
		 	i. the }
		 	ii. all of its children should have been created.
		 	iii. its level is the size of the stack after the pop	 
		 2.d. Create the new scope with the info. 
		So also set their (2.c.ii) parent fields after the new scope is created.	 
		 2.e.
		 If the stack is empty, the new scope is a root.
		 Otherwise, add the newly created scope to the top of the stack now as the corresponding scope's child.
	 */
	private void onRBraceEncountered(CodeBlock rb)
	{
		// Should end a scope and the stack must be empty now.
		assert (!scopeBuildingStack.empty());
		
		// 2.c
		var info = scopeBuildingStack.pop();
		var end = rb;
		int level = scopeBuildingStack.size();
		
		// 2.d
		// The children's parent are set in the constructor.
		var newScope = new SyntaxScope(info.type, null, info.children, info.start, end, level);
		
		// 2.e.
		if(scopeBuildingStack.empty())
		{
			// This new scope is a root. Add it to the root scopes
			syntaxStructure.rootScopes.add(newScope);
		}
		else
		{
			// Otherwise, add the newly created scope to the top of the stack now as the corresponding scope's child.
			var top = scopeBuildingStack.peek();
			top.children.add(newScope);
		}
	}
	
///////////////////////////// JavaDoc following structure discovery /////////////////////////
	/**
	 * The index after the lastly examined javadoc in
	 * the list sourceFile.getJavaDocs()
	 * 
	 * If not over the size, then it's also the index of the currently examined one.
	 */
	private int examinedJavaDocInd = 0;
	
	private JavaDocBlock examinedJavaDoc()
	{
		assert(examinedJavaDocInd >=0 && examinedJavaDocInd < sourceFile.getJavaDocs().size());
		return sourceFile.getJavaDocs().get(examinedJavaDocInd);
	}
	
	/**
	 * On entering a syntax structure, check if it's before or after the start position of the 
	 * examined java doc.
	 * if it's before, then ignore it.
	 * if it's after, then set the examined javadoc's fields to information obtained from the syntax structure
	 * and ++examinedJavaDocInd.
	 * 
	 * @return true if it's after the currently examined java doc ind (not all have been examined)
	 * if all have been examined, then return false.
	 */
	private boolean isAfterExaminedJavaDoc(int antlrTokenInd)
	{
		// check if we have already examined all javadocs
		if(examinedJavaDocInd >= sourceFile.getJavaDocs().size())
		{
			return false;
		}
		
		return antlrTokenInd > examinedJavaDoc().index();
	}

	/**
	 * All things to do to examine the current javadoc
	 * Mostly importantly, I won't forget to 
	 * 	1. check isAfterExaminedJavaDoc()
	 * 	2. setExaminedJavaDocInd accordingly
	 * @param type
	 * @param method
	 */
	private void examineJavaDoc(ParserRuleContext ctx, JavaDocBlock.FollowingType type, JavaDocBlock.FollowingMethod method)
	{
		int antlrInd = ctx.start.getTokenIndex();
		int nearestJDInd = findTheNearestJavaDoc(antlrInd);
		
		// if the structure is the first one that corresponds to an unexamined javadoc
		if(-1 != nearestJDInd)
		{
			// all javadocs between the old examinedJavaDocInd
			// and nearestJDInd are not touched,
			// which means they use the default FollowingType: OTHER, which means they are unmatched.
			
			examinedJavaDocInd = nearestJDInd;
			var jD = examinedJavaDoc();
			jD.setFollowing(type, method);
			++examinedJavaDocInd;
		}
	}
	
///////////////////////////// Helpers /////////////////////////////////
	/**
	 * Adds the corresponding modifier to the pending additional attributes
	 * based on the given parser rule context, modifier
	 * @param modifier the context generated by the parser
	 */
	private void addPendingModifier(ParserRuleContext modifier)
	{
		// If it is an annotation modifier.
		if (modifier instanceof AnnotationContext)
		{
			pendingAttributes.addAnnotationModifier((AnnotationContext)modifier);
			return;
		}
		
		// Otherwise, it is a keyword modifier
		switch(modifier.getText())
		{
		// I only care about these keyword modifiers in this project.
		// Other keywords are ignored.
		case "public" -> 
			pendingAttributes.setOopModifier(AdditionalAttributes.OOP_MODIFIER_PUBLIC);
		case "protected" ->
			pendingAttributes.setOopModifier(AdditionalAttributes.OOP_MODIFIER_PROTECTED);
		case "private" ->
			pendingAttributes.setOopModifier(AdditionalAttributes.OOP_MODIFIER_PRIVATE);
		case "static" -> 
			pendingAttributes.setOtherModifiers(AdditionalAttributes.MODIFIER_STATIC);
		case "abstract" ->
			pendingAttributes.setOopModifier(AdditionalAttributes.OOP_MODIFIER_ABSTRACT);
		case "final" ->
			pendingAttributes.setOtherModifiers(AdditionalAttributes.MODIFIER_FINAL);
		case "strictfp" -> 
			pendingAttributes.setOtherModifiers(AdditionalAttributes.MODIFIER_STRICTFP);
		}
	}
	
	/**
	 * Sets the additional modifiers for the corresponding code block
	 * @see The comment for pendingTypeModifiers
	 * 
	 * @param type the type of the CodeBlock (e.g. class, interface, enum)
	 * @param tokenInd the index of the token of the code piece
	 * @param reset whether to reset the pending attributes at the end
	 */
	private void setAdditionalTokenAttributesForTheCode
	(
		CodeBlock.Type type, int tokenInd,
		boolean reset
	)
	{
		// Sets the type of the code block
		pendingAttributes.setType(type);
		// Adds the attributes to the list
		additionalTokenAttributes.put(tokenInd, pendingAttributes);
		// Resets the attributes to a new and blank object, 
		// if the parameter orders so
		if(reset) resetPendingAttributes();
	}
	
	/**
	 * the same as calling setAdditionalTokenAttributesForTheCode(type, tokenInd, true)
	 * @param type
	 * @param tokenInd
	 */
	private void setAdditionalTokenAttributesForTheCode(CodeBlock.Type type, int tokenInd)
	{
		setAdditionalTokenAttributesForTheCode(type, tokenInd, true);
	}
	
	/**
	 * Some javadoc may be unmatched.
	 * Therefore, after examination, examinedJavaDocInd may increase by more than 1.
	 * This method, given the index of a syntax structure, 
	 * 
	 * @param antlrTokenInd
	 * @return the index of the nearest Javadoc before the structure, after the examinedJavaDocInd.
	 * or -1 if !isAfterExaminedJavaDoc(antlrTokenInd)
	 */
	private int findTheNearestJavaDoc(int antlrTokenInd)
	{
		if(!isAfterExaminedJavaDoc(antlrTokenInd))
		{
			return -1;
		}
		
		// find the first i such that it's after the structure
		// then return i-1
		int i = examinedJavaDocInd;
		while(i < sourceFile.getJavaDocs().size())
		{
			var jD = sourceFile.getJavaDocs().get(i);
			int jDTokenInd = jD.index();
			
			if(jDTokenInd > antlrTokenInd)
			{
				assert(i != examinedJavaDocInd);
				return i-1;
			}
			
			++i;
		}
		
		// all remaining javaDocs are before the structure.
		// return the last one
		return sourceFile.getJavaDocs().size()-1;

	}
		

///////////////////////////// Inherited parser listener methods /////////////////////////////////
	/*
	 * Syntactical analysis goals:
	 * 1. obtain all modifiers and the precise type of an identifier
	 * 2. obtain all scopes and the approximate type of each.
	 * 3. for each javadoc, obtain information about the structure immediately following the javadoc
	 * 	and set the javadoc's corresponding fields.
	 * 
	 * All structures needed to be examined for 1:
	 * 	TypeDeclaration
	 *	ClassBodyDeclaration
	 *	InterfaceBodyDeclaration
	 * 	LocalTypeDeclaration
	 * 	FormalParameters
	 * 	LocalVariableDeclaration
	 * 	ClassDeclaration
	 * 	EnumDeclaration
	 * 	InterfaceDeclaration
	 * 	MethodDeclaration
	 * 	GenericMethodDeclaration
	 * 	InterfaceMethodDeclaration
	 * 	GenericInterfaceMethodDeclaration
	 * 	ConstructorDeclaration
	 * 	GenericConstructorDeclaration
	 * 	FieldDeclaration
	 * 
	 * All structures needed to be examined for 2:
	 * 	enumDeclaration
	 * 	classBody
	 * 	interfaceBody
	 * 	arrayInitializer
	 * 	elementValueArrayInitializer
	 * 	annotationTypeBody
	 * 	block
	 * 	statement (on the SWITCH path)
	 * 	switchExpression
	 * 	methodBody (gives type to block)
	 * 	constructorDeclaration (gives type to block)
	 * 	compactConstructorDeclaration (gives type to block)
	 * 	statement (single block path) (gives type to block)
	 * 	statement (TRY path) (gives type to block)
	 * 	statement (SYNCHRONIZED path) (gives type to block)
	 * 	catchClause (gives type to block)
	 * 	finallyBlock (gives type to block)
	 * 	lambdaBody (gives type to block)
	 * 	switchRuleOutcome (gives type to block)
	 * To handle blocks, also need to handle
	 * 	enterTerminal()
	 * 
	 * All structures needed to be examined for 3:
	 * 	i. class-like
	 * 		classDeclaration | 
	 * 		enumDeclaration | 
	 * 		interfaceDeclaration | 
	 * 		annotationTypeDeclaration
	 * 	ii. fields
	 * 		fieldDeclaration
	 * 	iii. methods
	 * 		methodDeclaration
	 * 		genericMethodDeclaration
	 * 		interfaceMethodDeclaration
	 * 		genericInterfaceMethodDeclaration
	 * 	iv. constructors
	 * 		constructorDeclaration
	 * 		genericConstructorDeclaration
	 * NOTE: For iii and iv, the methods should be exit... so that the parameters can be available.
	 * 	
	 */
	
	// entering things
	
	/**
	 * Because I care about the modifiers, I have to explore here
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx)
	{		
		var modifiersList = ctx.classOrInterfaceModifier();
		for(var modifier : modifiersList)
		{
			addPendingModifier(modifier);
		}
	}
	
	/**
	 * ClassBodyDeclarations also include modifiers
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx)
	{	
		var modifiersList = ctx.modifier();
		for(var modifier : modifiersList)
		{
			addPendingModifier(modifier);
		}
	}
	
	/**
	 * ClassBody is part of ClassBodyDeclarations
	 */
	@Override
	public void enterClassBody(JavaParser.ClassBodyContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_CLASS_DEF_SCOPE;
		}
	}
	
	/**
	 * InterfaceBodyDeclarations also include modifiers
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx)
	{
		var modifiersList = ctx.modifier();
		for(var modifier : modifiersList)
		{
			addPendingModifier(modifier);
		}
	}
	
	/**
	 * InterfaceBody is part of InterfaceBodyDeclarations
	 */
	@Override
	public void enterInterfaceBody(JavaParser.InterfaceBodyContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_CLASS_DEF_SCOPE;
		}
	}
	
	/**
	 * ArrayInitializer is used to initialize an array
	 */
	@Override
	public void enterArrayInitializer(JavaParser.ArrayInitializerContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
		}
	}

	/**
	 * ElementValueArrayInitializer initializes an element value array
	 */
	@Override
	public void enterElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
		}
	}
	
	/**
	 * AnnotationTypeBody is part of the definition of an annotation.
	 */
	@Override
	public void enterAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_CLASS_DEF_SCOPE;
		}
	}

	/**
	 * A statement.
	 */
	@Override
	public void enterStatement(JavaParser.StatementContext ctx)
	{
		// 2.
		{
		
			// Actually all scopes here have this GENERAL_STATMENT_SCOPE type,
			// but I must be careful not to override the type unless needed.
			// Don't do this here: pendingScopeType = Type.GENERAL_STATMENT_SCOPE;
			if(ctx.SWITCH() != null) // the switch path
			{
				pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
			}
			else if(ctx.blockLabel != null) // the single block path
			{
				pendingScopeType = Type.STANDALONE_SCOPE;
				// the onlbrace will be called in the block
			}
			else if(ctx.TRY() != null) // the try path
			{
				pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
				// the onlbrace will be called in the block
			}
			else if(ctx.SYNCHRONIZED() != null) // the synchronized path
			{
				pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
				// the onlbrace will be called in the block
			}

		}
	}
	
	/**
	 * A switch expression
	 */
	@Override
	public void enterSwitchExpression(JavaParser.SwitchExpressionContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_METHOD_DEF_SCOPE;
		}
	}
	
	/**
	 * A method body
	 */
	@Override
	public void enterMethodBody(JavaParser.MethodBodyContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_METHOD_DEF_SCOPE;
		}
	}
	
	/**
	 * A CatchClause
	 */
	@Override
	public void enterCatchClause(JavaParser.CatchClauseContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
		}
	}
	
	/**
	 * A FinallyBlock
	 */
	@Override
	public void enterFinallyBlock(JavaParser.FinallyBlockContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
		}
	}
	
	/**
	 * A method body
	 */
	@Override
	public void enterLambdaBody(JavaParser.LambdaBodyContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_METHOD_DEF_SCOPE;
		}
	}

	/**
	 * A SwitchRuleOutcome
	 */
	@Override
	public void enterSwitchRuleOutcome(JavaParser.SwitchRuleOutcomeContext ctx)
	{
		// 2.
		{
			pendingScopeType = Type.GENERAL_STATEMENT_SCOPE;
		}
	}
	
	/**
	 * LocalTypeDeclarationDeclarations also include modifiers
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterLocalTypeDeclaration(JavaParser.LocalTypeDeclarationContext ctx)
	{
		var modifiersList = ctx.classOrInterfaceModifier();
		for(var modifier : modifiersList)
		{
			addPendingModifier(modifier);
		}
	}
	
	/**
	 * All method parameters go here
	 * I can handle both the modifiers and the identifiers here
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterFormalParameters(JavaParser.FormalParametersContext ctx)
	{
		//  receiverParameter?
        //| receiverParameter (COMMA formalParameterList)?
        //| formalParameterList?
		
		// need to handle both the receiver parameter
		// and the formal parameters
		// But I can handle them independently
		
		// first check the receive parameters
		var rp = ctx.receiverParameter();
		if(rp != null)
		{
			// receive parameters do not have modifiers
			var identifiers = rp.identifier();
			for(var par : identifiers)
			{
				Token token = par.getStart();
				setAdditionalTokenAttributesForTheCode(CodeBlock.Type.PARAMETER_NAME, token.getTokenIndex());
			}
		}
		
		// then check the formal parameters
		var fp_list = ctx.formalParameterList();
		if(fp_list != null)
		{
			var formal_parameters = fp_list.formalParameter();
			if(formal_parameters != null)
			{
				for(var fp : formal_parameters)
				{
					var modifiers = fp.variableModifier();
					for(var modifier : modifiers)
					{
						addPendingModifier(modifier);
					}
					
					Token token = fp.variableDeclaratorId().identifier().getStart();
					setAdditionalTokenAttributesForTheCode(CodeBlock.Type.PARAMETER_NAME, token.getTokenIndex());
				}
			}
			
			// But it can also be lastFormalParameter
			var lfp = fp_list.lastFormalParameter();
			if(lfp != null)
			{
				var modifiers = lfp.variableModifier();
				for(var modifier : modifiers)
				{
					addPendingModifier(modifier);
				}
				
				Token token = lfp.variableDeclaratorId().identifier().getStart();
				setAdditionalTokenAttributesForTheCode(CodeBlock.Type.PARAMETER_NAME, token.getTokenIndex());
			}
		}
	}
	
	/**
	 * LocalVariableDeclarations include modifiers, too.
	 * But it also has only one possibility of declarations
	 * (unlike type declaration, where I could have a class, interface, enum, or annotation)
	 * Therefore, I can handle the type at the same time here.
	 * @see the comment for pending_type_modifiers
	 */
	@Override
	public void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx)
	{
		var modifiersList = ctx.variableModifier();
		for(var modifier : modifiersList)
		{
			addPendingModifier(modifier);
		}
		
		// decide if it is a local variable or a for-loop variable
		CodeBlock.Type local_or_for;
		if(ctx.getParent() instanceof ForInitContext)
		{
			local_or_for = CodeBlock.Type.FOR_VARIABLE_NAME;
		}
		else
		{
			local_or_for = CodeBlock.Type.VARIABLE_NAME;
		}
		
		// variableModifier* (VAR identifier ASSIGN expression | typeType variableDeclarators)
		// See if this is a var declaration or explicit declaration
		if(ctx.identifier() != null)
		{
			// This is a var declaration
			
			// The local variable name token
			Token token = ctx.identifier().getStart();
			setAdditionalTokenAttributesForTheCode(local_or_for, token.getTokenIndex());
		}
		else
		{
			// this is declared using variableDeclarators
			var variable_declarator_list = ctx.variableDeclarators().variableDeclarator();
			for(var variable_declarator : variable_declarator_list)
			{
				// One variable token.
				Token token = variable_declarator.variableDeclaratorId().identifier().getStart();
				
				// don't reset
				setAdditionalTokenAttributesForTheCode(local_or_for, token.getTokenIndex(), false);
			}
			// don't forget to reset pending_modifiers in the end
			resetPendingAttributes();
		}
	}

	/**
	 * When a declaration of a class is encountered
	 */
	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx)
	{
		// 1.
		{
			// the class name token.
			Token token = ctx.identifier().getStart();
			
			// additional attributes
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.CLASS_NAME, token.getTokenIndex());
		}
		
		// 3.
		{
			examineJavaDoc(ctx, FollowingType.CLASS_LIKE, null);
		}
	}
	
	/**
	 * When a declaration of an enumeration is encountered
	 */
	@Override
	public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx)
	{
		// 1.
		{
			// the enumeration name token.
			Token token = ctx.identifier().getStart();

			// additional attributes
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.ENUM_NAME, token.getTokenIndex());
		}

		// 2.
		{
			pendingScopeType = Type.GENERAL_CLASS_DEF_SCOPE;
		}
		
		// 3.
		{
			examineJavaDoc(ctx, FollowingType.CLASS_LIKE, null);
		}
	}
	
	/**
	 * When a declaration of an interface is encountered
	 */
	@Override
	public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx)
	 {
		// 1.
		{
			// the interface name token.
			Token token = ctx.identifier().getStart();

			// additional attributes
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.INTERFACE_NAME, token.getTokenIndex());
		}
		
		// 3.
		{
			examineJavaDoc(ctx, FollowingType.CLASS_LIKE, null);
		}
	 }
	
	/**
	 * When a declaration of a class method is encountered
	 */
	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx)
	{
		// 1.
		{
			// the method name token.
			Token token = ctx.identifier().getStart();
		
			// additional attributes
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.METHOD_NAME, token.getTokenIndex());
		}
		
		// 3. is done in exiting where all parameters have been built by enterFormalParameters
	}
	
	/**
	 * When a declaration of a generic class method is encountered
	 */
	@Override
	public void enterGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx)
	{
		// 1.
		{
			// the generic method name token.
			Token token = ctx.methodDeclaration().identifier().getStart();
		
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.METHOD_NAME, token.getTokenIndex());
		}
		
		// 3. is done in exiting.
	}
	
	/**
	 * When a declaration of an interface method is encountered
	 */
	@Override
	public void enterInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx)
	{
		// 1.
		{
			// Strangely, there can be some additional modifiers here
			var modifiersList = ctx.interfaceMethodModifier();
			for(var modifier : modifiersList)
			{
				addPendingModifier(modifier);
			}
			
			// the method name token.
			Token token = ctx.interfaceCommonBodyDeclaration().identifier().getStart();
		
			// additional attributes
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.METHOD_NAME, token.getTokenIndex());
		}
	}
	
	/**
	 * When a declaration of a generic interface method is encountered
	 */
	@Override
	public void enterGenericInterfaceMethodDeclaration(JavaParser.GenericInterfaceMethodDeclarationContext ctx)
	{
		// Strangely, there can be some additional modifiers here
		var modifiersList = ctx.interfaceMethodModifier();
		for(var modifier : modifiersList)
		{
			addPendingModifier(modifier);
		}
		
		// the generic method name token.
		Token token = ctx.interfaceCommonBodyDeclaration().identifier().getStart();
	
		setAdditionalTokenAttributesForTheCode(CodeBlock.Type.METHOD_NAME, token.getTokenIndex());
	}
	
	/**
	 * When a declaration of a constructor is encountered
	 */
	@Override
	public void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx)
	{
		// 1.
		{
			// the constructor name token.
			Token token = ctx.identifier().getStart();
		
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.CONSTRUCTOR_NAME, token.getTokenIndex());
		}
		
		// 2.
		{
			pendingScopeType = Type.GENERAL_METHOD_DEF_SCOPE;
		}
		
		// 3. is done in exiting
	}
	
	/**
	 * When a declaration of a generic constructor is encountered
	 */
	@Override
	public void enterGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx)
	{
		// 1.
		{
			// the generic constructor method name token.
			Token token = ctx.constructorDeclaration().identifier().getStart();
		
			setAdditionalTokenAttributesForTheCode(CodeBlock.Type.CONSTRUCTOR_NAME, token.getTokenIndex());
		}
		
		// 2.
		{
			pendingScopeType = Type.GENERAL_METHOD_DEF_SCOPE;
		}
		
		// 3. is done in exiting
	}
	
	/**
	 * When a declaration of a field is encountered
	 */
	@Override 
	public void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx)
	{
		// 1.
		{
			// A field declaration can declare multiple variables,
			// as in "int a, b, c;"
			var variable_declarator_list = ctx.variableDeclarators().variableDeclarator();
			for(var variable_declarator : variable_declarator_list)
			{
				// One variable token.
				Token token = variable_declarator.variableDeclaratorId().identifier().getStart();
				
				// Don't reset
				setAdditionalTokenAttributesForTheCode(CodeBlock.Type.FIELD_NAME, token.getTokenIndex(), false);
			}
			// don't forget to reset pending_modifiers in the end
			resetPendingAttributes();
		}
		
		// 3.
		{
			examineJavaDoc(ctx, FollowingType.FIELD, null);
		}
	}

	@Override
	public void enterAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx)
	{
		// 3.
		{
			examineJavaDoc(ctx, FollowingType.CLASS_LIKE, null);
		}
	}
	
	// exiting things
	/**
	 * When a declaration of a class method is exited
	 */
	@Override
	public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx)
	{
		// 3. is done in exiting where all parameters have been built by enterFormalParameters
		{
			FollowingMethod methodInfo = new FollowingMethod();
			methodInfo.returnType = ctx.typeTypeOrVoid().getText();
			
			// indices of parameters 
			// (each parameter has an additionalTokenAttributes structure built for it,
			// and the structure is mapped to by the index of the parameter).
			var parTokenIndices = additionalTokenAttributes.subMap
			(
				ctx.formalParameters().start.getTokenIndex(), 
				ctx.formalParameters().stop.getTokenIndex()
			).keySet();
			for(Integer pi : parTokenIndices)
			{
				methodInfo.parameterNames.add(sourceFile.getFormatToken(pi).characters());
			}
			
			//methodInfo.parameterNames
			examineJavaDoc(ctx, FollowingType.METHOD_LIKE, methodInfo);
		}
	}
	
	/**
	 * When a declaration of a generic class method is exited
	 */
	@Override
	public void exitGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx)
	{		
		// 3. is done in exiting where all parameters have been built by enterFormalParameters
		{
			FollowingMethod methodInfo = new FollowingMethod();
			methodInfo.returnType = ctx.methodDeclaration().typeTypeOrVoid().getText();
			
			// indices of parameters 
			// (each parameter has an additionalTokenAttributes structure built for it,
			// and the structure is mapped to by the index of the parameter).
			var parTokenIndices = additionalTokenAttributes.subMap
			(
				ctx.methodDeclaration().formalParameters().start.getTokenIndex(), 
				ctx.methodDeclaration().formalParameters().stop.getTokenIndex()
			).keySet();
			for(Integer pi : parTokenIndices)
			{
				methodInfo.parameterNames.add(sourceFile.getFormatToken(pi).characters());
			}
			
			//methodInfo.parameterNames
			examineJavaDoc(ctx, FollowingType.METHOD_LIKE, methodInfo);
		}
	}
	
	/**
	 * When a declaration of an interface method is exited
	 */
	@Override
	public void exitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx)
	{
		// 3.
		{
			FollowingMethod methodInfo = new FollowingMethod();
			var methodCtx = ctx.interfaceCommonBodyDeclaration();
			methodInfo.returnType = methodCtx.typeTypeOrVoid().getText();
			
			// indices of parameters 
			// (each parameter has an additionalTokenAttributes structure built for it,
			// and the structure is mapped to by the index of the parameter).
			var parTokenIndices = additionalTokenAttributes.subMap
			(
				methodCtx.formalParameters().start.getTokenIndex(), 
				methodCtx.formalParameters().stop.getTokenIndex()
			).keySet();
			for(Integer pi : parTokenIndices)
			{
				methodInfo.parameterNames.add(sourceFile.getFormatToken(pi).characters());
			}
			
			//methodInfo.parameterNames
			examineJavaDoc(ctx, FollowingType.METHOD_LIKE, methodInfo);
		}
	}
	
	/**
	 * When a declaration of a generic interface method is exited
	 */
	@Override
	public void exitGenericInterfaceMethodDeclaration(JavaParser.GenericInterfaceMethodDeclarationContext ctx)
	{
		// 3.
		{
			FollowingMethod methodInfo = new FollowingMethod();
			var methodCtx = ctx.interfaceCommonBodyDeclaration();
			methodInfo.returnType = methodCtx.typeTypeOrVoid().getText();
			
			// indices of parameters 
			// (each parameter has an additionalTokenAttributes structure built for it,
			// and the structure is mapped to by the index of the parameter).
			var parTokenIndices = additionalTokenAttributes.subMap
			(
				methodCtx.formalParameters().start.getTokenIndex(), 
				methodCtx.formalParameters().stop.getTokenIndex()
			).keySet();
			for(Integer pi : parTokenIndices)
			{
				methodInfo.parameterNames.add(sourceFile.getFormatToken(pi).characters());
			}
			
			//methodInfo.parameterNames
			examineJavaDoc(ctx, FollowingType.METHOD_LIKE, methodInfo);
		}
	}

	
	/**
	 * When a declaration of a constructor is exited
	 */
	@Override
	public void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx)
	{
		// 3. is done in exiting where all parameters have been built by enterFormalParameters
		{
			FollowingMethod methodInfo = new FollowingMethod();
			// a constructor returns nothing
			methodInfo.returnType = "void";
			
			// indices of parameters 
			// (each parameter has an additionalTokenAttributes structure built for it,
			// and the structure is mapped to by the index of the parameter).
			var parTokenIndices = additionalTokenAttributes.subMap
			(
				ctx.formalParameters().start.getTokenIndex(), 
				ctx.formalParameters().stop.getTokenIndex()
			).keySet();
			for(Integer pi : parTokenIndices)
			{
				methodInfo.parameterNames.add(sourceFile.getFormatToken(pi).characters());
			}
			
			//methodInfo.parameterNames
			examineJavaDoc(ctx, FollowingType.METHOD_LIKE, methodInfo);
		}
	}
	
	/**
	 * When a declaration of a generic constructor is exited
	 */
	@Override
	public void exitGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx)
	{
		// 3. is done in exiting where all parameters have been built by enterFormalParameters
		{
			FollowingMethod methodInfo = new FollowingMethod();
			// a constructor returns nothing
			methodInfo.returnType = "void";
			
			// indices of parameters 
			// (each parameter has an additionalTokenAttributes structure built for it,
			// and the structure is mapped to by the index of the parameter).
			var parTokenIndices = additionalTokenAttributes.subMap
			(
				ctx.constructorDeclaration().formalParameters().start.getTokenIndex(), 
				ctx.constructorDeclaration().formalParameters().stop.getTokenIndex()
			).keySet();
			for(Integer pi : parTokenIndices)
			{
				methodInfo.parameterNames.add(sourceFile.getFormatToken(pi).characters());
			}
			
			//methodInfo.parameterNames
			examineJavaDoc(ctx, FollowingType.METHOD_LIKE, methodInfo);
		}
	}
	
	// On visiting every terminal
	@Override
	public void visitTerminal(TerminalNode t)
	{
		// 2.
		{
			if(t.getText().equals("{"))
			{
				var lBraceAntlrToken = t.getSymbol();
				var lBraceCodeBlock = (CodeBlock)sourceFile.getFormatToken(lBraceAntlrToken);
				onLBraceEncountered(lBraceCodeBlock);
			}
			else if(t.getText().equals("}"))
			{
				var rBraceAntlrToken = t.getSymbol();
				var rBraceCodeBlock = (CodeBlock)sourceFile.getFormatToken(rBraceAntlrToken);
				onRBraceEncountered(rBraceCodeBlock);
			}
		}
	}
}
