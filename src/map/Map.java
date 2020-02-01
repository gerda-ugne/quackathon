package map;

public class Map {

	private static final char CAN_GO_CHAR = '.';
	private static final char OBSTACLE_CHAR = 'O';
	private static final char PLAYER_1_CHAR = '1';
	private static final char PLAYER_2_CHAR = '2';
	
	private char[][] map;
	private final static int MAP_SIZE = 10;
	

	public Map() {
		
//		map = new char[][]{
//				{CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, PLAYER_2_CHAR },
//				{CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
//				{CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
//				{CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
//				{CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR},
//				{OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR },
//				{CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
//				{CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR },
//				{CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
//				{PLAYER_1_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR },
//		};
		
//		//map.Map is set to be empty when created
//		for(int i=0; i<map.length;i++)
//		{
//			for(int j=0; j<map[i].length;j++)
//			{
//				map[i][j] = ;
//			}
//		}
		
	}

	/**
	 * map.Map is displayed on screen
	 */
	public void displayMap()
	{
		
		//map.Map contents are printed
		for(int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[i].length;j++)
			{
				System.out.print(map[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	public void generateMap()
	{
		map = new char[MAP_SIZE][MAP_SIZE];
		for (int i = 0; i < MAP_SIZE; i++) {

		}
	}
		
		
	

}
