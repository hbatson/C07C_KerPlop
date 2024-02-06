package levelPieces;

import gameEngine.Drawable;

public class Tree implements Drawable{
	
	private char symbol;
	private int location;
	
	public Tree(int location) {
		this.location = location;
		this.symbol = 'T';
	}

	@Override
	public void draw() {
		System.out.println(symbol);
	}
	
	public int getLocation() {
		return location;
	}
	
}
