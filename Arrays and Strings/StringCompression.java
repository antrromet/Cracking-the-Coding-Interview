/**
*	Implement a method to perform basic string compression using the counts of repeated
*	characters. For example the string aabcccccaaa would become a2b1dca3.
**/

public class StringCompression {

	public static void main(String[] args){
		System.out.println(countCompress(args[0]));
		System.out.println(anotherCompress(args[0]));
	}
	
	private static String countCompress(String str){
		StringBuilder builder = new StringBuilder();
		builder.append(str.charAt(0));
		int counter = 1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i) == str.charAt(i-1)){
				counter++;
			} else {
				builder.append(counter);
				counter = 1;
				builder.append(str.charAt(i));
			}
		}
		builder.append(counter);
		return builder.toString();
	}
	
	private static String anotherCompress(String str){
		int len = countCompressedLength(str);
		char[] chAr = new char[len];
		char last = str.charAt(0);
		int x = 0;
		chAr[x++] = last;
		int counter = 1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i) == last){
				counter++;
			} else {
				last = str.charAt(i);
				for(int j=0;j<String.valueOf(counter).length();j++){
					chAr[x++] = String.valueOf(counter).charAt(j);
				}
				chAr[x++] = last;
				counter = 1;
			}
		}
		for(int j=0;j<String.valueOf(counter).length();j++){
			chAr[x++] = String.valueOf(counter).charAt(j);
		}
		return new String(chAr);
	}
	
	private static int countCompressedLength(String str){
		int lenCounter = 1;
		char last = str.charAt(0);
		int counter = 1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i) == last){
				counter++;
			} else {
				lenCounter += String.valueOf(counter).length();
				counter = 1;
				last = str.charAt(i);
				lenCounter++;
			}
		}
		lenCounter += String.valueOf(counter).length();
		return lenCounter;
	}

}