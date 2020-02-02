package main;

import main.map.Field;

import java.io.*;
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

	private String gameName;
	//private String name;
	private int count;
	private boolean end;
	//boolean player1;
    
	
	/**  
	 *  */
	
	public Menu()
	{
		game = new Game();
		gameName = "";

		count = 0;
		end = false;
      

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

	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * This method welcomes the user when the program is started by using a counter ('count') that is only zero the first time this method is used.
	 * This method then gives a short explanation of the game and opens the main menu. 
	 */

	public void welcome()
	{
		if (count == 0)
		{
			System.out.println(
					"            ,-.\n" +
					"    ,      ( {o\\\n" +
					"    {`\"=,___) (`~\n" +
					"     \\  ,_.-   )\n" +
					"~^~^~^`- ~^ ~^ '~^~^~^~"
			);
			
			System.out.println("Hello. This is Snappy Ducks!" );
			
			typeSlowest("\nOur hero, duck Beacky, comes back to her home pond and meets");
			typeSlowest("her old friend Quilly. They both notice that the problem of pollution");
			typeSlowest("is even worse than the year before. Thus, they decide to fight back ");
			typeSlowest("against the main cause of the pollution - humans. During their adventure");
			typeSlowest("they not only punish the polluters by scaring them but also clean up");
			typeSlowest("the pond from litter.");

			typeSlowest("\nThe game displays the pond map. Beacky is marked as letter B on the map,");
			typeSlowest("and her friend Quilly as letter Q. The obstacles are marked as ¥ and");
			typeSlowest("the human polluters, which ducks can fight, as ☻. Trash is marked as *.");
			typeSlowest("You start the game as Beacky.");

			typeSlow("\nWould you like to... \n");
			System.out.println(" ... start a new game? Please enter number 1.");
			System.out.println(" ... load an old game? Please enter number 2.");
					
            System.out.print("\nWhich number do you chose? Number = ");
			
			Scanner s1 = new Scanner(System.in);
			String choice = s1.nextLine();
			
			boolean notAValidChoice = false;
			
			do
			{
			
				switch(choice)
				{
					case "1":
						return;
						//break;
		
					case "2":	
						loadGame();
						break;
		
					default:
						System.out.println("\nSorry. This is not a valid choice. Please enter either '1' or '2'. ");
						notAValidChoice = true;
					return;
				}	
			}
			while(notAValidChoice);
		}
		
		else 
		{
			typeSlow("\nIs there anything else you would like to do? \n" );
		}
	}


	/**
	
	*/

	public void mainMenu()
	{
		do
		{
			typeSlow("\nMain Menu:");
			typeSlow("\t \n Would you like to... \n");
            System.out.print(" ... play the game? Please enter number 1.");
			
			if (game.isPlayer1())
			{
				System.out.print("\n ... change to player 2? Please enter number 2.");
			}
			else
			{
				System.out.print("\n ... change to player 1? Please enter number 2.");
			}

			
			System.out.print("\n ... get some help with the rules? Please enter number 3.");
			System.out.print("\n ... exit the game? Please enter number 4. \n");
			typeSlow("\nWhich number do you choose? Number = ");

			Scanner s2 = new Scanner(System.in);
			String decision = s2.nextLine();
			
			
			while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3") && !decision.equals("4"))
			{
				System.out.print("\nError. Please enter an integer between 1-4!");
				typeSlow("\n" + "\nWhich number do you chose? Number = ");
				decision = s2.nextLine();
			}

			int player1Counter = 0;
			int player2Counter = 0;

			int counterLimit = 2;
			switch (decision) {

				case "1":

					typeSlow("\n Welcome back to the pond! \n ");
					game.playGame(s2);

					gameMenu();

					break;

                case "2":

                    if(game.isPlayer1())
                    {
                        game.setPlayer1(false);
                    }
			
                    else
                    {
						game.setPlayer1(true);
                    }

                    break;

				case "3": //help menu
					typeSlow("\nThis is SNAPPYducks! These are the rules:");
					typeSlow("You start the game as Beacky. \n");
					typeSlow("You can move around by following the directions displayed on screen.");
					typeSlow("The pond contains many obstacles, so make sure you don't lose your way.");
					typeSlow("Unfortunately, there are many tourists who've come to visit your idyllic home pond.");
					typeSlow("They happen to leave their litter everywhere. \n");
					typeSlow("If you pick the litter up, you can find valuable resources to aid you.");
					typeSlow("Since humans are disturbing your peace, you can fight them to support the ecosystem. \n");
					typeSlow("You have limited resources to fight humans. You must keep an eye on your health bar and");
					typeSlow("your energy at all times. Remember that wax helps your feathers, and that rocks are");
					typeSlow("important to help your digestion. \n");
					typeSlow("If a tourist overpowers you, you will lose your consciousness and float ");
					typeSlow("to the shore.\n");
					typeSlow("But it might also be interesting to discover the pond from Quilly's perspective.");
					typeSlow("After some time, Beacky will need a rest, and Quilly can take over.\n");
					typeSlow("That does not prevent you from switching the perspective whenever you want");
					typeSlow("to in the main menu.\n");
					typeSlow("Together you will be able to clear the pond of the litter and those who leave it.");
					typeSlow("Save the ecosystem with Beacky and Quilly! \n");
					typeSlow("Map legend:");
					typeSlow(Field.CAN_GO_CHAR + " : Available pathway");
					typeSlow(Field.OBSTACLE_CHAR + " : Obstacle marker");
					typeSlow(Field.HUMAN_CHAR + " : Human marker");
					typeSlow(Field.TRASH_CHAR + " : Litter marker");
					typeSlow(Field.PLAYER_1_CHAR + " : Beacky's location");
					typeSlow(Field.PLAYER_2_CHAR + " : Quilly's location");

					break;

				case "4":
					end = true;
					typeSlow("\nThank you for playing SNAPPYducks. We hope you have enjoyed it. \nGoodybe. ");
					System.out.println();
					System.out.println();
					System.exit(0);
					break;

				default:
					System.out.print("\nError. Please enter an integer between 1-3!");
					typeSlow("\n" + "\nWhich number do you chose? Number = ");
					decision = s2.nextLine();

			}
		}
	    while(!end);
	}
		

	/**
	 * This method serves as the program's game menu. 
	 * It lets the user choose between different options by selecting integer numbers, calling other methods respectively.
	There is also an option to take the user back to the main menu.
	*/
		
	public void gameMenu()
	{
		boolean end = false;
		
		do
		{
			System.out.print("\n");
			typeSlow(" Game Menu:");				
			Scanner s2 = new Scanner(System.in);
			System.out.print("\t \n Would you like to... \n"
					+ "\n ... continue with the game? Please enter number 1.");

			if (game.isPlayer1())
			{
				System.out.print("\n ... change to Quilly? Please enter number 2.");
			}
			else
			{
				System.out.print("\n ... change to Beacky? Please enter number 2.");
			}

			System.out.print("\n ... save? Please enter number 3.");
			System.out.println("\n ... open your inventory? Please enter number 4.");
			System.out.println(" ... go to main menu? Please enter number 5.");

						
		

			String decision = s2.nextLine();

			while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3") && !decision.equals("4") && !(decision.equals("5")))
			{
				System.out.print("\nError. Please enter an integer between 1-4!");
				typeSlow("\nWhich number do you chose? Number = ");
				decision = s2.nextLine();
			}
				
			switch(decision)
			{
				
				case "1":
					game.playGame(s2);

					break;
				case "2":

                    if(game.isPlayer1())
                    {
                        game.setPlayer1(false);
						game.setCountingSteps(0);
                        typeSlow("Player changed! Welcome back Quilly!");
                    }

                    else
                    {
						game.setPlayer1(true);
						game.setCountingSteps(0);
						typeSlow("Player changed! Welcome back Quilly!");
                    }
                    break;

				case "4":
					game.player.showInventory();
					break;

				case "3":
					saveGame();
					
					break;

				case "5":
					return;
					
					
				default:
					System.out.print("\nError. Please enter an integer between 1-5!");
					typeSlow("\nWhich number do you chose? Number = "); //needs to be changed accordingly
					String decision2 = s2.nextLine();
					decision = decision2; 
					
			}	
				++ count ; 
				welcome();	
		} while (true);
	}

	public void saveGame(//boolean isPlayer1)
	)
	{
		System.out.print("\n");

		FileOutputStream outputStream = null;
		ObjectOutputStream objectWriter = null;

		try
		{
			Scanner s2 = new Scanner(System.in);
			System.out.print("\nPlease enter a name of this game.\nGame name: ");
			String name = s2.nextLine();

			outputStream = new FileOutputStream(name + ".txt");
			objectWriter = new ObjectOutputStream(outputStream);

			System.out.println();

			objectWriter.writeObject(game);
		}

		catch (IOException e)
		{
			System.out.println("Error in file write: " + e + "!");
		}

		finally
		{
			if (objectWriter != null)
			{
				try {
					objectWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void loadGame()
	{
		boolean fileExists = true;
		int tryThreeTimes = 0;

		FileInputStream fileReader = null;
		ObjectInputStream inputStream = null;
		String nextLine;


		try
		{
			Scanner s2 = new Scanner(System.in);
			System.out.print("\nPlease enter a name for your game. Game name: ");
			String name = s2.nextLine();

			fileExists = checkIfFileExists(name + ".txt");

			while((!fileExists) && (tryThreeTimes < 3))
			{
				System.out.print("\nStrange, we could not find a game with that name.");
				System.out.print("\nPlease a the name for your game. Game name: ");
				name = s2.nextLine();

				fileExists = checkIfFileExists(name + ".txt");
				tryThreeTimes++;

				if((tryThreeTimes == 2) && (!fileExists))
				{
					System.out.print("\nStrange, we could not find a game with that name.");
					System.out.print("\nWe will now take you back to the main menu. ");
					System.out.println();
				}
			}

			fileReader = new FileInputStream(name + ".txt");
			inputStream = new ObjectInputStream(fileReader);

			game = (Game) inputStream.readObject();
			//isPlayer1 = Boolean.parseBoolean(nextLine);

			//methods to set map to map
			// methods to set all the rest


		}

		catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Sorry, an error occurred."+ " \n");
		}

		finally
		{
			try
			{
				if (fileReader != null)
				{
					fileReader.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			}

			catch (IOException e)
			{
				System.out.println("Sorry, an error occurred.");
			}
		}
	}

	public boolean checkIfFileExists (String fileName)
	{
		File firstFile = new File(fileName);
		boolean exists = firstFile.exists();
		boolean readable = firstFile.canRead();
		boolean yepOrNope = false;

		if (exists && readable)
		{
			yepOrNope = true;
		}

		return yepOrNope;
	}

	public static void endGame() {
		System.exit(1);
	}
	
    public void typeSlow(String text)
    {
        String[] txt = text.split("");
        
        for (String aTxt : txt) 
        {
            System.out.print(aTxt);
            sleepMe(10);
        }

        System.out.println();
    }

	public void typeSlowest(String text)
	{
		String[] txt = text.split("");

		for (String aTxt : txt)
		{
			System.out.print(aTxt);
			sleepMe(60);
		}

		System.out.println();
	}
    
    public void sleepMe(int time) 
    {
        try 
        {
            Thread.sleep(time);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}