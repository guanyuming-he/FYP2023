/**
 * 
 */
package edu.guanyfyp.format.summaries;

import java.util.List;

import edu.guanyfyp.format.primitives.CodeBlock;

/**
 * Summary for code blocks that are identifiers 
 * (i.e. names)
 */
public class IdentifierSummary extends CodeBlockSummary 
{
//////////////////////// Fields ////////////////////////
	// Classes, interfaces, and generics.
	// All that are named like a class.
	private List<CodeBlock> badlyNamedClasses;
	private List<CodeBlock> badlyNamedMethods;
	// All variables, except constants
	private List<CodeBlock> badlyNamedVariables;
	// Variables that come with static and final,
	// and whose type are built-in.
	// Also may be enumeration items.
	private List<CodeBlock> badlyNamedConstants;
	
	/**
	 * 
	 */
	public IdentifierSummary() 
	{
		super();
	}

}
