
public class Enemy {

	private int health;
	private int mana;
	
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
	 * It consumes mana.
	 * @return damage numbers
	 */
	public int specialAttack()
	{
		if (mana < 40)
		{
			System.out.println("Enemy does not have enough MP to cast a special attack. They rest.");
			return 0;
		}
		int damage = (int )(Math.random() *20  + 5);
		System.out.println("Enemy has used a special attack on you!");
		System.out.println("Enemy has inflicted " + damage + " points of damage.");
		
		mana = mana - 40;
		
		return damage;
		
	}
	
	/**
	 * Enemy heals their health points.
	 * 
	 */
	public void healHP()
	{
		int HPPoints = (int )(Math.random() *15  + 40);
		
		System.out.println("Enemy has used a health potion!");
		System.out.println("Enemy has gained " + HPPoints + " health points.");
		
		health = health + HPPoints;
	}
	
	/**
	 * Enemy heals their mana points.
	 * 
	 */
	public void healMP()
	{
		int MPPoints = (int )(Math.random() *15  + 40);
		
		System.out.println("Enemy has used a mana potion!");
		System.out.println("Enemy has gained " + MPPoints + " mana points.");
		
		mana = mana + MPPoints;
	}
	

	/**
	 * Executes choices that enemy AI has made by calling appropriate methods
	 * @param recordedMoves - randomly generated 
	 * @return damage - returns damage done to the player in total
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
	
}
