package main;

import main.map.Field;
import main.map.Map;
import main.players.Enemy;
import main.players.Inventory;
import main.players.Player;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable {

	private int player1X;
	private int player1Y;
	private int player2X;
	private int player2Y;

	private boolean isPlayer1;

	private Map map;
	private Enemy enemy;
	private Player player;

	public Game() {
		player1X = Map.MAP_SIZE - 1;
		player1Y = 0;
		player2X = 0;
		player2Y = Map.MAP_SIZE - 1;

		map = new Map();
		enemy = new Enemy();
		player = new Player();

		isPlayer1 = true;
	}

	/**
	 * Getter for player1
	 */
	public boolean isPlayer1()
	{
		return isPlayer1;
	}


	/**
	 *  Setter for player1
	 */
	public void setPlayer1(boolean player1)
	{
		this.isPlayer1 = player1;
	}

	public void playGame(Scanner in) {
		Random rnd = new Random();

		int playerX = isPlayer1 ? player1X : player2X;
		int playerY = isPlayer1 ? player1Y : player2Y;
		char direction = ' ';
		boolean valid = false;

		while (!valid) {
			int fightWon = -1;
			direction = getDirection(in);
			int destinationX;
			int destinationY;

			try {
				switch (direction) {
					case 'u':
						destinationX = playerX;
						destinationY = playerY - 1;
						break;
					case 'r':
						destinationX = playerX + 1;
						destinationY = playerY;
						break;
					case 'd':
						destinationX = playerX;
						destinationY = playerY + 1;
						break;
					case 'l':
						destinationX = playerX - 1;
						destinationY = playerY;
						break;
					default:
						throw new IllegalStateException("Unexpected value: " + direction);
				}

				switch (map.getField(destinationX, destinationY)) {
					case Field.CAN_GO_CHAR:
						valid = true;
						continue;
					case Field.HUMAN_CHAR:
						fightWon = combat();
						switch (fightWon) {
							case -1:
								return;
							case 0:
								continue;
							case 1:
								map.setField(playerX, playerY, Field.CAN_GO_CHAR);
								valid = true;
								continue;
						}
						break;
					case Field.TRASH_CHAR:
						valid = true;
						player.addToInventory(rnd.nextInt(2) == 0 ? Inventory.MP_POTION : Inventory.HP_POTION);
						player.showInventory();
						valid = true;
						continue;
				}
			} catch (IndexOutOfBoundsException | IllegalStateException ignore) { }

			if (fightWon != 1) {
				System.out.println("You cannot go into that direction.");
			}
		}
		movePlayer(direction);
		checkForVictory();
		map.moveEnemies();
		map.displayMap();
	}

	private char getDirection(Scanner in) {
		String direction;
		boolean valid;
		do {
			map.displayMap();
			System.out.println("Where would you like to move?");
			System.out.println("Up:     u");
			System.out.println("Right:  r");
			System.out.println("Down:   d");
			System.out.println("Left:   l");
			direction = in.nextLine();
			switch (direction) {
				case "u": case "r": case "d": case "l":
					valid = true;
					break;
				default:
					System.out.println("Not a valid direction.");
					valid = false;
			}
		} while (!valid);
		return direction.charAt(0);
	}

	private void movePlayer(char direction) {
		int playerX = isPlayer1 ? player1X : player2X;
		int playerY = isPlayer1 ? player1Y : player2Y;
		switch (direction) {
			case 'u':
				map.setField(playerX, playerY--, Field.CAN_GO_CHAR);
				break;
			case 'r':
				map.setField(playerX++, playerY, Field.CAN_GO_CHAR);
				break;
			case 'd':
				map.setField(playerX, playerY++, Field.CAN_GO_CHAR);
				break;
			case 'l':
				map.setField(playerX--, playerY, Field.CAN_GO_CHAR);
				break;
			default:
				return;
		}
		map.setField(playerX, playerY, isPlayer1 ? Field.PLAYER_1_CHAR : Field.PLAYER_2_CHAR);
		if (isPlayer1) {
			player1X = playerX;
			player1Y = playerY;
		} else {
			player2X = playerX;
			player2Y = playerY;
		}
	}

	public void showCombatOptions()
	{
		System.out.println("1. Peck the human with your beak.");
		System.out.println("2. Unleash a flapping attack [Special attack]");
		System.out.println("3. Have a crunchy worm with a rock [Heal up]");
		System.out.println("4. Use your wax to restore your powers [Restore MP]");
		System.out.println("0. Flee");

	}

	// return -1: death, 0: flee, 1: victory
	public int combat()
	{
		System.out.println("You have encountered a human, and they seem to be polluting the lake!");
		Scanner s = new Scanner(System.in);
		enemy = new Enemy();
		String userInput;
		String enemyInput;

		//Records damage enemy and player do each turn
		int enemyDamage;
		int playerDamage;

		//Retry if input is invalid
		boolean retry;

		do {

			//Player has their turn first
			StringBuilder recordedUserMoves = new StringBuilder();
			for (int i=0; i<2; i++)
			{
				do
				{

					if(i == 1) 	System.out.println("You have 1 move left.");
					else System.out.println("You have " + (2-i) + " moves left.");

					System.out.println("Please choose your next move:");
					showCombatOptions();

					userInput = s.nextLine();
					retry = false;

					switch(userInput)
					{
					case "1": recordedUserMoves.append("1");break;
					case "2": recordedUserMoves.append("2"); break;
					case "3": recordedUserMoves.append("3"); break;
					case "4": recordedUserMoves.append("4"); break;
					case "0": player.flee(); return 0;
					default: System.out.println("Please try again - wrong user input."); retry = true; break;
					}

					//separating input with a space
					System.out.println("Option recorded! \n");
					recordedUserMoves.append(" ");

				} while (retry);
			}

			//Player choices are executed, damage recorded
			playerDamage = player.execute(recordedUserMoves.toString());

			//Enemy health is deduced after player moves
			enemy.setHealth(enemy.getEnemyHealth()-playerDamage);
			if(!enemy.isEnemyAlive()) break;

			//Enemy has their turn
			System.out.println("\nHuman has their turn!");
			StringBuilder recordedEnemyMoves = new StringBuilder();

			for (int i=0; i<2; i++)
			{
				int random = (int )(Math.random() * 4 + 1);
				enemyInput = Integer.toString(random);

				switch(enemyInput)
				{
				case "1": recordedEnemyMoves.append("1");break;
				case "2": recordedEnemyMoves.append("2"); break;
				case "3": recordedEnemyMoves.append("3"); break;
				case "4": recordedEnemyMoves.append("4"); break;
				}

				//Separating input with a space
				recordedEnemyMoves.append(" ");

			}

			//Enemy choices are executed, damage recorded
			enemyDamage = enemy.execute(recordedEnemyMoves.toString());

			//Player's health is deduced after enemy moves
			player.setHealth(player.getHealth()- enemyDamage);


		} while(enemy.isEnemyAlive() && player.isPlayerAlive());


		if(!enemy.isEnemyAlive())
		{
			System.out.println("You have scared the polluter human and they have ran away! Good job.");
			return 1;



		}
		else if(!player.isPlayerAlive())
		{
			System.out.println("The polluter has drowned you in trash. As you awaken, you discover snacks in your inventory. You must retreat for now.");
			if(isPlayer1)
			{
				map.setField(player1X, player1Y, Field.CAN_GO_CHAR);
				player1Y = 0;
				player1X = Map.MAP_SIZE - 1;
				map.setField(player1X, player1Y, Field.PLAYER_1_CHAR);
			}
			else
			{
				map.setField(player2X, player2Y, Field.CAN_GO_CHAR);
				player2Y = Map.MAP_SIZE - 1;
				player2X = 0;
				map.setField(player2X, player2Y, Field.PLAYER_2_CHAR);
			}

			player.getInv().resetInventory();
			player.setHealth(100);
			player.setMana(100);
			return -1;
		}

		return -1;

	  }

	private void checkForVictory() {
		for (int i = 0; i < Map.MAP_SIZE; i++) {
			for (int j = 0; j < Map.MAP_SIZE; j++) {
				if (map.getField(i, j) == Field.TRASH_CHAR || map.getField(i, j) == Field.HUMAN_CHAR) {
					return;
				}
			}
		}
		System.out.println(
				"            ,-.\n" +
				"    ,      ( {o\\\n" +
				"    {`\"=,___) (`~\n" +
				"     \\  ,_.-   )\n" +
				"~^~^~^`- ~^ ~^ '~^~^~^~"
		);
		System.out.println("!!! CONGRATULATION !!!");
		System.out.println("       You won!");
		Menu.endGame();
	}
}
