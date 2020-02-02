package main;

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
	
	private String namePlayer1;
	private String namePlayer2;
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
		
		namePlayer1 = "";
		namePlayer2 = "";
		gameName = "";
		//name = "";
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

	/**
	 * This method welcomes the user when the program is started by using a counter ('count') that is only zero the first time this method is used.
	 * This method then gives a short explanation of the game and opens the main menu. 
	 */

	public void welcome()
	{
		if (count == 0)
		{
			
			System.out.println("Hello. This is Snappy Ducks!" );
			
			System.out.println("\nOur hero, duck Beacky, after a long journey back to her pond,");
			System.out.println("finds that the pollution problem is even worse than a year ago. ");
			System.out.println("Snappy Beacky decides to fight back against the main cause of pollution - humans.");

			System.out.println("\nThe game displays the pond map. Beacky is marked as number 1 on the map,");
			System.out.println("and her friend Quilly as number 2. The obstacles are marked as O and");
			System.out.println("the human polluters, which ducks can fight, as H.");

			System.out.println("\n Would you like to... \n"
					+ "\n ... start a new game? Please enter number 1."
					+ "\n ... load an old game? Please enter number 2.");
					
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
						selectGame();
						break;
		
					default:
						System.out.print("\nSorry. This is not a valid choice. Please enter either '1' or '2'. ");
						notAValidChoice = true;
					return;
				}	
			}
			while(notAValidChoice);
		}
		
		else 
		{
			System.out.print("\nIs there anything else you would like to do? \n" );
		}
	}
	
	public void selectGame()
	{
			
			boolean notAValidName = false;

			loadGame();

			System.out.println("\nThanks. ");
		
			if(game.isPlayer1())
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
            System.out.print("\n ... play the game? Please enter number 1.");
			
			if (game.isPlayer1())
			{
				System.out.print("\n ... change to player 2? Please enter number 2.");
			}
			else
			{
				System.out.print("\n ... change to player 1? Please enter number 2.");
			}

			
			System.out.print("\n ... get some help with the rules? Please enter number 3.");
			System.out.print("\n ... exit the game? Please enter number 4. \n"
					+ "\n Which number do you choose? Number = ");

			Scanner s2 = new Scanner(System.in);
			String decision = s2.nextLine();
			
			
			while(!decision.equals("1") && !decision.equals("2") && !decision.equals("3") && !decision.equals("4"))
			{
				System.out.print("\nError. Please enter an integer between 1-4!"
				+ "\n" + "\nWhich number do you chose? Number = ");
				decision = s2.nextLine();
			}

			switch (decision) {

				case "1":

					System.out.println("\n Welcome back to the pond! \n ");
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
					System.out.print("\nThis is SNAPPYducks! These are the rules: xxx ");

					break;

				case "4":
					end = true;
					System.out.print("\n Thank you for playing SNAPPYducks. We hope you have enjoyed it. \n Goodybe. ");
					System.out.println();
					System.out.println();
					System.exit(0);
					break;

				default:
					System.out.print("\nError. Please enter an integer between 1-3!"
							+ "\n" + "\nWhich number do you chose? Number = ");
					decision = s2.nextLine();

			}
		}
	    while(!end);
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
					+ "\n ... save? Please enter number 3."
					+ "\n ... go to main menu? Please enter number 4.");
						
		

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
					game.playGame(s2);

					break;

				case "4":
					return;

				case "3":
					saveGame();
					
					break;
					
					
				default:
					System.out.print("\nError. Please enter an integer between 1-6!"
							+ "\n" + "\nWhich number do you chose? Number = "); //needs to be changed accordingly
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

			//prints the grid with the compuer's fleet (the one that the user can't see!)

			//  printWriter.print(isPlayer1);
			objectWriter.writeObject(game);
		}

		// print other stuff: inventory, score, etc


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

	private void setInputName(String nextLine) {

	}


	public void loadGame()
	{
		//boolean player1or2 = false;
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
}
		
		
		
		
	

 
