/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.FormatPrimitive;
import edu.guanyfyp.format.primitives.FormatToken;
import edu.guanyfyp.format.primitives.Line;

/**
 * Represents a syntax scope.
 * In Java, all scopes start with a { and ends with a }
 * Many syntax structures can produce a scope,
 * e.g. a class definition, a method definition.
 * 
 * A scope mainly affects name resolution, i.e. which names are available.
 * A scope also has formatting implications.
 * E.g. inside a scope normally the overall indentation level should be increased.
 * 
 * For traversal, a syntax scope also acts as a node in a tree.
 * Therefore, it contains its parent and children, which are supplied by some external builder.
 * 
 * Invariants:
 * 	1. parent is its parent and children are its children
 * 	2. startToken is a { and endToken is a }
 * 	3. startToken is before endToken
 * 	4. children.level-1 = level = parent.level+1 (or 0 if parent is null)
 *  5. oneLine = startToken.line() == endToken.line()
 *  6. its type is correct.
 * 
 */
public final class SyntaxScope 
{	
//////////////////////// Other members //////////////////////////////
	/**
	 * Syntactical type of the scope.
	 * i.e. which kind of syntax structure results in this scope
	 */
	public static enum Type
	{
		// Scope of a definition of something that is generally like a class:
		// class, interface, enum, or generic class.
		GENERAL_CLASS_DEF_SCOPE,
		// Scope of a definition of something that that is generally like a method:
		// method or lambda.
		GENERAL_METHOD_DEF_SCOPE,
		// A scope that is a syntax structure on its own.
		// e.g. an unnamed scope inside a method.
		STANDALONE_SCOPE
	}
	
//////////////////////// Fields //////////////////////////////
	/**
	 * Which type of scope this is.
	 * Supplied to the constructor by an external builder.
	 */
	public final Type type;
	
	/**
	 * Its parent, can be null only when it has no parent.
	 * Supplied to the constructor by an external builder.
	 */
	public final SyntaxScope parent;
	/**
	 * An immutable list of its children. 
	 * Can be empty only when it has no children.
	 * Supplied to the constructor by an external builder.
	 */
	public final List<SyntaxScope> children;
	
	/**
	 * The first token before the scope.
	 * It must be a {.
	 */
	public final CodeBlock startToken;	
	/**
	 * The first token after the scope.
	 * It must be a }.
	 */
	public final CodeBlock endToken;
	
	/**
	 * How deep the scope is.
	 * That is, how many scopes encloses it.
	 * The root scope of a Java source file has level 0.
	 */
	public final int level;
	
	/**
	 * If the scope is a one-line scope.
	 * e.g. void foo() { ... }
	 */
	public final boolean oneLine;
	
//////////////////////// Ctors //////////////////////////////
	/**
	 * @param type which kind of syntactical structure this scope is (or is part of)
	 * @param parent its containing scope, should be null if it is the root
	 * @param children its children, should be empty if it is a leaf
	 * @param startToken the { token that starts it
	 * @param endToken the } token that ends it
	 * 
	 * @throws IllegalArgumentException if parent and children do not match in level.
	 * @throws IllegalArgumentException if then start/end token is not {/},
	 * or if start is after end.
	 * @apiNote the constructor's checking won't cover all illegal cases, because that would be too expensive,
	 * and that should be the job of the builder.
	 * If the builder gives illegal arguments that the constructor can't check against, 
	 * then the behaviour will be undefined.
	 */
	public SyntaxScope
	(
		Type type,
		SyntaxScope parent, List<SyntaxScope> children,
		CodeBlock startToken, CodeBlock endToken
	)
	{	
		// check the start and end token
		if(!startToken.characters().equals("{") || !endToken.characters().equals("}"))
		{
			throw new IllegalArgumentException("start token must be { and end token must be }.");
		}
		// This must hold or I have serious problem elsewhere
		assert (startToken.index() != endToken.index());
		if(startToken.index() > endToken.index())
		{
			throw new IllegalArgumentException("start token must be before the end token.");
		}
		// Check the level of parent and children.
		if(parent == null)
		{
			for(var c : children)
			{
				if(c.level != 1)
				{
					throw new IllegalArgumentException("parent and children do not match in the field level");
				}
			}
		}
		else // parent != null
		{
			for(var c : children)
			{
				if(c.level != parent.level+2)
				{
					throw new IllegalArgumentException("parent and children do not match in the field level");
				}
			}
		}
		
		this.type = type;
		this.parent = parent;
		// make the list immutable
		this.children = Collections.unmodifiableList(children);
		this.startToken = startToken;
		this.endToken = endToken;
		
		// calculate the level
		level = (parent == null ? 0 : parent.level+1);
		
		// calclaute oneLine
		oneLine = (startToken.line() == endToken.line());
	}
	

//////////////////////// Observers //////////////////////////////
	/**
	 * Decides if a p is covered between the startToken and the endToken.
	 * 
	 * If p is a line, then it is a little ambiguous:
	 * I decide to exclude the lines of the startToken and the endToken,
	 * since they do not follow the same indentation rule of those inside.
	 * Therefore, on the occasional of single-line scopes, they cover no line.
	 * 
	 * @param p
	 * @return true iff so.
	 * @throws UnsupportedOperationException if p is neither a FormatToken nor a Line.
	 * @apiNote c.f. isPrimitiveInScope().
	 */
	public boolean isPrimitiveInRange(FormatPrimitive p)
	{
		if(p instanceof FormatToken)
		{
			var t = (FormatToken)p;
			// If t is in between the start and end tokens.
			return t.index() > startToken.index() && t.index() < endToken.index();
		}
		else if(p instanceof Line)
		{
			// I decide to exclude the lines of the startToken and the endToken,
			// since they do not follow the same indentation rule of those inside.
			var l = (Line)p;
			return l.lineNumber > startToken.line() && l.lineNumber < endToken.line();
		}
		else
		{
			throw new UnsupportedOperationException("This kind of primitive is not supported.");
		}
	}
	
	/**
	 * Decides if p is inside this scope, but also not in any of its subscopes.
	 * 
	 * @implNote Could use a recursive approach. 
	 * 	1. The base case is for the deepest scopes that have no subscopes. 
	 * They just return true for all primitives in the range.
	 * 	2. The recursive step: primitives in the range but are not deemed inside any subscope.
	 * @param p a format primitive
	 * @return true iff so.
	 */
	public boolean isPrimitiveInScope(FormatPrimitive p)
	{
		// Check if it's a leaf
		if(children.isEmpty())
		{
			// it's a leaf. Perform the base case step.
			return isPrimitiveInRange(p);
		}
		
		// Otherwise, perform the recursive step:
		// all primitives that are not in its subscopes,
		for(var c : children)
		{	
			if (c.isPrimitiveInScope(p))
			{
				return false;
			}
		}
		// but are in it's range.
		return isPrimitiveInRange(p);
	}

	// Names inside a scope is not important to judging code quality.
	// Consider the most important things first.
//		/**
//		 * All the names defined in this scope.
//		 */
//		private final Map<String, FormatToken> names;
	//	
//		/**
//		 * During the building of this.names, call this method to 
//		 * add a name to the scope.
//		 * @param name
//		 * @param token token linked to the name.
//		 * 
//		 * @apiNote if the name is already in the scope then the method will fail an assertion.
//		 */
//		public void addName(String name, FormatToken token)
//		{
//			// During the building of a scope,
//			// a name should never be defined twice.
//			assert !hasName(name);
//			
//			names.put(name, token);
//		}
	//	
//		/**
//		 * Tells if the scope has the name defined.
//		 * @param name
//		 * @return true iff the name has been defined in the scope.
//		 */
//		public boolean hasName(String name)
//		{
//			return names.containsKey(name);
//		}
	//	
//		/**
//		 * Obtains the FormatToken associated with the name defined in the scope.
//		 * @param name
//		 * @return the token, or null if has_name(name) returns false.
//		 */
//		public FormatToken getNameToken(String name)
//		{
//			return names.get(name);
//		}
}
