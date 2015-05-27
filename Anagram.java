
import java.util.Scanner;

public class Anagram {
	public static boolean anagramsTest(String[] strings) {
		//verify that all strings are same length, otherwise test fails
		for(int i=1;i < strings.length;i++) {
			if (strings[0].length() != strings[i].length()) return false;
		}
		
		//verify that all strings are identical to the first string, otherwise test fails
		for(int i=1; i < strings.length; i++) { //loop once for each string
			for(int j=0; j < strings[0].length(); j++) { //loop once for each character of the first string
				//loop once to compare a character of first string to each character of another string
				//deletes the first matching character found, then breaks loop; otherwise if no match is found, return false;
				boolean match = false;
				for(int k = 0; k < strings[i].length(); k++) {
					if ( strings[0].charAt(j) == strings[i].charAt(k) ) {
						match = true; //takes note that a match is found
						//to delete the first matching char; strings[i].length() being modified is expected and intended
						if (strings[i].length()==1) strings[i] = "";
						else if (k == 0) strings[i] = strings[i].substring(1); //substring from index 1 until the end of the original string
						else if (k == strings[i].length() - 1) strings[i] = strings[i].substring(0,k); //substring from index 0 until index k-1
						else strings[i] = strings[i].substring(0,k) + strings[i].substring(k+1);
						break; //break loop after first match is found and deleted
					}
				}
				if (match == false) return false; //if no match is found, return false
			}
		}
		
		return true; //test succeeds if above loops complete without returning false
	}
	
	public static void main(String[] args) {
		//constants
		final int numberOfInputs = 2;
		
		System.out.println("<Anagrams Test>");
		
		Scanner sc = new Scanner(System.in);
		
		String[] inputs = new String[numberOfInputs];
		for(int i=0;i<numberOfInputs;i++) {
			System.out.print("Word #"+ (i+1) +"? ");
			inputs[i] = sc.nextLine();
		}
		System.out.print("Are they anagrams? "+ anagramsTest(inputs) );
	}
}
