/**
*	Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
*	write a method to rotate the image by 90 degrees. Can you do this in place?
**/

import java.util.Scanner;

public class RotateImage {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = Integer.valueOf(args[0]);
		int[][] matrix = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print("Enter a["+i+"]["+j+"] : ");
				matrix[i][j] = in.nextInt();
			}
		}
		
		System.out.println("You entered : ");
		printMatrix(matrix, N);
		
		rotateMatrix(matrix, N);
	}
	
	private static void rotateMatrix(int[][] matrix, int N){
		System.out.println("Rotated matrix is as follows : ");
		for(int layer = 0;layer < N/2; layer++){
			int first = layer;
			int last = N - layer - 1;
			for(int i= first;i<last;i++){
				int offset = i - first;
				
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		printMatrix(matrix, N);
	}
	
	private static void printMatrix(int[][] matrix, int N){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}