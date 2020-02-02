
import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    public static final String HP_POTION = "HP Potion";
    public static final String MP_POTION = "MP Potion";
    private List<String> inventory;
    private int capacity;

    public Inventory() {
        capacity = 10;
        this.inventory = new ArrayList<>();
        
        inventory.add(HP_POTION);
        inventory.add(HP_POTION);
        inventory.add(MP_POTION);
        inventory.add(MP_POTION);
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