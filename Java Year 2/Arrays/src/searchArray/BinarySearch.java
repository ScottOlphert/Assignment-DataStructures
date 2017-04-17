package searchArray;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		 
		int [] ages = {26,51,81,29,32,16,48,39,22,39,30,42,92,17,58,64,38,62};
		int search, result;
		
		for (int x=0; x<ages.length; x++)//print unsorted array
		{
			System.out.print(ages[x] + " ");
		}
		
		System.out.print("\nPlease enter search number: ");
		search = key.nextInt();
		
		result = binarySearch(ages, search);
		
		if (result > -1)
		{
			System.out.print("your number is in position " +result+ " in the array\n");
		}
		else
		{
			System.out.print("your number is not in the array\n");
		}
		
		for (int x=0; x<ages.length; x++) // print sorted array
		{
			System.out.print(ages[x] + " ");
		}

	}
	
	private static int binarySearch(int[] ages, int search)
	{
		int temp = 0, start = 0, end = ages.length - 1, mid = 0;
		boolean change = false;
		//bubble sort
		do
		{
			 change = false;
			for(int x = 0; x<9; x++)
			{
				if(ages[x]>ages[x+1])
				{
					change = true;
					temp = ages[x];
					ages[x] = ages[x+1];
					ages[x+1] = temp;
				}
			}
				
		}
		while (change == true);
		
		
		// Binary search
		while(start<=end)
		{
			mid=(start+end)/2;
			
			if(search < ages[mid])
			{
				end=mid-1;
			}
			else 
				if(search > ages[mid])
				{
					start=mid+1;
				}
				else
				{
					start=end+1;
				}
		}
		
		if (search == ages[mid])
		{
			return mid;
		}
		else
		{
			return -1;
		}
		 
	}
	

}
