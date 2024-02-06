package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * Groundhog is a GamePiece that kills the player if they land on it
 * The groundhog moves to a random location on the board
 *
 * @author Henry Batson
 * @author Benjamin Kaylor
 *
 */
public class Groundhog extends GamePiece implements Moveable{

	public Groundhog(int location) {
		super('G', "Groundhog - (Can kill you)", location);
	}

    // the groundhog kills the player if on the same board space
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == this.getLocation()) {
            return InteractionResult.KILL;
        } else {
            return InteractionResult.NONE;
        }
	}

    // the groundhog moves to a random board space
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random rand = new Random();
		int newLocation;
		do {
			newLocation = rand.nextInt(GameEngine.BOARD_SIZE);
		}
		while (gameBoard[newLocation] != null && newLocation != playerLocation);
		
		gameBoard[getLocation()] = null;
		setLocation(newLocation);
		gameBoard[newLocation] = this;
	}
}
