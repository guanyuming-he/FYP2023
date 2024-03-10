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
	
	/**
	 * The global scope, also the root of the scope tree.
	 */
	SyntaxScope rootScope;
	
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
		// Algorithm to find:
		// 1. start with scope = root
		// 2. for each children, c, of scope, check if p is in c.
		// 3. if so, scope = c. goto 2.
		// 4. if none of c has p, then we are done.
		
		// 1.
		SyntaxScope scope = rootScope;
		// p must be in the range of root.
		assert (scope.isPrimitiveInRange(p));
		
		while(true)
		{
			// 2.
			for(var c : scope.children)
			{
				if(c.isPrimitiveInRange(p))
				{
					// 3.
					scope = c;
					break;
				}
			}
			
			// 4. None of its children contains p.
			// we are done.
			break;
		}
		
		return new SyntaxContext(scope);
	}
}
