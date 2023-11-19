/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.SourceFile;

/**
 * Tests the SourceFile class.
 */
class TestSourceFile {
	
	/**
	 * Creates a new SourceFile, but calls JUnit's fail()
	 * if the creation fails.
	 * @return the SourceFile created, or null if the creation fails.
	 */
	SourceFile createSourceFileNoError(String file_path) {
		
		
		SourceFile s = null;
		try {
			s = new SourceFile(file_path);
		} catch (UnsupportedOperationException e) {
			fail("The source contains no syntax error yet the ctor says otherwise.");
		} catch (IOException e) {
			fail("Could not open the source file.");
		}
		return s;
	}

	/**
	 * Tests if the source file constructor can get the number of lines right
	 * when in the source code there is no empty line (i.e. lines of only line terminators).
	 */
	@Test
	void testCtorLinesNoEmptyLine() {
		final String file_path_1 = "test_data/no_empty_lines1.txt";
		var s1 = createSourceFileNoError(file_path_1);
		
		assertEquals(4, s1.__test_get_format_tokens().size());
	}
	
	/**
	 * Tests if the source file constructor can get the number of lines right
	 * when in the source code there are some empty lines (i.e. lines of only line terminators).
	 */
	@Test
	void testCtorLinesEmptyLines() {
		final String file_path_1 = "test_data/empty_lines1.txt";
		var s1 = createSourceFileNoError(file_path_1);
		final String file_path_2 = "test_data/empty_lines2.txt";
		var s2 = createSourceFileNoError(file_path_2);
		
		// Nothing. The file is empty
		assertEquals(1, s1.__test_get_format_tokens().size());
		assertTrue(s1.__test_get_format_tokens().get(0).isEmpty());
		// Some lines...
		assertEquals(16, s2.__test_get_format_tokens().size());
	}

}
