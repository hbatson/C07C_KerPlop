package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Wizard extends GamePiece implements Moveable{

	public Wizard(char symbol, String label, int location) {
		super('W', "Special character", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.GET_POINT;
	}

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
		setLocation(newLocation);
		gameBoard[newLocation] = this;
	}
}
