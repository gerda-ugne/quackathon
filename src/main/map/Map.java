package main.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Map implements Serializable {

	private Field[][] map;
	public final static int MAP_SIZE = 10;


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
	
	public void generateMap() {
		Random rn = new Random();

		ArrayList<ArrayList<Field>> blocked = new ArrayList<>(MAP_SIZE);
		for (int i = 0; i < MAP_SIZE; i++) {
			ArrayList<Field> row = new ArrayList<Field>(MAP_SIZE);
			for (int j = 0; j < MAP_SIZE; j++) {
				row.add(new Field(i, j));
			}
			blocked.add(row);
		}

		ArrayList<ArrayList<Field>> unblocked = new ArrayList<>();

		Field start = blocked.get(0).get(MAP_SIZE - 1);
		Field end = blocked.get(MAP_SIZE - 1).get(0);

		start.setCharacter(Field.CAN_GO_CHAR);
		end.setCharacter(Field.CAN_GO_CHAR);

		unblocked.add(new ArrayList<>(Collections.singletonList(start)));
		unblocked.add(new ArrayList<>(Collections.singletonList(end)));

		while (unblocked.size() > 1) {
			int row = rn.nextInt(blocked.size());
			int col = rn.nextInt(blocked.get(row).size());
			Field newUnblocked = blocked.get(row).get(col);
			map[newUnblocked.getX()][newUnblocked.getY()] = newUnblocked;

			if (map[row][col - 1].canMove()) {

			}
		}
	}

	public char getField(int x, int y) throws IndexOutOfBoundsException {
		return map[y][x].getCharacter();
	}

	public void setField(int x, int y, char type) throws IndexOutOfBoundsException {
		map[y][x].setCharacter(type);
	}
}
