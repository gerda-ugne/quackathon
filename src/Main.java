import map.Map;

public class Main {

	private Map map;
	public Main() {
		// TODO Auto-generated constructor stub
		map = new Map();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main myTest = new Main();
		myTest.test();

	}
	
	public void test()
	{
		map.displayMap();
	}

}

