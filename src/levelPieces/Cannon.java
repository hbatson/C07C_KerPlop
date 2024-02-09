package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import jdk.jfr.Timestamp;

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

    /*
     * Test that the cannon can shoot the player
     */
    @test
    public void testCannon() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Cannon can = new Cannon(3);
        // confirm the cannon interacts with spaces within 3 spaces
        for (int i = 0; i < 7; i++) {
            assertEquals(InteractionResult.HIT, can.interact(gameBoard, i));
        }
        // confirm the cannon does not interact with spaces outside of 3 spaces
        for (int i = 7; i < GameEngine.BOARD_SIZE; i++) {
            assertEquals(InteractionResult.NONE, can.interact(gameBoard, i));
        }
    }
}
