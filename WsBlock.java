

/**
 * I plan to process whitespaces as "blocks".
 * That is, I only care about the length (not the number of characters, but how long it should look) 
 * and positions of such blocks and don't care what are the actual characters (spaces, tabs, etc.)
 * 
 * I decide that 
 *      1. A space occupies 1 unit unconditionally.
 *      2. A tab always looks as if it pushes the next character to the next position divisible by 4.
 *          e.g. a tab at position 0, 1, 2, or 3 will cause the next character to show at position 4.
 *      3. A \n or \n\r breaks the current line and causes the next character to start from the position 0
 *          of the next line. It also starts a new whitespace block even if the next character is still a whitespace.
 */
public class WsBlock {
    // The characters that form the block.
    String characters;
}
