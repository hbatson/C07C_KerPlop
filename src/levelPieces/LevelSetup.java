package levelPieces;

import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
    private int levelNum;
    private Drawable[] board;
    private ArrayList<Moveable> movingPieces;
    private ArrayList<GamePiece> interactingPieces;
    private int playerStartLoc;
    
    public LevelSetup(int levelNum) {
        this.levelNum = levelNum;
        this.board = new Drawable[21];
        this.movingPieces = new ArrayList<Moveable>();
        this.interactingPieces = new ArrayList<GamePiece>();
        System.out.println("Level " + levelNum + " Legend:");
        System.out.println("  P - Player (you)");
    }

    public void createLevel(int levelNum) {
        // TODO Auto-generated method stub
    }

    public Drawable getBoard() {
        return this.board;
    }

    public Moveable[] getMovingPieces() {
        return this.movingPieces;
    }

    public GamePiece[] getInteractingPieces() {
        return this.interactingPieces;
    }

    public int getPlayerStartLoc() {
        return this.playerStartLoc;
    }
}
