import java.util.Scanner;

public class Main {

	private Map map;
	private Enemy enemy;
	private Player player;
	
	
	public Main() {
		// TODO Auto-generated constructor stub
		map = new Map();
		enemy = new Enemy();
		player = new Player();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main myTest = new Main();
		myTest.test();
		

	}
	
	public void test()
	{
		map.displayMap();
	}
	
	public void showCombatOptions()
	{
		System.out.println("1. Attack");
		System.out.println("2. Use a special attack");
		System.out.println("3. Use a HP potion");
		System.out.println("4. Use a MP potion");
		System.out.println("0. Flee");
		
	}
	
	public void combat()
	{
		System.out.println("You have encountered an enemy!");
		Scanner s = new Scanner(System.in);
		String userInput;
		String enemyInput;
		
		//Only one move of the same kind permitted per turn
		int attackLimit = 0;
		int specialAttackLimit=0;
		int healHPLimit = 0;
		int healMPLimit = 0;
		
		do {
			
			//Player has their turn first
			for (int i=0; i<2; i++)
			{
				System.out.println("Please choose your next move:");
				if(i == 1) 	System.out.println("You have 1 move left.");
				else System.out.println("You have " + i + " moves left.");
				
				showCombatOptions();
				
				switch(userInput)
				{
				case "1": player.attack();attackLimit++; break;
				case "2": player.specialAttack(); specialAttackLimit++; break;
				case "3": player.healHP(); healHPLimit++; break;
				case "4": player.healMP(); healMPLimit++; break;
				case "0": player.flee();break;
				}
				
			}
			
			//Enemy has their turn		
			for (int i=0; i<2; i++)
			{
				System.out.println("Enemy has their turn!");
				int random = (int )(Math.random() * 4 + 1);
				enemyInput = Integer.toString(random);
				
				switch(enemyInput)
				{
				case "1": enemy.attack();attackLimit++; break;
				case "2": enemy.specialAttack(); specialAttackLimit++; break;
				case "3": enemy.healHP(); healHPLimit++; break;
				case "4": enemy.healMP(); healMPLimit++; break;
				}
				
			}
			
			
			
		} while(enemy.isEnemyAlive() == false || player.isPlayerAlive() == false);
	}

}

