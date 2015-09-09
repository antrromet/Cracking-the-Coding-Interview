/**
*	Write a method to replace all spaces in a string with '%20'. You may assume that the
*   string has sufficient space at the end of the sting to hold the additional characters, 
*   and that you are given the "true" length of the string.
**/

public class ReplaceSpaces {
	
	public static void main(String[] args){
		System.out.println("Replacing spaces with '%20' in \""+args[0] + "\" gives us \""+replaceSpaces(args[0].toCharArray())+"\"");
	}
	
	private static String replaceSpaces(char[] charArr){
		int numSpaces = 0;
		for(char c:charArr){
			if(c == ' '){
				numSpaces++;
			}
		}
		int len = charArr.length + 2*numSpaces;
		char[] replacedCharArr = new char[len];
		for(int i=charArr.length - 1;i>=0;i--){
			if(charArr[i] == ' '){
				replacedCharArr[--len] = '0';
				replacedCharArr[--len] = '2';
				replacedCharArr[--len] = '%';
			} else {
				replacedCharArr[--len] = charArr[i];
			}
		}
		return new String(replacedCharArr);
	}	
}