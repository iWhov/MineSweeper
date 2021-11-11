import java.util.Scanner;


public class Board 
{
	private Square[][] Square;
	private int boardHeight;
	private int boardWidth;
	private int numBombs;
	
	Scanner input = new Scanner(System.in);
	
							//Constructor Method to make a the Board
	public Board()
	{
		System.out.println("What should the height of the board be?");
		boardHeight = input.nextInt();
		
		System.out.println("What should the width of the board be?");
		boardWidth = input.nextInt();
		
		
		Square = new Square[boardHeight][boardWidth];
		
		
		for (int i = 0; i < Square.length; i++)
		{
			for (int j = 0; j <Square[0].length; j++)
			{
				Square[i][j] = new Square();
			}
		}
	}
	
							//Method to set the amount of bombs
	public void setBombs()
	{
		System.out.println("How many bombs should there be?");
		numBombs = input.nextInt();
		
		
		
		int squareHeight = (int)(Math.random() * (boardHeight));
		int squareWidth = (int)(Math.random() * (boardWidth));
		
		
		do
		{
			
			if (!Square[squareHeight][squareWidth].getSquare())
			{
				Square[squareHeight][squareWidth].setSquare(true);
				
				numBombs --;
			}
			else
			{
				squareHeight = (int)(Math.random() * (boardHeight));
				squareWidth = (int)(Math.random() * (boardWidth));
			}
			
		} while (numBombs > 0);
	}
	
	
							//Method to set a Label
	public void setLable()
	{
		System.out.println("What is the row of the square you would like to mark?");
		int squareRow = input.nextInt() - 1;
		
		System.out.println("What is the Column of the square you would like to mark?");
		int squareColumn = input.nextInt() - 1;
		
		System.out.println("[1]: Lable Square Bomb \n[2]: Lable Square Question Mark");
		Square[squareRow][squareColumn].setLable(input.nextInt());
		
	}
	
								//Selects a Square
	public void selectSquare(int row, int column)
	{
		
		
		if (Square[row][column].getSquare())
		{
			System.out.println("You Hit A BOMB! Game Over!");
			System.exit(0);
		}
		else
		{
			if (checkForBombs(row, column) == 0)
			{
				setSurroundingTiles(row,column);
			}
			Square[row][column].setSelected(true);
			Square[row][column].setLableBomb(checkForBombs(row, column));
			Square[row][column].setRevealed(true);
			checkTilesAroundSquare(row,column);
			
		}
	}
								//Checks for bombs in surrounding area
	public int checkForBombs(int row, int column)
	{
		int numOfBombs = 0;
		
		
		
		for (int i = row - 1; i <= row + 1 ; i ++)
		{
			for (int j = column - 1; j <= column + 1; j ++)
			{
				try
				{
					if (Square[i][j].getSquare())
					{
						numOfBombs ++;
					}
					else
					{
						
					}
				}
				catch (Exception e)
				{
					
				}
			}
		}
		
		
		return numOfBombs;
	}
							//2nd method to check for Bombs
	public void checkTilesAroundSquare(int row, int column)
	{
	
		
		for (int i = row - 1; i <= row + 1 ; i ++)
		{
			for (int j = column - 1; j <= column + 1; j ++)
			{
				try
				{
					if (Square[i][j].getSelected())
					{
						
					}
					else if (checkForBombs(i,j) == 0)
					{
						selectSquare(i, j);
						
						setSurroundingTiles(i, j);
						
					}
				}
				catch (Exception e)
				{
					
				}
			}
		}
	}
						//sets surrounding tiles to the number of bombs around it
	public void setSurroundingTiles(int row, int column)
	{
		for (int i = row - 1; i <= row + 1 ; i ++)
		{
			for (int j = column - 1; j <= column + 1; j ++)
			{
				try
				{
				Square[i][j].setLableBomb(checkForBombs(i, j));
				}
				catch (Exception e)
				{
					
				}
			}
		}
	}
								//Checks for a win
	public boolean checkForWin()
	{
		int numClearTiles = 0;
		boolean Win = false;
		
		for(int i = 0; i < Square.length; i ++)
		{
			
			for (int j = 0; j < Square[0].length; j ++)
			{
				if (Square[i][j].getSquare() || Square[i][j].getRevealed())
				{
					numClearTiles ++;
				}
			}
		}
		if (numClearTiles == Square.length * Square[0].length)
		{
			
			Win = true;
		}
		return Win;
	}
	
							//method that returns the board
	public String toString()
		{
			String Board = "";
			
			for (int i = 0; i < Square.length; i++)
			{
				String row = "";
				for (int j = 0; j < Square[0].length; j ++)
				{
				row = row + " " + Square[i][j];
				}
				
				Board = Board + "\n" + row;
			}
			
			return Board;
		}
	
	
}
