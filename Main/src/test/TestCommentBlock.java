package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.CommentBlock;

public class TestCommentBlock 
{
	/**
	 * Visibility test
	 */
	@Test
	void testVisibility()
	{
		// Let cb be any comment block
		var t = new CommonToken(0, "// 123");
		CommentBlock cb = new CommentBlock(t, 0, 0);
		
		assertTrue(cb.isVisible(), "Every comment block should be visible.");
	}
}
