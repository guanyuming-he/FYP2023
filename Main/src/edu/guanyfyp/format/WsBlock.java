/**
 * @author Guanyuming He
 */
package edu.guanyfyp.format;

import javax.management.RuntimeErrorException;

import edu.guanyfyp.syntax.SyntaxContext;

/**
 * I plan to process whitespaces as "blocks".
 * That is, I only care about the length (not the number of characters, but how long it should look) 
 * and positions of such blocks and don't care what are the actual characters (spaces, tabs, etc.)
 * 
 * I decide that 
 *      1. A space occupies 1 unit unconditionally.
 *      2. A tab always looks as if it pushes the next character to the next position divisible by 4.
 *          e.g. a tab at position 0, 1, 2, or 3 will cause the next character to show at position 4.
 *      3. I will process the format line by line so I will ignore all \n or \n\r characters.
 *  
 * @implNote According to the Java language specification,
 * https://docs.oracle.com/javase/specs/jls/se17/html/jls-3.html#jls-3.6,
 * A white space is one of
 * 		ASCII SP (space), HT (\t), FF (\f) 
 * 		or a line terminator, which is
 * 			a \n,
 * 			a \r,
 * 			or a \n\r.
 * Therefore, I only need to care about these characters.
 */
public class WsBlock extends FormatToken 
{
		
	public WsBlock
	(
		String characters, 
		int visual_pos, int actual_pos, int line, int index_in_line
	) 
	{
		super(characters, visual_pos, actual_pos, line, index_in_line);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Used for testing.
	 * Checks if str consists of only white space characters, excluding line terminators,
	 * as specified by the Java language specification,
	 * https://docs.oracle.com/javase/specs/jls/se17/html/jls-3.html#jls-3.6
	 * @param str
	 * @return true if so.
	 */
	public static boolean isTrulyWs(String str)
	{
		for(int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			switch(c)
			{
			case ' ':
				continue;
			case '\t':
				continue;
			case '\f':
				continue;
			default:
				return false;
			}
		}
		
		return true;
	}

	@Override
	protected int calculateVisualLength() 
	{
		int length = 0;
		for (int i = 0; i < characters.length(); ++i)
		{
			char c = characters.charAt(i);
			switch(c)
			{
			case ' ':
				length += 1;
				break;
			case '\t':
				// the current position of the \t
				int cur_pos = visualPos + length;
				length += (4 - (cur_pos % 4));
				break;
			default:
				// No other whitespace characters occupy space
				break;
			}
		}
		
		return length;
	}

	@Override
	protected float calculateFormatScore(SyntaxContext ctx) 
	{
		throw new RuntimeException("Not implemented.");		
	}
}
