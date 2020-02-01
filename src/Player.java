import java.util.ArrayList;
import java.util.List;

public class Player
{
	private String name;
	private String [] coordinates;
	private final int maxHp;
	private int hp;
	private final int minDmg;
	private final int maxDmg;
	private final int defence;
	private boolean alive = true;
	private List<String> inventory;

	public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
    	this.name = name;
    }

    public String[] getCoordinates()
    {
        return coordinates;
    }

    public void setCoordinates(String[] coordinates)
    {
        this.coordinates = coordinates;


    }

    public Player(String name, int maxHp, int minDmg, int maxDmg, int defence)
    {
    	this.name = name;
    	this.maxHp = maxHp;
    	this.maxHp = maxHp;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.defence = defence;
        inventory = new ArrayList<>();

    }
