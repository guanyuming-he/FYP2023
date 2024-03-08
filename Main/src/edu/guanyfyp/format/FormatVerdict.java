/**
 * 
 */
package edu.guanyfyp.format;

import edu.guanyfyp.format.summaries.CodeBlockSummary;
import edu.guanyfyp.format.summaries.CommentBlockSummary;
import edu.guanyfyp.format.summaries.FormatEvalSummary;
import edu.guanyfyp.format.summaries.JavaDocSummary;
import edu.guanyfyp.format.summaries.LineSummary;
import edu.guanyfyp.format.summaries.WsBlockSummary;

/**
 * The verdict of analyzing the format of a source file.
 * May include scores, problem descriptions, etc.
 *  - a. stores an instance of each summary class.
    - b. has a method `giveVerdict()` that gives verdict for these summaries. 
    The results of the method are stored in fields of the class and are accessed through its observers.
    - c. final.
    - d. has a field `hasVerdict` that tells if `giveVerdict()` has been called on it.
    - e. For each subclass of `FormatEvalSummary`, has a field of it.
        - i. if a such field is `null` when giving verdict, then it means the source file has no such summary 
        (e.g. no such format primitives)
    - f. Has a method `include()` that includes a `FormatEvalSummary` to the future verdict according to its dynamic type.
        - i. if the field of its dynamic type is already not `null`, then `include()` throws.
        - ii. if the field of its dynamic type does not exist (i.e. not supported for verdict yet), then `include()` throws.
        - iii. cannot be called after giving a verdict
    
 */
public final class FormatVerdict 
{
//////////////////////// Fields ////////////////////////
	private boolean hasVerdict = false;
	
	// TODO: add summary classes for different format tokens and add a field for each of them.
	private WsBlockSummary wsBlockSummary = null;
	private CommentBlockSummary commentBlockSummary = null;
	private JavaDocSummary javaDocSummary = null;
	// Perhaps I will use summary classes inherited from this instead
	// for a more detailed verdict.
	// Anyway, I can leave the field here because giveVerdict() will
	// treat a null summary as unused.
	private CodeBlockSummary codeBlockSummary = null;
	
	// TODO: add summary class for Line and add a field for it
	private LineSummary lineSummary = null;
	
//////////////////////// Methods ////////////////////////	
	
	public boolean hasGivenVerdict() { return hasVerdict; }
	
	/**
	 * Give verdict for the summaries of the evaluations of the format primitives in the source file.
	 */
	public void giveVerdict()
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
	public void include(FormatEvalSummary<?> summary)
	{
		if(hasGivenVerdict())
		{
			throw new IllegalStateException("Already has a verdict.");
		}
		
		if(summary instanceof WsBlockSummary)
		{
			if (wsBlockSummary != null)
			{
				throw new IllegalArgumentException("this kind of summary has already been given.");
			}
			wsBlockSummary = (WsBlockSummary)summary;
		}
		else if(summary instanceof JavaDocSummary)
		{
			if (javaDocSummary != null)
			{
				throw new IllegalArgumentException("this kind of summary has already been given.");
			}
			javaDocSummary = (JavaDocSummary)summary;
		}
		else if(summary instanceof CommentBlockSummary)
		{
			if (commentBlockSummary != null)
			{
				throw new IllegalArgumentException("this kind of summary has already been given.");
			}
			commentBlockSummary = (CommentBlockSummary)summary;
		}
		else if(summary instanceof LineSummary)
		{
			if (lineSummary != null)
			{
				throw new IllegalArgumentException("this kind of summary has already been given.");
			}
			lineSummary = (LineSummary)summary;
		}
		else // unsupported summary type
		{
			throw new UnsupportedOperationException("Unsupported summary type.");
		}
		
		hasVerdict = true;
	}
}
