package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.summaries.CodeBlockSummary;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * Test if CodeBlocks are correctly summarised.
 */
public class TestCodeBlockSummary 
{
	private static final String DIFFERENT_IDENTIFIERS_SF_PATH = "test_data/different_identifiers.txt";
	private static SourceFile differentIdentifiersSf;
	private static CodeBlockSummary differentIdentifiersSum;
	
	private static final String SPACES_AROUND_CODE_SF_PATH = "test_data/spaces_around_code.java";
	private static SourceFile spacesAroundCodeSf;
	private static CodeBlockSummary spacesAroundCodeSum;
	
	private static final String BAD1_SF_PATH = "demo_data/bad1.java";
	private static SourceFile bad1Sf;
	private static CodeBlockSummary bad1Sum;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		differentIdentifiersSf = TestUtils.createSourceFileNoError(DIFFERENT_IDENTIFIERS_SF_PATH);
		// This will complete the summaries
		var verdict1 = differentIdentifiersSf.analyze();
		differentIdentifiersSum = verdict1.getCodeBlockSummary();
		
		spacesAroundCodeSf = TestUtils.createSourceFileNoError(SPACES_AROUND_CODE_SF_PATH);
		// This will complete the summaries
		var verdict2 = spacesAroundCodeSf.analyze();
		spacesAroundCodeSum = verdict2.getCodeBlockSummary(); 
		
		bad1Sf = TestUtils.createSourceFileNoError(BAD1_SF_PATH);
		// This will complete the summaries
		var verdict3 = bad1Sf.analyze();
		bad1Sum = verdict3.getCodeBlockSummary(); 
	}
	
	/**
	 * Test if the identifier summary lists are correctly populated
	 */
	@Test
	public void testIdentifierLists()
	{
		// Length
		assertEquals(7, differentIdentifiersSum.tooLongList.size());
		assertEquals(5, differentIdentifiersSum.tooShortList.size());
		
		// Naming 
		CodeBlock pascalClass = (CodeBlock)differentIdentifiersSf.getFormatToken(8, 4);
		CodeBlock camelInterface = (CodeBlock)differentIdentifiersSf.getFormatToken(10, 7);
		CodeBlock pascalEnum = (CodeBlock)differentIdentifiersSf.getFormatToken(15, 7);
		CodeBlock camelMethod = (CodeBlock)differentIdentifiersSf.getFormatToken(12, 5);
		CodeBlock upperUnderscoreMethod = (CodeBlock)differentIdentifiersSf.getFormatToken(41, 5);
		CodeBlock singleLowercaseField = (CodeBlock)differentIdentifiersSf.getFormatToken(25, 5);
		CodeBlock singleLowercaseLocalVar = (CodeBlock)differentIdentifiersSf.getFormatToken(37, 3);
		CodeBlock camelField = (CodeBlock)differentIdentifiersSf.getFormatToken(31, 5);
		CodeBlock camelPar = (CodeBlock)differentIdentifiersSf.getFormatToken(34, 9);
		CodeBlock pascalPar = (CodeBlock)differentIdentifiersSf.getFormatToken(34, 14);
		CodeBlock badlyNamedField1 = (CodeBlock)differentIdentifiersSf.getFormatToken(27, 5);
		CodeBlock badlyNamedField2 = (CodeBlock)differentIdentifiersSf.getFormatToken(28, 5);
		CodeBlock badlyNamedField3 = (CodeBlock)differentIdentifiersSf.getFormatToken(29, 5);
		CodeBlock badlyNamedField4 = (CodeBlock)differentIdentifiersSf.getFormatToken(29, 8);
		CodeBlock singleUppercaseConstant = (CodeBlock)differentIdentifiersSf.getFormatToken(21, 9);
		CodeBlock upperUnderConstant = (CodeBlock)differentIdentifiersSf.getFormatToken(22, 9);
		
		var expectedBadlyNamedList = List.of
		(
			camelInterface,
			upperUnderscoreMethod,
			pascalPar,
			badlyNamedField1,
			badlyNamedField2,
			badlyNamedField3,
			badlyNamedField4
		);
		// may be of different orders,
		// so I don't simply assert the two lists are equal
		assertEquals(expectedBadlyNamedList.size(), differentIdentifiersSum.badlyNamedList.size());
		assertTrue(expectedBadlyNamedList.containsAll(differentIdentifiersSum.badlyNamedList));
	}
	
	/**
	 * Test if the spacing problem list is correctly populated
	 */
	@Test 
	public void testSpacingProblemList()
	{
		var lBrace1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(2, 5);
		var comma1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 10);
		var semi1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 27);
		var rBrace1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 28);
		var semi2 = (CodeBlock)spacesAroundCodeSf.getFormatToken(7, 4);

		var equals1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(10, 8);
		var qm1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(13, 10);
		var colon1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(13, 12);
		var inc1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(14, 9);
		
		var expectedSpacingProblemList = List.of
		(
			lBrace1, comma1, semi1, rBrace1, semi2,
			equals1, qm1, colon1, inc1
		);
		// may be of different orders,
		// so I don't simply assert the two lists are equal
		assertEquals(expectedSpacingProblemList.size(), spacesAroundCodeSum.spaceProblemsList.size());
		assertTrue(expectedSpacingProblemList.containsAll(spacesAroundCodeSum.spaceProblemsList));
	}

	/**
	 * See if the { of each scope is put in the correct list.
	 */
	@Test
	public void testScopeLists()
	{
		assertEquals(List.of(bad1Sf.getFormatToken(7, 6)), bad1Sum.lbraceNoNewLineScopes);
		assertEquals(List.of(bad1Sf.getFormatToken(19, 1)), bad1Sum.lbraceNewLineScopes);
	}
	
}
