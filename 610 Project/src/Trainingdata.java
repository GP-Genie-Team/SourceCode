import java.util.*;

public class Trainingdata {
	public static void main (String [] args){
	
	double [] input = new double [45];
	double [] output = new double [45];
	Random rand = new Random();
	
	for (int i=0; i<45; i++)
	{
		double temp = rand.nextDouble();
		temp = 4.0 * (temp-0.5);
		input[i] = temp ;
		output [i] = (-3.0 *temp * temp *temp +7.0)/2;
		

	}
	
	for (int i=0; i<45; i++)
	{
		System.out.print(input[i] + ",");
		
	}
	System.out.println();
	
	for (int i=0; i<45; i++)
	{
		System.out.print(output[i] + ",");
		
	}
	
	}

}

