/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.syntax.SyntaxScope;
import edu.guanyfyp.syntax.SyntaxScope.Type;
import edu.guanyfyp.syntax.SyntaxStructure;

/**
 * 
 */
public class TestSyntaxScope 
{
	private static final String DIFFERENT_SCOPES_SF_PATH = "test_data/different_scopes.txt";
	private static SourceFile differentScopesSf;
	private static SyntaxStructure differentScopesSs;
	
	private static final String SIMPLE_SCOPES_SF_PATH = "test_data/simple_scopes.java";
	private static SourceFile simpleScopesSf;
	private static SyntaxStructure simpleScopesSs;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		differentScopesSf = TestUtils.createSourceFileNoError(DIFFERENT_SCOPES_SF_PATH);
		differentScopesSs = differentScopesSf.getSyntaxStructure();
		
		simpleScopesSf = TestUtils.createSourceFileNoError(SIMPLE_SCOPES_SF_PATH);
		simpleScopesSs = simpleScopesSf.getSyntaxStructure();
	}
	
	/**
	 * Tests if scopes can be constructed correctly.
	 * 
	 * As it's practically very hard to check against all invalid inputs,
	 * the constructor does not check all, so I do not test construction with invalid inputs here.
	 */
	@Test
	public void testConstruction()
	{
		// construct the leaves
		var leaf1 = new SyntaxScope
		(
			Type.STANDALONE_SCOPE, 
			null, List.of(), 
			(CodeBlock)simpleScopesSf.getFormatToken(10, 1), (CodeBlock)simpleScopesSf.getFormatToken(12, 1),
			2
		);
		var leaf2 = new SyntaxScope
		(
			Type.STANDALONE_SCOPE, 
			null, List.of(), 
			(CodeBlock)simpleScopesSf.getFormatToken(14, 1), (CodeBlock)simpleScopesSf.getFormatToken(16, 1),
			2
		);
		var leaf3 = new SyntaxScope
		(
			Type.GENERAL_METHOD_DEF_SCOPE, 
			null, List.of(), 
			(CodeBlock)simpleScopesSf.getFormatToken(19, 9), (CodeBlock)simpleScopesSf.getFormatToken(19, 14),
			1
		);
		
		// construct the middle node
		var middle = new SyntaxScope
		(
			Type.GENERAL_METHOD_DEF_SCOPE, 
			null, List.of(leaf1, leaf2), 
			(CodeBlock)simpleScopesSf.getFormatToken(9, 9), (CodeBlock)simpleScopesSf.getFormatToken(17, 1),
			1
		);
		
		// construct the root
		var root = new SyntaxScope
		(
			Type.GENERAL_CLASS_DEF_SCOPE, 
			null, List.of(middle, leaf3), 
			(CodeBlock)simpleScopesSf.getFormatToken(8, 6), (CodeBlock)simpleScopesSf.getFormatToken(20, 0),
			0
		);
		
		// set the parent fields
		leaf1.parent = middle;
		leaf2.parent = middle;
		middle.parent = root;
		
		// Tests
		
		// Don't need to test the parents because I set them.
		assertTrue(leaf1.children.isEmpty() && leaf2.children.isEmpty());
		assertEquals(List.of(leaf1, leaf2), middle.children);
		assertEquals(List.of(middle, leaf3), root.children);
		
		assertFalse(leaf1.oneLine);
		assertFalse(leaf2.oneLine);
		assertTrue(leaf3.oneLine);
		assertFalse(middle.oneLine);
		assertFalse(root.oneLine);
		
		assertEquals(0, root.level);
		assertEquals(1, middle.level);
		assertEquals(2, leaf1.level);
		assertEquals(2, leaf2.level);
		assertEquals(1, leaf3.level);
	}

	@Test
	public void testLineInRange()
	{
		// Wait until the structure builder can build all the scopes.
		fail("Not implemented");
	}
	
	@Test
	public void testFormatTokenInRange()
	{
		// Wait until the structure builder can build all the scopes.
		fail("Not implemented");	
	}
	
	@Test
	public void testLineInScope()
	{
		// Wait until the structure builder can build all the scopes.
		fail("Not implemented");
	}
	
	@Test
	public void testFormatTokenInScope()
	{
		// Wait until the structure builder can build all the scopes.
		fail("Not implemented");
	}
}
