package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.Cannon;
import levelPieces.Groundhog;
import levelPieces.Owl;
import levelPieces.Ring;
import levelPieces.Wizard;
import gameEngine.GameEngine;

/**
 * Test Interactions: Tests all pieces that interact with the player, ensuring
 * that the expected interaction result matches with the interaction seen
 * 
 * @author Henry Batson
 * @author Ben Kaylor
 */
public class TestInteractions {
	/*
     * Test that the cannon can shoot the player
     */
    @Test
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
    
    /*
     * Test that the groundhog kills the player on the same board space
     */
    @Test
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
    
    @Test
    public void testOwlInteract() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Owl owl = new Owl(10);
        // confirm the owl does nothing
        assertEquals(InteractionResult.NONE, owl.interact(gameBoard, 10));
    }
    
    @Test
    public void testRing() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Ring ring = new Ring(10);
        // confirm the ring advances to the next level when touched
        assertEquals(InteractionResult.ADVANCE, ring.interact(gameBoard, 10));
    }
    
    @Test
    public void testWizard() {
        Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Wizard wizard = new Wizard(10);
        // confirm the wizard gives the player a point when landed on
        assertEquals(InteractionResult.GET_POINT, wizard.interact(gameBoard, 10));
    }
}
