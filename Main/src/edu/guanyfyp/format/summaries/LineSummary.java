/**
 * 
 */
package edu.guanyfyp.format.summaries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.guanyfyp.format.primitives.Line;

/**
 * Summary of the quality of all the lines in a source file
 */
public final class LineSummary extends FormatEvalSummary<Line>
{
//////////////////////// Fields ////////////////////////
	
	// The lists will be converted to immutable ones in summarize()
	
	// Lines that are badly indented.
	private List<Line> badlyIndentedLines;
	// Lines that are too long
	private List<Line> tooLongLines;
	
//////////////////////// Ctor  ////////////////////////
	/**
	 * Creates a summary that waits to include new evaluated liness
	 */
	public LineSummary() 
	{
		super();
		
		badlyIndentedLines = new ArrayList<Line>();
		tooLongLines = new ArrayList<Line>();
	}

//////////////////////// From super  ////////////////////////
	/**
	 * Includes an evaluated line for summary.
	 */
	@Override
	public void include(Line l) 
	{
		tooLongLines.add(l);
		
		// TODO: Detect if l is badly indented from the corresponding observers of Line
		
		// include it to the list.
		super.include(l);
	}

	@Override
	public void summarize() 
	{
		// Convert the lists to immutable ones
		badlyIndentedLines = Collections.unmodifiableList(badlyIndentedLines);
		tooLongLines = Collections.unmodifiableList(tooLongLines);
		
		// TODO: some summary
	}
	
//////////////////////// Observers ////////////////////////
	/**
	 * You can only get it after the summary.
	 * @return badlyIndentedLines, immutable.
	 * @throws IllegalStateException if the summary is not done.
	 */
	public List<Line> getBadlyIndentedLines() 
	{
		if(isSummaryDone())
		{
			throw new IllegalStateException("the summary is not done.");
		}
		
		return badlyIndentedLines;
	}

	/**
	 * You can only get it after the summary.
	 * @return tooLongLines, immutable.
	 * @throws IllegalStateException if the summary is not done.
	 */
	public List<Line> getTooLongLines() 
	{
		if(isSummaryDone())
		{
			throw new IllegalStateException("the summary is not done.");
		}
		
		return tooLongLines;
	}

	
//////////////////////// Settings ////////////////////////
	
	// To be added. Not used now.

}
