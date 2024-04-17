/**
 * 
 */
package edu.guanyfyp.format.summaries;

import edu.guanyfyp.format.primitives.WsBlock;

/**
 * 
 */
public class WsBlockSummary extends FormatEvalSummary<WsBlock>
{
	// number of ws blocks that consist of pure tabs (and possibly other 0 length characters).
	long numTabBlocks = 0;
	// number of ws blocks that consist of spaces and possibly tabs (and possibly other 0 length characters).
	// the number of characters in any of such block must be > 1.
	long numSpaceTabBlocks = 0;
	// number of ws blocks that are single spaces.
	long numSingleSpaces = 0;
	
	/**
	 * 
	 */
	public WsBlockSummary() 
	{
		super();
	}


}
