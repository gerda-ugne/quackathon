import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * @author 
 * @version 1.0
 *
 */
public class Menu 
{
	private Game game;
	
	private String namePlayer1;
	private String namePlayer2;
	private String gameName;
	//private String name;
	private int count;
	private boolean end;
	boolean player1;
	
	/**  
	 *  */
	
	public Menu()
	{
		game = new Game();
		
		namePlayer1 = "";
		namePlayer2 = "";
		gameName = "";
		//name = "";
		count = 0;
		end = false;
		player1 = true;
	}
	

	/**  
	 * This is the project's main method. It calls two methods that help the user navigate the program; welcome() and choose().
	 */
	
	public static void main(String[] args) 
	{
		Menu menu1 = new Menu(); 	
		
		menu1.welcome();
		menu1.mainMenu();
	}
	
	
	public String getNamePlayer1() 
	{
		return namePlayer1;
	}


	public void setNamePlayer1(String namePlayer1) 
	{
		this.namePlayer1 = namePlayer1;
	}


	public String getNamePlayer2() 
	{
		return namePlayer2;
	}


	public void setNamePlayer2(String namePlayer2) 
	{
		this.namePlayer2 = namePlayer2;
	}


	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	/** Getter for player1 */
	
	public boolean isPlayer1() 
	{
		return player1;
	}
	
	
	/** Setter for player1 */
	
	public void setPlayer1(boolean player1) 
	{
		this.player1 = player1;
	}

	/**
	 * This method welcomes the user when the program is started by using a counter ('count') that is only zero the first time this method is used.
	 * This method then gives a short explanation of the game and opens the main menu. 
	 */

	public void welcome()
	{
		if (count == 0)
		{
			
			System.out.println("Hello. This is Hide&Seek&GetLostInAMaze!" );
			
			System.out.print("\t \n Would you like to... \n"
					+ "\n ... start a new game? Please enter number 1."
					+ "\n ... load an old game? Please enter number 2.");
			
			Scanner s1 = new Scanner(System.in);
			String choice = s1.nextLine();
			
			boolean notAValidChoice = false;
			
			do
			{
			
				switch(choice)
				{
					case "1":
						// do sth
						break;
		
					case "2":	
						selectGame();
						break;
		
					default:
						System.out.print("\nSorry. This is not a valid choice. Please enter either '1' or '2'. ");
						notAValidChoice = true;
					return;
				}	
			}
			while(notAValidChoice == true);
		}
		
		else 
		{
			System.out.print("\nIs there anything else you would like to do? \n" );
		}
	}
	
	public void selectGame()
	{
			
			boolean notAValidName = false;
			
			do
			{
				System.out.print("\nWhat is the name of your game? \n" );
				System.out.print("Name of the game: " );
				
				Scanner s1 = new Scanner(System.in);
				gameName = s1.nextLine();
				// look for file, if doesn't exist -> notAValidName = true;
			
				System.out.println("\nThanks. ");
				String name1 = getNamePlayer1();
				String name2 = getNamePlayer2();
				System.out.println("Are you " + name1 + " or " + name2 +"?" );
				String inputName = s1.nextLine();
			
				switch(inputName)
				{
			
					case name1:
						player1 = true;
						break;
				
					case name2:
						player1 = false;
						break;
				
					default:
						System.out.print("\nError. This player does not participate in the game. Please try again. ");
						notAValidName = true;
						break;;
				}
				
			}
			while(notAValidName == true);
			
		
			if(player1 == true)
			{
				System.out.print("\n" + "Hello " + namePlayer1 + "!");
			}
			
			else
			{
				System.out.print("\n" + "Hello " + namePlayer2 + "!");
			}
			
			System.out.println();
	}

	/**
	
	*/

	public void mainMenu()
	{
		do
		{
			
			
			System.out.print("\n Main Menu:");
			System.out.print("\t \n Would you like to... \n");
			
			if (player1 == true)
			{
				System.out.print("\n ... change to player 1? Please enter number 1.");
			}
			else
			{
				System.out.print("\n ... change to player 2? Please enter number 1.");
			}
			
			
			System.out.print("\n ... get some help with the rules? Please enter number 2.");
			System.out.print("\n ... exit the game? Please enter number 3. \n"
					+ "\n Which number do you choose? Number = ");

			Scanner s2 = new Scanner(System.in);
			String decision = s2.nextLine();
			
			
			while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3"));
			{
				System.out.print("\nError. Please enter an integer between 1-3!"
				+ "\n" + "\nWhich number do you chose? Number = ");
				decision = s2.nextLine();
			}
			
			chosenOption:
			switch(decision)
			{

			case "1":
				
	
				if(player1 == true)
				{
					System.out.print("\n Welcome back " + namePlayer1 + "!" + "\n");
					game.playGame();
					gameMenu();
				}
				
				else
				{
					System.out.print("\n Welcome back " + namePlayer2 + "!" + "\n");
					game.playGame();
					gameMenu();
				}
				break;
				
			case "2": //help menu
				System.out.print("\nThis is Hide&Seek&GetLostInAMaze! These are the rules: xxx " );
				
				break;
				
			case "3":
				end = true;
				System.out.print("\n Thank you for playing Hide&Seek&GetLostInAMaze. We hope you have enjoyed it. \n Goodybe. ");
				System.out.println();
				System.out.println();
				System.exit(0);
				break;
				
			default:
				System.out.print("\nError. Please enter an integer between 1-3!"
						+ "\n" + "\nWhich number do you chose? Number = ");
				String decision2 = s2.nextLine();
				decision = decision2; 
				
			}
		}
	    while(end == false);
	}
		

	/**
	 * This method serves as the program's game menu. 
	 * It lets the user choose between different options by selecting integer numbers form 1 to 6, calling other methods respectively.
	It also calls the game menu after the user has started playing the game (and entered 'M' at the beginning of their turn for the first time).
	There is also an option to take the user back to the main menu.
	*/
		
	public void gameMenu()
	{
		boolean end = false;
		
		do
		{
			System.out.print("\n");
			System.out.print(" Game Menu:");				
			Scanner s2 = new Scanner(System.in);
			System.out.print("\t \n Would you like to... \n"
					+ "\n ... return to the game? Please enter number 1."
					+ "\n ... display your current score? Please enter number 2."
					+ "\n ... save? Please enter number 2."
					+ "\n ... go to main menu=);
						
		

			String decision = s2.nextLine();
				
			while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3") && !decision.equals("4") && !decision.equals("5") && !decision.equals("6"))
			{
				System.out.print("\nError. Please enter an integer between 1-6!"
						+ "\n" + "\nWhich number do you chose? Number = ");
				decision = s2.nextLine();
			}
				
			switch(decision)
			{
				
				case "1":
					
					
					break;
				
				
					
				case "4":
					game.saveGame(playerVComputer);
					
					break;
					
					
				default:
					System.out.print("\nError. Please enter an integer between 1-6!"
							+ "\n" + "\nWhich number do you chose? Number = "); //needs to be changed accordingly
					String decision2 = s2.nextLine();
					decision = decision2; 
					
			}	
				++ count ; 
				welcome();	
			 }
			 while (end == false);
	} 
}
		
		
		
		
	