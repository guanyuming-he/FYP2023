/**
 * 
 */
package edu.guanyfyp.format.summaries;

import edu.guanyfyp.format.primitives.CodeBlock;

/**
 * 
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

}
