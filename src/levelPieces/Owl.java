package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * Owl is a GamePiece that flies around the board
 * 
 * @author Henry Batson
 * @author Benjamin Kaylor
 *
 */
public class Owl extends GamePiece implements Moveable{

	public Owl(int location) {
		super('o', "Owl - (Flies around board)", location);
	}

    // owl does nothing
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;
	}

    // owl moves to a random board space that is empty
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

    @test
    public void testOwlInteract() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Owl owl = new Owl(10);
        // confirm the owl does nothing
        assertEquals(InteractionResult.NONE, owl.interact(gameBoard, 10));
    }

    @test
    public void testOwnMove() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Owl owl = new Owl(10);
        // confirm the owl moves to a random empty board space
        owl.move(gameBoard, 0);
        assertEquals(null, gameBoard[10]);
        assertEquals(owl, gameBoard[owl.getLocation()]);
    }
}
