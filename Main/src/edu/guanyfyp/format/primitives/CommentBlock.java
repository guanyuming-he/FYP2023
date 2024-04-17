/**
 * 
 */
package edu.guanyfyp.format.primitives;

import org.antlr.v4.runtime.Token;

import edu.guanyfyp.SourceFile;

/**
 * Block for all comments
 */
public class CommentBlock extends FormatToken 
{
	
	/**
	 * @param characters
	 * @param visual_pos
	 * @param actual_pos
	 * @param line
	 * @param index_in_line
	 */
	public CommentBlock
	(
		Token antlr_token,
		int visual_pos,
		int index_in_line
	)
	{
		super
		(
			antlr_token, visual_pos, index_in_line
		);
	}

	/**
	 * For comments.
	 * 
	 * @return If it is a single line comment, then returns the number of characters, even if 
	 * 	the most characters are all spaces.
	 * If it is a multi-line comment, then returns the number of characters before the first line terminator.
	 */
	@Override
	public int calculateVisualLength(String str)
	{
		// we have //, /*...*/, or /**...*/
		assert(str.length() >= 2);
		
		if(str.substring(0, 2).equals("//"))
		{
			// Single line comment starting with //
			return str.length();
		}
		else
		{
			// Must start with /* or /**
			assert(str.substring(0, 2).equals("/*"));
				
			int indFirstN = str.indexOf("\n");
			int indFirstR = str.indexOf("\r");
			int indFirstNewLine = -1;
			if(indFirstN == -1)
			{
				indFirstNewLine = indFirstR;
			}
			else if(indFirstR == -1)
			{
				indFirstNewLine = indFirstN;
			}
			else
			{
				indFirstNewLine = Math.min(indFirstR, indFirstN);
			}
			
			// Length is 
			// 1. the number of characters until the first /n (multi-line) or
			// 2. the whole number of characters (single-line)
			return indFirstNewLine != -1 ? indFirstNewLine : str.length();
		}
	}
	
	/**
	 * A comment block should always be visible, because both // and /* are visible.
	 */
	@Override
	public boolean isVisible()
	{
		return true;
	}
	
///////////////////////////// From FormatPrimitive /////////////////////////////
	@Override
	public void evaluateFormat(SourceFile sf, PrimitiveContext context) 
	{
		// Non-javaDoc comments need nothing.
		super.evaluateFormat(sf, context);
	}
	
	@Override
	public String toString()
	{
		if(characters().substring(0, 2).equals("//"))
		{
			return "One-line comment at " + actualPos() + ", line " + line();
		}
		else
		{
			return "Comment at " + actualPos() + ", line " + line();
		}
	}
}
