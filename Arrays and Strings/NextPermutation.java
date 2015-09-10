/** 
*	Write a program to find the next permutation in the sequence
*
*	The following algorithm generates the next permutation lexicographically after a
*	given permutation. It changes the given permutation in-place.
*
*	1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the
*	   permutation is the last permutation.
*	2. Find the largest index l greater than k such that a[k] < a[l].
*	3. Swap the value of a[k] with that of a[l].
*	4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
*
**/

public class NextPermutation {

	public static void main(String[] args){
		String nextPerm = findNextPermutation(args[0].toCharArray());
		System.out.println((nextPerm == null)?"This is the largest string there is!":
		nextPerm);
	}
	
	private static String findNextPermutation(char[] charAr){
		int k=-1, l=-1;
		for(int i=charAr.length-2;i>=0;i--){
			if(charAr[i] < charAr[i+1]){
				k = i;
				break;
			}
		}
		if(k == -1){
			return null;
		}
		for(int i=charAr.length - 1;i>k;i--){
			if(charAr[i] > charAr[k]){
				l = i;
				break;
			}
		}
		swap(charAr, l, k);
		
		if(k+1 < charAr.length-1){
			for(int i = 0;i < (charAr.length - k)/2;i++){
				swap(charAr, k+1+i, charAr.length - i - k);
			}
		}
		return new String(charAr);
	}
	
	private static void swap(char[] a, int l, int k){
		char tmp = a[l];
		a[l] = a[k];
		a[k] = tmp;
	}

}