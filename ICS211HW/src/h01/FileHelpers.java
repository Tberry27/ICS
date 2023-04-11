
package h01;

import java.io.File;
import java.util.Scanner;

public class FileHelpers {
	public static String Filehelper(String args) {
		//creating variables, new file, and scanner
		File f = new File(args);
		int charCount= 0;
		int wordCount=0;
		Scanner scan = null;
			//try catch to scan files
		try {
			scan = new Scanner(f);
		}catch(Exception e){
			System.out.print("Exception found with scanner.");
		}
			//while loop scanning each line and splitting up words by using space as the delimiter then
			//getting word length an adding it to total character count
		while(scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			String[]words = currentLine.split(" ");
			wordCount = wordCount + words.length;
			for (String word : words) {
				charCount = charCount + word.length();
			}
		}
			//changing character count integer to string for return statement
		String characterAmmount = Integer.toString(charCount);
		return characterAmmount;
	}
}