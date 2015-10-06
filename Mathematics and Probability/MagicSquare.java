public class MagicSquare {
	
	public static void main(String[] args){
		int gridSize = Integer.valueOf(args[0]);
		if(gridSize%2 == 0){
			System.out.println("Grid size must be an odd number!");
			System.exit(0);
		}
		
		int[][] grid = new int[gridSize][gridSize];
		generateMagicNumbers(grid, gridSize);
		
		int sumOfRows = 0;
		for(int i=0;i<gridSize;i++){
			sumOfRows = 0;
			for(int j=0;j<gridSize;j++){
				System.out.print(grid[i][j]+"\t");
				sumOfRows += grid[i][j];
			}
			System.out.println();
		}
		
		assert sumOfRows == grid[gridSize/2][gridSize/2] * gridSize;
	}
	
	private static void generateMagicNumbers(int[][] grid, int size){
		// First entry in the first row, middle column
		int row = 0;
		int column = size/2;
		int num = 0;
		while(true) {
			grid[row][column] = ++num;
			row--;
			column++;
			
			// Rightmost corner of grid
			if(row < 0 && column >= size){
				column--;
				row+=2;
			}
			
			// Row size underflow
			if(row < 0){
				row = size - 1;
			}
			
			// Column size overflow
			if(column >= size){
				column = 0;
			}
			
			// Number entered already
			if(grid[row][column] != 0){
				column--;
				row+=2;
			}
			
			// Last entry in the last row, middle column
			if(row == size-1 && column == size/2){
				grid[row][column] = ++num;
				break;
			}
		}
	}
	
}