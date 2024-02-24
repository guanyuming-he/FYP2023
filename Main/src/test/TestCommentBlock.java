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
	
	/**
	 * Visual length calculation test
	 */
	@Test
	void testCalculateVisualLength()
	{
		// Need to create a comment block anyway
		// as calculateVisualLength() is not static.
		var t = new CommonToken(0, "// 123");
		CommentBlock cb = new CommentBlock(t, 0, 0);
		
		// 1. Single line comment starting with //
		// Boundary case
		assertEquals(2, cb.calculateVisualLength("//"));
		// Other cases
		assertEquals(5, cb.calculateVisualLength("//   "));
		assertEquals(6, cb.calculateVisualLength("// a  "));
		assertEquals(4, cb.calculateVisualLength("//ab"));
		assertEquals(5, cb.calculateVisualLength("// //"));
		assertEquals(5, cb.calculateVisualLength("// /*"));
		
		// 2. Single line comment starting with /* or /**
		// Boundary cases
		assertEquals(4, cb.calculateVisualLength("/**/"));
		assertEquals(5, cb.calculateVisualLength("/***/"));
		// Other cases
		assertEquals(6, cb.calculateVisualLength("/*  */"));
		assertEquals(7, cb.calculateVisualLength("/*a b*/"));
		assertEquals(19, cb.calculateVisualLength("/** @return shit */"));
		assertEquals(9, cb.calculateVisualLength("/** /* */"));
		assertEquals(9, cb.calculateVisualLength("/** // */"));
		
		// 3. Multi line comment (can only start with /* or /**)
		// Boundary cases
		assertEquals(2, cb.calculateVisualLength("/*\n*/"));
		assertEquals(3, cb.calculateVisualLength("/**\n*/"));
		// Other cases
		assertEquals(3, cb.calculateVisualLength("/* \n */"));
		assertEquals(3, cb.calculateVisualLength("/*\t\n */"));
		assertEquals(28, cb.calculateVisualLength("/** this method returns shit\n@return shit */"));
		assertEquals(24, cb.calculateVisualLength("/**@author Guanyuming He\r\n" + 
				"Copyright (C) 2023\r\n"));
		assertEquals(6, cb.calculateVisualLength("/** /*\n */"));
	}
}
