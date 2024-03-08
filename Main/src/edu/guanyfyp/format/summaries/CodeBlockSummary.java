/**
 * 
 */
package edu.guanyfyp.format.summaries;

import static org.junit.jupiter.api.Assertions.*;

import org.antlr.v4.runtime.CommonToken;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.CodeBlock.NamingStyle;
import edu.guanyfyp.format.primitives.PrimitiveContext;
import edu.guanyfyp.generated.JavaLexer;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * Dedicated to testing the evalFormat() method of Line
 */
public class CodeBlockSummary extends FormatEvalSummary<CodeBlock>
{

	/**
	 * 
	 */
	public CodeBlockSummary() 
	{
		super();
	}

	@Override
	public void include(CodeBlock p) 
	{
		
		super.include(p);
		
		throw new RuntimeException("Unimplemented.");	
	}

	@Override
	public void summarize() 
	{
		throw new RuntimeException("Unimplemented.");
	}
	
//////////////////////// Settings ////////////////////////

}
