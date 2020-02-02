package main.players;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable
{
    public static final String NUTRIENTS = "Nutrients - Use these when you're low on health";
    public static final String WAX = "Wax - Wax restores your energy levels!";
    private List<String> inventory;
    private int capacity;

    public Inventory() {
        capacity = 10;
        this.inventory = new ArrayList<>();
        
        inventory.add(NUTRIENTS);
        inventory.add(NUTRIENTS);
        inventory.add(WAX);
        inventory.add(WAX);
    }

    public void addToInventory(String item) {
        if (inventory.size() < capacity) {
            inventory.add(item);
        } else System.out.println("Inventory is full!");
    }

    public void showInventory() {
        System.out.println("Here's your inventory:");
        for (String item : inventory) {
            System.out.println(item);
        }
        
        if(inventory.size() == 0) System.out.println("Your inventory is empty!");
    }
    
    /**
     * Removes an item from the inventory
     * @param itemName - removed item name
     * @return true if item is not on the inventory
     */
    public boolean remove(String itemName)
    {

        for (int i = 0;  i<inventory.size(); i++){
            String tempName = inventory.get(i);
            if(tempName.equals(itemName)){
                inventory.remove(i);
                return true;
            }
        }
        
        return false;
        
    }

    /**
     *Resets the inventory
     */
    public void resetInventory()
    {
        this.inventory = new ArrayList<>();
    }
}