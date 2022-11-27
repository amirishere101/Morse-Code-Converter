import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * A utility class For morse Code Translation
 * @author Amir Hawasly
 *
 */
public class MorseCodeConverter {
	
	/**
	 * Translates morse code to english
	 * @param codeFile the name of the file you wish to translate from morse code to english
	 * @return returns the english version of the morse code
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner scan = new Scanner(codeFile);
		String data = "";
		while(scan.hasNextLine()) {
			data += scan.nextLine();
		}
		scan.close();
		return convertToEnglish(data);
	}
	
	/**
	 * Translates morse code to english
	 * @param code the String of the morse code to be translated to english
	 * @return the english version of the morse code passed in
	 */
	public static String convertToEnglish(String code) {
		MorseCodeTree morseCodeTree = new MorseCodeTree();
		String[] morseCode = code.split(" ");
		String result = "";
		System.out.println(Arrays.toString(morseCode));
		for(int i = 0; i < morseCode.length; i++) {
			if(morseCode[i].equals("/")){
				result += " ";
			}else {
				result += morseCodeTree.fetch(morseCode[i]);
			}
			System.out.println(morseCode[i]);
		}
		return result;
	} 
	
	/**
	 * prints the tree out for testing purposes
	 * @return String of the tree inorder
	 */
	public static String printTree() {
		MorseCodeTree morseCodeTree = new MorseCodeTree();
		String result = "";
		for(int i = 0; i < morseCodeTree.toArrayList().size(); i++) {
			result += morseCodeTree.toArrayList().get(i);
			if(!(i == morseCodeTree.toArrayList().size() - 1)) {
				result += " ";
			}
		}
		return result;
	}
}
