package levelPieces;

import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
    private int levelNum;
    private gameEngine.Drawable[] board;
    private ArrayList<Moveable> movingPieces;
    private ArrayList<GamePiece> interactingPieces;
    private int playerStartLoc;
    
    public LevelSetup() {
    }

    public void createLevel(int levelNum) {
        this.levelNum = levelNum;
        this.board = new gameEngine.Drawable[gameEngine.GameEngine.BOARD_SIZE];
        this.movingPieces = new ArrayList<Moveable>();
        this.interactingPieces = new ArrayList<GamePiece>();
        System.out.println("Level " + levelNum + " Legend:");
        System.out.println("  P - Player (you)");
        if (levelNum == 1) {
            Owl owl = new levelPieces.Owl(0);
            Tree tree = new levelPieces.Tree(5);
            Wizard wizard = new levelPieces.Wizard(15);
            System.out.println(" " + owl);
            System.out.println(" " + tree);
            System.out.println(" " + wizard);
            System.out.println("");
        } else if (levelNum == 2) {
            
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
