import java.io.Serializable;

public class Field implements Serializable {

    public static final char CAN_GO_CHAR = '░';
    public static final char OBSTACLE_CHAR = '¥';
    public static final char PLAYER_1_CHAR = 'B';
    public static final char PLAYER_2_CHAR = 'Q';
    public static final char HUMAN_CHAR = '☻';
    public static final char TRASH_CHAR = '*';

    private int x;
    private int y;
    private boolean canMove;
    private boolean hasItem;
    private char character;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        canMove = false;
        hasItem = false;
        character = OBSTACLE_CHAR;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean canMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean hasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
