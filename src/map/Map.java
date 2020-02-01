package map;

public class Map {

	public static final char CAN_GO_CHAR = '.';
	public static final char OBSTACLE_CHAR = 'O';
	public static final char PLAYER_1_CHAR = '1';
	public static final char PLAYER_2_CHAR = '2';
	
	private char[][] map;
	public final static int MAP_SIZE = 10;
	

	public Map() {
		
		map = new char[][]{
				{CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, PLAYER_2_CHAR },
				{CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
				{CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
				{CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
				{CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR},
				{OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR },
				{CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
				{CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR },
				{CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR },
				{PLAYER_1_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, CAN_GO_CHAR, OBSTACLE_CHAR, CAN_GO_CHAR, CAN_GO_CHAR },
		};
		
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
	
	public void setUpMap()
	{
		
	}

	public char getField(int x, int y) throws IndexOutOfBoundsException {
		return map[x][y];
	}

	public void setField(int x, int y, char type) throws IndexOutOfBoundsException {
		map[y][x] = type;
	}
}
