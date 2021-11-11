import java.util.Scanner;


public class MineSweeperControl 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean NewGame = false;
		do
		{
		
		
		
		Board GameBoard = new Board();
		GameBoard.setBombs();
		
		int option;
		
		do
		{
			System.out.println(GameBoard.toString() + "\n");
		System.out.println("What would you like to do?");
		System.out.println("[1]: Set Square Lable \n[2]: Select Square \n[3]: Exit");
		option = input.nextInt();
		
		
		switch (option)
		{
		
		case 1:
			GameBoard.setLable();
			break;
		case 2:
			System.out.println("What is the row of the square you would like to select?");
			int squareRow = input.nextInt() - 1;
			
			System.out.println("What is the Column of the square you would like to select?");
			int squareColumn = input.nextInt() - 1;
			
			GameBoard.selectSquare(squareRow, squareColumn);
			if (GameBoard.checkForWin())
			{
				option = 3;
				System.out.println(GameBoard.toString());
				System.out.println("\nYou Won!!!!\n");
			}
				
			
			
			
			break;
		case 3:
			break;
			
		}
		} while (option != 3);
		
		
		System.out.println("New Game? [Y/N]");
		
		String answer = input.nextLine();
		answer = input.nextLine();
		
		switch (answer)
		{
		case "Y":
			NewGame = true;
			break;
		case "N":
			NewGame = false;
			break;
		}
		
		} while (NewGame);
input.close();

	}
	
}
