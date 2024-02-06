package levelPieces;

import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
    private gameEngine.Drawable[] board;
    private ArrayList<Moveable> movingPieces;
    private ArrayList<GamePiece> interactingPieces;
    private int playerStartLoc;
    
    public void createLevel(int levelNum) {
        this.board = new gameEngine.Drawable[gameEngine.GameEngine.BOARD_SIZE];
        this.movingPieces = new ArrayList<Moveable>();
        this.interactingPieces = new ArrayList<GamePiece>();
        System.out.println("Level " + levelNum + " Legend:");
        System.out.println(" P - Player (you)");
        this.playerStartLoc = 10;
        if (levelNum == 1) {
            Owl owl = new levelPieces.Owl(0);
            board[0] = owl;
            interactingPieces.add(owl);
            movingPieces.add(owl);
            Tree tree = new levelPieces.Tree(5);
            board[5] = tree;
            Wizard wizard = new levelPieces.Wizard(15);
            board[15] = wizard;
            interactingPieces.add(wizard);
            movingPieces.add(wizard);
            Ring ring = new levelPieces.Ring(1);
            board[1] = ring;
            interactingPieces.add(ring);
            System.out.println(" " + owl);
            System.out.println(" " + tree);
            System.out.println(" " + wizard);
            System.out.println(" " + ring);
            System.out.println("");
        } else if (levelNum == 2) {
            Cannon cannon = new levelPieces.Cannon(0);
            board[0] = cannon;
            interactingPieces.add(cannon);
            Groundhog groundhog = new levelPieces.Groundhog(11);
            board[11] = groundhog;
            interactingPieces.add(groundhog);
            movingPieces.add(groundhog);
            Tree tree = new levelPieces.Tree(5);
            board[5] = tree;
            Ring ring = new levelPieces.Ring(20);
            board[20] = ring;
            interactingPieces.add(ring);
            System.out.println(" " + cannon);
            System.out.println(" " + groundhog);
            System.out.println(" " + tree);
            System.out.println(" " + ring);
        }
    }

    public gameEngine.Drawable[] getBoard() {
        return this.board;
    }

    public ArrayList<Moveable> getMovingPieces() {
        return this.movingPieces;
    }

    public ArrayList<GamePiece> getInteractingPieces() {
        return this.interactingPieces;
    }

    public int getPlayerStartLoc() {
        return this.playerStartLoc;
    }
}
