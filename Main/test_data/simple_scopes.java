/*
 * A file with a few simple scopes that cover all kinds:
 * 1. root
 * 2. some that's in the middle
 * 3. leaves
 */

public class ABC {
    public void foo() {
        {
            int bar = 1;
        }

        {
            int i = 0;
        }
    }
    
    public void bar() { return; }
}