/**
 * 
 */
package edu.guanyfyp.format;

import edu.guanyfyp.SyntaxContext;

/**
 * 
 */
public class CommentBlock extends FormatToken 
{
	// Is the comment block a JavaDoc comment.
	public final boolean is_java_doc;

	/**
	 * @param characters
	 * @param visual_pos
	 * @param actual_pos
	 * @param line
	 * @param index_in_line
	 * @param is_java_doc
	 */
	public CommentBlock
	(
		String characters, 
		int visual_pos, int actual_pos, int line, int index_in_line,
		boolean is_java_doc
	) 
	{
		super(characters, visual_pos, actual_pos, line, index_in_line);
		this.is_java_doc = is_java_doc;
	}

	@Override
	protected float calculate_format_score(SyntaxContext ctx) 
	{
		throw new RuntimeException("Not implemented.");		
	}
}
