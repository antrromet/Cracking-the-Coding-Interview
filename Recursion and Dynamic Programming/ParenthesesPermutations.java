/**
* Write a method to permute all permutations of a string of unique characters
**/

import java.util.*;

public class ParenthesesPermutations {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int n = in.nextInt();
		Set<String> parens = generateParens(n);
		for(String word : parens){
			System.out.println(word);
		}
	}
	
	private static Set<String> generateParens(int n){
		Set<String> set = new HashSet<String>();
		if(n == 0){
			set.add("");
		}else{
			Set<String> prev = generateParens(n-1);
			for(String str:prev){
				for(int i=0;i<str.length();i++){
					if(str.charAt(i) == '('){
						String s = insertInside(str, i);
						set.add(s);
					}
				}
				set.add("()"+str);
			}
		}
		return set;
	}
	
	private static String insertInside(String s, int i){
		String left = s.substring(0,i+1);
		String right = s.substring(i+1);
		return left+"()"+right;
	}

}