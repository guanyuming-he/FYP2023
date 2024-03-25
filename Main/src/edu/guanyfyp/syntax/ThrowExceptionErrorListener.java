/**
 * 
 */
package edu.guanyfyp.syntax;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * By default, Antlr tries to recover from some syntax errors
 * and throws an exception for the errors that it cannot recover from.
 * 
 * However, for this project, I assume that the input is correct.
 * Therefore, I want it to throw an exception for EVERY syntax error.
 * This class will throw a RuntimeException with a message about the syntax error
 * whenever it encounters an error.
 */
public final class ThrowExceptionErrorListener extends BaseErrorListener 
{
	/**
	 * Will throw a RuntimeException with a message about the syntax error
	 */
	@Override
	public void syntaxError
	(
		Recognizer<?, ?> recognizer,
		Object offendingSymbol,
		int line, int charPositionInLine,
		String msg,
		RecognitionException e
	)
	{
		throw new RuntimeException
		(
			"At line " + line + ":" + charPositionInLine + ": " + msg
		);
	}
}
