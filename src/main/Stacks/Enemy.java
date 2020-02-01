package main.Stacks;

import java.util.Stack;

public class Enemy {

	private int health;
	private int mana;


	private Stack actionQueue;
	
	public Enemy() {
		// TODO Auto-generated constructor stub
		health = 100;
		mana = 50;
		
	}
	
	/**
	 * Checks if the enemy is still alive
	 * @return true/false depending on the state
	 */
	public boolean isEnemyAlive()
	{
		if(health > 0) return true;
		else return false;
	}

	
	/**
	 * Returns health of the enemy
	 * @return health status
	 */
	public int getEnemyHealth() {
		return health;
	}
	
	
	public void setHealth(int health)
	{
		this.health = health;
	}

	/**
	 * Returns MP status of the enemy
	 * @return MP status
	 */
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	/**
	 * Enemy uses a basic attack on the player.
	 * @return damage numbers
	 */
	public int attack()
	{
		int damage = (int )(Math.random() *10  + 1);
		System.out.println("Enemy has attacked you!");
		System.out.println("Enemy has inflicted " + damage + " points of damage.");
		
		return damage;
		
	}
	
	/**
	 * Enemy uses a special attack on the player.
	 * @return damage numbers
	 */
	public int specialAttack()
	{
		int damage = (int )(Math.random() *20  + 5);
		System.out.println("Enemy has used a special attack on you!");
		System.out.println("Enemy has inflicted " + damage + " points of damage.");
		
		return damage;
		
	}
	
	/**
	 * Enemy heals their health points.
	 * @return healed HP points
	 */
	public int healHP()
	{
		int HPPoints = (int )(Math.random() *15  + 40);
		
		System.out.println("Enemy has used a health potion!");
		System.out.println("Enemy has gained " + HPPoints + " health points.");
		
		return HPPoints;
	}
	
	/**
	 * Enemy heals their mana points.
	 * @return healed MP points
	 */
	public int healMP()
	{
		int MPPoints = (int )(Math.random() *15  + 40);
		
		System.out.println("Enemy has used a mana potion!");
		System.out.println("Enemy has gained " + MPPoints + " mana points.");
		
		return MPPoints;
	}
	

}
