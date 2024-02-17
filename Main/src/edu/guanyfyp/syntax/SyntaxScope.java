/**
 * 
 */
package edu.guanyfyp.syntax;

import java.util.HashMap;
import java.util.Map;

import edu.guanyfyp.format.FormatToken;

/**
 * Represents a syntax scope.
 * A scope usually starts with a { and ends with a }
 * Many syntax structures can produce a scope,
 * e.g. a class definition, a method definition.
 * 
 * A scope mainly affects name resolution, i.e. which names are available.
 * A scope also has formatting implications.
 * E.g. inside a scope normally the overall indentation level should be increased.
 * 
 */
public final class SyntaxScope 
{
	public SyntaxScope
	(
		int start_line, int start_char_index,
		int end_line, int end_char_index
	)
	{
		// Some assertions to make sure the scope is of negative size.
		// It can be empty, though.
		assert start_line <= end_line;
		if(start_line == end_line)
		{
			assert start_char_index < end_char_index;
		}
		
		this.startLine = start_line;
		this.startCharIndex = start_char_index;
		this.endLine = end_line;
		this.endCharIndex = end_char_index;
		
		this.names = new HashMap<String, FormatToken>();
	}
	
	/**
	 * The position where the scope starts.
	 * The char index is with respect to the line.
	 * The scope starts after start_char_index.
	 */
	public final int startLine, startCharIndex;
	
	/**
	 * The position where the scope ends.
	 * The char index is with respect to the line.
	 * The scope ends before end_char_index.
	 */
	public final int endLine, endCharIndex;
	
	/**
	 * All the names defined in this scope.
	 */
	private final Map<String, FormatToken> names;
	
	/**
	 * During the building of this.names, call this method to 
	 * add a name to the scope.
	 * @param name
	 * @param token token linked to the name.
	 * 
	 * @apiNote if the name is already in the scope then the method will fail an assertion.
	 */
	public void addName(String name, FormatToken token)
	{
		// During the building of a scope,
		// a name should never be defined twice.
		assert !hasName(name);
		
		names.put(name, token);
	}
	
	/**
	 * Tells if the scope has the name defined.
	 * @param name
	 * @return true iff the name has been defined in the scope.
	 */
	public boolean hasName(String name)
	{
		return names.containsKey(name);
	}
	
	/**
	 * Obtains the FormatToken associated with the name defined in the scope.
	 * @param name
	 * @return the token, or null if has_name(name) returns false.
	 */
	public FormatToken getNameToken(String name)
	{
		return names.get(name);
	}
	
	
	/**
	 * Tells if the token given is inside this scope.
	 * @param token
	 * @return true iff so.
	 */
	public boolean isTokenInScope(FormatToken token)
	{
		int t_line = token.line;
		int t_char_pos = token.actualPos;
		
		if(t_line < startLine || t_line > endLine)
		{
			return false;
		}
		else if(t_line == startLine)
		{
			if(t_line != endLine) 
			{
				// t_line == start_line != end_line
				return t_char_pos > startCharIndex;
			}
			else
			{
				// t_line == start_line == end_line
				return startCharIndex < t_char_pos &&
						t_char_pos < endCharIndex;
			}
		}
		else if(t_line == endLine)
		{
			// t_line == end_line != start_line
			return t_char_pos < endCharIndex;
		}
		else
		{
			// start_line < t_line < end_line
			return true;
		}
	}
}
