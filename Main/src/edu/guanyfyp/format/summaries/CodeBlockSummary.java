/**
 * 
 */
package edu.guanyfyp.format.summaries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.CodeBlock.ScopeStyle;

/**
 * Dedicated to testing the evalFormat() method of Line
 */
public class CodeBlockSummary extends FormatEvalSummary<CodeBlock>
{
//////////////////////// Fields ////////////////////////
	// Statistics
	public int numTotal = 0;
	public int numIdentifiers = 0;
	public int numPunctuation = 0;
	public int numOperators = 0;
	public int numKeywords = 0;
	public int numLiterals = 0;
	public int numOthers = 0;
	
	// Length
	public List<CodeBlock> tooLongList = new ArrayList<CodeBlock>();
	public List<CodeBlock> tooShortList = new ArrayList<CodeBlock>();
	
	// Naming style
	public List<CodeBlock> badlyNamedList = new ArrayList<CodeBlock>();
	
	// Spaces and new lines around (before and/or after)
	// 	1. should have such around when it doesn't
	//	2. should not have such around (e.g. ++ --) when it does.
	public List<CodeBlock> spaceProblemsList = new ArrayList<CodeBlock>();
	
	// Inconsistent coding styles
	// when a scope's { stays in the old line, the { is put here.
	public List<CodeBlock> lbraceNoNewLineScopes = new ArrayList<CodeBlock>();
	// when a scope's { starts a new line, the { is put here.
	public List<CodeBlock> lbraceNewLineScopes = new ArrayList<CodeBlock>();
	
//////////////////////// Ctor and methods ////////////////////////
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
		
		// update statistics
		{
			++numTotal;
			switch(p.additionalAttr.getType())
			{
			case KEYWORD_UNCLASSIFIED:
				++numKeywords;
				break;
				
			case STRING_LITERAL:
			case NUMBER_LITERAL:
			case BOOL_LITERAL:
			case NULL_LITERAL:
				++numLiterals;
				break;
				
			case SEMICOLON:
			case COMMA:
			case DOT:
			case L_PARENTHESIS:
			case R_PARENTHESIS:
			case L_SBRACKET:
			case R_SBRACKET:
			case L_CBRACKET:
			case R_CBRACKET:
				++numPunctuation;
				break;
				
			case IDENTIFIER_UNCLASSIFIED:
			case CLASS_NAME:
			case INTERFACE_NAME:
			case ENUM_NAME:
			case CONSTRUCTOR_NAME:
			case METHOD_NAME:
			case FIELD_NAME:
			case FOR_VARIABLE_NAME:
			case VARIABLE_NAME:
			case PARAMETER_NAME:
				++numIdentifiers;
				break;
				
			case OPERATOR_LOW_PRECEDENCE:
			case OTHER_OPERATORS:
				++numOperators;
				break;
				
			case UNKNOWN:
			case OTHERS:
				++numOthers;
				break;
			default:
				// Should never reach here.
				assert(false);
			}
		}
		
		// put the codeblock in some lists according to the evaluation result.
		{
			if(p.isTooLong())
			{
				tooLongList.add(p);
			}
			else if(p.isTooShort())
			{
				tooShortList.add(p);
			}
			
			if(!p.isNamingCorrect())
			{
				badlyNamedList.add(p);
			}
			
			if(!p.hasSpaceAroundWhenItShould)
			{
				spaceProblemsList.add(p);
			}
			if(p.hasSpaceAroundWhenItShouldNot)
			{
				spaceProblemsList.add(p);
			}
			
			if(p.characters().equals("{"))
			{
				assert(p.currentScopeStyle != null);
				
				if(p.currentScopeStyle == ScopeStyle.LBRACE_STARTS_NEW_LINE)
				{
					lbraceNewLineScopes.add(p);
				}
				else if(p.currentScopeStyle == ScopeStyle.LBRACE_STAYS_IN_OLD_LINE)
				{
					lbraceNoNewLineScopes.add(p);
				}
			}
		}
	}

	@Override
	public void summarize() 
	{
		super.summarize();
		
		// turn the lists immutable
		tooLongList = Collections.unmodifiableList(tooLongList);
		tooShortList = Collections.unmodifiableList(tooShortList);
		badlyNamedList = Collections.unmodifiableList(badlyNamedList);
		spaceProblemsList = Collections.unmodifiableList(spaceProblemsList);
		lbraceNewLineScopes = Collections.unmodifiableList(lbraceNewLineScopes);
		lbraceNoNewLineScopes = Collections.unmodifiableList(lbraceNoNewLineScopes);
	}
	
//////////////////////// Settings ////////////////////////
	public static final class Settings
	{
		// No settings for now
	}
	
	public static final Settings settings = new Settings();

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("Identifier length problems:\n");
		for(var c : tooLongList)
		{
			builder.append('\t');
			builder.append(c.toString());
			builder.append('\n');
		}
		for(var c : tooShortList)
		{
			builder.append('\t');
			builder.append(c.toString());
			builder.append('\n');
		}
		
		builder.append("Badly named identifiers:\n");
		for(var c : badlyNamedList)
		{
			builder.append('\t');
			builder.append(c.toString());
			builder.append('\n');
		}
		
		builder.append("Space and newlines around problems:\n");
		for(var c : spaceProblemsList)
		{
			builder.append('\t');
			builder.append(c.toString());
			builder.append('\n');
		}
		
		if(!lbraceNewLineScopes.isEmpty() && !lbraceNoNewLineScopes.isEmpty())
		{
			builder.append("Inconsistent scope styles found.\n");
			builder.append("Scopes in new line style:\n");
			for(var c : lbraceNewLineScopes)
			{
				builder.append('\t');
				builder.append(c.toString());
				builder.append('\n');
			}
			builder.append("Scopes in old line style:\n");
			for(var c : lbraceNoNewLineScopes)
			{
				builder.append('\t');
				builder.append(c.toString());
				builder.append('\n');
			}
		}
		
		return builder.toString();
	}
}
