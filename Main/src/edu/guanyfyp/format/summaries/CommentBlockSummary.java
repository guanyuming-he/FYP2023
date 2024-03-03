/**
 * 
 */
package edu.guanyfyp.format.summaries;

import edu.guanyfyp.format.primitives.CommentBlock;

/**
 * 
 */
public class CommentBlockSummary extends FormatEvalSummary<CommentBlock>
{
//////////////////////// Fields ////////////////////////
	

//////////////////////// Ctor ////////////////////////
	/**
	 * Default construction. No CB is included for summary.
	 */
	public CommentBlockSummary() 
	{
		super();
	}
	
//////////////////////// Inherited from super ////////////////////////
	@Override
	public void include(CommentBlock p) 
	{
		throw new RuntimeException("Unimplemented.");	
	}

	@Override
	public void summarize() 
	{
		throw new RuntimeException("Unimplemented.");
	}

}
