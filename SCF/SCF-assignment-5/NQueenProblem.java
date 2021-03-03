package GETA2021.SCF.SCFAssignment5;

/**
 * Solves the NQueenProblem by recursive backtracking
 * 
 * @since 03-03-2021
 * @author Hitesh Pareek
 *
 */
public class NQueenProblem {
	int board[][];

	NQueenProblem(int sizeOfBoard) {
		this.board = new int[sizeOfBoard][sizeOfBoard];
	}

	/**
	 * Finds the solution for given n*n chess board where n is the size of board
	 * 
	 * @param board
	 * @param row
	 * @param column
	 * @return true if solution is found, else false
	 */
	public boolean findSolution(int[][] board, int column) {
  
		if (column >= board.length) {
			return true;
		}

		for (int index = 0; index < board.length; index++) {
			if (isQueenSafe(board, index, column)) {
				board[index][column] = 1;
				if (findSolution(board, column + 1) == true) {
					return true;
				}
				board[index][column] = 0;
			}
		}
		return false;
	}

	/**
	 * Check if queen is safe on a particular block of the board
	 * 
	 * @param board
	 * @param row
	 * @param column
	 * @return true if queen is safe else, return false
	 */
	public boolean isQueenSafe(int[][] board, int row, int column) {

		for (int index = 0; index < column; index++) {
			if (board[row][index] == 1) {
				return false;
			}
		}

		for (int rowIndex = row, colIndex = column; rowIndex >= 0
				&& colIndex >= 0; rowIndex--, colIndex--) {
			if (board[rowIndex][colIndex] == 1) {
				return false;
			}
		}

		for (int rowIndex = row, colIndex = column; colIndex >= 0
				&& rowIndex < board.length; rowIndex++, colIndex--) {
			if (board[rowIndex][colIndex] == 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Prints the Solution of the given NQueens problem
	 */
	public void showBoard() {

		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}
}