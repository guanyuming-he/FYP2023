/**
 * 
 */
package edu.guanyfyp.format;

import edu.guanyfyp.SourceFile;

/**
 * Represents a collection of all the FormatTokens in a line
 * and how the line looks.
 * 
 * The essential visual properties of a line are
 * 	1. Its identation level (i.e. how much space is before the first visible character)
 * 	2. Its length (i.e. the visual length between its first visible character and its last)
 * 
 * Because the tokens in a line are continuous, I don't need a list to store them.
 * Instead, I merely store the first and last tokens.
 * 
 * After creation, a Line and all its fields are immutable. Hence they are all public.
 */
public final class Line 
{
///////////////////////////// Constructors /////////////////////////////
	
	/**
	 * Constructs a line from its first and last token.
	 * 
	 * @param first the first token. can be null if the line has no token.
	 * @param last the last token. can be null if the line has no token.
	 * @param sf the source file in which the tokens are in. Used to find all the tokens 
	 * in the line.
	 * 
	 * @throws IllegalArgumentException if only one of first and last is null.
	 * @throws IllegalArgumentException if either first or last does not come from sf.
	 * @throws IllegalArgumentException if first and last are not in the same line.
	 * @throws IllegalArgumentException if first's index in the line is not 0.
	 * @throws IllegalArgumentException if last's index is not the last in the line.
	 */
	public Line(FormatToken first, FormatToken last, final SourceFile sf)
	{
		if(	(first == null && last != null) || 
			(first != null && last == null) )
		{
			throw new IllegalArgumentException("If one argument is null, then the other must also be.");
		}
		
		if(first == null && last == null)
		{
			// The line has no token.
			firstToken = null;
			lastToken = null;
			firstVisibleToken = null;
			lastVisibleToken = null;
			// If the line has no visible token, then they are 0.
			indentationLevel = 0;
			visualLength = 0;
			
			return;
		}
		
		// first != null && last != null.
		
		if(!sf.includes(first) || !sf.includes(last))
		{
			throw new IllegalArgumentException("first and last must come from the given source file.");
		}
		
		// They are from the same sf.
		// Now the line has some tokens.
		
		if(last.line() != first.line())
		{
			throw new IllegalArgumentException("First and last must be in the same line.");
		}
		
		// Now last.line = first.line.
		
		if(first.indexInLine != 0)
		{
			throw new IllegalArgumentException("First must be the first token in the line.");
		}
		if(sf.hasFormatToken(last.line(), last.indexInLine+1))
		// If there is some token after last in the line
		{
			throw new IllegalArgumentException("Last must be the last token in the line.");
		}
		
		// Now all are correct.
		
		firstToken = first;
		lastToken = last;
		
		throw new RuntimeException("The implementation is unfinished.");
	}

///////////////////////////// Fields /////////////////////////////
	// The first token in the line.
	// Is null if the line has no token at all.
	public final FormatToken firstToken;
	// The last token in the line.
	// Is null if the line has no token at all.
	public final FormatToken lastToken;
	
	// The first visible token in the line. 
	// Is null if the line has no such tokens (e.g. only whitespace or no token at all).
	// Will be found in any constructor.
	public final FormatToken firstVisibleToken;
	// The last visible token in the line. 
	// Is null if the line has no such tokens (e.g. only whitespace or no token at all).
	// Will be found in any constructor.
	public final FormatToken lastVisibleToken;
	
	// How long the first visible token is separated from the start of the line.
	// If the indentation is correct, then this should be a multiple of 4.
	// Will be calculated in any constructor.
	// If the line has no visible token, then it is 0.
	public final int indentationLevel;
	
	// How long the line looks like from the first visibleToken to the last.
	// Will be calculated in any constructor.
	// If the line has no visible token, then it is 0.
	public final int visualLength;
	
///////////////////////////// Observers /////////////////////////////
	/**
	 * @return true iff the line has any FormatToken at all.
	 */
	public boolean hasToken() { return null != firstToken; }
	
	/**
	 * @return true iff the line has any visible FormatToken at all.
	 */
	public boolean hasVisibleToken() { return null != firstVisibleToken; }
	
}
