package sortArrays;
import java. util. Scanner;

public class BubbleSort 
{
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int [] age = new int [10]; 
		int temp;
		boolean change = false;
		
		for(int x=0; x<10; x++)
		{
			System.out.print("Please enter age number " + (x+1) + ": ");
			age [x] = scan.nextInt();
		}
		
		do
		{
			change = false;
			for(int x = 0; x<9; x++)
			{
				if(age[x]>age[x+1])
				{
					change = true;
					temp = age[x];
					age[x] = age[x+1];
					age[x+1] = temp;
				}
			}
				
				
			
		}
		while (change == true);
			
		for (int x=0; x<9; x++)
		{
			System.out.print(age[x] + "\n");
		}
		
		
	}

}
