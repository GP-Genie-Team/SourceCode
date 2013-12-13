import java.util.*;
public class Mutation {
	
	Random generator = new Random();
	int index1,index2;
	

	public String [] operatants = {"0","1","2","3","4","5","6","7","8","9","x"};
	public void crossover(TreeNode temp1, TreeNode temp2)
	{
		if (temp1.IsLeaf && temp2.IsLeaf)
		{String temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;
		}
		
		if (temp1.IsLeaf && !temp2.IsLeaf)
		{
			index1 = generator.nextInt(2);
			if (index1==0) crossover(temp1, temp2.left);
			else crossover(temp1, temp2.right);
		}
		
		if (!temp1.IsLeaf && temp2.IsLeaf)
		{
			index1 = generator.nextInt(2);
			if (index1==0) crossover(temp1.right, temp2);
			else crossover(temp1.left, temp2);
		}
		
		if (!temp1.IsLeaf && !temp2.IsLeaf)
		{
			index1 = generator.nextInt(2);
			index2 = generator.nextInt(2);
			if (index1 == 0 && index2 ==0) crossover(temp1.left,temp2.left);
			if (index1 == 1 && index2 ==0) crossover(temp1.right,temp2.left);
			if (index1 == 0 && index2 ==1) crossover(temp1.left,temp2.right);
			if (index1 == 1 && index2 ==1) crossover(temp1.right,temp2.right);
		}
	}
	public void mutating(TreeNode temp)
	{
		/*if (temp.left.IsLeaf && temp.right.IsLeaf)
		{
			String data = temp.left.data;
			temp.left.data= temp.right.data;
			temp.right.data = temp.left.data; 
		}
		
		if (temp.left.IsLeaf && !temp.right.IsLeaf)
		{
			mutating(temp.right);
		}
		if (temp.right.IsLeaf && !temp.left.IsLeaf)
		{
			mutating(temp.left);
		}
		if (!temp.right.IsLeaf && !temp.left.IsLeaf)
		{
			index1 = generator.nextInt(2);
			if (index1==1) mutating(temp.left);
			else mutating(temp.right);
		}1*/
		
		if (temp.IsLeaf)
		{
			index1 = generator.nextInt(11);
			temp.data = operatants[index1];
		}
		else
		{
			index1 = generator.nextInt(2);
			if (index1 ==1) mutating (temp.left);
			else mutating (temp.right);
		}
			
		}
	
	}


