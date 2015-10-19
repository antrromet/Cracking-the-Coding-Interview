/**
* Write a method to permute all permutations of a string of unique characters
**/

import java.util.*;

public class StringPermutations {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str = in.nextLine();
		ArrayList<String> perms = getPerms(str);
		for(String word : perms){
			System.out.println(word);
		}
	}
	
	private static ArrayList<String> getPerms(String str){
		if(str == null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word : words){
			for(int j=0;j<=word.length();j++){
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	private static String insertCharAt(String s, char ch, int i){
		String first = s.substring(0,i);
		String second = s.substring(i);
		return first+ch+second;
	}

}