package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.FormatVerdict;
import edu.guanyfyp.format.summaries.CodeBlockSummary;

/**
 * Test if the verdict is correctly given
 */
public class TestVerdict 
{
	private static final String BAD1_SF_PATH = "demo_data/bad1.java";
	private static SourceFile bad1Sf;
	private static FormatVerdict bad1Verdict;
	
	private static final String GOOD_SF_PATH = "demo_data/good.java";
	private static SourceFile goodSf;
	private static FormatVerdict goodVerdict;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		bad1Sf = TestUtils.createSourceFileNoError(BAD1_SF_PATH);
		bad1Verdict = bad1Sf.analyze();
		
		goodSf = TestUtils.createSourceFileNoError(GOOD_SF_PATH);
		goodVerdict = goodSf.analyze();
	}
	
	@Test
	public void testGoodVerdict()
	{
		assertTrue(goodVerdict.hasGivenVerdict());
		
		assertEquals(0.f, goodVerdict.getIdentifierLengthProblemFrequency());
		assertEquals(0.f, goodVerdict.getIdentifierNamingProblemFrequency());
		assertEquals(0.f, goodVerdict.getSpacingProblemFrequency());
		assertEquals(0.f, goodVerdict.getInconsistentScopeStyleFrequency());
		assertEquals(0.f, goodVerdict.getBadJavaDocFrequency());	
		assertEquals(0.f, goodVerdict.getLineLengthProblemFrequency());
		assertEquals(0.f, goodVerdict.getLineIndentationProblemFrequency());

		assertTrue(goodVerdict.getHasCommentAtAll());
	}
	
	@Test
	public void testBad1Verdict()
	{
		assertTrue(bad1Verdict.hasGivenVerdict());
		
		assertEquals(.3125f, bad1Verdict.getIdentifierLengthProblemFrequency());
		assertEquals(.1875f, bad1Verdict.getIdentifierNamingProblemFrequency());
		assertEquals(.2f, bad1Verdict.getSpacingProblemFrequency());
		assertEquals(1.f, bad1Verdict.getInconsistentScopeStyleFrequency());
		assertEquals(1.f, bad1Verdict.getBadJavaDocFrequency());	
		// These two are not exactly the real numbers, so use delta for floating number equals.
		assertEquals(.041666668f, bad1Verdict.getLineLengthProblemFrequency());
		assertEquals(.16666667f, bad1Verdict.getLineIndentationProblemFrequency());

		assertTrue(bad1Verdict.getHasCommentAtAll());
	}
}
