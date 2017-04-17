package simpleArray;

public class RunArray 
{

	public static void main(String[] args) 
	{
		
		/* 
		 
		// 1 Dimensional Array
		 
		int [] arrayA = {6,5,8,9,2,6,8,9,2,3};
		int [] arrayB = {6,4,3,4,5,8,9,6,7,8};
		
		for(int x=0; x<10; x++)
		{
			System.out.print("" +(x+1)+ ". " +arrayA[x]+ "\t" +arrayB[x]+ "\t" + 
							(arrayA[x]+arrayB[x])+ "\t" +(arrayA[x]-arrayB[x])+ "\t" + 
							(arrayA[x]*arrayB[x])+ "\n");
		}
		*/
		
		
		
		// 2 Dimensional Array
		
		String [][] Players = {{"Jordan", "Wayne", "Allen", "Kent"},
							   {"Parker", "Logan", "Rogers", "Stark"},
							   {"Danvers", "Pride", "Grey", "Monro"}};
		
		disPlayer(Players);
		
		
		
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

}
