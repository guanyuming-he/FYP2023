/**
 * @author Guanyuming He
 */
package format;

/**
 * A FormatToken represents how a token affects the format (or appearance) of the source code
 * Therefore, I only care about the length and position of such tokens.
 * But for the sake of implementation convenience, I decide to also include 
 * the index of the token in the line.
 * 
 * @implNote A position consists of the line number and the position in the line.
 * Line numbers start from 1 while the in-line position starts from 0.
 * The length is not the number of characters. It's how long the token looks like in a text editor.
 * 
 * Different kinds of tokens that I care about in formatting will be represented by subclasses of the class.
 * 
 * Given all the information contained in such format tokens,
 * my formatter can divide a source code text file into lines,
 * and each line into such format tokens by:
 * 		1. set pos = act_pos = 0
 * 		2. read in the next FormatToken, give it the characters, line, pos, and act_pos.
 * 			and let it calculate its length.
 * 		3. act_pos += num of characters; pos += calculated length.
 * 		4. repeat for next token.
 */
public class FormatToken 
{
	/**
	 * All fields are public as they won't change.
	 * This way accessing is easier.
	 */
	
	// The actual characters of the token in the text.
	public final String characters;
	// The appeared position of the first character in the line.
	// i.e. the number of characters before the first character of this token in the line
	public final int pos;
	// The actual position of the first character in the line.
	public final int act_pos;
	
	// The number of the line that the token is in.
	public final int line;
	// If index_in_line = n, then the token is the n^th in the line.
	public final int index_in_line;
	// How long the token looks like in a text editor.
	public final int length;
	
	/**
	 * Because the system I am developing will not modify the text,
	 * all the info is fixed and should be obtained at creation.
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
		int position, int act_pos,
		int line, int index_in_line, int length
	)
	{
		this.characters = characters;
		this.pos = position;
		this.act_pos = act_pos;
		this.line = line;
		this.index_in_line = index_in_line;
		this.length = length;
	}
	
/////////////////////////// Accessors ///////////////////////////////////
	/**
	 * @return the number of characters in the token.
	 */
	public int getNumCharacters() { return characters.length(); }
	
	
////////////////////////// From Object ///////////////////////////////	
	@Override
	public String toString()
	{
		return "Token " + characters + "of length " + Integer.toString(length) +
				" at " + Integer.toString(pos) +
				", line " + Integer.toString(line);
	}
	
	/**
	 * Works if line <= 2^17 and act_pos < 2^14, which should nearly always be the case
	 * for source code to be processed by my system.
	 */
	@Override
	public int hashCode()
	{
		return 2^17 * line + act_pos;
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
		return line == o.line && pos == o.pos;
	}
	
}

