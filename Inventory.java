import java.util.ArrayList;

public class Inventory
{
    private ArrayList<String> inventory;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.inventory = new ArrayList<String>();
    }

    public void addToInventory(String item) {
        if (inventory.size() < capacity) {
            inventory.add(item);
        } else System.out.println("Inventory is full!");
    }

    public void showInventory() {
        System.out.println("\nInventory:");
        for (String item : inventory) {
            System.out.println(item);
        }
    }
}
