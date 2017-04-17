package searchArray;

import java.util.Scanner;

public class SequentialSearch {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		 
		int [] arrayA = {45,54,23,43,17,76,25,40,19,50,38,47,43,56,20,67};
		int search, result;
		
		System.out.print("Please enter search number: ");
		search = key.nextInt();
		
		result = searchPos(arrayA, search);
		
		if (result > 0)
		{
			System.out.print("your number is in position " +result+ " in the array");
		}
		else
		{
			System.out.print("your number is not in the array");
		}
		
		
		 
		 
	}
	
	private static int searchPos(int[] arrayA, int search)
	{
		int  pos = 0, length = arrayA.length;
		
		for(int x=0; x < arrayA.length ;x++)
		{ 
			if(arrayA[x]== search)
			{
				pos = x+1;
			}
			
		}
		return pos;	
		
	}

}
