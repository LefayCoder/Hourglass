import java.util.*;

public class Hourglass 
{
    public static void main(String[] args) 
    {
    	int [][] matrix = new int[6][6];
    	int [][] tempo = new int [3][3];
    	Integer [] arraySum = new Integer [16];
    	int hourglass = 1;
    	
    	int Godeey = 0; // It changes the column as it transition to the next Hourglass.
    	int GodeeyMeyta = 0; // It changes the rows as it transition to the next set of Hourglass.
    	int total = 0;
    	int total2 = 0;
    	
    	Scanner input = new Scanner(System.in);
    	
    	//System.out.println("Enter " + matrix.length + " rows and " + matrix[0].length + " columns: ");
    	
    	for (int row = 0; row < matrix.length; row++) // row 0
    	{
    		for (int column = 0; column < matrix[row].length; column++) // column 0
    		{
    			System.out.print("bro please populate the 2D array, got to type 16 time: ");
    			matrix[row][column] = input.nextInt();
    		} // end
    	}// end
    	
    	/*
    	// We got the array populated
    	for (int row = 0; row < matrix.length; row++) 
    	{
    		for (int column = 0; column < matrix[row].length; column++) 
    		{
    			matrix[row][column] = (int)(Math.random() * 100);
    		}
    	} */
    
    System.out.println("Bro, here is the array populated!!\n");
    
    	for (int row = 0; row < matrix.length; row++) 
    	{
    		for (int column = 0; column < matrix[row].length; column++) 
    		{
    			System.out.print(matrix[row][column] + " ");
    		}
    			System.out.println();
    	}
    
    // Every hour glass is populated from the 6x6 matrix, and summed up. There are four hourglasses
    	// in the first raw. The 6x6 have 16 hourglass, and the has four hourglass eligible rows.
	    
    	for(int roow = 0; roow < 4; roow++)	
    	{
    		Godeey = 0;
	    	for (int columnn = 0; columnn < 4; columnn++)
	    	{
	    		total = 0;
	        	total2 = 0;
	        	
	    		
		    	for (int row = 0, row1 = GodeeyMeyta; row < tempo.length; row++, row1++) 
		    	{
		    		for (int column = 0, column1 = Godeey; column < tempo[row].length; column++, column1++) 
		    		{	
		    			tempo[row][column] = matrix[row1][column1];
		    		}
		    		
		    	}
		    	
		    	System.out.println("*****************************************");
		    	
		    	System.out.println("Here is the semi 3 x 3 Hourglass Number : " + hourglass);
		    	
		    	for (int row = 0; row < tempo.length; row++) 
		    	{
		    		for (int column = 0; column < tempo[row].length; column++) 
		    		{
		    			System.out.print(tempo[row][column] + " ");
		    		}
		    			System.out.println();
		    	}
		    	  	   	
		    	for (int row = 0; row < tempo.length; row++) 
		    	{
		    		for (int column = 0; column < tempo[row].length; column++) 
		    		{
		    			total += tempo[row][column];
		    		}
		    	}
		    	
		    	System.out.println("\nHere the sum of the Semi hourglass:" + total);
		    	
		    	tempo[1][0] = 0;
		    	tempo[1][2] = 0;  
		    	
		    	System.out.println("\nHere is the Full 3 x 3 Hourglass, Number:" + hourglass + "\n");
		    	
		    	for (int row = 0; row < tempo.length; row++) 
		    	{
		    		for (int column = 0; column < tempo[row].length; column++) 
		    		{
		    			System.out.print(tempo[row][column] + " ");
		    		}
		    			System.out.println();
		    	}
		    	
		    	
		    	for (int row = 0; row < tempo.length; row++) 
		    	{
		    		for (int column = 0; column < tempo[row].length; column++) 
		    		{
		    			total2 += tempo[row][column];
		    		}
		    	}
		    	
		    	System.out.println("\n Here the sum of the Second hourglass:" + total2);
		    	
		    	
		    	
		    	arraySum[hourglass-1] = total2;
		    	
		    	hourglass++;
		    	Godeey++; // It walks to the next start of the next hour glass.
	    	}	// end of VIP for-loop for columns		
	    	GodeeyMeyta++; // It walks to the next start of the next hour glass.
    	}// end of VIP for-loop for rows
    	
    	for(int summ = 0; summ < arraySum.length;summ++)
    	{
    		System.out.println(arraySum[summ]+ ", ");
    	}
    	
    	System.out.println("\n");
    	
    	mergeSort(arraySum);
		System.out.println(Arrays.toString(arraySum));
    	
		
    	
	  } // end of Main.
    
    public static void mergeSort(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    	
} // end of class.
