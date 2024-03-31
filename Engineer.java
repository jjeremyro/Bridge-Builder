/**
 * This class represents the Engineer, all of their properties and behaviours
 * @author jeremyro
 */

package BridgeBuilderAdv;
import java.util.random.*;

public class Engineer {

	private char token;
	private boolean hardMode;
	
	/**
	 * Constructor method that initializes and sets the hardMode
	 * @param hardMode
	 */
	public Engineer(boolean hardMode) {
		token = '0';
		this.hardMode = hardMode;
	}
	
	/**
	 * This method makes a move on the game board at a position determined by the Engineer's strategy. Engineer attempts to block off player by using rightwards and top-down blocking
	 * @param board
	 * @param playerLastRow
	 * @param playerLastCol
	 */
	public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
		
		while(true) {
			if (hardMode == false) {
				int randRow = (int)(Math.random() * (board.getSize())); // generates a random integer and stores in randRow for future use
				int randCol = (int)(Math.random() * (board.getSize())); // generates a random integer and stores in randCol for future use
				if (board.isPositionEmpty(randRow, randCol)) { // if the board is empty at the specified spot in the matrix, then the players token will be placed there
					board.placeToken(randRow, randCol, token);
					break;
				}
				
			} else { // if the board is not empty at the specified row/column...
			
				int tempRow = playerLastRow; // holds temporary variables so that we can keep the values of original playerLastRow for later use
				int tempCol = playerLastCol + 1;
				while(!board.isPositionEmpty(tempRow, tempCol) && board.getSize() > tempCol) {
					tempCol++;
				}
				
				if (board.isPositionEmpty(tempRow, tempCol)) { // if the board is empty at the temp spot, then the engineer token is placed in that spot
					board.placeToken(tempRow, tempCol, token);
					return;
				}
				
				tempRow = playerLastRow + 1;
				tempCol = playerLastCol;
				while(!(board.isPositionEmpty(tempRow,  tempCol)) && board.getSize() > tempRow) { // loops while the board is empty at position tempRow and tempCol
					tempRow++; // adds 1 to temp row to move down the rows
				}
				if (board.isPositionEmpty(tempRow,    tempCol)) { // if the board position is empty 
					board.placeToken(tempRow, tempCol, token);
					return;
				}	
			}
		}
	}
	
	/**
	 * returns the token
	 * @return token
	 */
	public char getToken() {
		return token;
	}
	
	
}
