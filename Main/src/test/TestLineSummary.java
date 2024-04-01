package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.format.primitives.Line;
import edu.guanyfyp.format.summaries.LineSummary;
import edu.guanyfyp.syntax.SyntaxStructure;

public class TestLineSummary 
{
	
	private static final String DIFFERENT_LINES_SF_PATH = "test_data/different_lines.txt";
	private static SourceFile differentLinesSf;
	private static LineSummary differentLinesSum;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		differentLinesSf = TestUtils.createSourceFileNoError(DIFFERENT_LINES_SF_PATH);
		var verdict = differentLinesSf.analyze();
		differentLinesSum = verdict.getLineSummary();
		
		assertTrue(differentLinesSum != null);
	}
	
	/**
	 * Test if the line length summary list is correctly populated
	 */
	@Test
	public void testLineLengthList()
	{
		// only these lines are too long
		Line line8 = differentLinesSf.getLine(8);
		Line line13 = differentLinesSf.getLine(13);
		Line line17 = differentLinesSf.getLine(17);
		
		var expected = List.of
		(
			line8, line13, line17
		);
		assertEquals(expected.size(), differentLinesSum.getTooLongLines().size());
		assertTrue(expected.containsAll(differentLinesSum.getTooLongLines()));
	}
	
	/**
	 * Test if the line indentation summary list is correctly populated
	 */
	@Test
	public void testLineIndentationList()
	{
		// only these lines are badly indented
		Line line9 = differentLinesSf.getLine(9);
		Line line10 = differentLinesSf.getLine(10);
		
		var expected = List.of
		(
			line9, line10
		);
		assertEquals(expected.size(), differentLinesSum.getBadlyIndentedLines().size());
		assertTrue(expected.containsAll(differentLinesSum.getBadlyIndentedLines()));
	}
}
