import java.util.*;
import java.lang.*;
public class GPTree {
	
	
	public TreeNode rootnode = new TreeNode(); //every tree should have at least a root node
	public double fitness;
	
	
	String [] operators = {"+","-","*","/"};
	String [] operatants = {"0","1","2","3","4","5","6","7","8","9","x"};
	
	
	int index1, index2;
	Random generator = new Random();
	//constructor, here use code to make sure that the root is an operator
	final int HEIGHT = GetInput.height;
	
	public String ToString(double value)
	{
		String result = Double.toString(value);

	      return result;

	}
	
	//constructor
	public GPTree()
	{
		//index1 = generator.nextInt(3); //TODO - Li: Why is this a 3? If root is operand, should be a 4
		index1 = generator.nextInt(4);
		rootnode = new TreeNode(operators[index1]);
		rootnode.level=0;
		//System.out.print(rootnode);
	}
	
	//copy - constructor
	  public GPTree(GPTree another) {
		    this.rootnode = another.rootnode;
		  }
	

	
	
	public TreeNode GenTree(int hight)
	{
		//decide whether this is an operator or operand
		TreeNode temp;

		
		
		index1 = generator.nextInt(2);
		
		
		if ((index1==1) | (hight == HEIGHT)) // if index1 == 1 then a random operand will be generated
		{
			//TODO - SMM: is this where we need to place a "(" ?
			index2 = generator.nextInt(11);
			TreeNode newnode;
			
			newnode = new TreeNode(operatants[index2]);
			
			newnode.level = hight;
			newnode.IsLeaf = true;
			temp = newnode;
			//TODO - SMM: and here a ")" ?

			
				
		}
		else   // index1 == 0 so a random operator will be generated
		{
			index2 = generator.nextInt(4);
			TreeNode newnode = new TreeNode(operators[index2]);
			newnode.level = hight;
			newnode.IsLeaf = false;
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
	public double EvaTree(TreeNode Temp, double value)
	{
		double evaluation =0;
		
		if (Temp.IsLeaf == true ) 
		{
			if (Temp.data.compareTo("x") == 0) evaluation = value;
			else evaluation = ToDouble(Temp.data);
			
		}
		else
		{
			double leftvalue = EvaTree(Temp.left, value);
			double rightvalue = EvaTree(Temp.right, value);
			
			if (Double.isNaN(leftvalue) || Double.isNaN(rightvalue)) evaluation = Double.NaN;
			else{
			if (Temp.data.compareTo("+") == 0) evaluation = leftvalue + rightvalue;
			if (Temp.data.compareTo("-") == 0) evaluation = leftvalue - rightvalue;
			if (Temp.data.compareTo("*") == 0) evaluation = leftvalue * rightvalue;
			if (Temp.data.compareTo("/") == 0) 
				{
				if (Math.abs(rightvalue) <0.0000001) evaluation = Double.NaN;
				else evaluation = leftvalue / rightvalue;
				
				
				}
			
			}
		}
		
		return evaluation;
		
	}
	
	
	public void printTree(TreeNode temp)
	
	{	
		

		if (temp!=null)
		{
		

		if (temp.IsLeaf)

			{
			printTree(temp.left);
			}
		else
			{
			System.out.print("(");
			printTree(temp.left);
			}			
		
		//System.out.print(" ");
		System.out.print(temp.data);
		//System.out.print(" ");
		

		if (temp.IsLeaf)

			{
			printTree(temp.right);
			}
		else
			{
			printTree(temp.right);
			System.out.print(")");
			}	

		}
	}
	
	public void mutation(TreeNode temp1, TreeNode temp2)
	{
		if (temp1.IsLeaf && temp2.IsLeaf)
		{String temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;
		}
		else{
			index1 = generator.nextInt(2);
			index2 = generator.nextInt(2);
			if (index1 == 0 && index2 ==0) mutation(temp1.left,temp2.left);
			if (index1 == 1 && index2 ==0) mutation(temp1.right,temp2.left);
			if (index1 == 0 && index2 ==1) mutation(temp1.left,temp2.right);
			if (index1 == 1 && index2 ==1) mutation(temp1.right,temp2.right);
		}
	}


	
	
}

