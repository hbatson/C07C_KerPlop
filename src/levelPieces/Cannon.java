package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * Cannon is a GamePiece that can shoot and damage the player from range
 *
 * @author Henry Batson
 * @author Benjamin Kaylor
 *
 */
public class Cannon extends GamePiece{

	public Cannon(int location) {
		super('C', "Cannon - (Can shoot and damage you)", location);
	}

    // Cannon shoots any player within 3 spaces
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
