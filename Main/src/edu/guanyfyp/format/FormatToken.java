/**
 * @author Guanyuming He
 */
package edu.guanyfyp.format;

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
	/**
	 * All fields are public as they won't change.
	 * This way accessing is easier and the invariants are better protected.
	 */
	
	// The actual characters of the token in the text.
	public final String characters;
	// The appeared position of the first character in the line.
	// i.e. the number of characters before the first character of this token in the line
	public final int visualPos;
	// The actual position of the first character in the line.
	public final int actualPos;
	// The number of the line that the token is in.
	public final int line;
	// If it = n, then the token is the n^th token in the line.
	// Used to navigation among tokens.
	public final int indexInLine;
	// How long the token looks like in a text editor.
	public final int visualLength;
	
	// Indicates how good the single token's format is,
	// taking its context into consideration.
	protected float formatScore = -1.0f;
	public float getFormatScore() { return formatScore; }
	
	/**
	 * Direct assignment of all fields
	 * 
	 * @param characters The actual characters of the token in the text.
	 * @param position The appeared position of the first character in the line.
	 * @param act_pos The actual position of the first character in the line.
	 * i.e. the number of characters before the first character of this token in the line
	 * @param line The number of the line that the token is in.
	 * @param length How long the token looks like in a text editor.
	 */
	FormatToken
	(
		String characters, 
		int visual_pos, int actual_pos,
		int line, int index_in_line, int length
	)
	{
		this.characters = characters;
		this.visualPos = visual_pos;
		this.actualPos = actual_pos;
		this.line = line;
		this.indexInLine = index_in_line;
		this.visualLength = length;
	}
	
	/**
	 * Length is calculated by calling calculate_visual_length().
	 * All other fields are given.
	 * @param characters The actual characters of the token in the text.
	 * @param position The appeared position of the first character in the line.
	 * @param act_pos The actual position of the first character in the line.
	 * i.e. the number of characters before the first character of this token in the line
	 * @param line The number of the line that the token is in.
	 */
	FormatToken
	(
		String characters, 
		int visual_pos, int actual_pos,
		int line, int index_in_line
	)
	{
		this.characters = characters;
		this.visualPos = visual_pos;
		this.actualPos = actual_pos;
		this.line = line;
		this.indexInLine = index_in_line;
		this.visualLength = calculateVisualLength();
	}
	
	
/////////////////////////// Virtual methods ////////////////////////////
	
	/**
	 * Calculates how long the token should look like in a text editor.
	 * @implNote The default implementation returns the number of characters
	 * @return the visual lengths calculated
	 */
	protected int calculateVisualLength()
	{
		return this.getNumCharacters();
	}
	
	/**
	 * Calculates the format score of the token given the context that it's in.
	 * @param ctx the context that the token is in.
	 * @return the format_score calculated.
	 */
	protected abstract float calculateFormatScore(SyntaxContext ctx);
	
/////////////////////////// Accessors ///////////////////////////////////
	/**
	 * @return the number of characters in the token.
	 */
	public int getNumCharacters() { return characters.length(); }
	
////////////////////////// From Object ///////////////////////////////	
	@Override
	public String toString()
	{
		return "Token " + characters + "of length " + Integer.toString(visualLength) +
				" at " + Integer.toString(visualPos) +
				", line " + Integer.toString(line);
	}
	
	/**
	 * Works if line <= 2^19 and index_in_line < 2^12, which should nearly always be the case
	 * for source code to be processed by my system.
	 */
	@Override
	public int hashCode()
	{
		return 2^19 * line + indexInLine;
	}
	
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
		return line == o.line && indexInLine == o.indexInLine;
	}
	
///////////////////////// For tests //////////////////////////////////
	/**
	 * @param other
	 * @return true iff all fields (except the format score) are the same with the fields of other
	 */
	public boolean __test_equals(FormatToken other) {
		return 
			this.characters.equals(other.characters) &&
			this.visualPos == other.visualPos &&
			this.actualPos == other.actualPos &&
			this.line == other.line &&
			this.indexInLine == other.indexInLine &&
			this.visualLength == other.visualLength;
	}
}

