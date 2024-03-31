/**
 * Class Player defines all of the players properties/attributes and behaviours (things that it can perform)
 * @author Jeremy Ro
 */

package BridgeBuilderAdv;

public class Player {
	
	private char token;
	private int score;
	
	// constructor
	// Initialize the token and score

	/**
	 * method player constructs/initializes variables token and score
	 */
	public Player() {
		token = '+';
		score = 0;
				
	}
	
	// Place the player's token on the game board at the specified row and column.
	/**
	 * calls the makeMove method, this takes in the input of the player and places player token '+' in the specified spot
	 * @param board
	 * @param row
	 * @param col
	 */
	public void makeMove(GameBoard board, int row, int col) {
		if (board.isPositionEmpty(row, col)) {
			board.placeToken(row, col, token);
		}
	}
	
	/**
	 * returns token
	 * @return
	 */
	public char getToken() {
		return token;
	}
	
	/**
	 * returns score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * increases the score by a specific increment
	 * @param increment
	 */
	public void addScore(int increment) {
		score = score + increment;
	}
	
	
}
