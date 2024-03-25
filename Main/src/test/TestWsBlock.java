/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.antlr.v4.runtime.CommonToken;
import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.primitives.WsBlock;

/**
 * Tests all methods of the class WsBlock
 */
class TestWsBlock 
{

	/**
	 * When the token consists of only spaces
	 */
	@Test
	void testCalculateLengthSpacesOnly() 
	{
		// A CodeBlock requires an ANTLR token to create.
		CommonToken t = null;
		
		// The visual position and the line index should not affect the length.
		
		// One space
		final String spaces1 = " ";
		t = new CommonToken(0, spaces1);
		var block1 = new WsBlock(t, 2, 2);
		// Multiple spaces
		final String spaces2 = "       ";
		t = new CommonToken(0, spaces2);
		var block2 = new WsBlock(t, 4, 1);
		
		assertEquals(spaces1.length(), block1.visualLength);
		assertEquals(spaces2.length(), block2.visualLength);
	}
	
	/**
	 * When the token consists of only spaces and tabs
	 */
	@Test
	void testCalculateLengthSpacesAndTabs() 
	{
		// A CodeBlock requires an ANTLR token to create.
		CommonToken t = null;
		
		// What matters here is only the visual position.
		
		final String oneTab = "\t";
		t = new CommonToken(0, oneTab);
		var block1 = new WsBlock(t, 0, 0);
		var block2 = new WsBlock(t, 5, 1);
		var block3 = new WsBlock(t, 10, 1);
		var block4 = new WsBlock(t, 15, 2);
		
		// See if the length is correctly calculated with respect to the position of the tabs
		assertEquals(4, block1.visualLength);
		assertEquals(3, block2.visualLength);
		assertEquals(2, block3.visualLength);
		assertEquals(1, block4.visualLength);
		
		t = new CommonToken(0, "\t\t\t\t");
		var block5 = new WsBlock(t, 5, 1);
		t = new CommonToken(0, "\t\t\t\t\t");
		var block6 = new WsBlock(t, 8, 2);
		
		// See if subsequent tabs are all of 4 lengths
		assertEquals(3 + 3*4, block5.visualLength);
		assertEquals(5*4, block6.visualLength);
		
		// See if mixture of spaces and tabs will be calculated correctly
		t = new CommonToken(0, " \t  \t   \t    \t");
		var block7 = new WsBlock(t, 0, 0);
		t = new CommonToken(0, "    \t   \t  \t \t");
		var block8 = new WsBlock(t, 1, 1);

		assertEquals(5*4, block7.visualLength);
		assertEquals(4+3+3*4, block8.visualLength);
	}
	
	/**
	 * When all kinds of characters are involved (i.e. spaces, tabs, and form feeds).
	 */
	@Test
	void testCalculateLengthAll()
	{
		// The strings are made by inserting form feeds into previous test strings.
		// The results should be exactly the same as previous ones,
		// because form feeds are not treated as occupying space.
		
		// A CodeBlock requires an ANTLR token to create.
		CommonToken t = null;
		
		// Spaces and FFs
		t = new CommonToken(0, "\f \f");
		var block1 = new WsBlock(t, 2, 2);
		t = new CommonToken(0, "    \f  \f \f");
		var block2 = new WsBlock(t, 4, 1);
		
		assertEquals(1, block1.visualLength);
		assertEquals(7, block2.visualLength);
		
		// Tabs and FFs
		final String oneTabFFs = "\f\t\f";
		t = new CommonToken(0, oneTabFFs);
		var block3 = new WsBlock(t, 4, 1);
		var block4 = new WsBlock(t, 5, 1);
		var block5 = new WsBlock(t, 10, 1);
		var block6 = new WsBlock(t, 15, 2);
		
		assertEquals(4, block3.visualLength);
		assertEquals(3, block4.visualLength);
		assertEquals(2, block5.visualLength);
		assertEquals(1, block6.visualLength);
		
		t = new CommonToken(0, "\f\t\t\t\f\t");
		var block7 = new WsBlock(t, 5, 1);
		t = new CommonToken(0, "\f\t\t\f\t\f\t\t\f");
		var block8 = new WsBlock(t, 8, 2);
		
		// See if subsequent tabs are all of 4 lengths
		assertEquals(3 + 3*4, block7.visualLength);
		assertEquals(5*4, block8.visualLength);
		
		// All characters
		t = new CommonToken(0, " \t \f \t   \t   \f \t\f");
		var block9 = new WsBlock(t, 4, 4);
		t = new CommonToken(0, "\f   \f \t  \f \t  \f\t \t");
		var block10 = new WsBlock(t, 5, 5);

		assertEquals(5*4, block9.visualLength);
		assertEquals(4+3+3*4, block10.visualLength);
	}
	
	/**
	 * Visibility test
	 */
	@Test
	void testVisibility()
	{
		// Let wb be any ws block
		var t = new CommonToken(0, "  \t");
		var wb = new WsBlock(t, 0, 0);
		
		assertFalse(wb.isVisible(), "Every ws block should be invisible.");
	}

}
