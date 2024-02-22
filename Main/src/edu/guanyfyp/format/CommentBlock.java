/**
 * 
 */
package edu.guanyfyp.format;

import org.antlr.v4.runtime.Token;

import edu.guanyfyp.syntax.SyntaxContext;

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

	@Override
	protected float calculateFormatScore(SyntaxContext ctx) 
	{
		throw new RuntimeException("Not implemented.");		
	}
}
