import map.Map;

import java.util.Scanner;

public class Game {

	private int player1X;
	private int player1Y;
	private int player2X;
	private int player2Y;

	public static void main(String[] args) {
		Game test = new Game();
		test.playGame(new Scanner(System.in));
	}

	private boolean isPlayer1;

	private Map map;

	public Game() {
		player1X = 0;
		player1Y = Map.MAP_SIZE - 1;
		player2X = Map.MAP_SIZE - 1;
		player2Y = 0;
		map = new Map();
		isPlayer1 = true;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Game myTest = new Game();
//		myTest.test();
//
//	}

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
	
	public void test()
	{
		map.displayMap();
	}

	public void playGame(Scanner in) {
		int playerX = isPlayer1 ? player1X : player2X;
		int playerY = isPlayer1 ? player1Y : player2Y;
		char direction = ' ';
		boolean valid = false;
		while (!valid) {
			try {
				direction = getDirection(in);
				switch (direction) {
					case 't':
						if (map.getField(playerX, playerY - 1) == Map.CAN_GO_CHAR) {
							valid = true;
							continue;
						} else {
							break;
						}
					case 'r':
						if (map.getField(playerX + 1, playerY) == Map.CAN_GO_CHAR) {
							valid = true;
							continue;
						} else {
							break;
						}
					case 'b':
						if (map.getField(playerX, playerY + 1) == Map.CAN_GO_CHAR) {
							valid = true;
							continue;
						} else {
							break;
						}
					case 'l':
						if (map.getField(playerX - 1, playerY) == Map.CAN_GO_CHAR) {
							valid = true;
							continue;
						} else {
							break;
						}
				}
			} catch (IndexOutOfBoundsException ignore) {

			}
			System.out.println("You cannot go into that direction.");
		}
		movePlayer(direction);
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
				map.setField(playerX, playerY - 1, isPlayer1 ? Map.PLAYER_1_CHAR : Map.PLAYER_2_CHAR);
				break;
			case 'r':
				map.setField(playerX + 1, playerY, isPlayer1 ? Map.PLAYER_1_CHAR : Map.PLAYER_2_CHAR);
				break;
			case 'b':
				map.setField(playerX, playerY + 1, isPlayer1 ? Map.PLAYER_1_CHAR : Map.PLAYER_2_CHAR);
				break;
			case 'l':
				map.setField(playerX - 1, playerY, isPlayer1 ? Map.PLAYER_1_CHAR : Map.PLAYER_2_CHAR);
				break;
			default:
				return;
		}
		map.setField(playerX, playerY, Map.CAN_GO_CHAR);
	}
}
