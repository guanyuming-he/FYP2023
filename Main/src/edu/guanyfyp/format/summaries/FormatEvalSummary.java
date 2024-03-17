/**
 * 
 */
package edu.guanyfyp.format.summaries;

import java.util.ArrayList;
import java.util.List;

import edu.guanyfyp.format.primitives.FormatPrimitive;

/**
	A **generic abstract base** (cannot be an interface) of type `T extends FormatPrimitive`, `FormatEvalSummary`, of all evaluation summaries for a specific kind of primitives is defined, which
	    - a. has a virtual method `include()` which will include an evaluated primitive of type `T` into the account of the summary that is to be made.
	        - `include()` is not allowed to be called after a `summarize()` call.
	        - `include()` can only take evaluated primitives.
	    - b. has a virtual method `summarize()` that all the evaluated primitives included. The results of the method are stored in fields of the class and are accessed through its observers.
	    - c. has a field `summaryDone` that tells if `summarize()` has been called on it.
	    - d. perhaps, store all `include()`d primitives into a `List` field.
 */
public abstract class FormatEvalSummary<T extends FormatPrimitive>
{
//////////////////////// Fields ////////////////////////
	private boolean summaryDone;
	
//////////////////////// Constructors ////////////////////////
	/**
	 * Default ctor.
	 * 
	 * isSummaryDone() will be false.
	 */
	FormatEvalSummary()
	{
		summaryDone = false;
	}
	
//////////////////////// Methods ////////////////////////
	public boolean isSummaryDone() { return summaryDone; }
	
	/**
	 * Include an evaluated format primitive into the account of the summary that is to be made.
	 * The default implementation checks the states only
	 * 
	 * @param p an evaluated primitive
	 * @throws IllegalStateException if it already has a summary.
	 * @throws IllegalArgumentException if p is not evaluated
	 */
	public void include(T p)
	{
		if(isSummaryDone())
		{
			throw new IllegalStateException("Already summarised.");
		}
		
		if(!p.isEvaluated())
		{
			throw new IllegalArgumentException("p is not evaluated.");
		}
	}
	
	/**
	 * Summarises all the evaluated primitives included.
	 * The results of the method are stored in fields of the class and are accessed through its observers.
	 * After it, isSummaryDone() = true.
	 * 
	 * The default implementation only sets summaryDone = true and does nothing else.
	 * 
	 * @throws IllegalStateException if it already has a summary.
	 */
	public void summarize()
	{
		if(isSummaryDone())
		{
			throw new IllegalStateException("Already summarised.");
		}
		
		summaryDone = true;
	}
}
