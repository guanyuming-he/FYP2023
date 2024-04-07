/**
 * 
 */
package edu.guanyfyp;

import java.io.IOException;

import edu.guanyfyp.format.FormatVerdict;

/**
 * The class where the main method is
 */
public final class Main {

	/**
	 * Usage: executable_name path_to_source_file.
	 * @param args contains the path_to_source_file.
	 */
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("The source file has grammatical errors.");
			return;
		}
		
		String path = args[0];
		SourceFile sourceFile = null;
		try {
			sourceFile = new SourceFile(path);
		} 
		catch (UnsupportedOperationException e) {
			
			System.out.println("The source file has grammatical errors.");
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			
			System.out.println("The source file could not be opened.");
			System.out.println(e.getMessage());
		}
		
		if(sourceFile == null) {
			return; // error
		}
		
		FormatVerdict verdict = sourceFile.analyze();
		System.out.println("Verdict:");
		System.out.println(verdict.toString());
	}

}
