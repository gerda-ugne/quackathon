package main.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map implements Serializable {

	public static void main(String[] args) {
		Map test = new Map();
		test.generateMap();
		test.displayMap();
	}

	private Field[][] map;
	public final static int MAP_SIZE = 10;


	public Map() {

		map = new Field[MAP_SIZE][MAP_SIZE];
		
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
		
		//map.Map is set to be empty when created
		for(int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[i].length;j++)
			{
				map[i][j] = new Field(j, i);
			}
		}
		
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
				System.out.print(map[i][j].getCharacter() + " ");
			}
			
			System.out.println();
		}
		
	}
	
	public void generateMap() {
		Random rn = new Random();

		List<ArrayList<Field>> blocked = new ArrayList<>(MAP_SIZE);
		for (int i = 0; i < MAP_SIZE; i++) {
			ArrayList<Field> row = new ArrayList<Field>(MAP_SIZE);
			for (int j = 0; j < MAP_SIZE; j++) {
				row.add(new Field(i, j));
			}
			blocked.add(row);
		}

		List<List<Field>> unblocked = new ArrayList<>();

		Field start = blocked.get(0).remove(MAP_SIZE - 1);
		Field end = blocked.get(MAP_SIZE - 1).remove(0);

		start.setCharacter(Field.CAN_GO_CHAR);
		end.setCharacter(Field.CAN_GO_CHAR);
		start.setCanMove(true);
		end.setCanMove(true);
		map[0][MAP_SIZE - 1] = start;
		map[MAP_SIZE - 1][0] = end;

		unblocked.add(new ArrayList<>(Collections.singletonList(start)));
		unblocked.add(new ArrayList<>(Collections.singletonList(end)));

		while (unblocked.size() > 1) {
			int row = rn.nextInt(blocked.size());
			int col = rn.nextInt(blocked.get(row).size());
			Field newUnblocked = blocked.get(row).remove(col);
			if (blocked.get(row).isEmpty()) {
				blocked.remove(row);
			}
			int x = newUnblocked.getX();
			int y = newUnblocked.getY();
			newUnblocked.setCanMove(true);
			newUnblocked.setCharacter(Field.CAN_GO_CHAR);
			map[x][y] = newUnblocked;

			List<Field> newSet = new ArrayList<>(Collections.singletonList(newUnblocked));

			Field up = null;
			Field right = null;
			Field down = null;
			Field left = null;
			try {
				up = map[x][y - 1];
			} catch (IndexOutOfBoundsException ignore) {	}
			try {
				right = map[x + 1][y];
			} catch (IndexOutOfBoundsException ignore) {	}
			try {
				down = map[x][y + 1];
			} catch (IndexOutOfBoundsException ignore) {	}
			try {
				left = map[x - 1][y];
			} catch (IndexOutOfBoundsException ignore) {	}

			if (up != null && up.canMove()) {
				Field finalUp = up;
				List<Field> neighbor = unblocked.stream()
						.filter(set -> set.contains(finalUp))
						.findAny()
						.orElse(null);
				unblocked.remove(neighbor);
				if (neighbor != null) {
					newSet = Stream.concat(newSet.stream(), neighbor.stream()).collect(Collectors.toList());
				}
			}
			if (right != null && right.canMove()) {
				Field finalRight = right;
				List<Field> neighbor = unblocked.stream()
						.filter(set -> set.contains(finalRight))
						.findAny()
						.orElse(null);
				unblocked.remove(neighbor);
				if (neighbor != null) {
					newSet = Stream.concat(newSet.stream(), neighbor.stream()).collect(Collectors.toList());
				}
			}
			if (down != null && down.canMove()) {
				Field finalDown = down;
				List<Field> neighbor = unblocked.stream()
						.filter(set -> set.contains(finalDown))
						.findAny()
						.orElse(null);
				unblocked.remove(neighbor);
				if (neighbor != null) {
					newSet = Stream.concat(newSet.stream(), neighbor.stream()).collect(Collectors.toList());
				}
			}
			if (left != null && left.canMove()) {
				Field finalLeft = left;
				List<Field> neighbor = unblocked.stream()
						.filter(set -> set.contains(finalLeft))
						.findAny()
						.orElse(null);
				unblocked.remove(neighbor);
				if (neighbor != null) {
					newSet = Stream.concat(newSet.stream(), neighbor.stream()).collect(Collectors.toList());
				}
			}

			unblocked.add(newSet);
			System.out.println();
		}
	}

	public char getField(int x, int y) throws IndexOutOfBoundsException {
		return map[y][x].getCharacter();
	}

	public void setField(int x, int y, char type) throws IndexOutOfBoundsException {
		map[y][x].setCharacter(type);
	}
}
