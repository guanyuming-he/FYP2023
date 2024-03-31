/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.format.primitives.JavaDocBlock.Tag;
import edu.guanyfyp.format.primitives.PrimitiveContext;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * Test how the JavaDocBlock class evaluates the format of JavaDocs
 */
public class TestJavaDocBlockEval 
{	

	private static final String DIFFERENT_JAVADOCS_SF_PATH = "test_data/different_java_docs.java";
	private static SourceFile differentJavaDocsSf;
	private static SyntaxStructure differentJavaDocsSs;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{	
		differentJavaDocsSf = TestUtils.createSourceFileNoError(DIFFERENT_JAVADOCS_SF_PATH);
		differentJavaDocsSs = differentJavaDocsSf.getSyntaxStructure();
		
		// evaluate all javadocs
		var javaDocs = differentJavaDocsSf.getJavaDocs();
		for(var j : javaDocs)
		{
			var ctx = new PrimitiveContext(differentJavaDocsSs.getSyntaxContext(j));
			j.evaluateFormat(differentJavaDocsSf, ctx);
		}
	}
	
	/**
	 * Test the eval results when the type of what follows a javadoc
	 * is different from the type suggested by the javadoc's tags
	 */
	@Test
	void testEvalFollowTypeIncorrect()
	{
		// Incorrectness can only happen in these situations:
		// 	1. the tags include @param or @return or @throws but
		// what follows is not METHOD_LIKE
		//	2. followed by OTHER (which includes not being followed)
		
		var javaDocs = differentJavaDocsSf.getJavaDocs();
		
		// 1. followed by a field, but has @param and @return
		{
			JavaDocBlock thisJd = javaDocs.get(8);

			assertTrue(thisJd.isTypeUnMatched());
			
			// the unmatched tags should be recorded
			var expected = List.of(new JavaDocBlock.AttrTag("@param what?"), new JavaDocBlock.Tag("@return why?     "));
			assertEquals
			(
				expected,
				thisJd.getUnmatchedCommentTags()
			);
		}
		
		// 1. followed by nothing, and has @return and @throws
		{
			var thisJd = javaDocs.get(9);
			
			assertTrue(thisJd.isTypeUnMatched());
			
			// the unmatched tags should be recorded
			var expected = List.of(new JavaDocBlock.Tag("@return xxx"), new JavaDocBlock.Tag("@throws yyy     "));
			assertEquals
			(
				expected,
				thisJd.getUnmatchedCommentTags()
			);
		}
		
		// 2. followed by nothing, but does not have unmatched tags
		{
			assertTrue(javaDocs.get(3).isTypeUnMatched());
			assertTrue(javaDocs.get(4).isTypeUnMatched());
			
			assertTrue(javaDocs.get(3).getUnmatchedCommentTags().isEmpty());
			assertTrue(javaDocs.get(4).getUnmatchedCommentTags().isEmpty());
			assertTrue(javaDocs.get(3).getUnmatchedSyntaxObjects().isEmpty());
			assertTrue(javaDocs.get(4).getUnmatchedSyntaxObjects().isEmpty());
		}
	}

	/**
	 * Test the eval results when the type of what follows a javadoc
	 * is the same from the type suggested by the javadoc's tags,
	 * and the type is not METHOD_LIKE
	 */
	@Test
	void testEvalFollowTypeCorrectNoneMethod()
	{
		var javaDocs = differentJavaDocsSf.getJavaDocs();
		
		assertFalse(javaDocs.get(0).isTypeUnMatched());
		assertFalse(javaDocs.get(1).isTypeUnMatched());
		assertFalse(javaDocs.get(6).isTypeUnMatched());
		
		assertTrue(javaDocs.get(0).getUnmatchedCommentTags().isEmpty());
		assertTrue(javaDocs.get(1).getUnmatchedCommentTags().isEmpty());
		assertTrue(javaDocs.get(6).getUnmatchedCommentTags().isEmpty());
		assertTrue(javaDocs.get(0).getUnmatchedSyntaxObjects().isEmpty());
		assertTrue(javaDocs.get(1).getUnmatchedSyntaxObjects().isEmpty());
		assertTrue(javaDocs.get(6).getUnmatchedSyntaxObjects().isEmpty());
	}
	
	/**
	 * Test the eval results when the type of what follows a javadoc
	 * is the same from the type suggested by the javadoc's tags,
	 * and the type is METHOD_LIKE
	 */
	@Test
	void testEvalFollowTypeCorrectMethod()
	{
		var javaDocs = differentJavaDocsSf.getJavaDocs();
		
		assertFalse(javaDocs.get(2).isTypeUnMatched());
		assertFalse(javaDocs.get(5).isTypeUnMatched());
		assertFalse(javaDocs.get(7).isTypeUnMatched());
		
		// even if the type is right,
		// the tags might not agree with the syntax objects in the method
		// that is false for 2 and true for 5 and 7
		assertTrue(javaDocs.get(2).getUnmatchedCommentTags().isEmpty());
		assertTrue(javaDocs.get(2).getUnmatchedSyntaxObjects().isEmpty());
		assertFalse(javaDocs.get(5).getReturnNotProvided());
		
		assertEquals	
		(
			List.of(new JavaDocBlock.AttrTag("@param bc something\r\n     ")), 
			javaDocs.get(5).getUnmatchedCommentTags()
		);
		assertEquals
		(
			List.of("abc"),
			javaDocs.get(5).getUnmatchedSyntaxObjects()
		);
		assertFalse
		(
			javaDocs.get(5).getReturnNotProvided()
		);
		
		assertTrue
		(
			javaDocs.get(7).getUnmatchedCommentTags().isEmpty()
		);
		assertTrue
		(
			javaDocs.get(7).getUnmatchedSyntaxObjects().isEmpty()
		);
		assertTrue
		(
			javaDocs.get(7).getReturnNotProvided()
		);
	}
}
