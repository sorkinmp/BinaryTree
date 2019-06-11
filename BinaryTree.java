/**
 * A binary tree implementation. When adding values to
 * a tree, there is no assumed "correct" location for that value.
 * So, we will give the root package access, so that we can manually
 * build our trees from a tester class.
 * 
 * @author sorkinmp
 *
 */

public class BinaryTree {
	// Variables
	Node root;
	
	// Constructors
	
	// default
	public BinaryTree() {
		root = null;
	}
	
	// Methods
	/**
	 * Returns the height of this tree
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public int getNumberOfNodes() {
		return getNumberOfNodes(root);
	}
	
	private int getNumberOfNodes(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + getNumberOfNodes(root.left) + getNumberOfNodes(root.right);
	}
	
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(root);
	}
	
	private int getNumberOfLeaves(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
	}
	
	/**
	 * Prints the preorder traversal of this tree
	 * First visit (print) root, then subtrees (first left then right)
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " " );    // visit root
			preorderTraversal(root.left);          // visit left subtree
			preorderTraversal(root.right);         // visit right subtree
		}
	}
	
	/**
	 * Prints the inorder traversal of this tree
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);          // visit left subtree
			System.out.print(root.data + " " );   // visit root
			inorderTraversal(root.right);         // visit right subtree
		}
	}
	
	/**
	 * Prints the postorder traversal of this tree
	 * First visit subtrees, then root
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node root) {
		if (root != null) {
			postorderTraversal(root.left);          // visit left subtree
			postorderTraversal(root.right);         // visit right subtree
			System.out.print(root.data + " " );     // visit root
		}
	}
	
	public boolean isFull() {
		return getNumberOfNodes() == Math.pow(2, getHeight()) - 1;
	}
	
	public boolean contains(int value) {
		return contains(value, root);
	}
	
	private boolean contains(int value, Node root) {
		if (root != null) {
			return value == root.data || contains(value, root.left) || contains(value, root.right);
		}
		return false;
	}
	
	public int getMin() {
		return getMin(root);
	}
	
	private int getMin(Node root) {
		if (root != null) {
			int data = root.data;
			return Math.min(data, Math.min(getMin(root.left), getMin(root.right) ) );
		}
		return Integer.MAX_VALUE;  // if null, value will be max value
	}

}
