package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Tree extends GamePiece{
	
	public Tree(int location) {
		super('T', "Tree - (Adds scenery. Does nothing)", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;
	}

}
