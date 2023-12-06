/**
 * 
 */
package edu.guanyfyp.syntax;

import static org.junit.jupiter.api.Assertions.assertAll;

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
		
		this.start_line = start_line;
		this.start_char_index = start_char_index;
		this.end_line = end_line;
		this.end_char_index = end_char_index;
		
		this.names = new HashMap<String, FormatToken>();
	}
	
	/**
	 * The position where the scope starts.
	 * The char index is with respect to the line.
	 * The scope starts after start_char_index.
	 */
	public final int start_line, start_char_index;
	
	/**
	 * The position where the scope ends.
	 * The char index is with respect to the line.
	 * The scope ends before end_char_index.
	 */
	public final int end_line, end_char_index;
	
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
	public void add_name(String name, FormatToken token)
	{
		// During the building of a scope,
		// a name should never be defined twice.
		assert !has_name(name);
		
		names.put(name, token);
	}
	
	/**
	 * Tells if the scope has the name defined.
	 * @param name
	 * @return true iff the name has been defined in the scope.
	 */
	public boolean has_name(String name)
	{
		return names.containsKey(name);
	}
	
	/**
	 * Obtains the FormatToken associated with the name defined in the scope.
	 * @param name
	 * @return the token, or null if has_name(name) returns false.
	 */
	public FormatToken get_name_token(String name)
	{
		return names.get(name);
	}
	
	
	/**
	 * Tells if the token given is inside this scope.
	 * @param token
	 * @return true iff so.
	 */
	public boolean is_token_in_scope(FormatToken token)
	{
		int t_line = token.line;
		int t_char_pos = token.actual_pos;
		
		if(t_line < start_line || t_line > end_line)
		{
			return false;
		}
		else if(t_line == start_line)
		{
			if(t_line != end_line) 
			{
				// t_line == start_line != end_line
				return t_char_pos > start_char_index;
			}
			else
			{
				// t_line == start_line == end_line
				return start_char_index < t_char_pos &&
						t_char_pos < end_char_index;
			}
		}
		else if(t_line == end_line)
		{
			// t_line == end_line != start_line
			return t_char_pos < end_char_index;
		}
		else
		{
			// start_line < t_line < end_line
			return true;
		}
	}
}
