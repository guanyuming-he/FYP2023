/**
 * 
 */
package edu.guanyfyp.syntax;

/**
 * Represents where a FormatPrimitive is in a SyntaxStructure.
 * That is, the context around that thing in a SyntaxStructure.
 */
public final class SyntaxContext 
{
//////////////////////// Fields //////////////////////////////
	/**
	 * The scope that the primitive is part of.
	 * But the primitive isn't in one of its subscopes.
	 */
	public final SyntaxScope scope;
	
	
//////////////////////// Ctor //////////////////////////////
	SyntaxContext(final SyntaxScope scope)
	{
		this.scope = scope;
	}
}
