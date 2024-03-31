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
	private int numComments = 0;

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
	public void include(CommentBlock b)
	{
		super.include(b);
		
		++numComments;
	}
	
	public int getNumComments() { return numComments; }
	
}
