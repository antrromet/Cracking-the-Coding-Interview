/**
* A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
* 3 steps at a time. Implement a method to count how many possible ways the child can
* run up the stairs.
**/

import java.util.*;

public class CountingSteps {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the steps: ");
		int n = in.nextInt();
		int[] map = new int[n+1];
		for(int i=0;i<map.length;i++){
			map[i] = -1;
		}
		System.out.println("Total Ways: "+calculateSteps(n, map));
	}
	
	private static int calculateSteps(int n, int[] map){
		if(n < 0){
			return 0;
		} else if(n == 0){
			return 1;
		} else if(map[n] > -1){
			return map[n];
		}
		map[n] = calculateSteps(n-1, map) + calculateSteps(n-2, map) + calculateSteps(n-3, map);
		return map[n];
	}

}