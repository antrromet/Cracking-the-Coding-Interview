/**
* Implement an algorithm to determine if a string has all unique characters.
**/

public class CheckUniqueChars {
	
	public static void main(String[] args) {
		System.out.println(args[0]+(check(args[0])?" has all ":" does not have ")+"unique characters");
	}
	
	private static boolean check(String str){
		if(str.length() > 128){
			return false;
		}
		boolean[] chars = new boolean[256];
		for(int i=0;i<str.length();i++){
			int ch = str.charAt(i);
			if(chars[ch]){
				return false;
			}
			chars[ch] = true;
		}
		return true;
	}
	
}