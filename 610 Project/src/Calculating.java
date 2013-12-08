import java.util.*;


public class Calculating {
	public static void main (String [] arg){
		int index, index1,index2, index3, index4, index5;
		
		int index6, index7, index8;
		
		int index9, index10;
		long start,now, diff;

		//TreeNode temp1, temp2;
		GetInput getinput = new GetInput();
		getinput.getvariable();
		

		
		final int POPULATION = getinput.size;
		int height = GetInput.height;
		
		
		
		Random generator = new Random();
		
		Trainingdata training = new Trainingdata();
		
		Mutation mute = new Mutation();
		
		GPTree temp = new GPTree();
		
		//calculating current time
		start = System.currentTimeMillis( );
		diff = 0;
		
		
		// this part initialize the population, and sort them using the fitness data
		GPTree [] Trees = new GPTree[POPULATION];
		Trees[0] = new GPTree();

		Trees[0].rootnode.left = Trees[0].GenTree(1);
		Trees[0].rootnode.right = Trees[0].GenTree(1);
		for (index2 = 0; index2<45; index2 ++)
		{
			double value = training.training_input[index2];
			Trees[0].fitness += Math.abs(Trees[0].EvaTree(Trees[0].rootnode,value)-training.training_output[index2]);
			
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
				Trees[index].fitness += Math.abs(Trees[index].EvaTree(Trees[index].rootnode,value)-training.training_output[index2]);
				
			}
			
			
			temp = Trees[index];
			while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
			{
				Trees[index1] = Trees[index1-1];
				index1 --;
			}
			Trees[index1] = temp;
			
		}
		

		

				
		//tree.printTree(tree.rootnode);
		//System.out.print("fitness: ");
		//System.out.println(tree.EvaTree(tree.rootnode));
		
		//now generating next generation of population
		//assuming keeping first 200 every time
		while (diff < GetInput.timeinterval*360){
		for (index3 = 0; index <1; index ++)
		{
			//first, crossover, using the kept 200 to generate another 100
			for (index6 = 0; index6<50; index6++)
			{
				index4 = generator.nextInt(200);
				index5 = generator.nextInt(200);
				index7 = 200+ 2 * index6;
				index8 = 200 + 2 * index6 +1;
			
				Trees[index7] = Trees[index4];
				Trees[index8] = Trees[index5];
				mute.crossover(Trees[index7].rootnode, Trees[index8].rootnode);
				
			}
			
			//now insert the newly generated tree to the correct position
			
			for (index6 = 200; index6 <300; index ++)
			{
				
				for (index2 = 0; index2<45; index2 ++)
				{
					double value = training.training_input[index2];
					Trees[index6].fitness += Math.abs(Trees[index6].EvaTree(Trees[index6].rootnode,value)-training.training_output[index2]);
					
				}
				
				temp = Trees[index6];
				
				index8 = index6-1;
				while( (index8>0) && (temp.fitness<Trees[index8-1].fitness))
				{
					Trees[index8] = Trees[index8-1];
					index8 --;
				}
				Trees[index6] = temp;
				
			}
			
	
				//first, mutation, using the kept 200 to generate another 100
				for (index6 = 0; index6<100; index6++)
				{
					index4 = generator.nextInt(200);
					index7 = index6 + 300;				
					Trees[index7] = Trees[index4];

					mute.mutating(Trees[index7].rootnode);
					
				}
				
				//now insert the newly generated tree to the correct position
				
				for (index6 = 300; index6 <400; index ++)
				{
					
					for (index2 = 0; index2<45; index2 ++)
					{
						double value = training.training_input[index2];
						Trees[index6].fitness += Math.abs(Trees[index6].EvaTree(Trees[index6].rootnode,value)-training.training_output[index2]);
						
					}
					temp = Trees[index6];
					index8 = index6-1;
					while( (index8>0) && (temp.fitness<Trees[index8-1].fitness))
					{
						Trees[index8] = Trees[index8-1];
						index8 --;
					}
					Trees[index6] = temp;
					
				}
			
			//now random generate the rest tree
			
			for (index=400;index < 500; index ++)
			{
				Trees[index] = new GPTree();
				
				Trees[index].rootnode.left = Trees[index].GenTree(1);
				Trees[index].rootnode.right = Trees[index].GenTree(1);
				
				
				index1 = index;
				for (index2 = 0; index2<500; index2 ++)
				{
					double value = training.training_input[index2];
					Trees[index].fitness += Math.abs(Trees[index].EvaTree(Trees[index].rootnode,value)-training.training_output[index2]);
					
				}
				
				temp = Trees[index];
				while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
				{
					Trees[index1] = Trees[index1-1];
					index1 --;
				}
				Trees[index1] = temp;
				
			}
			
			
		}
		now = System.currentTimeMillis( );
		diff = now - start;

		
		}
	
		/*for (index =0; index <500; index ++)
		{
			System.out.println(Trees[index].fitness);
		}
		*/
		
		
		Trees[0].printTree(Trees[0].rootnode);
	}

}
