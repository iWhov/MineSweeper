
public class Square 
{
	boolean Square;
	String SquareLable;
	boolean Revealed;
	boolean Selected;
	
	public Square()
	{
		Square = false;
		SquareLable = "[.]";
		Revealed = false;
	}
	
						//Sets the Square status to true (Has Bomb)
	public void setSquare(boolean Bomb)
	{
		Square = Bomb;
	}
	
				//Sets The status of Revealed to true (Has been revealed on the Board)
	public void setRevealed(boolean Reveal)
	{
		Revealed = Reveal;
	}
	
					//Sets the Square boolean Square to True (Has been selected)
	public void setSelected(boolean Selected)
	{
		this.Selected = Selected;
	}
	
							//Returns if the Space has been selected
	public boolean getSelected()
	{
		return Selected;
	}
				//Returns the boolean Revealed to check if the Square is revealed on the Board
	public boolean getRevealed()
	{
		return Revealed;
	}
	
							//Returns the if the Square is a Bomb Square or Not
	public boolean getSquare()
	{
		return Square;
	}
	
						//returns the Squares Label
	public String toString()
	{
		return SquareLable;
	}
	
								//Sets the Label of the square to what the user selects
	public void setLable(int option)
	{
		if(option == 1)
		{
			SquareLable = "[!]";
		}
		else if (option == 2)
		{
			SquareLable = "[?]";
		}
	}
	
						//Sets the label of the Square to the number of bombs input
	public void setLableBomb(int numBombs)
	{
		if (numBombs == 0)
		{
			SquareLable = "[ ]"; 
		}
		else
		{
		SquareLable = "[" + numBombs + "]";
		Revealed = true;
		}
	}
}
