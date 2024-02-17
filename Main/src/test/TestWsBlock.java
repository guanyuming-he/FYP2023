/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.guanyfyp.format.WsBlock;

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
		// One space
		final String spaces1 = " ";
		var block1 = new WsBlock(spaces1, 2, 2, 3, 2);
		// Multiple spaces
		final String spaces2 = "       ";
		var block2 = new WsBlock(spaces2, 4, 2, 5, 1);
		
		assertEquals(spaces1.length(), block1.visualLength);
		assertEquals(spaces2.length(), block2.visualLength);
	}
	
	/**
	 * When the token consists of only spaces and tabs
	 */
	@Test
	void testCalculateLengthSpacesAndTabs() 
	{
		final String oneTab = "\t";
		var block1 = new WsBlock(oneTab, 0, 0, 3, 0);
		var block2 = new WsBlock(oneTab, 5, 1, 4, 1);
		var block3 = new WsBlock(oneTab, 10, 2, 5, 1);
		var block4 = new WsBlock(oneTab, 15, 3, 6, 2);
		
		// See if the length is correctly calculated with respect to the position of the tabs
		assertEquals(4, block1.visualLength);
		assertEquals(3, block2.visualLength);
		assertEquals(2, block3.visualLength);
		assertEquals(1, block4.visualLength);
		
		var block5 = new WsBlock("\t\t\t\t", 5, 2, 1, 1);
		var block6 = new WsBlock("\t\t\t\t\t", 8, 3, 8, 2);
		
		// See if subsequent tabs are all of 4 lengths
		assertEquals(3 + 3*4, block5.visualLength);
		assertEquals(5*4, block6.visualLength);
		
		// See if mixture of spaces and tabs will be calculated correctly
		var block7 = new WsBlock(" \t  \t   \t    \t", 0, 0, 1, 0);
		var block8 = new WsBlock("    \t   \t  \t \t", 1, 1, 8, 1);

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
		// The results should be exactly the same as previous ones.
		
		// Spaces and FFs
		var block1 = new WsBlock("\f \f", 2, 2, 3, 2);
		var block2 = new WsBlock("    \f  \f \f", 4, 2, 5, 1);
		
		assertEquals(1, block1.visualLength);
		assertEquals(7, block2.visualLength);
		
		// Tabs and FFs
		final String oneTabFFs = "\f\t\f";
		var block3 = new WsBlock(oneTabFFs, 4, 4, 3, 1);
		var block4 = new WsBlock(oneTabFFs, 5, 1, 4, 1);
		var block5 = new WsBlock(oneTabFFs, 10, 2, 5, 1);
		var block6 = new WsBlock(oneTabFFs, 15, 3, 6, 2);
		
		assertEquals(4, block3.visualLength);
		assertEquals(3, block4.visualLength);
		assertEquals(2, block5.visualLength);
		assertEquals(1, block6.visualLength);
		
		var block7 = new WsBlock("\f\t\t\t\f\t", 5, 5, 1, 1);
		var block8 = new WsBlock("\f\t\t\f\t\f\t\t\f", 8, 9, 8, 2);
		
		// See if subsequent tabs are all of 4 lengths
		assertEquals(3 + 3*4, block7.visualLength);
		assertEquals(5*4, block8.visualLength);
		
		// All characters
		var block9 = new WsBlock(" \t \f \t   \t   \f \t\f", 4, 7, 1, 4);
		var block10 = new WsBlock("\f   \f \t  \f \t  \f\t \t", 5, 6, 8, 5);

		assertEquals(5*4, block9.visualLength);
		assertEquals(4+3+3*4, block10.visualLength);
	}

}
