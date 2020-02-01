import java.util.ArrayList;
import java.util.List;

public class Player
{
	private int health;
	private int mana;
	
	private final int minDmg;
	private final int maxDmg;
	
	private final int defence;
	Inventory inv = new Inventory();
	
	public Player(){
		
		minDmg = 1;
		maxDmg = 20;
		defence = 20;
		
		health = 100;
		mana = 100;
		
	}
	
	/**
	 * Checks if the player is still alive
	 * @return true/false depending on the state
	 */
	public boolean isPlayerAlive()
	{
		if(health > 0) return true;
		else return false;
	}

      
    public void heal(Item potion) {
    	this.health =+ 20;
    	inv.remove(potion);
    }
    
    public void addToInventory(String item) {
        inv.addToInventory(item);
    }
    
    public void showInventory() {
        inv.showInventory();
    }
    
    /**
	 * Player uses a basic attack on the enemy.
	 * @return damage numbers
	 */
    public int attack()
	{
		int damage = (int )(Math.random() *15  + 3);
		System.out.println("You have attacked the enemy!");
		System.out.println("You have inflicted " + damage + " points of damage.");
		
		return damage;
		
	}
	/**
	 * Player uses a special attack on the enemy.
	 * It consumes MP.
	 * @return damage numbers
	 */
	public int specialAttack()
	{
		if(mana < 40)
		{
			System.out.println("You don't have enough mana to cast the special attack! You rest.");
			return 0;
		}
		
		int damage = (int )(Math.random() *25  + 7);
		System.out.println("You have attacked the enemy with a special attack!");
		System.out.println("You have inflicted " + damage + " points of damage.");
		mana = mana - 40;
		
		return damage;
		
	}
	
	/**
	 * Player uses a health potion if they have one.
	 * 
	 */
	public void healHP()
	{
		
		int HPPoints = (int )(Math.random() *20  + 45);
		
		System.out.println("You have used a health potion!");
		System.out.println("You have gained " + HPPoints + " health points.");
		
		health = health + HPPoints;
		if(health > 100) health = 100;
		
		inv.remove(potion);
	}
	
	/**
	 * Player uses a MP potion if they have one.
	 * 
	 */
	public void healMP()
	{
		int MPPoints = (int )(Math.random() *20  + 45);
		
		System.out.println("You have used a mana potion!");
		System.out.println("You have gained " + MPPoints + " mana points.");
		
		mana = mana + MPPoints;
		if(mana > 100) mana = 100;
		
		inv.remove(potion);
	}
    
}
 

    
 