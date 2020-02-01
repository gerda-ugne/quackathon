package main.map;

public class Field {

    private boolean canGo;
    private boolean hasItem;

    public Field(boolean canGo, boolean hasItem) {
        this.canGo = canGo;
        this.hasItem = hasItem;
    }

    public boolean isCanGo() {
        return canGo;
    }

    public boolean isHasItem() {
        return hasItem;
    }
}
