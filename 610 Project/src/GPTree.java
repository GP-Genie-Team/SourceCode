import java.util.*;
import java.lang.*;
public class GPTree {
	
	
	public TreeNode rootnode = new TreeNode(); //every tree should have at least a root node
	public double fitness;
	
	
	String [] operators = {"+","-","*","/"};
	String [] operatants = {"0","1","2","3","4","5","6","7","8","9","10"};
	
	int index1, index2;
	Random generator = new Random();
	//constructor, here use code to make sure that the root is an operator
	public GPTree()
	{
		index1 = generator.nextInt(4);
		rootnode = new TreeNode(operators[index1]);
		rootnode.level=0;
	}
	

	
	
	public TreeNode GenTree(int hight)
	{
		//decide whether this is an operator or operatant
		TreeNode temp;
		
		index1 = generator.nextInt(2);
		//System.out.println(index1);
		
		if ((index1==1) | (hight ==10))
		{
			index2 = generator.nextInt(11);
			TreeNode newnode = new TreeNode(operatants[index2]);
			newnode.level = hight;
			temp = newnode;
			
				
		}
		else
		{
			index2 = generator.nextInt(4);
			TreeNode newnode = new TreeNode(operators[index2]);
			newnode.level = hight;
			newnode.left = GenTree(hight+1);
			newnode.right = GenTree(hight+1);
			temp = newnode;
			

			
			
		}
		
		return temp;
		
	}
	
	public boolean IsNumeric(String value)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(value);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return  false;  
	  }  
	  return true;  
	}
	
	public double ToDouble(String value)
	{
		double d = Double.parseDouble(value);
		return d;
	}
	
	
	//used to calculate the fitness of the GP tree
	public double EvaTree(TreeNode Temp)
	{
		double evaluation =0;
		
		if (IsNumeric(Temp.data)) evaluation = ToDouble (Temp.data);
		else
		{
			double leftvalue = EvaTree(Temp.left);
			double rightvalue = EvaTree(Temp.right);
			
			if (Temp.data.compareTo("+") == 0) evaluation = leftvalue + rightvalue;
			if (Temp.data.compareTo("-") == 0) evaluation = leftvalue - rightvalue;
			if (Temp.data.compareTo("*") == 0) evaluation = leftvalue * rightvalue;
			if (Temp.data.compareTo("/") == 0) evaluation = leftvalue / rightvalue;
			
			
		}
		
		return evaluation;
		
	}
	
	
	public void printTree(TreeNode temp)
	
	{
		if (temp.left!=null) printTree(temp.left);
		System.out.print(temp.data);
		if (temp.left!=null) printTree(temp.right);
	}
	


	public void getFitness(){
		this.fitness = EvaTree(rootnode);
		
	}
	
	
}

