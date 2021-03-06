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
	
	public double [] input = {-5.685849616022263,3.3682869645854163,4.201003178664386,-2.3980005154824813,2.863257914834587,-5.470855402802133,-0.5555000364092466,-3.483791316032827,4.2230395963185,5.6899462002511125,2.9624292580748945,-4.782305734450672,9.538506931113558,-8.101785147114358,0.4943746185904496,-89.18845101519794,-52.66172022018547,99.2748675723729,-86.85508620189755,-92.34122488123204,22.482269506799323,32.00928246343402,-15.753598238413357,-63.386374562537284,-76.27341611966743,-72.25379313426734,77.56553444232912,44.16597969622549,25.203823953836356,-78.28350201015493,976.5000488477659,-252.89208809902618,-885.6522815894974,364.32872056922963,423.5310442111377,785.3318997855279,451.1238745928481,134.37245324912416,969.5023648588233,-801.4748387064421,919.5302806002776,293.99599273640445,-748.9148149626214,982.8588804527707,86.02574968410414};
	public double [] output= {-44.993328784030766,-13.518035613694057,-22.97264156072242,-5.1256097083813685,-8.797368830294362,-41.39538825755394,3.0371295643239886,-14.705202900498605,-23.251095148110885,-45.063231642628104,-9.663980663647255,-30.80567220663967,-132.97467171235206,-94.95838385500423,3.1333906047403213,-11928.369691735545,-4156.385164823637,-14779.748997268263,-11312.20899870858,-12786.852718849399,-754.6786632645379,-1533.391245735857,-368.7637861860106,-6023.24872027341,-8722.951009845914,-7827.415933434248,-9021.118199986218,-2922.4506437911036,-949.349112843963,-9188.960030460898,-1430325.0180995339,-95928.11233462843,-1176566.4458270236,-199099.62494741773,-269064.31811586506,-925115.7892311197,-305265.6253414956,-27080.434288282086,-1409898.7532002765,-963539.3756192763,-1268300.405411238,-129646.96561759597,-841306.6001057462,-1449013.8683273105,-11097.144413068216};

	
	public String ToString(double value)
	{
		String result = Double.toString(value);

	      return result;

	}
	
	//constructor
	public GPTree()
	{
		index1 = generator.nextInt(4);
		rootnode = new TreeNode(operators[index1]);
		rootnode.level=0;
	}
	
	//copy - constructor
	  public GPTree(GPTree another) {
		    this.rootnode = another.rootnode;
		    this.fitness = another.fitness;
		  }
	
	  
	  public GPTree copyTree(GPTree another){
		  GPTree tree = new GPTree();
		  tree.rootnode = another.rootnode;
		  return tree;
	  }
	
	
	public TreeNode GenTree(int height)
	{
		//decide whether this is an operator or operand
		TreeNode temp;
		
		index1 = generator.nextInt(2);
		//System.out.println(index1);
		
		if ((index1==1) | (height == HEIGHT))  // if index1 == 1 then a random operand will be generated
		{
			index2 = generator.nextInt(11);
			TreeNode newnode;
			
			newnode = new TreeNode(operatants[index2]);
			
			newnode.level = height;
			newnode.IsLeaf = true;
			temp = newnode;
			
			
				
		}
		else
		{
			index2 = generator.nextInt(4);
			TreeNode newnode = new TreeNode(operators[index2]);
			newnode.level = height;
			newnode.IsLeaf = false;
			newnode.left = GenTree(height+1);
			newnode.right = GenTree(height+1);
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
	public double EvalTree(TreeNode Temp, double value)
	{
		double evaluation =0;
		
		if (Temp.IsLeaf == true ) 
		{
			if (Temp.data.compareTo("x") == 0) evaluation = value;
			else evaluation = ToDouble(Temp.data);
			
		}
		else
		{
			double leftvalue = EvalTree(Temp.left, value);
			double rightvalue = EvalTree(Temp.right, value);
			
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
	
	
	public void PrintTree(TreeNode temp)
	
	{	
		

		if (temp!=null)
		{
		
			if (temp.IsLeaf)
				{
				PrintTree(temp.left);
				}
			else
				{
				System.out.print("(");
				PrintTree(temp.left);
				}			
		
			System.out.print(temp.data);
	
	
			if (temp.IsLeaf)
				{
				PrintTree(temp.right);
				}
			else
				{
				PrintTree(temp.right);
				System.out.print(")");
				}	
		}
	}
	
	
	
}

