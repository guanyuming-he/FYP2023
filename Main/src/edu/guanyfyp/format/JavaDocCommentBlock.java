/**
 * 
 */
package edu.guanyfyp.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.misc.Pair;

import edu.guanyfyp.SyntaxContext;

/**
 * Comment block exclusively for JavaDoc.
 * There was no such a class, but a boolean in CommentBlock.
 * However, Dr. Selig pointed out that it was a bad design.
 * Hence this class.
 */
public final class JavaDocCommentBlock extends CommentBlock 
{
	
	/**
	 * Type of code block this JavaDoc comment precedes
	 */
	public enum Preceding
	{
		CLASS,
		METHOD,
		FIELD,
		CONSTRUCTOR,
		OTHER // This should be avoided in Java code but I need to have it anyway.
	}
	
	/**
	 * A tag of some JavaDoc comment.
	 */
	public class Tag
	{
		/**
		 * @param org_text the original text that defines the tag.
		 * In the form of \at tag_name tag_text
		 */
		Tag(String org_text)
		{
			// Discard the @
			String t = org_text.substring(1);
			int space_ind = t.indexOf(" ");
			
			assert space_ind != -1;
			tag_name = t.substring(0, space_ind);
			// Since space must be a character in t,
			// space_ind + 1 won't be bigger than the end and the method won't throw an exception.
			tag_text = t.substring(space_ind+1);
		}
		
		Tag(String tn, String tt)
		{
			tag_name = tn;
			tag_text = tt;
		}
		
		public final String tag_name;
		public final String tag_text;
	}
	/**
	 * A tag that marks an attribute that has a name.
	 * e.g. \at param name ... \at throws name ...
	 * tt := attr_name " " attr_text
	 */
	public class AttrTag extends Tag
	{
		/**
		 * @param org_text the original text that defines the tag.
		 */
		AttrTag(String org_text)
		{
			super(org_text);
			
			// tt := attr_name " " attr_text	
			int space_ind = this.tag_text.indexOf(" ");
			if(space_ind == -1)
			{
				// No space in the text
				attr_name = this.tag_text;
				attr_text = "";
			}
			else
			{
				attr_name = this.tag_text.substring(0, space_ind);
				// Since space must be a character in the tag_text,
				// space_ind + 1 won't be bigger than the end and the method won't throw an exception.
				attr_text = this.tag_text.substring(space_ind + 1);
			}
		}
		
		AttrTag(String tn, String tt) 
		{
			super(tn, tt);
			
			// tt := attr_name " " attr_text	
			int space_ind = tt.indexOf(" ");
			if(space_ind == -1)
			{
				// No space in the text
				attr_name = tt;
				attr_text = "";
			}
			else
			{
				attr_name = tt.substring(0, space_ind);
				// Since space must be a character in the tt,
				// space_ind + 1 won't be bigger than the end and the method won't throw an exception.
				attr_text = tt.substring(space_ind + 1);
			}
		}
		
		public final String attr_name;
		public final String attr_text;
	}
	
	// Which kind of code block this JavaDoc comment precedes.
	private Preceding preceding;
	
	/*
	 * These lists will be stored in immutable containers.
	 * But as their reference are not (cannot be) final, I still declare 
	 * them as private and provide only getters.
	 */
	
	// The tags in this JavaDoc comment, in the order they appear.
	private List<Tag> tags;
	public List<Tag> getTags() { return tags; }
	
	// All important tags that are specially treated in this system.
	// The fields are all lists of indices of tags in the field tags.
	private List<Integer> param_tags;
	public List<Integer> getParamTags() { return param_tags; }
	
	private List<Integer> throws_tags;
	public List<Integer> getThrowsTags() { return throws_tags; }
	
	// The text before the tags
	private String main_text;

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
		preceding = Preceding.OTHER;
	}
	
	/**
	 * Parses characters as JavaDoc
	 * and sets fields related to the text and the tags.
	 */
	public void parseJavaDoc()
	{
		// JavaDoc is, according to the spec, desc followed by tags
		// First I divide the string into lines and remove those /* 's
		// Then I separate the main desc and each tag and feed the tag string to a corresponding constructor
		
		// preparation: init temp lists which are to be converted to
		// immutable lists as fields.
		var temp_tags = new ArrayList<Tag>();
		var temp_param_tags = new ArrayList<Integer>();
		var temp_throws_tags = new ArrayList<Integer>();
		
		String lines[] = characters.split("\\r?\\n");
		
		this.main_text = "";
		
		// Set to true on encountering the first tag
		boolean main_desc_ended = false;
		// A portion of text may be separated over several lines.
		// This variable is used to accumulate them.
		// It's reset when next portion of text is needed.
		String accumulated_text = "";
		
		for(int i = 0; i < lines.length; ++i)
		{
			String processed_line = null;
			if(i == 0)
			{
				// Delete /** from the first line
				processed_line = lines[0].substring(3);
			}
			else if(i == lines.length - 1)
			{
				// Last line contains no information
				processed_line = "";
			}
			else
			{
				// Remove all before  "* "
				int index = lines[i].indexOf("* ");
				processed_line = lines[i].substring(i+2);
			}
			
			if(processed_line.isEmpty())
			{
				continue;
			}
			
			// Tell if the line contains a tag start
			if(processed_line.charAt(0) == '@')
			{
				// It's a tag start, also the only place where the last text portion ends.
				
				// Now check if it's where the main desc ends.
				if(!main_desc_ended)
				{
					// Yes, now main desc should end.
					main_desc_ended = true;
					this.main_text = accumulated_text;
				}
				else
				{
					// The main desc already ended. 
					// The accumulated_text is for a tag.
					
					// Try to parse the tag text.
					Tag tag = new Tag(accumulated_text);
					// Decide what to do based on the tag name
					switch(tag.tag_name)
					{
					case "param":
						temp_tags.add(new AttrTag(tag.tag_name, tag.tag_text));
						temp_param_tags.add(temp_tags.size()-1);
						break;
					case "throws":
						temp_tags.add(new AttrTag(tag.tag_name, tag.tag_text));
						temp_throws_tags.add(temp_tags.size()-1);
						break;
					default:
						temp_tags.add(new Tag(tag.tag_name, tag.tag_text));
					}
				}
				
				// Now reset the accumulated text
				accumulated_text = "";
			}
			else
			{
				// Accumulate the text.
				accumulated_text += processed_line;
			}
		}
		
		// Finally, turn all temp lists into immutable ones
		this.tags = Collections.unmodifiableList(temp_tags);
		this.param_tags = Collections.unmodifiableList(temp_param_tags);
		this.throws_tags = Collections.unmodifiableList(temp_throws_tags);
	}

	/**
	 * Determines which kind of code block the javadoc precedes
	 * and sets its preceding field accordingly.
	 * @param context
	 */
	public void setPreceding(SyntaxContext context)
	{
		
	}
}
