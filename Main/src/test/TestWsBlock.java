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
		
		assertEquals(spaces1.length(), block1.visual_length);
		assertEquals(spaces2.length(), block2.visual_length);
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
		assertEquals(4, block1.visual_length);
		assertEquals(3, block2.visual_length);
		assertEquals(2, block3.visual_length);
		assertEquals(1, block4.visual_length);
		
		var block5 = new WsBlock("\t\t\t\t", 5, 2, 1, 1);
		var block6 = new WsBlock("\t\t\t\t\t", 8, 3, 8, 2);
		
		// See if subsequent tabs are all of 4 lengths
		assertEquals(3 + 3*4, block5.visual_length);
		assertEquals(5*4, block6.visual_length);
		
		// TODO: See if mixture of spaces and tabs will be calculated correctly
	}

}
