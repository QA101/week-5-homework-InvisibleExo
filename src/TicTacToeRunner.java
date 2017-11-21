import java.util.Scanner;

public class TicTacToeRunner {
	//Future Designs: Maybe create an object to use arrow key input to place char in cell importing keylistener Class?
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		char p = 'X';
		TicTacToeClass game1 = new TicTacToeClass();
		int r, c;
		
		while (! (game1.isWinner('X') || game1.isWinner('O') || game1.isFull()) ) {
			game1.displayScreen();
			
			System.out.println("'" + p + "' , pick your cell (row, column):");
			System.out.println("Turn : " + (game1.numTurns()+1));
			r = keyboard.nextInt();
			c = keyboard.nextInt();
			while (validCell(game1, r, c)) {
				System.out.println("Pick your cell (row, column):");
				r = keyboard.nextInt();
				c = keyboard.nextInt();
			}
			 game1.playMove(p, r, c);
			 p = switchPlayer(game1, p);
		}
		game1.displayScreen();
		
		
		if (game1.isFull() == true) {
			System.out.println("The match is a tie.");
		}
		else {
			System.out.println(p + " is the winner!!!");
		}
		
		keyboard.close();
	}
	
	public static boolean validCell(TicTacToeClass game, int r, int c) {
		if (game.isValid(r, c) == false) {
			System.out.println("This is location is not within the board. Try again.");
			return true;
		}
		else if (game.playerAt(r, c) != ' ') {
			System.out.println("This is a location has already been filled.");
			return true;
		}
		return false;
	}
	public static char switchPlayer(TicTacToeClass game, char p) {
		if (game.isWinner('X') == true || game.isWinner('O') == true){
			return p;
		}
		if (p == 'X') {
			p = 'O';
			return p;
		}
		else {
			p = 'X';
			return p;
		}
	}
}
