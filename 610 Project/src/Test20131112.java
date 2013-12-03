
public class Test20131112 {
	public static void main (String [] arg){
		int index, index1;
		
		
		// this part initialize the population, and sort them using the fitness data
		GPTree [] Trees = new GPTree[5];
		Trees[0] = new GPTree();
		Trees[0].rootnode.left = Trees[0].GenTree(1);
		Trees[0].rootnode.right = Trees[0].GenTree(1);
		
		for (index=1;index < 5; index ++)
		{
			Trees[index] = new GPTree();
			Trees[index].rootnode.left = Trees[index].GenTree(1);
			Trees[index].rootnode.right = Trees[index].GenTree(1);
			GPTree temp = new GPTree();
			temp = Trees[index];
			index1 = index;
			while( (index1>0) && (temp.EvaTree(temp.rootnode)<Trees[index1-1].EvaTree(Trees[index1-1].rootnode)))
			{
				Trees[index1] = Trees[index1-1];
				index1 --;
			}
			Trees[index1] = temp;
			
		}
		
		for (index =0; index <5; index ++)
		{
			System.out.println(Trees[index].EvaTree(Trees[index].rootnode));
		}
		
		
				
		//tree.printTree(tree.rootnode);
		//System.out.print("fitness: ");
		//System.out.println(tree.EvaTree(tree.rootnode));
		
		

	}
}
