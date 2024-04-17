/**
 * 
 */
package edu.guanyfyp.format.primitives;

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
public final class Line extends FormatPrimitive
{
///////////////////////////// Constructors /////////////////////////////
	
	/**
	 * Constructs a line from its first and last token.
	 * 
	 * @param first the first token. can be null if the line has no token.
	 * @param last the last token. can be null if the line has no token.
	 * @param sf the source file in which the tokens are in. Used to find all the tokens 
	 * in the line. Not used if first = last = null.
	 * 
	 * @throws IllegalArgumentException if lineNumber <= 0
	 * @throws IllegalArgumentException if only one of first and last is null.
	 * @throws IllegalArgumentException if either first or last does not come from sf.
	 * @throws IllegalArgumentException if first and last are not in the same line.
	 * @throws IllegalArgumentException if lineNumber does not agree with the tokens.
	 * @throws IllegalArgumentException if first's index in the line is not 0.
	 * @throws IllegalArgumentException if last's index is not the last in the line.
	 */
	public Line(int lineNumber, FormatToken first, FormatToken last, final SourceFile sf)
	{
		if(lineNumber <= 0)
		{
			throw new IllegalArgumentException("lineNumber can only be positive.");
		}
		
		this.lineNumber = lineNumber;
		
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
		
		if(lineNumber != first.line())
		{
			throw new IllegalArgumentException("The lineNumber does not agree with the tokens.");
		}
		
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
		
		// Find the first & last visible tokens
		// Those fields are final, so they can only be assigned once.
		// Hence these temp ones.
		FormatToken tempFV = null, tempLV = null; 
		for(int i = firstToken.index(); i <= lastToken.index(); ++i)
		{
			FormatToken t = sf.getFormatToken(i);
			if(t.isVisible())
			{
				// Only assign tempFV once.
				if(tempFV == null)
				{
					tempFV = t;
				}
				
				// But always update tempLV to the latest visible token.
				tempLV = t;
			}
		}
		firstVisibleToken = tempFV;
		lastVisibleToken = tempLV;
		
		// Now calculate the visualLength and indentationLevel.
		if(firstVisibleToken != null)
		{
			// Should be in the same line.
			// Otherwise something's terribly wrong.
			assert(firstVisibleToken.line() == lastVisibleToken.line() && lastVisibleToken.line() == firstToken.line());
			
			// Has at least one visible token
			visualLength = lastVisibleToken.visualLength + 
					lastVisibleToken.visualPos - firstVisibleToken.visualPos;
			indentationLevel = firstVisibleToken.visualPos;
			
			// Should have this positive.
			assert(visualLength > 0);
		}
		else
		{
			// Doesn't have any visible token
			visualLength = 0;
			indentationLevel = 0;
		}
	}

///////////////////////////// Fields /////////////////////////////
	// The number of the line in the source file, 1..n.
	// Especially important if the line does not have any token.
	public final int lineNumber;
	
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
	// If the indentation of the source code in this line is correct, then this should be a multiple of 4.
	// Will be calculated in any constructor.
	// If the line has no visible token, then it is 0.
	public final int indentationLevel;
	
	// How long the line looks like from the start of the first visibleToken to the end of the last.
	// Will be calculated in any constructor.
	// If the line has no visible token, then it is 0.
	public final int visualLength;
	
///////////////////////////// Observers /////////////////////////////	
	/**
	 * @return true iff the line has any FormatToken at all.
	 * This line is empty <-> !hasToken().
	 */
	public boolean hasToken() 
	{ 
		return null != firstToken; 
	}
	
	/**
	 * @return true iff the line has any visible FormatToken at all.
	 */
	public boolean hasVisibleToken() 
	{ 
		return null != firstVisibleToken; 
	}
	
	/**
	 * @return How long the line ends visually from the start of the line.
	 * That is, indentationLevel + visualLength.
	 */
	public int visualOffset()
	{
		return indentationLevel + visualLength;
	}
	
///////////////////////////// From Object /////////////////////////////
	/**
	 * @return true iff the two lines are created from the same start/end of line tokens.
	 * So, they are equal also if they are both empty.
	 */
	@Override
	public boolean equals(Object other)
	{
		if(other == null)
		{
			return super.equals(other);
		}
		
		if(!(other instanceof Line))
		{
			return false;
		}
		
		Line o = (Line)other;
		
		if(!hasToken())
		{
			// If this is empty, then return true if o is empty.
			return !o.hasToken();
		}
		
		// Both are not empty.
		return firstToken.equals(o.firstToken) && lastToken.equals(o.lastToken);
	}

///////////////////////////// From FormatPrimitive /////////////////////////////
	/**
	 * 1. Evaluates if the line is too long
	 * 2. Evaluates if the line is well indented
	 * 3. May be more
	 */
	@Override
	public void evaluateFormat(SourceFile sf, PrimitiveContext context) 
	{		
		// 1
		if(visualOffset() > settings.maximumGoodLineVOffset)
		{
			tooLong = true;
		}
		
		// 2.
		{
			// get the scope that the line is in.
			var s = context.syntaxContext.scope;
			if(s == null)
			{
				// The line is outside of any scope.
				// e.g. part of the definition of a root class.
				correctIndentation = 0;
			}
			else
			{
				// the correct indentation should be 4 * (s.level+1)
				correctIndentation = 4 * (s.level+1);	
			}
			
			// only if the line is visible is the indentation meaningful
			if(hasVisibleToken())
			{
				indentationCorrect = correctIndentation == indentationLevel;
			}
		}
		
		// handles the state
		super.evaluateFormat(sf, context);
	}
	
//////////////////////// Format evaluation results ////////////////////////
	// If the line looks too long
	private boolean tooLong = false;
	public boolean isTooLong() { return tooLong; }
	// How far the line should be indented.
	private int correctIndentation = 0;
	private boolean indentationCorrect = true;
	/**
	 * @return if the current indentation is correct. i.e. if current == correct.
	 */
	public boolean isIndentationCorrect() { return indentationCorrect; }
	
//////////////////////// Format evaluation Settings ////////////////////////
	
	public static final class Settings
	{
		//////////////////////// maximum good line length ////////////////////////
		
		// Maximum visual offset a good line can have.
		// Default value is obtained from Oracle's Java coding conventions
		// https://www.oracle.com/java/technologies/javase/codeconventions-indentation.html
		// Note: At that time it was concerned because of terminal limits, so it was meant to be num of chars
		//	However, currently most use graphical IDEs, so what concerns most is the visual appearance 
		// (should not stick out of screen).
		private int maximumGoodLineVOffset = 80;

		public int getMaximumGoodLineVOffset() 
		{
			return maximumGoodLineVOffset;
		}
		/**
		 * Sets maximumGoodLineVOffset.
		 * @param maximumGoodLineVOffset
		 * @throws IllegalArgumentException if maximumGoodLineVOffset <= 0
		 */
		public void setMaximumGoodLineVOffset(int maximumGoodLineVOffset) 
		{
			if(maximumGoodLineVOffset <= 0)
			{
				throw new IllegalArgumentException("a visual offset must be positive.");
			}
			
			this.maximumGoodLineVOffset = maximumGoodLineVOffset;
		}
		
		//////////////////////// another entry ////////////////////////
	}
	
	public static final Settings settings = new Settings();
	
	@Override
	public String toString()
	{
		return "Line " + lineNumber;
	}
}
