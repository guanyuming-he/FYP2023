/**
 * This is a class
 * 
 * @author Guanyuming He
 * @implNote This is an impl Note
 */
public class ABCDE {

    /** This JavaDoc is followed by a field */
    private int i = 5;

    /**
     * This JavaDoc is followed by a constructor.
     * 
     * @param i something
     * @author Guanyuming He
     */
    public ABCDE(int i) {
        /**
         * This JavaDoc is followed by something that shouldn't follow it.
         */
        this.i = i;
    }

    /**
    * This JavaDoc goes without being followed by a syntax structure, 
and is poorly formatted.
        */

    /**
     * This JavaDoc is followed by a constructor, but has some tags wrong
     * @param i something
     * @param bc something
     */
    public ABCDE(int i, boolean abc) {
        this.i = i;
    }

    /** This JavaDoc is followed by a class-like definition */
    public static interface BCD {

        /**
         * This JavaDoc is followed by a method,
         * and it misses a return tag
         * 
         * @apiNote this is an api note
         * @param x ...
         * @param y something
         * @throws ArithmeticException if ...
         */
        int bcd(int x, String y) throws ArithmeticException;
    }

    /**
     * This JavaDoc is followed by a field, but it has undesired tags
     * @param what?
     * @return why?
     */
    public boolean ggg;
    
    /**
     * This JavaDoc is followed by nothing, but it has undesired tags
     * @return xxx
     * @throws yyy
     */
    
}