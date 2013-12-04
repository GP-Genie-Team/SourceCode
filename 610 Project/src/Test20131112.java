import java.util.*;

//susan testing checkin from new workspace
public class Test20131112 {
	public static void main (String [] arg){
		int index, index1,index2;
		
		Trainingdata training = new Trainingdata();
		
		// this part initialize the population, and sort them using the fitness data
		GPTree [] Trees = new GPTree[5];
		Trees[0] = new GPTree();

		Trees[0].rootnode.left = Trees[0].GenTree(1);
		Trees[0].rootnode.right = Trees[0].GenTree(1);
		for (index2 = 0; index2<5; index2 ++)
		{
			double value = training.training_input[index2];
			Trees[0].fitness += Math.abs(Trees[0].EvaTree(Trees[0].rootnode,value)-training.training_output[index2]);
			
		}
		
		for (index=1;index < 5; index ++)
		{
			Trees[index] = new GPTree();
			
			Trees[index].rootnode.left = Trees[index].GenTree(1);
			Trees[index].rootnode.right = Trees[index].GenTree(1);
			GPTree temp = new GPTree();
			
			index1 = index;
			for (index2 = 0; index2<5; index2 ++)
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
		
		for (index =0; index <5; index ++)
		{
			System.out.println(Trees[index].fitness);
		}
		

				
		//tree.printTree(tree.rootnode);
		//System.out.print("fitness: ");
		//System.out.println(tree.EvaTree(tree.rootnode));
		
		

	}
}
