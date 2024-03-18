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
public class TestSyntaxScope {
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
	public static void initSfs() {
		differentScopesSf = TestUtils.createSourceFileNoError(DIFFERENT_SCOPES_SF_PATH);
		differentScopesSs = differentScopesSf.getSyntaxStructure();

		simpleScopesSf = TestUtils.createSourceFileNoError(SIMPLE_SCOPES_SF_PATH);
		simpleScopesSs = simpleScopesSf.getSyntaxStructure();
	}

	/**
	 * Tests if scopes can be constructed correctly.
	 * 
	 * As it's practically very hard to check against all invalid inputs, the
	 * constructor does not check all, so I do not test construction with invalid
	 * inputs here.
	 */
	@Test
	public void testConstruction() {
		// construct the leaves
		var leaf1 = new SyntaxScope(Type.GENERAL_STATEMENT_SCOPE, null, List.of(),
				(CodeBlock) simpleScopesSf.getFormatToken(10, 1), (CodeBlock) simpleScopesSf.getFormatToken(12, 1), 2);
		var leaf2 = new SyntaxScope(Type.GENERAL_STATEMENT_SCOPE, null, List.of(),
				(CodeBlock) simpleScopesSf.getFormatToken(14, 1), (CodeBlock) simpleScopesSf.getFormatToken(16, 1), 2);
		var leaf3 = new SyntaxScope(Type.GENERAL_METHOD_DEF_SCOPE, null, List.of(),
				(CodeBlock) simpleScopesSf.getFormatToken(19, 9), (CodeBlock) simpleScopesSf.getFormatToken(19, 14), 1);

		// construct the middle node
		var middle = new SyntaxScope(Type.GENERAL_METHOD_DEF_SCOPE, null, List.of(leaf1, leaf2),
				(CodeBlock) simpleScopesSf.getFormatToken(9, 9), (CodeBlock) simpleScopesSf.getFormatToken(17, 1), 1);

		// construct the root
		var root = new SyntaxScope(Type.GENERAL_CLASS_DEF_SCOPE, null, List.of(middle, leaf3),
				(CodeBlock) simpleScopesSf.getFormatToken(8, 6), (CodeBlock) simpleScopesSf.getFormatToken(20, 0), 0);

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
	public void testLineInRange() {
		// use shorter local names
		var src = differentScopesSf;
		var s = differentScopesSs;

		// Test line in range or not for non one-line scopes
		// l1 is the line containing {
		// l3 is the line containing }
		// Expect that only l2_xxx are in the range.
		var scope1 = s.getRootScope(0);
		var l0 = src.getLine(1);
		var l1 = src.getLine(3);
		var l2_1 = src.getLine(4);
		var l2_2 = src.getLine(6);
		var l2_3 = src.getLine(9);
		var l3 = src.getLine(35);
		var l4 = src.getLine(36);
		assertFalse(scope1.isPrimitiveInRange(l0));
		assertFalse(scope1.isPrimitiveInRange(l1));
		assertTrue(scope1.isPrimitiveInRange(l2_1));
		assertTrue(scope1.isPrimitiveInRange(l2_2));
		assertTrue(scope1.isPrimitiveInRange(l2_3));
		assertFalse(scope1.isPrimitiveInRange(l3));
		assertFalse(scope1.isPrimitiveInRange(l4));

		var scope2 = scope1.children.get(0);
		// Note: variable reuse here.
		l0 = src.getLine(4);
		l1 = src.getLine(5);
		l2_1 = src.getLine(6);
		l2_2 = src.getLine(8);
		l3 = src.getLine(9);
		l4 = src.getLine(12);
		assertFalse(scope2.isPrimitiveInRange(l0));
		assertFalse(scope2.isPrimitiveInRange(l1));
		assertTrue(scope2.isPrimitiveInRange(l2_1));
		assertTrue(scope2.isPrimitiveInRange(l2_2));
		assertFalse(scope2.isPrimitiveInRange(l3));
		assertFalse(scope2.isPrimitiveInRange(l4));

		// Test line in range or not for such one-line scopes:
		// Now even l2 should not be in the range.
		// l0
		// ...
		// ... { ... } // l2
		// ...
		// l4
		var scope3 = scope1.children.get(2);
		// Note: variable reuse here.
		l0 = src.getLine(15);
		l2_1 = src.getLine(17);
		l4 = src.getLine(18);
		assertFalse(scope3.isPrimitiveInRange(l0));
		assertFalse(scope3.isPrimitiveInRange(l2_1));
		assertFalse(scope3.isPrimitiveInRange(l4));
	}

	@Test
	public void testFormatTokenInRange() {
		// use shorter local names
		var src = differentScopesSf;
		var s = differentScopesSs;

		// Test primitive in range or not for non one-line scopes
		// p1 is the {
		// p3 is the }
		// Expect that only p1, p2_xxx, p3 are in the range.
		var scope1 = s.getRootScope(0);
		var p0 = src.getFormatToken(1, 0);
		var p0_1 = src.getFormatToken(2, 3);
		var p1 = src.getFormatToken(3, 0);
		var p2 = src.getFormatToken(22, 1);
		var p3 = src.getFormatToken(35, 0);
		var p4 = src.getFormatToken(37, 0);
		assertFalse(scope1.isPrimitiveInRange(p0));
		assertFalse(scope1.isPrimitiveInRange(p0_1));
		assertTrue(scope1.isPrimitiveInRange(p1));
		assertTrue(scope1.isPrimitiveInRange(p2));
		assertTrue(scope1.isPrimitiveInRange(p3));
		assertFalse(scope1.isPrimitiveInRange(p4));

		var scope2 = s.getRootScope(1);
		// Note: variable reuse
		p0 = src.getFormatToken(1, 0);
		p0_1 = src.getFormatToken(39, 5);
		p1 = src.getFormatToken(39, 6);
		p2 = src.getFormatToken(40, 1);
		p3 = src.getFormatToken(44, 0);
		assertFalse(scope2.isPrimitiveInRange(p0));
		assertFalse(scope2.isPrimitiveInRange(p0_1));
		assertTrue(scope2.isPrimitiveInRange(p1));
		assertTrue(scope2.isPrimitiveInRange(p2));
		assertTrue(scope2.isPrimitiveInRange(p3));

		// Test primitives in range or not for one-line scopes
		var scope3 = scope1.children.get(2);
		// Note: variable reuse
		p0 = src.getFormatToken(1, 0);
		p0_1 = src.getFormatToken(39, 5);
		p1 = src.getFormatToken(39, 6);
		p2 = src.getFormatToken(40, 1);
		p3 = src.getFormatToken(44, 0);
		assertFalse(scope2.isPrimitiveInRange(p0));
		assertFalse(scope2.isPrimitiveInRange(p0_1));
		assertTrue(scope2.isPrimitiveInRange(p1));
		assertTrue(scope2.isPrimitiveInRange(p2));
		assertTrue(scope2.isPrimitiveInRange(p3));
	}

	@Test
	public void testLineInScope() {
		// use shorter local names
		var src = differentScopesSf;
		var s = differentScopesSs;

		// Test line in scope or not for non one-line scopes
		// l1 is the line containing {
		// l3 is the line containing }
		// Expect that only l2_xxx that are not in children are in the scope.
		var scope1 = s.getRootScope(0);
		var l0 = src.getLine(1);
		var l1 = src.getLine(3);
		var l2_1 = src.getLine(4);
		var l2_2 = src.getLine(6);
		var l2_3 = src.getLine(28);
		var l2_4 = src.getLine(31);
		var l3 = src.getLine(35);
		var l4 = src.getLine(36);
		assertFalse(scope1.isPrimitiveInScope(l0));
		assertFalse(scope1.isPrimitiveInScope(l1));
		assertTrue(scope1.isPrimitiveInScope(l2_1));
		assertFalse(scope1.isPrimitiveInScope(l2_2));
		assertTrue(scope1.isPrimitiveInScope(l2_3));
		assertFalse(scope1.isPrimitiveInScope(l2_4));
		assertFalse(scope1.isPrimitiveInScope(l3));
		assertFalse(scope1.isPrimitiveInScope(l4));

		var scope2 = scope1.children.get(3);
		// Note: variable reuse here.
		l2_1 = src.getLine(20);
		l2_2 = src.getLine(22);
		l2_3 = src.getLine(23);
		assertTrue(scope2.isPrimitiveInScope(l2_1));
		assertFalse(scope2.isPrimitiveInScope(l2_2));
		assertTrue(scope2.isPrimitiveInScope(l2_3));
	}

	@Test
	public void testFormatTokenInScope() {
		// use shorter local names
		var src = differentScopesSf;
		var s = differentScopesSs;

		// Test primitive in range or not for non one-line scopes
		// p1 is the {
		// p3 is the }
		// Expect that only p1, p2_xxx (that are not in range of children), p3 are in
		// the range.
		var scope1 = s.getRootScope(0);
		var p0 = src.getFormatToken(1, 0);
		var p0_1 = src.getFormatToken(2, 3);
		var p1 = src.getFormatToken(3, 0);
		var p2 = src.getFormatToken(5, 3);
		var p2_1 = src.getFormatToken(22, 1);
		var p2_2 = src.getFormatToken(26, 0);
		var p3 = src.getFormatToken(35, 0);
		var p4 = src.getFormatToken(37, 0);
		assertFalse(scope1.isPrimitiveInScope(p0));
		assertFalse(scope1.isPrimitiveInScope(p0_1));
		assertTrue(scope1.isPrimitiveInScope(p1));
		assertTrue(scope1.isPrimitiveInScope(p2));
		assertFalse(scope1.isPrimitiveInScope(p2_1));
		assertTrue(scope1.isPrimitiveInScope(p2_2));
		assertTrue(scope1.isPrimitiveInScope(p3));
		assertFalse(scope1.isPrimitiveInScope(p4));

		var scope2 = s.getRootScope(1);
		p0 = src.getFormatToken(1, 0);
		p0_1 = src.getFormatToken(39, 5);
		p1 = src.getFormatToken(39, 6);
		p2 = src.getFormatToken(40, 1);
		p2_1 = src.getFormatToken(41, 1);
		p2_2 = src.getFormatToken(43, 1);
		p3 = src.getFormatToken(44, 0);
		assertFalse(scope2.isPrimitiveInScope(p0));
		assertFalse(scope2.isPrimitiveInScope(p0_1));
		assertTrue(scope2.isPrimitiveInScope(p1));
		assertTrue(scope2.isPrimitiveInScope(p2));
		assertFalse(scope2.isPrimitiveInScope(p2_1));
		assertFalse(scope2.isPrimitiveInScope(p2_2));
		assertTrue(scope2.isPrimitiveInScope(p3));
	}
}
