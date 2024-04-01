package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.format.summaries.JavaDocSummary;

public class TestJavaDocSummary 
{
	private static final String DIFFERENT_JAVADOCS_SF_PATH = "test_data/different_java_docs.java";
	private static SourceFile differentJavaDocsSf;
	private static JavaDocSummary differentJavaDocsSum;
	private static List<JavaDocBlock> differentJavaDocs;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{	
		differentJavaDocsSf = TestUtils.createSourceFileNoError(DIFFERENT_JAVADOCS_SF_PATH);
		differentJavaDocs = differentJavaDocsSf.getJavaDocs();
		var verdict = differentJavaDocsSf.analyze();
		differentJavaDocsSum = verdict.getJavaDocSummary();
	}
	
	@Test
	public void testBadJavaDocList()
	{
		var expected = List.of
		(
			differentJavaDocs.get(3),
			differentJavaDocs.get(4),
			differentJavaDocs.get(5),
			differentJavaDocs.get(7),
			differentJavaDocs.get(8),
			differentJavaDocs.get(9)
		);
		
		assertEquals(expected.size(), differentJavaDocsSum.getBadJavaDocsList().size());
		assertTrue(expected.containsAll(differentJavaDocsSum.getBadJavaDocsList()));
	}
}
