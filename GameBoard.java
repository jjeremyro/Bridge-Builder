
	/**
	 * GameBoard class represents blueprint of what the gameboard will look like and its behaviours
	 * @author Jeremy Ro
	 */

/**
 * 150 Word Logic Explanation
 * 
 * - GameBoard.java - This class represents the gameboard where our game is going to be played on. In this class we have fields and methods such as the following:
 * Gameboard constructor: This method will take the size inputted by user and create an empty 2D array which represents the empty gameboard that will be played on.
 * placeToken(): This method simply places object token on the specified coordinate, isPositionEmpty(): This method simply returns true if the specified coordinate
 * has a '.' already occupying it in our 2D array, getSize(): simply returns the field size, displayBoard(): In this method we iterate through each column in each
 * row by using a nested for loop, and simply print the object board which is == '.', checkForWinDirection() & checkForTie(): This method was a little trickier to implement than
 * all of the other methods as there were more than possibility for a win. Similar to checkForWinDirection() and displayBoard(), we have to iterate through each
 * column of each row by using for loops to check if the conditions are met.
 * 
 * - Engineer - This class represents the engineer aka the algorithm that will attempt to block the path of the player. The hardest method in this class would easily
 * be the makeMove method. To implement this, we had to check for different possibilities such as if the coordinate was empty or if the coordinate was taken by the
 * player. If it was, we would have to place the token to the right of that, and if the coordinate to the right of that was taken as well, we would place a token on 
 * the coordinate above that, etc...
 * 
 * - Player - This class represents the player. This was by far the easiest class to implement. To place a token we simply used the isEmpty() method and if it was
 * empty, then a token was placed in that coordinate.
 */

package BridgeBuilderAdv;

public class GameBoard {
	
	char[] alphabetList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); // Alphabet char array to hold alphabets representing each column
	char[] numbersList = "0123456789".toCharArray(); // char numbersList to hold each integer representing rows
	private char[][] board;
	private int size;
	
	/**
	 * This is a constructor method that initializes the board to a 2D char array with '.' for empty positions.
	 * @param size
	 */
	public GameBoard(int size) { 
		
		this.board = board;
		this.size = size;
		this.board = new char[size][size]; // initializing a new board 2D array object
		
		for (int row = 0; row < size; row++) { // iterates through rows
            for (int col = 0; col < size; col++) { // nested for loop to iterate through columns of matrix 
                board[row][col] = '.'; // assigns each empty space '.'
            }
        }
    }
		
	/**
	 * This method places the given token at the specified row and column on the game board.
	 * @param row
	 * @param col
	 * @param token
	 */

	public void placeToken(int row, int col, char token) {
		
		board[row][col] = token; // assigns each empty space inputted token
		
	}
	
	
	/**
	 * Checks whether the specified position on the board is empty (denoted by '.').
	 * @param row
	 * @param col
	 * @return whether isPositionEmpty is true or false
	 */
	
	public boolean isPositionEmpty(int row, int col) {
		if (board[row][col] == '.') { // if the space [row][col] is == '.' then return true or else we return false
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the size of the game board
	 * @return size of board
	 */
	
	public int getSize() {
		return size; // returns size
	}

	/**
	 * Prints the game board on the console, including row and column numbers.
	 */
	public void displayBoard() {
		
		System.out.print("  "); // added one more space
		
		
		System.out.println();
		
		for (int row = 0; row < size; row++) { // iterates through each row
			
			System.out.print(row + " "); // added + " ".
			
	        for (int col = 0; col < size; col++) { // iterates through each column
	        	System.out.print(board[row][col] + " ");
	        }
	        System.out.println();
		}
		
	}
	
	
	// 
	/**
	 * Checks whether the player has won the game in any direction
	 * @param player
	 * @return Returns 1 for left-to-right, 2 for bottom-to-top, 3 for diagonal, and 0 for no win
	 */
	
	public int checkForWinDirection(Player player) {
		
		// check for left -> right win
		for (int row = 0; row < size; row++) { // iterates through each row 
			
			boolean win = true; // assigning variable win = true so that when it isn't true, then we turn it false
			
			for (int col = 0; col < size; col++) { // iterates through each column
				if(board[row][col] != '+') { // if the specified spot on matrix is not the player token '+', then it doesn't result in a win
					win = false;
				}
			}
			
			if (win == true) { // if win is true then returns number 1
				return 1;
			}
		}
		
		// check for top -> bottom win
		for (int row = 0; row < size; row++) { // iterates through rows
			
			boolean win = true;
			
			for (int col = 0; col < size; col++) { // iterates through each column in each row
				if(board[col][row] != '+') {
					win = false;
				}
			}
			
			if (win == true) {
				return 2;
			}
		}
		
		// check for diagonal win
		boolean win = true;
		for (int diagonalCoordinates = 0; diagonalCoordinates < size; diagonalCoordinates++) { // since this is actually a straight line and because the shape of matrix is a square, both row and column will be the same. Hence why we can use only one for loop
			
			if(board[diagonalCoordinates][diagonalCoordinates] != player.getToken()) { // when the diagonal Coordinate is not equal to the players token, this results in a loss
				win = false;
				
			}
		}
	
		if(win == true) {
			
			return 3;
			
		}
		
		return 0;
		
	}
	
	/**
	 * Checks whether the game board is full, indicating a tie.
	 * @return true if gameboard is full and false if gameboard contains '.'
	 */
	public boolean checkForTie() {
		for (int row = 0; row < size; row++) { // iterates through each row
			for (int col = 0; col < size; col++) { // iterates through each column in each row
				if (board[row][col] == '.') { // if the specified spot on the matrix is == '.' then return false
					return false;
				}
			}
		}
		
		return true;
	
	}
	
	
}
