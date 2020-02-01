
public class Map {
	
	private String map[][];
	private final static int MAP_SIZE = 20;
	

	public Map() {
		
		map = new String[MAP_SIZE][MAP_SIZE];
		
		//Map is set to be empty when created
		for(int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[i].length;j++)
			{
				map[i][j] = ".";
			}
		}
		
	}
	
	/**
	 * Map is displayed on screen
	 */
	public void displayMap()
	{
		
		//Map contents are printed 
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
		
		
	

}
