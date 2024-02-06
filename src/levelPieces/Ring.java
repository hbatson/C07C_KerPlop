package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Ring extends GamePiece{

	public Ring(int location) {
		super('R', "Ring - (Proceed to next level)", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.ADVANCE;
	}

}
