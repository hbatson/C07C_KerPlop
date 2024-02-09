package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import jdk.jfr.Timestamp;

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

    // the groundhog moves to a random open board space
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

    /*
     * Test that the groundhog kills the player on the same board space
     */
    @test
    public void testGroundhogHit() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Groundhog ground = new Groundhog(10);
        // confirm the groundhog kills the player on the same board space
        assertEquals(InteractionResult.KILL, ground.interact(gameBoard, 10));
        // confirm the groundhog does not kill the player on a different board space
        for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
            if (i != 10) {
                assertEquals(InteractionResult.NONE, ground.interact(gameBoard, i));
            }
        }
    }

    @test
    public void testGroundhogMove() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Groundhog ground = new Groundhog(10);
        // confirm the groundhog moves to a different board space
        ground.move(gameBoard, 0);
        assertEquals(null, gameBoard[10]);
        assertEquals(ground, gameBoard[ground.getLocation()]);
    }
}
