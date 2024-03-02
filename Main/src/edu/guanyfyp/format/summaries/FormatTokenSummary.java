/**
 * 
 */
package edu.guanyfyp.format.summaries;

import edu.guanyfyp.format.primitives.FormatToken;
import edu.guanyfyp.format.primitives.Line;

/**
 * 
 */
public abstract class FormatTokenSummary extends FormatEvalSummary<FormatToken> {

	/**
	 * Creates a summary that waits to include new evaluated format tokens
	 */
	public FormatTokenSummary() 
	{
		super();
	}

	@Override
	public void include(FormatToken p) 
	{
		throw new RuntimeException("Unimplemented.");

	}

	@Override
	public void summarize() 
	{
		throw new RuntimeException("Unimplemented.");
	}

}
