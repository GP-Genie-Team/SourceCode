import java.util.*;
public class Test20131210 {

	public static void main (String [] arg){
		GPTree tree = new GPTree();
		tree.rootnode = new TreeNode("+");
		tree.rootnode.left = new TreeNode ("/");
		tree.rootnode.right = new TreeNode ("*");
		
		tree.rootnode.IsLeaf = false;
		tree.rootnode.left.IsLeaf = false;
		tree.rootnode.right.IsLeaf = false;
		
		tree.rootnode.left.left = new TreeNode ("10");
		
		tree.rootnode.left.right = new TreeNode ("5");
		tree.rootnode.right.left = new TreeNode ("7");
		tree.rootnode.right.right = new TreeNode ("1");
		
		tree.rootnode.left.left.IsLeaf = true;
		tree.rootnode.left.right.IsLeaf = true;
		tree.rootnode.right.left.IsLeaf = true;
		tree.rootnode.right.right.IsLeaf = true;
		
		System.out.println(tree.EvaTree(tree.rootnode, 1));
		tree.printTree(tree.rootnode);
	}
}
