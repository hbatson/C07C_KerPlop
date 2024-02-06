package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Owl extends GamePiece implements Moveable{

	public Owl(int location) {
		super('o', "Flies around board", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;
	}

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
