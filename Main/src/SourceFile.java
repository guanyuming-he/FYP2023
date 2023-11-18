/**
 * @author Guanyuming He
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import format.FormatToken;

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
    // All the tokens for format checking.
    // Each element of the outmost array represents a line in the source file.
    // Each element inside a line array is a token.
    private final ArrayList<ArrayList<FormatToken>> format_tokens;
    
    /**
     * Reads the source code from a local file.
     * 
     * @param file_path The path to the file.
     * @param encoding The encoding of the file.
     * @throws IOException on reading error.
     */
    SourceFile(String file_path, Charset encoding) throws IOException
    {
    	// Initialise fields
    	format_tokens = new ArrayList<>();
    	
    	
    }
    
    /**
     * Reads the source code from a String in memory
     */
    SourceFile(String text)
    {
    	// Initialise fields
    	format_tokens = new ArrayList<>();
    	
    }
}
