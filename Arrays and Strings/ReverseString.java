public class ReverseString {

	public static void main(String[] args){
		System.out.println("Reverse of "+args[0]+" is "+reverse(args[0].toCharArray()));
		System.out.println("Recursive Reverse of "+args[0]+" is "+recurseReverse(args[0]));
	}
	
	private static String reverse(char[] chArray){
		for(int i=0;i<chArray.length/2;i++){
			char tmp = chArray[i];
			chArray[i] = chArray[chArray.length - i - 1];
			chArray[chArray.length - i - 1] = tmp;
		}
		return new String(chArray);
	}
	
	private static String recurseReverse(String str){
		if(str.length() <= 1){
			return str;
		}
		return recurseReverse(str.substring(1)) + str.charAt(0);
	}

}