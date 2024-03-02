/**
 * 
 */
package edu.guanyfyp.format;

import edu.guanyfyp.format.summaries.FormatEvalSummary;

/**
 * The verdict of analyzing the format of a source file.
 * May include scores, problem descriptions, etc.
 *  - a. stores an instance of each summary class.
    - b. has a method `giveVerdict()` that gives verdict for these summaries. 
    The results of the method are stored in fields of the class and are accessed through its observers.
    - c. final.
    - d. has a field `hasVerdict` that tells if `giveVerdict()` has been called on it.
    - e. For each subclass of `FormatEvalSummary`, has a field of it.
        - i. if a such field is `null` when giving verdict, then it means the source file has no such summary (no such format primitives)
    - f. Has a method `include()` that includes a `FormatEvalSummary` to the future verdict according to its dynamic type.
        - i. if the field of its dynamic type is already not `null`, then `include()` throws.
        - ii. if the field of its dynamic type does not exist (i.e. not supported for verdict yet), then `include()` throws.
        - iii. cannot be called after giving a verdict
    
 */
public final class FormatResult 
{
//////////////////////// Fields ////////////////////////
	private boolean hasVerdict = false;
	
	// TODO: add summary classes for different format tokens and add a field for each of them.
	// TODO: add summary class for Line and add a field for it
	
//////////////////////// Methods ////////////////////////	
	
	public boolean hasGivenVerdict() { return hasVerdict; }
	
	/**
	 * Give verdict for the summaries of the evaluations of the format primitives in the source file.
	 */
	void giveVerdict()
	{
		throw new RuntimeException("Unimplemented.");
	}
	
	/**
	 * Includes a `FormatEvalSummary` to the future verdict according to its dynamic type.
	 * 
	 * @param summary the summary for a particular type of format primitive
	 * @throws UnsupportedOperationException if that kind of summary is not supported for a verdict.
	 * @throws IllegalArgumentException if that kind of summary has already been given.
	 * @throws IllegalStateException if a verdict has already been given.
	 */
	void include(FormatEvalSummary summary)
	{
		if(hasGivenVerdict())
		{
			throw new IllegalStateException("Already has a verdict.");
		}
		
		throw new RuntimeException("Unimplemented.");
	}
}
