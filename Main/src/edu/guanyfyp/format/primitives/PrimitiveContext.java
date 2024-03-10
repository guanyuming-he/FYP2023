/**
 * 
 */
package edu.guanyfyp.format.primitives;

import edu.guanyfyp.syntax.SyntaxContext;

/**
 * The context in which a format primitive is in is represented by the class `PrimitiveContext`, which
    - a. may have the textual context of the primitive (i.e. which line, character, etc. this primitive is in the `SourceFile`). 
    Normally the primitive itself has such informatin so it might not be stored in the context.
    - b. has the syntax context of the primitive. That is, it stores an instance of the class `SyntaxContext`.
    - c. final. All primitives share the same context representation.
 */
public final class PrimitiveContext 
{
//////////////////////// Fields ////////////////////////
	// May not need to store textual context
	
	final SyntaxContext syntaxContext;

//////////////////////// Constructors ////////////////////////
	
	/**
	 * Construct a primitive context with only the syntax context,
	 * which means the primitive will know its textual context from itself.
	 * 
	 * @param syntax_context
	 */
	public PrimitiveContext(final SyntaxContext syntaxContext)
	{
		this.syntaxContext = syntaxContext;
	}
}
