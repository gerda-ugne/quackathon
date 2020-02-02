package main.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map implements Serializable {

//	public static void main(String[] args) {
//		Map map = new Map();
//		map.generateMap();
//		map.displayMap();
//	}

	private Field[][] map;
	public final static int MAP_SIZE = 15;

	public Map() {

		map = new Field[MAP_SIZE][MAP_SIZE];
		
		//map is set to be empty when created
		for(int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[i].length;j++)
			{
				map[i][j] = new Field(j, i);
			}
		}

		generateMap();
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
		start.setCharacter(Field.PLAYER_1_CHAR);
		end.setCharacter(Field.PLAYER_2_CHAR);
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

			if (up != null && (up.canMove() || up.getCharacter() == '1' || up.getCharacter() == '2')) {
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
			if (right != null && (right.canMove() || right.getCharacter() == '1' || right.getCharacter() == '2')) {
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
			if (down != null && (down.canMove() || down.getCharacter() == '1' || down.getCharacter() == '2')) {
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
			if (left != null && (left.canMove() || left.getCharacter() == '1' || left.getCharacter() == '2')) {
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

		addEnemies();
	}

	/**
	 * Places enemies on the map randomly.
	 *
	 */
	private void addEnemies()
	{
		int enemyCount = calculateEnemyCount();

		Random rand = new Random();
		int enemyPositionX;
		int enemyPositionY;

		for(int i=0; i<enemyCount; i++)
		{
			System.out.println();
			do {
				enemyPositionY = rand.nextInt(MAP_SIZE);
				enemyPositionX = rand.nextInt(MAP_SIZE);
			} while (!(map[enemyPositionX][enemyPositionY].getCharacter() == Field.CAN_GO_CHAR));

			map[enemyPositionX][enemyPositionY].setCharacter('☻');
		}
	}

	private int calculateEnemyCount() {
		int numberOfEmptyFields = 0;
		for(int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[i].length;j++)
			{
				if (map[i][j].getCharacter() == Field.CAN_GO_CHAR) {
					numberOfEmptyFields++;
				}
			}
		}
		return (int) (numberOfEmptyFields * 0.15);
	}

	public void moveEnemies() {
		Random rnd = new Random();
		for(int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[i].length;j++)
			{
				Field moveTo = null;
				if (map[i][j].getCharacter() == Field.HUMAN_CHAR) {
					try {
						switch (rnd.nextInt(4)) {
							case 0: // up
								moveTo = map[i][j - 1];
								break;
							case 1: // right
								moveTo = map[i + 1][j];
								break;
							case 2: // down
								moveTo = map[i][i + 1];
								break;
							case 3: // left
								moveTo = map[i - 1][j];
								break;
						}
					} catch (IndexOutOfBoundsException ignored) { }
					if (moveTo != null && moveTo.getCharacter() == Field.CAN_GO_CHAR) {
						moveTo.setCharacter(Field.HUMAN_CHAR);
						map[i][j].setCharacter(rnd.nextInt(20) == 1 ? Field.TRASH_CHAR : Field.CAN_GO_CHAR);
					}
				}
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
