/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.Line;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * Dedicated to testing the evalFormat() method of CodeBlock
 */
public class TestLineEval 
{
	private static final String DIFFERENT_LINES_SF_PATH = "test_data/different_lines.txt";
	private static SourceFile differentLinesSf;
	private static SyntaxStructure differentLinesSs;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		differentLinesSf = TestUtils.createSourceFileNoError(DIFFERENT_LINES_SF_PATH);
		differentLinesSs = differentLinesSf.getSyntaxStructure();
	}
	
	/**
	 * Test if lines that are too long are found in the evaluations.
	 */
	@Test
	public void testEvalLineLength()
	{
		// Only line 8 is too long.
		Line line8 = differentLinesSf.getLine(8);
		Line line9 = differentLinesSf.getLine(9);
		Line line15 = differentLinesSf.getLine(15);
		
		assert(line8 != null);
		assert(line9 != null);
		assert(line15 != null);
		
		TestUtils.evalPrimitiveOnlyOnce(line8, differentLinesSf, differentLinesSs);
		TestUtils.evalPrimitiveOnlyOnce(line9, differentLinesSf, differentLinesSs);
		TestUtils.evalPrimitiveOnlyOnce(line15, differentLinesSf, differentLinesSs);
		
		assertTrue(line8.isTooLong());
		assertFalse(line9.isTooLong());
		assertFalse(line15.isTooLong());
	}
}
