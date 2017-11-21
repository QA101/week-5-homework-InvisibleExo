
public class TicTacToeClass {
	private int boardSize;
	private int turns;
	private int maxTurns;
	private char [][] board;
	// Is it possible to figure out this problem with arrow keys to move and place char 'X' or 'O'?
	
	public TicTacToeClass() {
		//boardSize should be set as 3, 5, 7, 9, etc...
		boardSize = 3;
		maxTurns = (boardSize * boardSize);
		turns = 0;
		board = new char [boardSize][boardSize];
		
		for(int r = 0; r < boardSize; r++) {
			for(int c = 0; c < boardSize; c++) {
				board [r] [c] = ' ';
			}
		}
	}
	
	
	//place this method inside the playMove method.
	public boolean isWinner (char p) {
		//look at for-loops to find counts sets of 3 horizontal, vertical, diagonal 
		while(turns >= (maxTurns/2)) {
			//Row checks 
			return checkRow(board) || columnCheck(board) || diagonalCheck(board);
		}
		
		return false;
	}
	
	public boolean setOfThree(char[] setChecker) {
		boolean fullSet = true;
		char prevChar = ' ';
		for (char character : setChecker) {
			if (prevChar == ' ') {
				prevChar = character;
			}
			if ('O' != character && 'X' != character) {
				fullSet = false;
				break;
			}
			else if (prevChar != character) {
				fullSet = false;
				break;
			}
		}
		return fullSet;
	}
	
	public boolean checkRow(char[][] board) {
		for(int r = 0; r < board.length; r++) {
			if (setOfThree(board[r])) {
				return true;
			}
		}
		return false;
	}
	
	public boolean columnCheck(char[][] board) {
		char [] column = null;
		for(int c = 0; c < board[0].length; c++) {
			column = new char[board[0].length];
			for (int r = 0; r < column.length; r++) {
				column[r] = board[r][c];
			}
			if(setOfThree(column)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean diagonalCheck (char [][] board) {
		int row = 0, col = 0;
		int cols = board.length;
		int rows = board[0].length;
		
		int size = rows < cols ? rows : cols;
		char [] diagonal = new char [size];
		
		while (row < rows && col < cols) {
			diagonal[col] = board[row][col];
		
		
		row++;
		col++;
		}
		if (setOfThree(diagonal)) {
			return true;
		}
		
		row = rows -1;
		col = 0;
		diagonal = new char [size];
		while (row >= 0 && col < cols) {
			diagonal[col] = board[row][col];
			row--;
			col++;
		}
		return setOfThree(diagonal);
	}
	
	public int numTurns() {
		return turns;
	}
	public boolean isFull() {
		if (turns < maxTurns) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean isCat() {
		return false;
	}
	public boolean isValid(int r, int c) {
		if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
			return true;
		}
		else {
			return false;
		}
	}
	public char playerAt(int r, int c) {
		if (isValid(r,c)) {
			return board[r][c];
		}
		else {
			return '@';
		}
	}
	public void playMove(char p, int r, int c) {
		board [r][c] = p;
		turns++;
	}
	
	public void displayScreen() {
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}

}
