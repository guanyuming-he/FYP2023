/**
 * 
 */
package edu.guanyfyp.format;

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
		String characters, 
		int visual_pos, int actual_pos, int line, int index_in_line
	)
	{
		super(characters, visual_pos, actual_pos, line, index_in_line);
	}

	@Override
	protected float calculate_format_score(SyntaxContext ctx) 
	{
		throw new RuntimeException("Not implemented.");		
	}
}
