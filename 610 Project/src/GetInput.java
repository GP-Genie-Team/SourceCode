import java.util.*;

public class GetInput {

	public static int size, height, percent, timeinterval, choice;
	boolean IsValid = false;
	
	Scanner scan = new Scanner (System.in);
	
	
	public void getvariable ()
	{
		System.out.println(" Welcome to GP Genie! ");
		while (IsValid == false)
		{
			System.out.println("Please enter the height of tree you would like to use for this peoject (between 2 to 10): ");
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
			System.out.println("Please enter the size of population you would like to use for this peoject (between 100 to 400): ");
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
			System.out.println("Please enter the percentage of population you would like to keep for this peoject (between 10 to 30): ");
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
			System.out.println("Please enter the run time you would like to use for this peoject (between 1 to 15): ");
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
		
		IsValid = false;
		
		while (IsValid == false)
		{
			System.out.println("Please select which program to run: target (1) or optional (2) ");
			timeinterval = scan.nextInt();
		
			if (timeinterval<=2 && timeinterval >=1 ) 
			{
				IsValid = true;
			}
			else
			{
			IsValid = false;
			}
		}
		
		
	}
	
}
