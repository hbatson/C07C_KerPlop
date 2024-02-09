package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * Ring is a GamePiece that advances to the next level when it is touched
 *
 * @author Henry Batson
 * @author Benjamin Kaylor
 *
 */
public class Ring extends GamePiece{

	public Ring(int location) {
		super('R', "Ring - (Proceed to next level)", location);
	}

    // Ring advances to the next level when touched
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == this.getLocation()) {
            return InteractionResult.ADVANCE;
        } else {
            return InteractionResult.NONE;
        }
	}

    @test
    public void testRing() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Ring ring = new Ring(10);
        // confirm the ring advances to the next level when touched
        assertEquals(InteractionResult.ADVANCE, ring.interact(gameBoard, 10));
    }

}
