package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Groundhog;
import levelPieces.Owl;
import levelPieces.Wizard;

/**
 * Test Moving Pieces: Tests to ensure that pieces move as expected. Tests for 
 * random piece movement and movement based on player location.
 * 
 * @author Henry Batson
 * @author Ben Kaylor
 */
public class TestMovingPieces {

	@Test
    public void testGroundhogMove() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Groundhog ground = new Groundhog(10);
        // confirm the groundhog moves to a different board space
        ground.move(gameBoard, 0);
        assertEquals(null, gameBoard[10]);
        assertEquals(ground, gameBoard[ground.getLocation()]);
    }
	
	@Test
    public void testOwnMove() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Owl owl = new Owl(10);
        // confirm the owl moves to a random empty board space
        owl.move(gameBoard, 0);
        assertEquals(null, gameBoard[10]);
        assertEquals(owl, gameBoard[owl.getLocation()]);
    }
	
	/*
     * Test that the wizard moves away from the player when close
     */
    @Test
    public void testWizardMove() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wizard wizard = new Wizard(10);
        // confirm the wizard moves away from the player when close
        wizard.move(gameBoard, 9);
        assertEquals(null, gameBoard[10]);
        assertEquals(wizard, gameBoard[11]);
    }
}
