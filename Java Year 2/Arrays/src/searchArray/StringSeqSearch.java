package searchArray;

import java.util.Scanner;

public class StringSeqSearch 
{
	public static void main(String[] args) 
	{
		
		Scanner key = new Scanner(System.in);

	String [][] Players = {{"Jordan", "Wayne", "Allen", "Kent"},
			   {"Parker", "Logan", "Rogers", "Stark"},
			   {"Danvers", "Pride", "Grey", "Monro"}};
	
	int result;
	String search;

	disPlayer(Players);
	
	result = searchPos(int[] arrayA, int search)



	}

	private static void disPlayer(String[][] Players) 
	{
		for(int r = 0; r<3; r++)
		{
			System.out.print("\nTeam " +(r+1)+ ": ");
	
			for(int c = 0; c<4; c++)
			{
				System.out.print(""+Players[r][c]+ ", ");
			}
		   
		}

	}
	
	private static int searchPos(String[][] Players, String search)
	{
		int [][] pos = 0,0;
		
		for(int r = 0; r<3; r++)
		{
	
			for(int c = 0; c<4; c++)
			{
				if(Players[r][c].compareToIgnoreCase(search))
				{
					pos = x+1;
				}
			}
		   
		}
		
		for(int x=0; x < arrayA.length ;x++)
		{ 
			if(Players[])
			{
				pos = x+1;
			}
			
		}
		return pos;	
		
	}
}
