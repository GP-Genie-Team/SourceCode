import java.util.*;

public class Trainingdata {
	

	Random generator = new Random();
	
	public double [] training_input = new double[5];
	public double [] training_output = new double[5];
	

	
	public Trainingdata(){
		for (int index =0; index <5; index++)
		{
			double temp = generator.nextDouble();
			temp = 4.0*(temp - 0.5);
			training_input[index] = temp;
			training_output[index] = (-3.0 * temp * temp +7)/2;
		}
	}
}
