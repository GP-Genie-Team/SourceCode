import java.util.*;
import java.lang.*;

public class TreeNode {
	
	public String data; //can be an operator or operand
	public int ID,level;// use to track level
	public TreeNode left,right;
	public boolean IsLeaf;

	
	//constructor
	public TreeNode(String input)
	{
		this.data = input;
		this.IsLeaf = false;
		
	}
	
	
	public TreeNode()
	{
		this.data = null;
		this.IsLeaf = false;
		
		
	}
	
	public int GetLevel()
	{
		double cal = Math.log10(ID) /Math.log10(2);
		return (int)cal;
	}
	
	//
	

	
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
	



}
