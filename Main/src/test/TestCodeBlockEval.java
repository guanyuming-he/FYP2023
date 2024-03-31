package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.CodeBlock.NamingStyle;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * Dedicated to testing the evalFormat() method of CodeBlock
 */
public class TestCodeBlockEval 
{
	private static final String DIFFERENT_IDENTIFIERS_SF_PATH = "test_data/different_identifiers.txt";
	private static SourceFile differentIdentifiersSf;
	private static SyntaxStructure differentIdentifiersSs;
	
	private static final String SPACES_AROUND_CODE_SF_PATH = "test_data/spaces_around_code.java";
	private static SourceFile spacesAroundCodeSf;
	private static SyntaxStructure spacesAroundCodeSs;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		differentIdentifiersSf = TestUtils.createSourceFileNoError(DIFFERENT_IDENTIFIERS_SF_PATH);
		differentIdentifiersSs = differentIdentifiersSf.getSyntaxStructure();
		
		spacesAroundCodeSf = TestUtils.createSourceFileNoError(SPACES_AROUND_CODE_SF_PATH);
		spacesAroundCodeSs = spacesAroundCodeSf.getSyntaxStructure();
	}
	
	/**
	 * Test if the evaluation gives correct result on identifier lengths
	 */
	@Test
	public void testEvalIdentifierLength()
	{
		CodeBlock tooLong = (CodeBlock)differentIdentifiersSf.getFormatToken(12, 5);
		CodeBlock tooShort = (CodeBlock)differentIdentifiersSf.getFormatToken(25, 5);
		CodeBlock normal = (CodeBlock)differentIdentifiersSf.getFormatToken(31, 5);
		
		assert (tooLong != null);
		assert (tooShort != null);
		assert (normal != null);
		
		TestUtils.evalPrimitiveOnlyOnce(tooLong, differentIdentifiersSf, differentIdentifiersSs);
		TestUtils.evalPrimitiveOnlyOnce(tooShort, differentIdentifiersSf, differentIdentifiersSs);
		TestUtils.evalPrimitiveOnlyOnce(normal, differentIdentifiersSf, differentIdentifiersSs);
		
		assertTrue(tooLong.isIdentifier() && tooLong.isTooLong() && !tooLong.isTooShort());
		assertTrue(tooShort.isIdentifier() && !tooShort.isTooLong() && tooShort.isTooShort());
		assertTrue(normal.isIdentifier() && !normal.isTooLong() && !normal.isTooShort());
	}

	/**
	 * Test if after evaluation an identifier can have its current naming style
	 * and the naming style that it should have according to its type.
	 */
	@Test
	public void testEvalIdentifierNamingStyle()
	{
		// class, interface, enum, ...
		{
			CodeBlock pascalClass = (CodeBlock)differentIdentifiersSf.getFormatToken(8, 4);
			CodeBlock camelInterface = (CodeBlock)differentIdentifiersSf.getFormatToken(10, 7);
			CodeBlock pascalEnum = (CodeBlock)differentIdentifiersSf.getFormatToken(15, 7);
			
			assert (pascalClass != null);
			assert (camelInterface != null);
			assert (pascalEnum != null);
			
			TestUtils.evalPrimitiveOnlyOnce(pascalClass, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(camelInterface, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(pascalEnum, differentIdentifiersSf, differentIdentifiersSs);
			
			assertEquals(NamingStyle.PASCAL_CASE, pascalClass.getNamingStyle());
			assertEquals(NamingStyle.PASCAL_CASE, pascalClass.getCorrectNamingStyle());
			assertTrue(pascalClass.isNamingCorrect());
			assertEquals(NamingStyle.CAMEL_CASE, camelInterface.getNamingStyle());
			assertEquals(NamingStyle.PASCAL_CASE, camelInterface.getCorrectNamingStyle());
			assertFalse(camelInterface.isNamingCorrect());
			assertEquals(NamingStyle.PASCAL_CASE, pascalEnum.getNamingStyle());
			assertEquals(NamingStyle.PASCAL_CASE, pascalEnum.getCorrectNamingStyle());
			assertTrue(pascalEnum.isNamingCorrect());
		}
		
		// methods
		{
			CodeBlock camelMethod = (CodeBlock)differentIdentifiersSf.getFormatToken(12, 5);
			CodeBlock upperUnderscoreMethod = (CodeBlock)differentIdentifiersSf.getFormatToken(41, 5);
			
			assert (camelMethod != null);
			assert (upperUnderscoreMethod != null);
			
			TestUtils.evalPrimitiveOnlyOnce(camelMethod, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(upperUnderscoreMethod, differentIdentifiersSf, differentIdentifiersSs);
			
			assertEquals(NamingStyle.CAMEL_CASE, camelMethod.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, camelMethod.getCorrectNamingStyle());
			assertTrue(camelMethod.isNamingCorrect());
			assertEquals(NamingStyle.UPPERCASE_UNDERSCORE, upperUnderscoreMethod.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, upperUnderscoreMethod.getCorrectNamingStyle());
			assertFalse(upperUnderscoreMethod.isNamingCorrect());
		}
		
		// variables (fields, local var, parameters)
		{
			// camel
			CodeBlock singleLowercaseField = (CodeBlock)differentIdentifiersSf.getFormatToken(25, 5);
			CodeBlock singleLowercaseLocalVar = (CodeBlock)differentIdentifiersSf.getFormatToken(37, 3);
			CodeBlock camelField = (CodeBlock)differentIdentifiersSf.getFormatToken(31, 5);
			CodeBlock camelPar = (CodeBlock)differentIdentifiersSf.getFormatToken(34, 9);
			
			// pascal
			CodeBlock pascalPar = (CodeBlock)differentIdentifiersSf.getFormatToken(34, 14);
			
			// other
			CodeBlock badlyNamedField1 = (CodeBlock)differentIdentifiersSf.getFormatToken(27, 5);
			CodeBlock badlyNamedField2 = (CodeBlock)differentIdentifiersSf.getFormatToken(28, 5);
			CodeBlock badlyNamedField3 = (CodeBlock)differentIdentifiersSf.getFormatToken(29, 5);
			CodeBlock badlyNamedField4 = (CodeBlock)differentIdentifiersSf.getFormatToken(29, 8);
			
			assert (singleLowercaseField != null);
			assert (singleLowercaseLocalVar != null);
			assert (camelField != null);
			assert (camelPar != null);
			assert (pascalPar != null);
			assert (badlyNamedField1 != null);
			assert (badlyNamedField2 != null);
			assert (badlyNamedField3 != null);
			assert (badlyNamedField4 != null);
			
			TestUtils.evalPrimitiveOnlyOnce(singleLowercaseField, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(singleLowercaseLocalVar, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(camelField, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(camelPar, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(pascalPar, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(badlyNamedField1, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(badlyNamedField2, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(badlyNamedField3, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(badlyNamedField4, differentIdentifiersSf, differentIdentifiersSs);
			
			assertEquals(NamingStyle.CAMEL_CASE, singleLowercaseField.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, singleLowercaseField.getCorrectNamingStyle());
			assertTrue(singleLowercaseField.isNamingCorrect());
			assertEquals(NamingStyle.CAMEL_CASE, singleLowercaseLocalVar.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, singleLowercaseLocalVar.getCorrectNamingStyle());
			assertTrue(singleLowercaseLocalVar.isNamingCorrect());
			assertEquals(NamingStyle.CAMEL_CASE, camelField.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, camelField.getCorrectNamingStyle());
			assertTrue(camelField.isNamingCorrect());
			assertEquals(NamingStyle.CAMEL_CASE, camelPar.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, camelPar.getCorrectNamingStyle());
			assertTrue(camelPar.isNamingCorrect());
			
			assertEquals(NamingStyle.PASCAL_CASE, pascalPar.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, pascalPar.getCorrectNamingStyle());
			assertFalse(pascalPar.isNamingCorrect());
			assertEquals(NamingStyle.OTHER, badlyNamedField1.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, badlyNamedField1.getCorrectNamingStyle());
			assertFalse(badlyNamedField1.isNamingCorrect());
			assertEquals(NamingStyle.OTHER, badlyNamedField2.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, badlyNamedField2.getCorrectNamingStyle());
			assertFalse(badlyNamedField2.isNamingCorrect());
			assertEquals(NamingStyle.OTHER, badlyNamedField3.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, badlyNamedField3.getCorrectNamingStyle());
			assertFalse(badlyNamedField3.isNamingCorrect());
			assertEquals(NamingStyle.UPPERCASE_UNDERSCORE, badlyNamedField4.getNamingStyle());
			assertEquals(NamingStyle.CAMEL_CASE, badlyNamedField4.getCorrectNamingStyle());
			assertFalse(badlyNamedField4.isNamingCorrect());
		}
		
		// Constants
		{
			CodeBlock singleUppercaseConstant = (CodeBlock)differentIdentifiersSf.getFormatToken(21, 9);
			CodeBlock upperUnderConstant = (CodeBlock)differentIdentifiersSf.getFormatToken(22, 9);
			
			assert (singleUppercaseConstant != null);
			assert (upperUnderConstant != null);
			
			TestUtils.evalPrimitiveOnlyOnce(singleUppercaseConstant, differentIdentifiersSf, differentIdentifiersSs);
			TestUtils.evalPrimitiveOnlyOnce(upperUnderConstant, differentIdentifiersSf, differentIdentifiersSs);
			
			assertEquals(NamingStyle.UPPERCASE_UNDERSCORE, singleUppercaseConstant.getNamingStyle());
			assertEquals(NamingStyle.UPPERCASE_UNDERSCORE, singleUppercaseConstant.getCorrectNamingStyle());
			assertTrue(singleUppercaseConstant.isNamingCorrect());
			assertEquals(NamingStyle.UPPERCASE_UNDERSCORE, upperUnderConstant.getNamingStyle());
			assertEquals(NamingStyle.UPPERCASE_UNDERSCORE, upperUnderConstant.getCorrectNamingStyle());
			assertTrue(upperUnderConstant.isNamingCorrect());
		}
	}

	/**
	 * Tests if the spaces around operators can be evaluated properly
	 */
	@Test
	public void testEvalOperatorsSpace()
	{
		// has not spaces around when it should
		var qm1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(13, 10);
		var colon1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(13, 12);
		
		TestUtils.evalPrimitiveOnlyOnce(qm1, spacesAroundCodeSf, spacesAroundCodeSs);
		TestUtils.evalPrimitiveOnlyOnce(colon1, spacesAroundCodeSf, spacesAroundCodeSs);
		
		assertFalse(qm1.hasSpaceAroundWhenItShould);
		assertFalse(colon1.hasSpaceAroundWhenItShould);
		
		// has spaces around when it should
		var equals1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 22);
		TestUtils.evalPrimitiveOnlyOnce(equals1, spacesAroundCodeSf, spacesAroundCodeSs);
		assertTrue(equals1.hasSpaceAroundWhenItShould);
		
		// has spaces around when it should not
		var inc1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(14, 9);
		TestUtils.evalPrimitiveOnlyOnce(inc1, spacesAroundCodeSf, spacesAroundCodeSs);
		assertTrue(inc1.hasSpaceAroundWhenItShouldNot);
	}
	
	/**
	 * Tests if the spaces around punctuation can be evaluated properly
	 */
	@Test
	public void testEvalPunctuationSpace()
	{
		// has not spaces around when it should
		var lBrace1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(2, 5);
		var semi1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 27);
		var rBrace1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 28);
		var semi2 = (CodeBlock)spacesAroundCodeSf.getFormatToken(10, 8);
		
		TestUtils.evalPrimitiveOnlyOnce(lBrace1, spacesAroundCodeSf, spacesAroundCodeSs);
		TestUtils.evalPrimitiveOnlyOnce(semi1, spacesAroundCodeSf, spacesAroundCodeSs);
		TestUtils.evalPrimitiveOnlyOnce(rBrace1, spacesAroundCodeSf, spacesAroundCodeSs);
		TestUtils.evalPrimitiveOnlyOnce(semi2, spacesAroundCodeSf, spacesAroundCodeSs);
		
		assertFalse(lBrace1.hasSpaceAroundWhenItShould);
		assertFalse(semi1.hasSpaceAroundWhenItShould);
		assertFalse(rBrace1.hasSpaceAroundWhenItShould);
		assertFalse(semi2.hasSpaceAroundWhenItShould);
		
		// has spaces around when it should
		var lBrace2 = (CodeBlock)spacesAroundCodeSf.getFormatToken(4, 16);
		TestUtils.evalPrimitiveOnlyOnce(lBrace2, spacesAroundCodeSf, spacesAroundCodeSs);
		assertTrue(lBrace2.hasSpaceAroundWhenItShould);
	}
	
	/**
	 * Tests if the styles of syntax scopes can be evaluated
	 */
	@Test
	public void testEvalScopeStype()
	{
		var lBrace1 = (CodeBlock)spacesAroundCodeSf.getFormatToken(2, 5);
		var lBrace3 = (CodeBlock)spacesAroundCodeSf.getFormatToken(17, 1);
		
		TestUtils.evalPrimitiveOnlyOnce(lBrace1, spacesAroundCodeSf, spacesAroundCodeSs);
		TestUtils.evalPrimitiveOnlyOnce(lBrace3, spacesAroundCodeSf, spacesAroundCodeSs);
		
		assertEquals(CodeBlock.ScopeStyle.LBRACE_STAYS_IN_OLD_LINE, lBrace1.currentScopeStyle);
		assertEquals(CodeBlock.ScopeStyle.LBRACE_STARTS_NEW_LINE, lBrace3.currentScopeStyle);
	}
}
