/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.LinkedList;

import edu.guanyfyp.format.primitives.FormatPrimitive;

/**
 * Represents the syntax structure of some piece of source code
 * Once built should be immutable or at least treated as immutable
 */
public final class SyntaxStructure 
{
	// TODO: define a tree of SyntaxScopes here.
	public static class ScopeNode
	{
		public ScopeNode(ScopeNode p, SyntaxScope e)
		{
			this.parent = p;
			this.element = e;
			
			this.children = new LinkedList<>();
		}
		
		public final ScopeNode parent;
		public final LinkedList<ScopeNode> children;
		
		public final SyntaxScope element;
	
	}
	
	/**
	 * The global scope, also the root of the scope tree.
	 */
	ScopeNode globalScope;
	
////////////////////////// Observers //////////////////////////
	/**
	 * Get the syntax context of the primitive p.
	 * Should at least support getting Line's and FormatToken's
	 * 
	 * @param p the format primitive
	 * @return its syntax context
	 * @throws UnsupportedOperationException if p is of a type that is not supported
	 */
	public SyntaxContext getSyntaxContext(FormatPrimitive p)
	{
		// Not implemented!
		return null;
	}
}
