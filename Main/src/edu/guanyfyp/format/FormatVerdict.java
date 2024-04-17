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
public class FormatVerdict 
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
	
//////////////////////// Verdict Fields ////////////////////////
	// Each will 0.0f the default value if the source file has no such element.
	
	private float identifierLengthProblemFrequency = 0.0f;
	private float identifierNamingProblemFrequency = 0.0f;
	private float spacingProblemFrequency = 0.0f;
	// equals min(numStyle1, numStyle2) / sum
	private float inconsistentScopeStyleFrequency = 0.0f;
	private float badJavaDocFrequency = 0.0f;
	private float lineLengthProblemFrequency = 0.0f;
	private float lineIndentationProblemFrequency = 0.0f;
	
	// false iff numComments = numJavaDocs = 0.
	private boolean hasCommentsAtAll = false;
	
//////////////////////// Methods ////////////////////////	
	
	public boolean hasGivenVerdict() { return hasVerdict; }
	
	/**
	 * Give verdict for the summaries of the evaluations of the format primitives in the source file.
	 */
	public void giveVerdict()
	{
		// if the source file has code
		// (a source may only contain comments or spaces)
		if(codeBlockSummary != null)
		{
			if(codeBlockSummary.numIdentifiers > 0)
			{
				float numIdLengthProbs = 
						codeBlockSummary.tooShortList.size() + 
						codeBlockSummary.tooLongList.size();
				identifierLengthProblemFrequency = numIdLengthProbs / (float)codeBlockSummary.numIdentifiers;
			}

			if(codeBlockSummary.numIdentifiers > 0)
			{
				identifierNamingProblemFrequency = 
						(float)codeBlockSummary.badlyNamedList.size() / (float)codeBlockSummary.numIdentifiers;
			}
			
			if(codeBlockSummary.numOperators + codeBlockSummary.numPunctuation > 0)
			{
				spacingProblemFrequency = 
						(float)codeBlockSummary.spaceProblemsList.size() / 
						((float)codeBlockSummary.numOperators + (float)codeBlockSummary.numPunctuation);
			}

			float numScopeStyle1 = codeBlockSummary.lbraceNewLineScopes.size();
			float numScopeStyle2 = codeBlockSummary.lbraceNoNewLineScopes.size();
			if(numScopeStyle1 + numScopeStyle2 > 0)
			{
				// without the 2.f multiplier,
				// the maximum value is .5f when half is one style and the other half is another style
				inconsistentScopeStyleFrequency = 
						2.f * Math.min(numScopeStyle1, numScopeStyle2) / (numScopeStyle1 + numScopeStyle2);
			}

		}
		// if the source file has javadoc
		if(javaDocSummary != null)
		{
			if(javaDocSummary.getNumJavaDocs() > 0)
			{
				badJavaDocFrequency = 
						(float)javaDocSummary.getBadJavaDocsList().size() / (float)javaDocSummary.getNumJavaDocs();
			}
		}
		// if the source file has lines
		if(lineSummary != null)
		{
			if(lineSummary.getNumLines() > 0)
			{
				lineLengthProblemFrequency = 
						(float)lineSummary.getTooLongLines().size() / (float)lineSummary.getNumLines();
				
				lineIndentationProblemFrequency = 
						(float)lineSummary.getBadlyIndentedLines().size() / (float)lineSummary.getNumLines();
			}
		}
		if(javaDocSummary != null || commentBlockSummary != null)
		{
			hasCommentsAtAll = true;
		}
		
		
		hasVerdict = true;
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
		
		assert(summary.isSummaryDone());
		
		if(summary instanceof WsBlockSummary)
		{
			if (wsBlockSummary != null)
			{
				throw new IllegalArgumentException("this kind of summary has already been given.");
			}
			wsBlockSummary = (WsBlockSummary)summary;
		}
		else if(summary instanceof CodeBlockSummary)
		{
			if (codeBlockSummary != null)
			{
				throw new IllegalArgumentException("this kind of summary has already been given.");
			}
			codeBlockSummary = (CodeBlockSummary)summary;
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
	}

	public boolean isHasVerdict() {
		return hasVerdict;
	}

	public WsBlockSummary getWsBlockSummary() {
		return wsBlockSummary;
	}

	public CommentBlockSummary getCommentBlockSummary() {
		return commentBlockSummary;
	}

	public JavaDocSummary getJavaDocSummary() {
		return javaDocSummary;
	}

	public CodeBlockSummary getCodeBlockSummary() {
		return codeBlockSummary;
	}

	public LineSummary getLineSummary() {
		return lineSummary;
	}

	public float getIdentifierLengthProblemFrequency() {
		return identifierLengthProblemFrequency;
	}

	public float getIdentifierNamingProblemFrequency() {
		return identifierNamingProblemFrequency;
	}

	public float getSpacingProblemFrequency() {
		return spacingProblemFrequency;
	}

	public float getInconsistentScopeStyleFrequency() {
		return inconsistentScopeStyleFrequency;
	}

	public float getBadJavaDocFrequency() {
		return badJavaDocFrequency;
	}

	public float getLineLengthProblemFrequency() {
		return lineLengthProblemFrequency;
	}

	public float getLineIndentationProblemFrequency() {
		return lineIndentationProblemFrequency;
	}
	
	public boolean getHasCommentAtAll() {
		return hasCommentsAtAll;
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("identifierLengthProblemFrequency = " + identifierLengthProblemFrequency + "\n");
		ret.append("identifierNamingProblemFrequency = " + identifierNamingProblemFrequency + "\n");
		ret.append("spacingProblemFrequency = " + spacingProblemFrequency + "\n");
		ret.append("inconsistentScopeStyleFrequency = " + inconsistentScopeStyleFrequency + "\n");
		ret.append("badJavaDocFrequency = " + badJavaDocFrequency + "\n");
		ret.append("lineLengthProblemFrequency = " + lineLengthProblemFrequency + "\n");
		ret.append("lineIndentationProblemFrequency = " + lineIndentationProblemFrequency + "\n");
		ret.append("hasCommentsAtAll = " + hasCommentsAtAll + "\n");

		ret.append('\n');
		ret.append("CodeBlocks summary:\n");
		ret.append(codeBlockSummary.toString());
		ret.append('\n');
		ret.append("Lines summary:\n");
		ret.append(lineSummary.toString());
		ret.append('\n');
		ret.append("JavaDocs summary:\n");
		ret.append(javaDocSummary.toString());
		
		return ret.toString();
	}
}
