/**
* Given two strings, write a method to decide if one is a permutation of the other.
**/

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String args[]){
		System.out.println(args[0]+ " and "+args[1] +(sortCheck(args[0],args[1])?" are ":" aren't ") + "permutations of each other by sorting check");
		System.out.println(args[0]+ " and "+args[1] +(charCountCheck(args[0],args[1])?" are ":" aren't ") + "permutations of each other by char count check");
	}
	
	private static boolean sortCheck(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		return sort(str1.toCharArray()).equals(sort(str2.toCharArray()));
	}
	
	private static String sort(char[] charArray){
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	private static boolean charCountCheck(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		int[] charCounts = new int[256];
		for(int i=0;i<str1.length();i++){
			int ch = str1.charAt(i);
			charCounts[ch]++;
		}
		
		for(int i=0;i<str2.length();i++){
			int ch = str2.charAt(i);
			if(charCounts[ch] < 0){
				return false;
			}
		}
		return true;
	}

}