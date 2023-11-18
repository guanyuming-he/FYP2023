/**
 * @author Guanyuming He
 */
package edu.guanyfyp;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import edu.guanyfyp.format.CodeBlock;
import edu.guanyfyp.format.CommentBlock;
import edu.guanyfyp.format.FormatToken;
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
    private final ArrayList<ArrayList<FormatToken>> format_tokens;
    
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
    SourceFile(String file_path) throws IOException, UnsupportedOperationException
    {
    	// Initialise fields
    	format_tokens = new ArrayList<>();
    	
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
				// Check if it's getting into the next line.
				if(t.getLine() != cur_line)
				{
					// Push the tokens in the current line.
					// And creates a new container for tokens in the next line.
					format_tokens.add(cur_line_tokens);
					cur_line_tokens = new ArrayList<FormatToken>();
					
					// Refresh variables
					cur_line = t.getLine();
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
						visual_pos, t.getStartIndex(), 
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
						visual_pos, t.getStartIndex(), 
						cur_line, 
						cur_line_token_number // index of the token in the line
					);
					break;	
					
				case COMMENTS_CHANNEL:
					ft =
					new CommentBlock
					(
						t.getText(), // characters
						visual_pos, t.getStartIndex(), 
						cur_line, 
						cur_line_token_number, // index of the token in the line
						false // not JavaDoc
					);
					break;	
					
				case JAVADOC_CHANNEL:
					ft =
					new CommentBlock
					(
						t.getText(), // characters
						visual_pos, t.getStartIndex(), 
						cur_line, 
						cur_line_token_number, // index of the token in the line
						true // JavaDoc
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
}
