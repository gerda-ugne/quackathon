import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player
{
	private int health;
	private int mana;

	Inventory inv = new Inventory();
	
	public Player(){
		
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
    	Random rand = new Random();
		int damage = rand.nextInt(20);
		System.out.println("You pinch the human with your beak!");
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
		Random rand = new Random();
		if(mana < 40)
		{
			System.out.println("You don't have enough energy to cast the special attack! You rest.");
			return 0;
		}
		
		int damage = rand.nextInt(50);
		System.out.println("You furiously flap your wings at the human, inflicting serious damage!");
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
		boolean isPotionReal = false;
		isPotionReal = inv.remove("HP Potion");
		
		if(isPotionReal == true)
		{
			int HPPoints = 40;
			
			System.out.println("You had a crunchy worm with a rock. You feel restored!");
			System.out.println("You have gained " + HPPoints + " health points.");
			
			health = health + HPPoints;
			if(health > 100) health = 100;
		}
		else
		{
			System.out.println("You do not have any snacks left! You rest.");
		}

	}
	
	/**
	 * Player uses a MP potion if they have one.
	 * 
	 */
	public void healMP()
	{
		boolean isPotionReal = false;
		isPotionReal = inv.remove("MP Potion");
		
		
		if(isPotionReal == true)
		{
			int MPPoints = 50;
			
			System.out.println("You have used your wax for a power up!");
			System.out.println("You have gained " + MPPoints + " mana points.");
			
			mana = mana + MPPoints;
			if(mana > 100) mana = 100;
			
		}
		else
		{
			System.out.println("You do not have any wax left! You rest.");
		}
	}
	
	/**
	 * Executes choices that player has made by calling appropriate methods
	 * @param recordedMoves - moves the player chose
	 * @return damage - returns damage done to the enemy in total
	 */
	public int execute(String recordedMoves)
	{
		String [] splitString = recordedMoves.split(" ");
		
		//Variables to record the difference after the moves are done
		int damage = 0;
		
		for(int i=0; i<splitString.length; i++)
		{
				switch(splitString[i])
				{
				case "1": damage = damage + attack(); break;
				case "2": damage = damage + specialAttack(); break;
				case "3": healHP(); break;
				case "4": healMP(); break;
				
				}
		}
		
		return damage;
	}
	
	public void flee()
	{
		System.out.println("You've chosen to flee! You take off and fly away with your stash of plastic bags.");
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
    
}
 

    
 