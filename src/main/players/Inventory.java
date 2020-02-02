import java.util.ArrayList;

public class Inventory
{
    private ArrayList<String> inventory;
    private int capacity;

    public Inventory() {
        capacity = 10;
        this.inventory = new ArrayList<String>();
        
        inventory.add("HP Potion");
        inventory.add("HP Potion");
        inventory.add("MP Potion");
        inventory.add("MP Potion");
    }

    public void addToInventory(String item) {
        if (inventory.size() < capacity) {
            inventory.add(item);
        } else System.out.println("Inventory is full!");
    }

    public void showInventory() {
        System.out.println("Inventory:");
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
    	boolean itemFound = false;
    	
        for (int i = 0;  i<inventory.size(); i++){
            String tempName = inventory.get(i);
            if(tempName.equals(itemName)){
                inventory.remove(i);
                itemFound = true;
                return true;
            }
        }
        
        return false;
        
    }
}