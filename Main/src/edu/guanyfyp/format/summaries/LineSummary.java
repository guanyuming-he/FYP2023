/**
 * 
 */
package edu.guanyfyp.format.summaries;

import edu.guanyfyp.format.primitives.FormatPrimitive;
import edu.guanyfyp.format.primitives.Line;

/**
 * Summary of the quality of all the lines in a source file
 */
public final class LineSummary extends FormatEvalSummary<Line>
{

	/**
	 * Creates a summary that waits to include new evaluated liness
	 */
	public LineSummary() 
	{
		super();
	}

	@Override
	public void include(Line p) 
	{
		throw new RuntimeException("Unimplemented.");

	}

	@Override
	public void summarize() 
	{
		throw new RuntimeException("Unimplemented.");
	}

}
