/**
 * @author Guanyuming He
 */
package edu.guanyfyp.format;

import org.antlr.v4.runtime.Token;

import edu.guanyfyp.syntax.SyntaxContext;

/**
 * A FormatToken represents how a token affects the format (or appearance) of the source code
 * Therefore, I only care about the length and position of such tokens.
 * Additionally, each token is associated with a format_score that is calculated within a context.
 * The format_score is the only mutable and non-public field in the class, as it cannot be set at creation time.
 * 
 * But for the sake of navigation, I decide to also include 
 * the index of the token in the line.
 * 
 * @implSpec A position consists of the line number and the position in the line.
 * Line numbers start from 1 while the in-line position starts from 0.
 * The length is not the number of characters. It's how long the token looks like in a text editor.
 * Different kinds of tokens that I care about in formatting will be represented by subclasses of the class.
 * A piece of source code should be divided into three and only three kinds of format tokens:
 * 		1. whitespace blocks
 * 		2. comment blocks
 * 		3. code blocks that are neither whitespace nor comment.
 * 
 * @implNote Given all the information contained in such format tokens,
 * my formatter can divide a source code text file into lines,
 * and each line into such format tokens by:
 * 		1. set vis_pos = act_pos = 0
 * 		2. read in the next FormatToken, give it the characters, line, vis_pos, and act_pos.
 * 			and let it calculate its length.
 * 		3. act_pos += num of characters; vis_pos += calculated length.
 * 		4. repeat for next token.
 * All the tokens can be created after lexical analysis. 
 * But some fields (the non-public and non-final ones)
 * are only available after deeper analysis.
 */
public abstract class FormatToken 
{
//////////////////////// Fields //////////////////////////////
	
	// The appeared position of the first character in the line.
	// Public as it's immutable.
	// i.e. the number of characters before the first character of this token in the line
	public final int visualPos;
	// How long the FormatToken looks like.
	public final int visualLength;
	// The index of the token in the line, 0..n-1
	public final int indexInLine;

	
	// Its corresponding ANTLR token.
	protected final Token antlrToken;
	
	// Indicates how good the single token's format is,
	// taking its context into consideration.
	protected float formatScore = -1.0f;
	public float getFormatScore() { return formatScore; }
	
	
////////////////////// Constructors ///////////////////////////
	/**
	 * Creates a Format token by providing the corresponding ANTLR
	 * token and its visual position.
	 * 
	 * @param antlr_token The ANTLR token to create it.
	 * @param visual_pos Its visual position, calculated by its creator.
	 * @param index_in_line The index of the token in the line, 0..n-1
	 */
	FormatToken
	(
		Token antlr_token,
		int visual_pos,
		int index_in_line
	)
	{
		this.antlrToken = antlr_token;
		this.visualPos = visual_pos;
		this.indexInLine = index_in_line;
		this.visualLength = calculateVisualLength(antlr_token.getText());
	}
	
/////////////////////////// Observers ////////////////////////////
	/**
	 * @return the actual characters of this token.
	 */
	public String characters()
	{
		return antlrToken.getText();
	}
	
	/**
	 * @return the number of characters in the token.
	 */
	public int getNumCharacters() 
	{ 
		return characters().length(); 
	}

	/**
	 * @return The index of the first character of this token relative to the beginning of the line at which it occurs, 0..n-1
	 */
	public int actualPos()
	{
		return antlrToken.getCharPositionInLine();
	}
	
	/**
	 * @return The index of the line the token is in, 1..n
	 */
	public int line()
	{
		return antlrToken.getLine();
	}
	
	/**
	 * @return The index of the token in the whole SourceFile, 0..n-1
	 */
	int index()
	{
		return antlrToken.getTokenIndex();
	}
	
	/**
	 * @return true iff the token is visible (i.e. not completely blank)
	 */
	public abstract boolean isVisible();
	
/////////////////////////// Virtual methods ////////////////////////////
	
	/**
	 * Calculates how long the token with the characters should look like visually.
	 * 
	 * @param str the String that this token has. I use this instead of this.characters()
	 * because the method may be called inside constructors, where fields used by this.characters() may not be initialized yet.
	 * @implNote The default implementation returns the number of characters.
	 * @return the visual lengths calculated
	 */
	protected int calculateVisualLength(String str)
	{
		return str.length();
	}
	
	/**
	 * Calculates the format score of the token given the context that it's in.
	 * @param ctx the context that the token is in.
	 * @return the format_score calculated.
	 */
	protected abstract float calculateFormatScore(SyntaxContext ctx);
		
////////////////////////// From Object ///////////////////////////////	
	@Override
	public String toString()
	{
		return "Token: " + characters() + "\nof length " + Integer.toString(visualLength) +
				" at " + Integer.toString(visualPos) +
				", line " + Integer.toString(line());
	}
	
	/**
	 * Works if line <= 2^18 and actualPos() < 2^13, which should nearly always be the case
	 * for source code to be processed by my system.
	 */
	@Override
	public int hashCode()
	{
		return 2^18 * line() + actualPos();
	}
	
	/**
	 * @return true iff the two has the SAME underlying ANTLR token.
	 */
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof FormatToken))
		{
			return false;
		}
		
		var o = (FormatToken)other;
		// There can only be one token at a position.
		// For different files, I will manage tokens of a single file together
		// and not let tokens of other files intervene the process.
		return antlrToken == o.antlrToken;
	}
}

