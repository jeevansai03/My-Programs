/**
 * Created class named as SolveSudoku
 * @author Jeevan Sai V
 *
 */
public class SudokuSolver {

	/**
	 * My sudoku is 9*9 matrix form. The size of the int 9.
	 */
	public static final int Gridsize = 9;
	    
	public static void printBoard(int[][] board) {
		for (int row = 0; row < Gridsize; row++) {
			for (int column = 0; column < Gridsize; column++) {
				System.out.print(board[row][column]+ " ");
			}
			System.out.println();
	    }
	}
	
	
	public static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < Gridsize; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
	    return false;
	}
	  
	public static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < Gridsize; i++) {
			if (board[i][column] == number) {
				return true;
			}
	    }
	    return false;
	}
	  
	public static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int localBoxRow = row - row % 3;
	    int localBoxColumn = column - column % 3;
	    
	    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
	    	for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
	    		if (board[i][j] == number) {
	    			return true;
	    		}
	    	}
	    }
	    return false;
	}
	  
	public static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) &&
	        !isNumberInColumn(board, number, column) &&
	        !isNumberInBox(board, number, row, column);
	}
	  
	public static boolean solveBoard(int[][] board) {
		for (int row = 0; row < Gridsize; row++) {
			for (int column = 0; column < Gridsize; column++) {
				if (board[row][column] == 0) {
					for (int numberToTry = 1; numberToTry <= Gridsize; numberToTry++) {
						if (isValidPlacement(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;
	              
							if (solveBoard(board)) {
								return true;
							}
							else {
								board[row][column] = 0;
							}
						}
					}
					return false;
				}
			}
	    }
	    return true;
	}
	  
	public static void main(String[] args) {
		    
		int[][] Mysudoku = {
				{0, 0, 4, 0, 5, 0, 0, 0, 0},
				{9, 0, 0, 7, 3, 4, 6, 0, 0},
				{0, 0, 3, 0, 2, 1, 0, 4, 9},
				{0, 3, 5, 0, 9, 0, 4, 8, 0},
				{0, 9, 0, 0, 0, 0, 0, 3, 0},
				{0, 7, 6, 0, 1, 0, 9, 2, 0},
				{3, 1, 0, 9, 7, 0, 2, 0, 0},
				{0, 0, 9, 1, 8, 2, 0, 0, 3},
				{0, 0, 0, 0, 6, 0, 1, 0, 0}
		};
	    
	    printBoard(Mysudoku);
	    
	    if (solveBoard(Mysudoku)) {
	      System.out.println("My sudoku is solved successfully");
	    }
	    else {
	      System.out.println("My Sudoku is not solved");
	    }
	    
	    printBoard(Mysudoku);
	    
	}
}