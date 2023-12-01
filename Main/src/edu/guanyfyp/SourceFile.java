/**
 * @author Guanyuming He
 */
package edu.guanyfyp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.guanyfyp.format.CodeBlock;
import edu.guanyfyp.format.CommentBlock;
import edu.guanyfyp.format.FormatToken;
import edu.guanyfyp.format.JavaDocCommentBlock;
import edu.guanyfyp.format.WsBlock;
import edu.guanyfyp.generated.JavaLexer;
import edu.guanyfyp.generated.JavaParser;

/**
 * Represents a source code file.
 * Handles the reading of source code files.
 * Stores all the information needed to judge the code quality of the file.
 * 
 * @implSpec 
 * Invariants:
 * 		1. The lines and the tokens in the field format_tokens 
 * 		are stored in the order they appear in the file.
 */
public class SourceFile 
{
	/**
	 * The result of analyzing the format of the source.
	 * Includes scores, problem descriptions, etc.
	 */
	public final class FormatResult
	{
		// TODO: complete this class.
	}
	
    // All the tokens for format checking.
    // Each element of the outmost array represents a line in the source file.
    // Each element inside a line array is a token.
	// The field in the end will be immutable, and each inner list will also be.
    private final List<List<FormatToken>> format_tokens;
    /**
     * Because the format_tokens is immutable, one can get it.
     * @return this.format_tokens
     */
    public List<List<FormatToken>> get_format_tokens()
    {
    	return format_tokens;
    }    
    
    /**
     * Channel numbers of the lexer tokens
     */
	public static final int DEFAULT_CHANNEL = 0;
	public static final int WHITESPACE_CHANNEL = 1;
	public static final int COMMENTS_CHANNEL = 2;
	public static final int JAVADOC_CHANNEL = 3;
    
    /**
     * Reads the source code from a local file.
     * And parses the source file to create necessary objects to evaluate the format.
     * 
     * @param file_path The path to the file.
     * @param encoding The encoding of the file.
     * @throws IOException on reading error.
     * @throws UnsupportedOperationException if the source code contains some syntax error.
     */
    public SourceFile(String file_path) throws IOException, UnsupportedOperationException
    {
    	// Initialise temp fields
    	List<List<FormatToken>> temp_format_tokens = new ArrayList<>();
    	
    	// Parse the source file with ANTLR4
    	CharStream inputStream = CharStreams.fromFileName(file_path);
    	JavaLexer lexer = new JavaLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// Create all FormatTokens based on the lexer result
		{
			tokens.fill();
			List<Token> lexer_token_list = tokens.getTokens();
			
			// Container for the tokens in the current line.
			var cur_line_tokens = new ArrayList<FormatToken>();
			// Current line number (starting from 1)
			int cur_line = 1;
			// The current visual position in the line.
			int visual_pos = 0;
			// Number of tokens processed in this line.
			int cur_line_token_number = 0;
			// The tokens in the list should be in the order that they appear in the text.
			// Use a loop to iterate through them
			for(Token t : lexer_token_list)
			{
				// Do not accept empty tokens
				if(t.getText().isEmpty()) 
				{
					continue;
				}
				// Do not accept the final EOF token
				if(t.getType() == Token.EOF)
				{
					continue;
				}
				
				// Check if it's getting into another line.
				int tLine = t.getLine();
				if(cur_line != tLine)
				{
					// This should be true
					assert cur_line < tLine;
					
					// There may be lines that have no tokens since I ignore line separators.
					// Therefore, do this until I reach the next non-empty line.
					while(cur_line < tLine)
					{
						// Push the tokens in the current line in the immutable version.
						// And creates a new container for tokens in the next line.
						temp_format_tokens.add(Collections.unmodifiableList(cur_line_tokens));
						cur_line_tokens = new ArrayList<FormatToken>();
						
						// go to the next line.
						++cur_line;
					}
					// Now, cur_line = tLine
					assert cur_line == tLine;
					
					// Refresh variables
					visual_pos = 0;
					cur_line_token_number = 0;
				}
				
				FormatToken ft = null;
				switch(t.getChannel())
				{
				case DEFAULT_CHANNEL:
					ft = 
					new CodeBlock
					(
						t.getText(), // characters
						visual_pos, t.getCharPositionInLine(), 
						cur_line, 
						cur_line_token_number // index of the token in the line
					);
					
					// TODO: At this stage certain code block types can be deduced
					// (e.g. literals)
					// Assign such types now to reduce further deductions.
					break;
					
				case WHITESPACE_CHANNEL:
					ft = 
					new WsBlock
					(
						t.getText(), // characters
						visual_pos, t.getCharPositionInLine(), 
						cur_line, 
						cur_line_token_number // index of the token in the line
					);
					break;	
					
				case COMMENTS_CHANNEL:
					ft =
					new CommentBlock
					(
						t.getText(), // characters
						visual_pos, t.getCharPositionInLine(), 
						cur_line, 
						cur_line_token_number // index of the token in the line
					);
					break;	
					
				case JAVADOC_CHANNEL:
					ft =
					new JavaDocCommentBlock
					(
						t.getText(), // characters
						visual_pos, t.getCharPositionInLine(), 
						cur_line, 
						cur_line_token_number // index of the token in the line
					);
					break;	
					
				default:
					throw new RuntimeException("Unexpected channel number. Check my grammar.");
				}
				
				// Update the variables
				cur_line_tokens.add(ft);
				visual_pos += ft.visual_length;
				++cur_line_token_number;
			}
			// Now the cur_line_tokens that is for the last line has yet to be added.
			temp_format_tokens.add(Collections.unmodifiableList(cur_line_tokens));
			
			// Finally, turn format_tokens immutable
			format_tokens = Collections.unmodifiableList(temp_format_tokens);
		}
		
		// TODO: Parse the program and fill missing fields of the format tokens
		{
			// Reset the token stream because I retrieved all tokens once.
			tokens.seek(0);
			JavaParser parser = new JavaParser(tokens);
		}
    }

    /**
     * Analyzes the source code in the file and give a result.
     * @return the result given
     */
    FormatResult analyze()
    {
		throw new RuntimeException("Not implemented");
    }
    
//////////////////////////// Accessors /////////////////////////
    // The tokens can only be accessed through the following methods.
    /**
     * If in the line there is a token at index.
     * @param line line number, starting from 1
     * @param index starting from 0.
     * @return
     */
    boolean hasFormatToken(int line, int index)
    {
    	int line_ind = line - 1;
    	if (line_ind < 0 || line_ind >= format_tokens.size())
    	{
    		return false;
    	}
    	var line_array = format_tokens.get(line_ind);
    	if(index < 0 || index >= line_array.size())
    	{
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * Gets the index^th (starting from 0) FormatToken in the line (starting from 1).
     * @param line line number, starting from 1
     * @param index starting from 0.
     * @return the token or null if such a token does not exist.
     */
    public FormatToken getFormatToken(int line, int index)
    {
    	/*
    	 * Does not invoke hasFormatToken as hasFormatToken
    	 * gets a copy of the line_array, which I need to use here as well,
    	 * so it would be done twice that way.
    	 */
    	
    	int line_ind = line - 1;
    	if (line_ind < 0 || line_ind >= format_tokens.size())
    	{
    		return null;
    	}
    	var line_array = format_tokens.get(line_ind);
    	if(index < 0 || index >= line_array.size())
    	{
    		return null;
    	}
    	
    	return line_array.get(index);
    }
    
    /**
     * As a FormatToken contains its complete position information by design,
     * I can get tokens based on a given one.
     * This method gets the token immediately before the given one.
     * 
     * @param given the token given.
     * @return the token immediately before given (the method goes back to previous lines if necessary)
     * or null if there is no token before it.
     */
    public FormatToken getPrevFormatToken(FormatToken given)
    {
    	int line = given.line;
    	int index = given.index_in_line - 1;
    	
    	// If the token is the first in the line
    	if(index < 0)
    	{
    		// This should be true.
    		assert index == -1;
    		
        	int line_ind = line-1;
    		// Keep going back until the previous line is non-empty
    		// or until I have reached the first line.
    		while(line_ind >= 1)
    		{
        		--line_ind;
        		
        		var line_array = format_tokens.get(line_ind);
        		if(line_array.isEmpty())
        		{
        			continue;
        		}
        		
        		// now the line is not empty
        		// return the last token in the line.
        		return line_array.get(line_array.size()-1);
    		}
    		
    		// now line = 1 but it's still empty
    		// or the token is already the first one.
    		return null;    		
    	}
    	
    	// Otherwise, the prev token is still in the line.
    	return format_tokens.get(line-1).get(index);
    }
    
    /**
     * As a FormatToken contains its complete position information by design,
     * I can get tokens based on a given one.
     * This method gets the token immediately after the given one.
     * 
     * @param given the token given.
     * @return the token immediately after given (the method goes forth to further lines if necessary)
     * or null if there is no token after it.
     */
    public FormatToken getNextFormatToken(FormatToken given)
    {
    	int line = given.line;
    	int index = given.index_in_line + 1;
    	
    	int line_index = line-1;
    	var cur_line_array = format_tokens.get(line_index);
    	
    	// If the token is the last in the line
    	if(index >= cur_line_array.size())
    	{
    		// This should be true.
    		assert index == cur_line_array.size();
    		
    		// Keep going back until the previous line is non-empty
    		// or until I have reached the first line.
    		while(line_index+1 < format_tokens.size())
    		{
        		++line_index;
        		
        		var line_array = format_tokens.get(line_index);
        		if(line_array.isEmpty())
        		{
        			continue;
        		}
        		
        		// now the line is not empty
        		// return the first token in the line.
        		return line_array.get(0);
    		}
    		
    		// now line_index = size-1 but it's still empty
    		return null;    		
    	}
    	
    	// Otherwise, the next token is still in the line.
    	return cur_line_array.get(index);
    }
}
