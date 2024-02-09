package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * Wizard is a GamePiece that moves away from the player and gives them a point if they land on it
 *
 * @author Henry Batson
 * @author Benjamin Kaylor
 *
 */
public class Wizard extends GamePiece implements Moveable{

	public Wizard(int location) {
		super('W', "Wizard - (Special character)", location);
	}

    // gives the player a point if they land on the wizard
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == this.getLocation()) {
            return InteractionResult.GET_POINT;
        } else {
            return InteractionResult.NONE;
        }
	}

    // moves away from the player when close
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int newLocation = getLocation();
		
		if (Math.abs(playerLocation - getLocation()) <= 2) {
			if(playerLocation > getLocation() && getLocation() > 0) {
				newLocation = getLocation() - 1;
			}
			else if(playerLocation < getLocation() && getLocation() < GameEngine.BOARD_SIZE - 1) {
				newLocation = getLocation() +1;
			}
		}
        gameBoard[getLocation()] = null;
		setLocation(newLocation);
		gameBoard[newLocation] = this;
	}

    /*
     * Test that the wizard gives the player a point when landed on
     */
    @test
    public void testWizard() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wizard wizard = new Wizard(10);
        // confirm the wizard gives the player a point when landed on
        assertEquals(InteractionResult.GET_POINT, wizard.interact(gameBoard, 10));
    }

    /*
     * Test that the wizard moves away from the player when close
     */
    @test
    public void testWizardMove() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wizard wizard = new Wizard(10);
        // confirm the wizard moves away from the player when close
        wizard.move(gameBoard, 9);
        assertEquals(null, gameBoard[10]);
        assertEquals(wizard, gameBoard[11]);
    }
}
