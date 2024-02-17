/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.LinkedList;

/**
 * Represents the syntax structure of some piece of source code
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
}
