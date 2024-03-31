/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;
import edu.guanyfyp.format.primitives.CodeBlock;
import edu.guanyfyp.format.primitives.JavaDocBlock;
import edu.guanyfyp.syntax.SyntaxStructure;
import edu.guanyfyp.syntax.SyntaxStructureBuilder;

/**
 * 
 */
class TestSyntaxStructureBuilder 
{

	private static final String DIFFERENT_SCOPES_SF_PATH = "test_data/different_scopes.txt";
	private static SourceFile differentScopesSf;
	private static SyntaxStructure differentScopesSs;
	
	private static final String MANY_DECLS_SF_PATH = "test_data/many_declarations.txt";
	private static SourceFile manyDeclsSf;
	private static SyntaxStructureBuilder manyDeclsSynBuilder;
	private static SyntaxStructure manyDeclsSs;
	
	private static final String MIXTURE2_SF_PATH = "test_data/mixture2.txt";
	private static SourceFile mixture2Sf;
	
	private static final String DIFFERENT_JAVADOCS_SF_PATH = "test_data/different_java_docs.java";
	private static SourceFile differentJavaDocsSf;
	
	/**
	 * Initialises the source files used in the tests.
	 */
	@BeforeAll
	public static void initSfs()
	{
		differentScopesSf = TestUtils.createSourceFileNoError(DIFFERENT_SCOPES_SF_PATH);
		differentScopesSs = differentScopesSf.getSyntaxStructure();
		
		manyDeclsSf = TestUtils.createSourceFileNoError(MANY_DECLS_SF_PATH);
		manyDeclsSynBuilder = manyDeclsSf.getSyntaxStructureBuilder();
		manyDeclsSs = manyDeclsSf.getSyntaxStructure();
		
		mixture2Sf = TestUtils.createSourceFileNoError(MIXTURE2_SF_PATH);
		
		differentJavaDocsSf = TestUtils.createSourceFileNoError(DIFFERENT_JAVADOCS_SF_PATH);
	}
	
	/**
	 * I assume that the parser shares the same token stream with the lexer,
	 * and therefore the tokens there should have the same indices as the lexer
	 * even if the parser ignores the comments and white spaces.
	 */
	@Test
	void testParserTokenIndex() 
	{
		// See if the indices of the tokens in the parse tree are what I expected them to be.
		
		var additional_tokens_attributes = manyDeclsSynBuilder.getAdditionalTokenAttributes();
		
		// class ABC
		assertTrue(additional_tokens_attributes.containsKey(5));
		assertEquals(CodeBlock.Type.CLASS_NAME, additional_tokens_attributes.get(5).getType());
		
		// int a
		assertTrue(additional_tokens_attributes.containsKey(12));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(12).getType());
		// int b
		assertTrue(additional_tokens_attributes.containsKey(15));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(15).getType());
		// int c
		assertTrue(additional_tokens_attributes.containsKey(18));
		assertEquals(CodeBlock.Type.FIELD_NAME, additional_tokens_attributes.get(18).getType());
		
		// Constructor ABC
		assertTrue(additional_tokens_attributes.containsKey(27));
		assertEquals(CodeBlock.Type.CONSTRUCTOR_NAME, additional_tokens_attributes.get(27).getType());
		
		// method abc
		assertTrue(additional_tokens_attributes.containsKey(39));
		assertEquals(CodeBlock.Type.METHOD_NAME, additional_tokens_attributes.get(39).getType());
		
		// enum EABC
		assertTrue(additional_tokens_attributes.containsKey(54));
		assertEquals(CodeBlock.Type.ENUM_NAME, additional_tokens_attributes.get(54).getType());
	}

	/**
	 * Tests if after the syntax and partial semantical analysis
	 * the code blocks in a source file gets more accurate types
	 */
	@Test
	void testAdditionalAttributesType()
	{
		// use a shorter local name as it will be used many times.
		var src = mixture2Sf;
		
		// a global class
		var a_class = (CodeBlock)src.getFormatToken(12, 6);
		assertEquals(CodeBlock.Type.CLASS_NAME, a_class.additionalAttr.getType());
		
		// defined inside the first class
		var another_class = (CodeBlock)src.getFormatToken(14, 9);
		assertEquals(CodeBlock.Type.CLASS_NAME, another_class.additionalAttr.getType());
		
		// A field in the inner class
		var a_field = (CodeBlock)src.getFormatToken(16, 5);
		assertEquals(CodeBlock.Type.FIELD_NAME, a_field.additionalAttr.getType());
		
		// an enumeration
		var an_enum = (CodeBlock)src.getFormatToken(19, 5);
		assertEquals(CodeBlock.Type.ENUM_NAME, an_enum.additionalAttr.getType());
		
		// a method
		var a_method = (CodeBlock)src.getFormatToken(25, 7);
		assertEquals(CodeBlock.Type.METHOD_NAME, a_method.additionalAttr.getType());
		
		// another field, but in the global class
		var another_field = (CodeBlock)src.getFormatToken(28, 7);
		assertEquals(CodeBlock.Type.FIELD_NAME, another_field.additionalAttr.getType());
		
		// another method, more complex
		var another_method = (CodeBlock)src.getFormatToken(36, 5);
		assertEquals(CodeBlock.Type.METHOD_NAME, another_method.additionalAttr.getType());
		
		// some parameters
		var par1 = (CodeBlock)src.getFormatToken(36, 12);
		assertEquals(CodeBlock.Type.PARAMETER_NAME, par1.additionalAttr.getType());
		var par2 = (CodeBlock)src.getFormatToken(36, 17);
		assertEquals(CodeBlock.Type.PARAMETER_NAME, par2.additionalAttr.getType());
		var par3 = (CodeBlock)src.getFormatToken(36, 22);
		assertEquals(CodeBlock.Type.PARAMETER_NAME, par3.additionalAttr.getType());
		
		// a local variable
		var a_local_var = (CodeBlock)src.getFormatToken(38, 3);
		assertEquals(CodeBlock.Type.VARIABLE_NAME, a_local_var.additionalAttr.getType());
		
		// a for-loop variable
		var a_for_var = (CodeBlock)src.getFormatToken(40, 5);
		assertEquals(CodeBlock.Type.FOR_VARIABLE_NAME, a_for_var.additionalAttr.getType());
		
		// another local variable, which is inside a for loop
		var another_local_var = (CodeBlock)src.getFormatToken(42, 3);
		assertEquals(CodeBlock.Type.VARIABLE_NAME, another_local_var.additionalAttr.getType());
	}

	/**
	 * Tests if the builder can correctly build the tree structure of the syntax scopes.
	 */
	@Test
	void testBuildSyntaxScope()
	{
		// use shorter local names as they will be used many times.
		var src = differentScopesSf;
		var s = differentScopesSs;
		
		assertEquals(2, s.getNumRootScopes(), "Should have too roots for the two global classes inside.");
		
		var r1 = s.getRootScope(0);
		var r2 = s.getRootScope(1);
		assertTrue(r1 != null);
		assertTrue(r2 != null);
		
		// Should have the start/end {/} correct
		TestUtils.assertSyntaxScopeLocation(src, r1, 3, 0, 35, 0);
		TestUtils.assertSyntaxScopeLocation(src, r2, 39, 6, 44, 0);
		
		// children
		assertEquals(6, r1.children.size());
		assertEquals(1, r2.children.size());
		
		var r1c0 = r1.children.get(0);
		var r1c1 = r1.children.get(1);
		var r1c2 = r1.children.get(2);
		var r1c3 = r1.children.get(3);
		var r1c4 = r1.children.get(4);
		var r1c5 = r1.children.get(5);
		TestUtils.assertSyntaxScopeLocation(src, r1c0, 5, 9, 9, 1);
		TestUtils.assertSyntaxScopeLocation(src, r1c1, 13, 1, 14, 1);
		TestUtils.assertSyntaxScopeLocation(src, r1c2, 17, 9, 17, 20);
		TestUtils.assertSyntaxScopeLocation(src, r1c3, 19, 9, 24, 1);
		TestUtils.assertSyntaxScopeLocation(src, r1c4, 27, 9, 28, 10);
		TestUtils.assertSyntaxScopeLocation(src, r1c5, 30, 9, 34, 1);
		assertTrue(r1c0.isLeaf());
		assertTrue(r1c1.isLeaf());
		assertTrue(r1c2.isLeaf());
		assertTrue(r1c4.isLeaf());
		assertEquals(1, r1c3.children.size());
		assertEquals(1, r1c5.children.size());
		
		var r1c3c1 = r1c3.children.get(0);
		var r1c5c1 = r1c5.children.get(0);
		TestUtils.assertSyntaxScopeLocation(src, r1c3c1, 21, 1, 23, 1);
		TestUtils.assertSyntaxScopeLocation(src, r1c5c1, 32, 1, 33, 10);
		assertTrue(r1c3c1.isLeaf());
		assertTrue(r1c5c1.isLeaf());
		
		var r2c0 = r2.children.get(0);
		TestUtils.assertSyntaxScopeLocation(src, r2c0, 41, 1, 43, 1);
		assertTrue(r2c0.isLeaf());
	}

	/**
	 * Tests if the builder can correctly append the information about 
	 * the syntax structure that follows a JavaDoc to that JavaDoc.
	 */
	@Test
	void testBuildJavaDocs()
	{
		// After construction, the build is already complete.
		var javaDocs = differentJavaDocsSf.getJavaDocs();
		
		// There are this many JavaDocs
		assertEquals(10, javaDocs.size(), "There are this many JavaDocs");
		
		// First, the type of what follows each should be correct.
		{
			assertEquals(JavaDocBlock.FollowingType.CLASS_LIKE, javaDocs.get(0).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.FIELD, javaDocs.get(1).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.METHOD_LIKE, javaDocs.get(2).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.OTHER, javaDocs.get(3).getFollowingType(), "followed by something that shouldn't follow it");
			assertEquals(JavaDocBlock.FollowingType.OTHER, javaDocs.get(4).getFollowingType(), "followed by nothing");
			assertEquals(JavaDocBlock.FollowingType.METHOD_LIKE, javaDocs.get(5).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.CLASS_LIKE, javaDocs.get(6).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.METHOD_LIKE, javaDocs.get(7).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.FIELD, javaDocs.get(8).getFollowingType());
			assertEquals(JavaDocBlock.FollowingType.OTHER, javaDocs.get(9).getFollowingType(), "followed by nothing");
		}
		
		// Second, if the following is a method-like construct,
		// then check if the parameters and return type is recorded correctly.
		{
			// 2, 5, 7 are method-like
			var methodInfo2 = javaDocs.get(2).getFollowingMethodInfo();
			var methodInfo5 = javaDocs.get(5).getFollowingMethodInfo();
			var methodInfo7 = javaDocs.get(7).getFollowingMethodInfo();
			
			// return types
			assertEquals("void", methodInfo2.returnType);
			assertEquals("void", methodInfo5.returnType);
			assertEquals("int", methodInfo7.returnType);
			
			// parameters
			assertEquals(List.of("i"), methodInfo2.parameterNames);
			assertEquals(List.of("i", "abc"), methodInfo5.parameterNames);
			assertEquals(List.of("x", "y"), methodInfo7.parameterNames);
		}
	}
}
