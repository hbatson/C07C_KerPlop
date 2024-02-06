package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Cannon extends GamePiece{

	public Cannon(int location) {
		super('C', "Cannon - (Can shoot and damage you)", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - getLocation()) <= 3) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
}
