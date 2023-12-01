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
	public static class Tag
	{
		/**
		 * @param org_text the original text that defines the tag.
		 * In the form of \at tag_name tag_text
		 */
		public Tag(String org_text)
		{
			// Discard the @
			String t = org_text.substring(1);
			int space_ind = t.indexOf(" ");
			
			// The fields are final and can only be assigned once.
			// Hence these temps
			String temp_tag_name;
			String temp_tag_text;
			
			// If there is some text after the tag name
			if (space_ind != -1)
			{
				temp_tag_name = t.substring(0, space_ind);
				// Since space must be a character in t,
				// space_ind + 1 won't be bigger than the end and the method won't throw an exception.
				temp_tag_text = t.substring(space_ind+1);
			}
			else
			{
				temp_tag_name = t;
				temp_tag_text = "";
			}
			
			// Now, dump all line breaks
			tag_name = temp_tag_name.replaceAll("[\r\n]+", "");
			tag_text = temp_tag_text.replaceAll("[\r\n]+", "");
			
		}
		
		public Tag(String tn, String tt)
		{
			tag_name = tn;
			tag_text = tt;
		}
		
		public final String tag_name;
		public final String tag_text;
		
		@Override
		public boolean equals(Object o)
		{
			if (!(o instanceof Tag))
			{
				return false;
			}
			
			Tag t = (Tag)o;
			return t.tag_name.equals(tag_name) &&
					t.tag_text.endsWith(tag_text);
		}
		
	}
	/**
	 * A tag that marks an attribute that has a name.
	 * e.g. \at param name ... \at throws name ...
	 * tt := attr_name " " attr_text
	 */
	public static class AttrTag extends Tag
	{
		/**
		 * @param org_text the original text that defines the tag.
		 */
		public AttrTag(String org_text)
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
		
		public AttrTag(String tn, String tt) 
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
		
		@Override
		public boolean equals(Object o)
		{
			if (!(o instanceof AttrTag))
			{
				return false;
			}
			
			AttrTag t = (AttrTag)o;
			return super.equals(o) &&
					t.attr_name.equals(attr_name) &&
					t.attr_text.equals(attr_text);
		}
	}
	
	// Which kind of code block this JavaDoc comment precedes.
	private Preceding preceding;
	
	/*
	 * These lists will be stored in immutable containers.
	 * so they are all public
	 */
	
	// The tags in this JavaDoc comment, in the order they appear.
	public final List<Tag> tags;
	
	// All important tags that are specially treated in this system.
	// The fields are all lists of indices of tags in the field tags.
	public final List<Integer> param_tags;
	public final List<Integer> throws_tags;
	
	// The text before the tags
	public final String main_text;

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
		
		// Parses the javadoc string
		{
			// JavaDoc is, according to the spec, desc followed by tags
			// First I divide the string into lines and remove those /* 's
			// Then I separate the main desc and each tag and feed the tag string to a corresponding constructor
			
			// preparation: init temp lists which are to be converted to
			// immutable lists as fields.
			var temp_tags = new ArrayList<Tag>();
			var temp_param_tags = new ArrayList<Integer>();
			var temp_throws_tags = new ArrayList<Integer>();
			// preparation: main_text can only be assigned once.
			StringBuilder main_text_builder = new StringBuilder();
			
			String lines[] = characters.split("\\r?\\n");			
			
			// Set to true on encountering the first tag
			boolean main_desc_ended = false;
			// A portion of text may be separated over several lines.
			// This variable is used to accumulate them.
			// It's reset when next portion of text is needed.
			String accumulated_text = "";
			
			for(int i = 0; i < lines.length; ++i)
			{
				String processed_line = lines[i];
				// Remove characters from the first line
				if(i == 0)
				{
					// Delete /** from the first line
					processed_line = processed_line.substring(3);
				}
				// Remove characters from the last line
				if(i == lines.length - 1)
				{
					
					if(i != 0)
					{
						// Remove all when it's not the first line
						processed_line = "";
					}
					else
					{
						// Remove "*/" when it's also the first line.
						assert processed_line.length() >= 2;
						processed_line = processed_line.substring(0, processed_line.length()-2);
					}

				}
				// Not the first or the last line.
				else if(i != 0)
				{
					// Remove all before  " * "
					int index = processed_line.indexOf(" * ");
					assert index != -1;
					
					processed_line = processed_line.substring(index+3);
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
						main_text_builder.append(accumulated_text);
					}
					else
					{
						// The main desc already ended. 
						// The accumulated_text is for a tag.
						if(accumulated_text.isEmpty())
						{
							continue;
						}
						
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
					// and add the current line
					accumulated_text = "";
					accumulated_text += processed_line;
				}
				else
				{
					// Accumulate the text.
					accumulated_text += processed_line;
				}
			}
			// Handle the last accumulated text.
			// the whole accumulated_text is the main_text if the main desc has never ended
			if(!main_desc_ended)
			{
				main_desc_ended = true;
				main_text_builder.append(accumulated_text);
			}
			// Otherwise, it's a tag
			else
			{
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
			
			// Finally, assign all final fields
			this.tags = Collections.unmodifiableList(temp_tags);
			this.param_tags = Collections.unmodifiableList(temp_param_tags);
			this.throws_tags = Collections.unmodifiableList(temp_throws_tags);
			this.main_text = main_text_builder.toString();
		}
		
		preceding = Preceding.OTHER;
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
