package main.map;

import java.io.Serializable;

public class Field implements Serializable {

    public static final char CAN_GO_CHAR = '.';
    public static final char OBSTACLE_CHAR = 'O';
    public static final char PLAYER_1_CHAR = '1';
    public static final char PLAYER_2_CHAR = '2';
    public static final char HUMAN_CHAR = 'H';
    public static final char TRASH_CHAR = '#';

    private int x;
    private int y;
    private boolean hasItem;
    private char character;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        hasItem = false;
        character = OBSTACLE_CHAR;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public boolean canMove() {
        switch (character) {
            case CAN_GO_CHAR: case TRASH_CHAR: case HUMAN_CHAR:
                return true;
            default:
                return false;
        }
    }
}
