/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.guanyfyp.format.primitives.FormatPrimitive;

/**
 * Represents the syntax structure of some piece of source code
 * Once built should be immutable or at least treated as immutable
 */
public final class SyntaxStructure 
{	
//////////////////////////Observers //////////////////////////
	// Fields are defined as protected so only classes inside the 
	// syntax package (e.g. the builder class) can modify them 
	
	/**
	 * A Java source file can contain multiple classes (each one makes a root scope)
	 * Though the only the first one can and MUST be public, and must have the same name as the file.
	 */
	protected List<SyntaxScope> rootScopes = new ArrayList<SyntaxScope>();
	
////////////////////////// Observers //////////////////////////
	public int getNumRootScopes() { return rootScopes.size(); }
	
	/**
	 * @param i 0..n-1
	 * @return the i^th root scope
	 * @throws IndexOutOfBoundsException
	 */
	public SyntaxScope getRootScope(int i) 
	{ 
		return rootScopes.get(i); 
	}
	
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
		// 1. find the root scope that contains p
		// If p is outside of any root scope, then return.
		// 2. for each children, c, of scope, check if p is in c.
		// 3. if so, scope = c. goto 2.
		// 4. if none of c has p, then we are done.
		
		// 1.
		SyntaxScope scope = null;
		for(var r : rootScopes)
		{
			if(r.isPrimitiveInRange(p))
			{
				scope = r;
				break;
			}
		}
		// Check if p is outside of any scope
		if(scope == null)
		{
			return new SyntaxContext(null);
		}
		
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
