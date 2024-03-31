/**
 * 
 */
package edu.guanyfyp.format.primitives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Token;
import edu.guanyfyp.SourceFile;

/**
 * Comment block exclusively for JavaDoc.
 * There was no such a class, but a boolean in CommentBlock.
 * However, Dr. Selig pointed out that it was a bad design.
 * Hence this class.
 * 
 * How JavaDoc is parsed:
 * First the comment is divided into lines.
 * 1. If a line is the first line, then /** is removed from the start of it
 * 2. If a line is a middle line and there is some *, then all before the first *, including it, is removed from it.
 * 3. If a line is the last line, then star/ (can't type the star here) is removed from it.
 * 
 * All other texts are preserved. And tags are processed based on the JavaDoc rules.
 */
public final class JavaDocBlock extends CommentBlock 
{	
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
			tagName = temp_tag_name.replaceAll("[\r\n]+", "");
			tagText = temp_tag_text.replaceAll("[\r\n]+", "");
			
		}
		
		public Tag(String tn, String tt)
		{
			tagName = tn;
			tagText = tt;
		}
		
		// These two are public as they are final.
		public final String tagName;
		public final String tagText;
		
		@Override
		public boolean equals(Object o)
		{
			if (!(o instanceof Tag))
			{
				return false;
			}
			
			Tag t = (Tag)o;
			return t.tagName.equals(tagName) &&
					t.tagText.equals(tagText);
		}
		
	}
	/**

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
			int space_ind = this.tagText.indexOf(" ");
			if(space_ind == -1)
			{
				// No space in the text
				attrName = this.tagText;
				attrText = "";
			}
			else
			{
				attrName = this.tagText.substring(0, space_ind);
				// Since space must be a character in the tag_text,
				// space_ind + 1 won't be bigger than the end and the method won't throw an exception.
				attrText = this.tagText.substring(space_ind + 1);
			}
		}
		
		/**
		 * @param tn tag name
		 * @param tt tag text
		 */
		public AttrTag(String tn, String tt) 
		{
			super(tn, tt);
			
			// tt := attr_name " " attr_text	
			int space_ind = tt.indexOf(" ");
			if(space_ind == -1)
			{
				// No space in the text
				attrName = tt;
				attrText = "";
			}
			else
			{
				attrName = tt.substring(0, space_ind);
				// Since space must be a character in the tt,
				// space_ind + 1 won't be bigger than the end and the method won't throw an exception.
				attrText = tt.substring(space_ind + 1);
			}
		}
		
		public final String attrName;
		public final String attrText;
		
		// Tag's equals works for all tags, so no overriding equals
	}
	
	
	/*
	 * These lists will be stored in immutable containers.
	 * so they are all public
	 */
	
	// The tags in this JavaDoc comment, in the order they appear.
	public final List<Tag> tags;
	
	// All important tags that are specially treated in this system.
	// The fields are all lists of indices of tags in the field tags.
	public final List<Integer> paramTags;
	public final List<Integer> throwsTags;
	
	// The text before the tags
	public final String mainText;

	/**
	 * @param characters
	 * @param visual_pos
	 * @param actual_pos
	 * @param line
	 * @param index_in_line
	 */
	public JavaDocBlock
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
			
			String lines[] = characters().split("\\r?\\n");			
			
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
					// Remove "*/" 
					assert processed_line.length() >= 2;
					processed_line = processed_line.substring(0, processed_line.length()-2);
				}
				// Not the first or the last line.
				else if(i != 0)
				{
					// Remove all before the starting "*" if there is one.
					int index = processed_line.indexOf("*");
					
					if(index != -1)
					{
						processed_line = processed_line.substring(index+1);
					}
				}
				
				if(processed_line.isEmpty())
				{
					continue;
				}
				
				// Tell if the line contains a tag start
				int tagInd = processed_line.indexOf('@');
				if(tagInd != -1)
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
						switch(tag.tagName)
						{
						case "param":
							temp_tags.add(new AttrTag(tag.tagName, tag.tagText));
							temp_param_tags.add(temp_tags.size()-1);
							break;
						case "throws":
							temp_tags.add(new AttrTag(tag.tagName, tag.tagText));
							temp_throws_tags.add(temp_tags.size()-1);
							break;
						default:
							temp_tags.add(new Tag(tag.tagName, tag.tagText));
						}
					}
					
					// Now reset the accumulated text to the current tag's string
					accumulated_text = processed_line.substring(tagInd);
				}
				else
				{
					// Accumulate the text.
					accumulated_text += processed_line;
				}
			}
			// Handle the last accumulated text.
			// the whole accumulated_text is for the main_text if the main desc has never ended
			if(!main_desc_ended)
			{
				main_desc_ended = true;
				main_text_builder.append(accumulated_text);
			}
			// Otherwise, it's for a tag
			else
			{
				// Try to parse the tag text.
				Tag tag = new Tag(accumulated_text);
				// Decide what to do based on the tag name
				switch(tag.tagName)
				{
				case "param":
					temp_tags.add(new AttrTag(tag.tagName, tag.tagText));
					temp_param_tags.add(temp_tags.size()-1);
					break;
				case "throws":
					temp_tags.add(new AttrTag(tag.tagName, tag.tagText));
					temp_throws_tags.add(temp_tags.size()-1);
					break;
				default:
					temp_tags.add(new Tag(tag.tagName, tag.tagText));
				}
			}
			
			// Finally, assign all final fields
			this.tags = Collections.unmodifiableList(temp_tags);
			this.paramTags = Collections.unmodifiableList(temp_param_tags);
			this.throwsTags = Collections.unmodifiableList(temp_throws_tags);
			this.mainText = main_text_builder.toString();
		}
		
		following = FollowingType.OTHER;
	}

//////////////////////////////////////// Format Evaluation ////////////////////////////////////////
	
	/**
	 * Type of the syntax structure that follows the JavaDoc.
	 */
	public static enum FollowingType
	{
		// class-like syntax structures
		// e.g. class, interface, enum, ...
		CLASS_LIKE,
		// methods and constructors, whether generic or not.
		METHOD_LIKE,
		FIELD,
		// other types of structures or none.
		// all that having this are inappropriate.
		OTHER 
	}
	
	/**
	 * The information about the method that follows it.
	 * Means nothing if it's not followed by a method.
	 */
	public static class FollowingMethod
	{
		// These are only meaningful if the containing JavaDocBlock's
		// following type is METHOD or CONSTRUCTOR
		
		// Constructors are treated as returning void
		public String returnType = "void";
		public List<String> parameterNames = new ArrayList<>(); 
	}

	// These are set in SyntaxStructureBuilder
	// Which kind of code block this JavaDoc comment precedes.
	private FollowingType following = FollowingType.OTHER;
	private FollowingMethod followingMethod = new FollowingMethod();
	
	// These are calculated in evaluateFormat().
	// if the JavaDoc has @param, @return, or @throws
	// then it can only be followed by a method/ctor.
	// The field is true iff 
	// 	1. the structure following the java doc is not a method/ctor,
	// but the tags suggest otherwise.
	//	2. the following type is other. JavaDocs should not be followed by other things.
	private boolean followingTypeUnmatched = false;
	// Tags that are written in the comment but are not matched in the following structure.
	// if the following is a method, then it only stores the unmatched param tags 
	// This field is from the opposite direction of another field: unmatchedParams.
	private List<Tag> unmatchedTags;
	// If what follows is METHOD_LIKE, then the list records all syntax objects
	// that appear there but not here.
	// A method can have a return, some params, and some throws.
	// But throws are hard to check and return is checked in another variable
	// So: for not this only means params that are in the following structure but are not matched by the tags
	private List<String> unmatchedSyntaxObjs;
	// If the method does not return void but there is not @return tag
	private boolean returnNotProvided = false;
	
	/**
	 * MUST only be called within SyntaxStructureBuilder to fill the information.
	 * @param type
	 * @param method if !(type = METHOD or CONSTRUCTOR), then ignored
	 */
	public void setFollowing(FollowingType type, FollowingMethod method)
	{
		this.following = type;
		if(type == FollowingType.METHOD_LIKE)
		{
			this.followingMethod = method;
		}
	}
	/** @return Which kind of code block this JavaDoc comment precedes. */
	public FollowingType getFollowingType() 
	{
		return following;
	}
	/** @return If a method/ctor definition follows the java doc, then returns information about that. */
	public FollowingMethod getFollowingMethodInfo() 
	{
		return followingMethod;
	}
	public boolean isTypeUnMatched() 
	{
		return followingTypeUnmatched;
	}
	
	/**
	 * @return Tags that are written in the comment but are not matched in the following structure.
	 if the following is a method, then it only stores the unmatched param tags 
	 */
	public List<Tag> getUnmatchedCommentTags() 
	{
		return unmatchedTags;
	}
	/**
	 * Only meaningful if the following is METHOD_LIKE
	 * @return the syntax objects in the following but are not matched
	 * by the tags. For now, this means only parameters.
	 */
	public List<String> getUnmatchedSyntaxObjects() 
	{
		return unmatchedSyntaxObjs;
	}
	public boolean getReturnNotProvided()
	{
		return returnNotProvided;
	}
	
	@Override
	public void evaluateFormat(SourceFile sf, PrimitiveContext context) 
	{
		super.evaluateFormat(sf, context);
		
		unmatchedSyntaxObjs = new ArrayList<>();
		unmatchedTags = new ArrayList<>();
		
		if(following == FollowingType.OTHER)
		{
			followingTypeUnmatched = true;
		}
		
		// If it's not followed by a method,
		// then any tag except return, param, and throws is allowed
		if(following != FollowingType.METHOD_LIKE)
		{
			// any method tag becomes unmatched.
			for(var tag: tags)
			{
				if(tag.tagName.equals("return") || tag.tagName.equals("param") || tag.tagName.equals("throws"))
				{
					followingTypeUnmatched = true;
					unmatchedTags.add(tag);
				}
			}
			
			return;
		}
		
		// Now it's followed by a method.
		// Algorithm to decide unmatched ones bidirectionally:
		// 1. copy all following method parameters in list1
		// 2. for each param tag, check if it's matched in list1.
		//	If so, remove it from list1.
		//	If not, add it to a new list, list2.
		// 3. list2 is the list of the params that exist in the comment but not in the definition.
		// 4. Add all remaining list1 items in unmatched list of the other direction.
		{		
			boolean hasReturnTag = false;
			var list1 = new ArrayList<>(followingMethod.parameterNames);
			var list2 = unmatchedTags;
			for(var tag: tags)
			{	
				switch(tag.tagName)
				{
				case "return":
					hasReturnTag = true;
					break;
				case "param":
					var attrTag = (AttrTag)tag;
					// if the par name equals the tag's attr name, then a match.
					boolean matched = list1.removeIf((par) -> par.equals(attrTag.attrName));
					if(!matched)
					{
						list2.add(tag);
					}
				}
			}
			unmatchedSyntaxObjs = list1;
			
			if(!followingMethod.returnType.equals("void")) 
			{
				returnNotProvided = !hasReturnTag;
			}
		}
		
	}

}
