/**
 * 
 */
package edu.guanyfyp.format;

/**
 * Comment block exclusively for JavaDoc.
 * There was no such a class, but a boolean in CommentBlock.
 * However, Dr. Selig pointed out that it was a bad design.
 * Hence this class.
 */
public class JavaDocCommentBlock extends CommentBlock {

	/**
	 * @param characters
	 * @param visual_pos
	 * @param actual_pos
	 * @param line
	 * @param index_in_line
	 */
	public JavaDocCommentBlock
	(
		String characters, 
		int visual_pos, int actual_pos, int line, int index_in_line
	) 
	{
		super(characters, visual_pos, actual_pos, line, index_in_line);
		// TODO Auto-generated constructor stub
	}

}
