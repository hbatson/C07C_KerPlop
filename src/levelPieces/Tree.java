package levelPieces;

import gameEngine.Drawable;

/**
 * Tree is a drawable piece on the board that does not interact with the player
 *
 * @author Henry Batson
 * @author Benjamin Kaylor
 *
 */
public class Tree implements Drawable{
	
	private char symbol;
	private int location;
	
	public Tree(int location) {
		this.location = location;
		this.symbol = 'T';
	}

    // tree implements abstract draw
	@Override
	public void draw() {
		System.out.print(symbol);
	}
	
	public int getLocation() {
		return location;
	}
	
}
