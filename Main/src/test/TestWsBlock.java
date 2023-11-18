/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import format.WsBlock;

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
		// Multiple spaces
		final String spaces2 = "       ";
		
		assertEquals(1, WsBlock.calculate_length(spaces1, 2, 3));
		assertEquals(spaces2.length(), WsBlock.calculate_length(spaces2, 4, 5));
	}
	
	/**
	 * When the token consists of only spaces and tabs
	 */
	@Test
	void testCalculateLengthSpacesAndTabs() 
	{
		// See if the length is correctly calculated with respect to the position of the tabs
		assertEquals(4, WsBlock.calculate_length("\t", 0, 0));
		assertEquals(3, WsBlock.calculate_length("\t", 1, 1));
		assertEquals(2, WsBlock.calculate_length("\t", 2, 2));
		assertEquals(1, WsBlock.calculate_length("\t", 3, 3));
		
		// See if subsequent tabs are all of 4 lengths
		assertEquals(3 + 3*4, WsBlock.calculate_length("\t\t\t\t", 4, 1));
		assertEquals(5*4, WsBlock.calculate_length("\t\t\t\t\t", 9, 8));
		
		// See if mixture of spaces and tabs will be calculated correctly
	}

}
