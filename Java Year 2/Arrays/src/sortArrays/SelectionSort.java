package sortArrays;

public class SelectionSort {

	public static void main(String[] args) 
	{
		int [] marks = {33,45,74,23,65,13,29,32,58,90,75,43,82,12,37,20,43};
		
		for (int x=0; x<16; x++)
		{
			System.out.print(marks[x]+ "\t");	
		}
		
		sort(marks,17);
		
		System.out.print("\n");
		
		for (int x=0; x<16; x++)
		{
			System.out.print(marks[x]+ "\t");	
		}

	}
	
	private static void sort(int marks[], int size)
	{
		int temp;
		for (int x=0; x<size-1; x++)
		{
			for (int y = x+1; y < size; y++)
			{
				if(marks[y]<marks[x])
				{
					temp = marks[x];
					marks[x] = marks[y];
					marks[y] = temp;
				}
			}
		}
	}

}
