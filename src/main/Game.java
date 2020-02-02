package main;

import main.map.Field;
import main.map.Map;
import main.players.Enemy;
import main.players.Player;

import java.io.*;
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
		int playerX = isPlayer1 ? player1X : player2X;
		int playerY = isPlayer1 ? player1Y : player2Y;
		char direction = ' ';
		boolean valid = false;
		boolean fightWon = true;

		while (!valid) {
			try {
				direction = getDirection(in);
				switch (direction) {
					case 't':
						if (map.getField(playerX, playerY - 1) == Field.CAN_GO_CHAR) {
							valid = true;
							continue;
						}
						else if(map.getField(playerX, playerY-1) == Field.HUMAN_CHAR)
						{
							fightWon = combat();
							if(fightWon == true)
							{
								map.setField(playerX, playerY-1, Field.CAN_GO_CHAR);
								valid = true;
								continue;
							}

						}
						else {
							break;
						}
					case 'r':
						if (map.getField(playerX + 1, playerY) == Field.CAN_GO_CHAR) {
							valid = true;
							continue;
						}
						else if(map.getField(playerX + 1, playerY) == Field.HUMAN_CHAR)
						{
							fightWon = combat();
							if(fightWon == true)
							{
								map.setField(playerX + 1, playerY, Field.CAN_GO_CHAR);
								valid = true;
								continue;
							}
						}
						else {
							break;
						}
					case 'b':
						if (map.getField(playerX, playerY + 1) == Field.CAN_GO_CHAR) {
							valid = true;
							continue;
						}
						else if(map.getField(playerX, playerY + 1) == Field.HUMAN_CHAR)
						{
							fightWon = combat();
							if(fightWon == true)
							{
								map.setField(playerX, playerY+1, Field.CAN_GO_CHAR);
								valid = true;
								continue;
							}
						}
						else {
							break;
						}
					case 'l':
						if (map.getField(playerX - 1, playerY) == Field.CAN_GO_CHAR) {
							valid = true;
							continue;
						}
						else if(map.getField(playerX - 1, playerY) == Field.HUMAN_CHAR)
						{
							fightWon = combat();
							if(fightWon == true)
							{
								map.setField(playerX-1, playerY, Field.CAN_GO_CHAR);
								valid = true;
								continue;
							}
						}
						else {
							break;
						}
				}
			} catch (IndexOutOfBoundsException ignore) {

			}
			System.out.println("You cannot go into that direction.");
		}
		movePlayer(direction);
		map.moveEnemies();
		map.displayMap();
	}

	private char getDirection(Scanner in) {
		String direction;
		boolean valid;
		do {
			map.displayMap();
			System.out.println("Where would you like to move?");
			System.out.println("Top:    t");
			System.out.println("Right:  r");
			System.out.println("Bottom: b");
			System.out.println("Left:   l");
			direction = in.nextLine();
			switch (direction) {
				case "t": case "r": case "b": case "l":
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
			case 't':
				map.setField(playerX, playerY--, Field.CAN_GO_CHAR);
				break;
			case 'r':
				map.setField(playerX++, playerY, Field.CAN_GO_CHAR);
				break;
			case 'b':
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

	public boolean combat()
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
			recordedUserMoves = "";
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
					case "1": recordedUserMoves = recordedUserMoves + "1";break;
					case "2": recordedUserMoves = recordedUserMoves + "2"; break;
					case "3": recordedUserMoves = recordedUserMoves + "3"; break;
					case "4": recordedUserMoves = recordedUserMoves + "4"; break;
					case "0": player.flee(); return false;
					default: System.out.println("Please try again - wrong user input."); retry = true; break;
					}

					//separating input with a space
					System.out.println("Option recorded! \n");
					recordedUserMoves = recordedUserMoves + " ";

				} while (retry==true);
			}

			//Player choices are executed, damage recorded
			playerDamage = player.execute(recordedUserMoves);

			//Enemy health is deduced after player moves
			enemy.setHealth(enemy.getEnemyHealth()-playerDamage);
			if(enemy.isEnemyAlive() == false) break;

			//Enemy has their turn
			System.out.println("\nHuman has their turn!");
			recordedEnemyMoves = "";

			for (int i=0; i<2; i++)
			{
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


		} while(enemy.isEnemyAlive() == true && player.isPlayerAlive() == true);


	if(enemy.isEnemyAlive() == false)
	{
		System.out.println("You have scared the polluter human and they have ran away! Good job.");
		return true;



	}
	else if(player.isPlayerAlive() == false)
	{
		System.out.println("The polluter has drowned you in trash and you have lost all your items. You must retreat for now.");
		if(isPlayer1 == true)
		{
			player1Y = 0;
			player1X = Map.MAP_SIZE - 1;
		}
		else
		{
			player2Y = Map.MAP_SIZE - 1;
			player2X = 0;
		}

		return false;
	}

	return false;

  }

	// please make a fields "inputName" & "outputName" (String) & generate getters&setters

}
