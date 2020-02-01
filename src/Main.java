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
		System.out.println("1. Peck the human with your beak.");
		System.out.println("2. Unleash a flapping attack [Special attack]");
		System.out.println("3. Have a crunchy worm with a rock [Heal up]");
		System.out.println("4. Use your wax to restore your powers [Restore MP]");
		System.out.println("0. Flee");
		
	}
	
	public void combat()
	{
		System.out.println("You have encountered a human, and they seem to be polluting the lake!");
		Scanner s = new Scanner(System.in);
		String userInput;
		String enemyInput;
		
		String recordedUserMoves = "";
		String recordedEnemyMoves = "";

		//Records damage enemy and player do each turn
		int enemyDamage =  0;
		int playerDamage = 0;
		
		//Retry if input is invalid
		boolean retry=false;
		
		do {
			
			//Player has their turn first
			for (int i=0; i<2; i++)
			{
				do
				{
					System.out.println("Please choose your next move:");
					if(i == 1) 	System.out.println("You have 1 move left.");
					else System.out.println("You have " + i + " moves left.");
					
					userInput = s.nextLine();
					
					showCombatOptions();
					retry = false;
					
					switch(userInput)
					{
					case "1": recordedUserMoves = recordedUserMoves + "1";break;
					case "2": recordedUserMoves = recordedUserMoves + "2"; break;
					case "3": recordedUserMoves = recordedUserMoves + "3"; break;
					case "4": recordedUserMoves = recordedUserMoves + "4"; break;
					case "0": player.flee();break;
					default: System.out.println("Please try again - wrong user input."); retry = true; break;
					}
					
					//separating input with a space
					recordedUserMoves = recordedUserMoves + " ";
					
				} while (retry=true);
			}
			
			//Player choices are executed, damage recorded
			playerDamage = player.execute(recordedUserMoves);
			
			//Enemy health is deduced after player moves
			enemy.setHealth(enemy.getEnemyHealth()-playerDamage);
			if(enemy.isEnemyAlive() == true) break;
			
			//Enemy has their turn		
			for (int i=0; i<2; i++)
			{
				System.out.println("Human has their turn!");
				int random = (int )(Math.random() * 4 + 1);
				enemyInput = Integer.toString(random);
				
				switch(enemyInput)
				{
				case "1": recordedEnemyMoves = recordedEnemyMoves + "1";break;
				case "2": recordedEnemyMoves = recordedEnemyMoves + "2"; break;
				case "3": recordedEnemyMoves = recordedEnemyMoves + "3"; break;
				case "4": recordedEnemyMoves = recordedEnemyMoves + "4"; break;
				}
				
				//Separating input with a space
				recordedEnemyMoves = recordedEnemyMoves + " ";
				
			}
			
			//Enemy choices are executed, damage recorded
			enemyDamage = enemy.execute(recordedEnemyMoves);
			
			//Player's health is deduced after enemy moves
			player.setHealth(player.getHealth()- enemyDamage);
			
			
		} while(enemy.isEnemyAlive() == false || player.isPlayerAlive() == false);
	
	
	if(enemy.isEnemyAlive() == false)
	{
		System.out.println("You have scared the polluter human and they have ran away! Good job.");
	}
	else if(player.isPlayerAlive() == false)
	{
		System.out.println("The polluter has drowned you in trash and you have lost all your items. You must retreat for now.");
	}

  }
	
}

