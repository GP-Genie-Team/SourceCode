import java.util.*;

public class GetInput {

	public static int size, height, percent, timeinterval;
	boolean IsValid = false;
	
	Scanner scan = new Scanner (System.in);
	/*
	private static int posNum(Scanner scan) {
	    int input = 0;
	    boolean error = false;
	    if (scan.hasNext()) {
	        if (scan.hasNextInt()) {
	            input = scan.nextInt();
	            error = input <= 0;
	        } else {
	            scan.next();
	            error = true;
	        }
	    }
	    while (error) {
	        System.out.print("Invalid input. Please reenter: ");
	        if (scan.hasNextInt()) {
	            input = scan.nextInt();
	            error = input <= 0;
	        } else {
	            if (scan.hasNext())
	                scan.next();
	            error = true;
	        }
	    }
	    return input;
	}
	*/
	
	public void getvariable ()
	{
		System.out.println("Welcome to GP Genie! ");
		while (IsValid == false)
		{
			System.out.println("Please enter the height of tree you would like to use for this project (between 2 to 10): ");
			height = scan.nextInt();
		
			if (height<=10 && height >=1 ) 
			{
				IsValid = true;
			}
			else
			{
			IsValid = false;
			}
		}
		
		IsValid = false;
		
		while (IsValid == false)
		{
			System.out.println("Please enter the size of population you would like to use for this project (between 100 to 400): ");
			size = scan.nextInt();
		
			if (size<=400 && size >=100 ) 
			{
				IsValid = true;
			}
			else
			{
			IsValid = false;
			}
		}
		
		IsValid = false;
		
		while (IsValid == false)
		{
			System.out.println("Please enter the percentage of population you would like to keep for this project (between 10 to 30): ");
			percent = scan.nextInt();
		
			if (percent<=30 && percent >=10) 
			{
				IsValid = true;
			}
			else
			{
			IsValid = false;
			}
		}
		
		IsValid = false;
		
		while (IsValid == false)
		{
			System.out.println("Please enter the run time you would like to use for this project (between 1 to 15): ");
			timeinterval = scan.nextInt();
		
			if (timeinterval<=15 && timeinterval >=1 ) 
			{
				IsValid = true;
			}
			else
			{
			IsValid = false;
			}
		}
		
		
		System.out.println("Program working to find match.... ");

	}
	
	public void printInputs ()
	{

	System.out.println(size);
	System.out.println(height);
	System.out.println(percent);
	System.out.println(timeinterval);
	}	

}
