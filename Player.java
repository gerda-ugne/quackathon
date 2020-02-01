import java.util.ArrayList;
import java.util.List;

public class Player
{
	private String name;
	private String [] coordinates;
	private int hp;
	private int mp;
	private final int minDmg;
	private final int maxDmg;
	private final int defence;
	private boolean alive = true;
	Inventory inv = new Inventory(10);
	
	public String getName() {
        return name;
    }
        
    public void setName(String name) {
    	this.name = name;
    }
 
    public String[] getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;    
    }
    
    public Player(String name) {
    	
    	
    }
      
    public void heal(Item potion) {
    	this.hp =+ 20;
    	inv.remove(potion);
    }
    
    public void addToInventory(String item) {
        inv.addToInventory(item);
    }
    
    public void showInventory() {
        inv.showInventory();
    }
    
}
 
/**
    public void defence(Enemy enemy)
    {
    	do
    	{
    		
    	}
    	
    }
    
*/
 