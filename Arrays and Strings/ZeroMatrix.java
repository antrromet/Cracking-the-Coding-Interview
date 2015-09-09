/**
*	Write an algorithm that if an element in an MxN matrix is 0, its entire row and column
*	are set to 0.
**/

import java.util.Scanner;

public class ZeroMatrix {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("M = ");
		int M = in.nextInt();
		System.out.print("N = ");
		int N = in.nextInt();
		int[][] matrix = new int[M][N];
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print("a["+i+"]["+j+"] = ");
				matrix[i][j] = in.nextInt();
			}
		}
		System.out.println("You entered : ");
		printMatrix(matrix, M, N);
		findZeroMatrix(matrix, M, N);
	}
	
	private static void findZeroMatrix(int[][] a, int M, int N){
		boolean hasZeroRow=false, hasZeroColumn = false;
		for(int j=0;j<N;j++){
			if(a[0][j] == 0){
				hasZeroRow = true;
				break;
			}
		}
		
		for(int i=0;i<M;i++){
			if(a[i][0] == 0){
				hasZeroColumn = true;
				break;
			}
		}
		
		for(int i=1;i<M;i++){
			for(int j=1;j<N;j++){
				if(a[i][j] == 0){
					a[0][j] = 0;
					a[i][0] = 0;
					break;
				}
			}
		}
		
		System.out.println("Zero Matrix : ");
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(i == 0 && hasZeroRow || j == 00 && hasZeroColumn){
					System.out.print("0 ");
				} else if(a[0][j] == 0 || a[i][0] == 0){
					System.out.print("0 ");
				} else {
					System.out.print(a[i][j]+" ");
				}
			}
			System.out.println("");
		}
	}
	
	private static void printMatrix(int[][] matrix, int M, int N){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}