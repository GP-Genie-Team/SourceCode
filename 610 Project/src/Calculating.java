import java.util.*;


public class Calculating {
	public static void main (String [] arg){
		int index, index1,index2, index3, index4, index5;
		
		int index6, index7, index8;
		
		int index9, index10, cutoff;
		long start,now, diff;

		//TreeNode temp1, temp2;
		GetInput getinput = new GetInput();
		getinput.getvariable();
		

		Random generator = new Random();
		final int POPULATION = getinput.size;
		int height = GetInput.height;
		cutoff = POPULATION*GetInput.percent/100;
		final int CUT_OFF = POPULATION*GetInput.percent/100;
		int rand [] = new int [CUT_OFF];
		
		for (index =0; index<CUT_OFF; index++)
		{
			rand[index] = index;
		}
		
		
		
	
		
		Trainingdata training = new Trainingdata();
		
		Mutation mute = new Mutation();
		
		GPTree temp = new GPTree();
		
		//calculating current time
		start = System.currentTimeMillis( );
		diff = 0;
		

		
		// this part initialize the population, and sort them using the fitness data
		System.out.println("Generating trees and calculating their fitness…");
		
		GPTree [] Trees = new GPTree[POPULATION];
		Trees[0] = new GPTree();
		
		
		Trees[0].rootnode.left = Trees[0].GenTree(1);

		Trees[0].rootnode.right = Trees[0].GenTree(1);
	
		
		for (index2 = 0; index2<45; index2 ++)
		{
			
			double value = training.training_input[index2];
			double cal = Trees[0].EvaTree(Trees[0].rootnode,value);
			if (Double.isNaN(cal)) Trees[0].fitness = Double.MAX_VALUE;
			else Trees[0].fitness += Math.abs(cal-training.training_output[index2]);
			
		}
		
		
		
		for (index=1;index < POPULATION; index ++)
		{
			Trees[index] = new GPTree();
			
			Trees[index].rootnode.left = Trees[index].GenTree(1);
			Trees[index].rootnode.right = Trees[index].GenTree(1);
			
			
			index1 = index;
			for (index2 = 0; index2<45; index2 ++)
			{
				double value = training.training_input[index2];
				double cal = Trees[index].EvaTree(Trees[index].rootnode,value);
				if (Double.isNaN(cal)) Trees[index].fitness = Double.MAX_VALUE;
				else Trees[index].fitness += Math.abs(cal-training.training_output[index2]);
				
			}
			
			
			temp = Trees[index];
			while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
			{
				Trees[index1] = Trees[index1-1];
				index1 --;
			}
			Trees[index1] = temp;
			
		}
		
		for (index =0; index <POPULATION; index ++)
		{
			System.out.print(Trees[index].fitness);
			System.out.print("\t");
			Trees[index].printTree(Trees[index].rootnode);
			System.out.println();
		}
		System.out.println("Above data shows initial trees sorted by fitness and their fitness values.");
		System.out.println("Now performing crossover and mutation for next generation of trees...");

		
		
		

				
		//tree.printTree(tree.rootnode);
		//System.out.print("fitness: ");
		//System.out.println(tree.EvaTree(tree.rootnode));
		
		//now generating next generation of population
		//assuming keeping first 200 every time


		while (diff < GetInput.timeinterval*60*1000 && (Trees[0].fitness >=0.0)){  //TODO SMM turn the 10 back into 1000 to get back to minutes.
			
				//first, crossover, using the kept parent to generate a new set of children
			
			//random generate a set of random number for cross-over
			
			for (int i =0; i<100; i++)
			{
				index1 = generator.nextInt(cutoff);
				index2 = generator.nextInt(cutoff);
				int j = rand[index1];
				rand[index1]=rand[index2];
				rand[index2] =j;
			}

			

			for (index6 = 0; index6<cutoff/2; index6 ++)
				{

					index7 = cutoff + 2*index6;
					index8 = cutoff + 2 * index6 +1;
					
					Trees[index7] = new GPTree(Trees[rand[index6*2]]);
					Trees[index8] = new GPTree(Trees[rand[index6 *2 +1]]);
					
					mute.crossover(Trees[index7].rootnode, Trees[index8].rootnode);

					
				}
	
				
				

					//now, mutation, using the kept parent to generate another set of children using mutation

					for (index6 = 0; index6<cutoff; index6++)
					{
						index7 = index6 + cutoff*2;				
						Trees[index7] = new GPTree(Trees[rand[index6]]);
						
						//System.out.println(index7);
						//Trees[index4].printTree(Trees[index4].rootnode);
						mute.mutating(Trees[index7].rootnode);
						
						//System.out.println(index4);
					}
			
		
					//System.out.println("done1");
					//now insert the newly generated tree to the correct position
					
					for (index = cutoff; index <cutoff*3; index ++)
					{
						
						index1 = index;
						for (index2 = 0; index2<45; index2 ++)
						{
							double value = training.training_input[index2];
							double cal = Trees[index].EvaTree(Trees[index].rootnode,value);
							if (Double.isNaN(cal)) Trees[index].fitness = Double.MAX_VALUE;
							else Trees[index].fitness += Math.abs(cal-training.training_output[index2]);
							
						}
						
						
						temp = Trees[index];
						while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
						{
							Trees[index1] = Trees[index1-1];
							index1 --;
						}
						Trees[index1] = temp;
						

						
					}
					
					
					//System.out.println("done2");
				//now random generate the rest tree
				
				for (index=cutoff*3;index < POPULATION; index ++)
				{
					Trees[index] = new GPTree();
					
					Trees[index].rootnode.left = Trees[index].GenTree(1);
					Trees[index].rootnode.right = Trees[index].GenTree(1);
					
					
					index1 = index;
					for (index2 = 0; index2<45; index2 ++)
					{
						double value = training.training_input[index2];
						double cal = Trees[index].EvaTree(Trees[index].rootnode,value);
						if (Double.isNaN(cal)) Trees[index].fitness = Double.MAX_VALUE;
						else Trees[index].fitness += Math.abs(cal-training.training_output[index2]);
						
					}
					
					
					temp = Trees[index];
					while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
					{
						Trees[index1] = Trees[index1-1];
						index1 --;

					}
					Trees[index1] = temp;
				}
				
		
			
			now = System.currentTimeMillis( );
			diff = now - start;
			//System.out.println(diff);
			//System.out.println(Trees[0].fitness);
		//}
			
		}
		System.out.println("Population and trees after crossover and mutation:");
		System.out.println();
		for (index =0; index <POPULATION; index ++)
		{
			System.out.print(Trees[index].fitness);
			System.out.print("\t");
			Trees[index].printTree(Trees[index].rootnode);


			System.out.println();
		}
		
		System.out.println("Run complete. Least fit and three fittest trees shown below.");


		System.out.println();
		System.out.print("Population\t");
		System.out.print(GetInput.size);
		System.out.println();
		System.out.print("Max Height\t");
		System.out.print(GetInput.height);
		System.out.println();
		System.out.print("Fit Percent\t");
		System.out.print(GetInput.percent);
		System.out.println();
		System.out.print("Run Time\t");
		System.out.print(diff/60000);
		System.out.print(" minute(s)");
		
		System.out.println();
		System.out.println();
		
		System.out.print("Tree 99\t");
		System.out.print(Trees[99].fitness);
		System.out.print("\t");
		Trees[99].printTree(Trees[99].rootnode);
		System.out.println();
		
		System.out.print("Tree  2\t");
		System.out.print(Trees[2].fitness);
		System.out.print("\t");
		Trees[2].printTree(Trees[2].rootnode);
		System.out.println();
		
		System.out.print("Tree  1\t");
		System.out.print(Trees[1].fitness);
		System.out.print("\t");
		Trees[1].printTree(Trees[1].rootnode);
		System.out.println();
		
		System.out.print("Tree  0\t");
		System.out.print(Trees[0].fitness);
		System.out.print("\t");
		Trees[0].printTree(Trees[0].rootnode);
		System.out.println();
		

	}

}
