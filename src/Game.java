import map.Map;

public class Game {

	private boolean isPlayer1;

	private Map map;

	public Game() {
		// TODO Auto-generated constructor stub
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

	public void playGame() {
		map.displayMap();
	}
}
