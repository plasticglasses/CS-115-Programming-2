/**
 * Aim of this class is to: make a binary search tree, 
 * allow access to the root of the binary search tree, 
 * assign a profile to a place in the binary search tree
 * allow a BST Node to be added to the tree - defendant on its alphabetical order
 * 
 * @author liz
 *
 */
public class BST {

	private BSTNode root = null; //the root node of the binary tree

	/**
	 * constructor allowing a BST to be made and access methods.
	 */
	BST() {

	}

	/**
	 * 
	 * @return the root node of the binary search tree
	 */
	public BSTNode getRoot() {
		return root;
	}

	/**
	 * 
	 * @param root of the binary search tree
	 */
	public void setRoot(BSTNode root) {
		this.root = root;
	}

	/**
	 * makes a new binary search tree node.
	 * 
	 * @param p,
	 *            a profile made from the constructor of the profile class
	 */
	public void insertProfile(Profile p) {
		BSTNode node = new BSTNode(p);
		/**
		 * if there is no root node then this is the first node in the binary search
		 * tree, else call a recursive method to place the node in the correct
		 * alphabetical order
		 */
		if (getRoot() == null) {
			setRoot(node);
		} else {
			addNode(root, node);
		}

	}

	/**
	 * 
	 * @param parent,
	 *            first pass through it is the root node, it is the parent node, the
	 *            Parent node is compared to the new node, if it is alphabetically
	 *            before the new node, the new node is added on the right. else the
	 *            new node is before the root node and is added on the left
	 * @param node,
	 *            the new node which is being added to the binary tree
	 */
	public void addNode(BSTNode parent, BSTNode node) {
		String parentName = parent.getProfile().getName();
		String newName = node.getProfile().getName();
		int compare = parentName.compareTo(newName);
		
		// parent is smaller, so newNode should be added to the right
		if (compare <= 0) {
			if (parent.getRight() != null) {
				addNode(parent.getRight(), node);
			} else {
				parent.setRight(node);
				// System.out.println("right node has been added");
			}
		}
		
		// parent is bigger, so newNode should be added to the left
		if (compare > 0) {
			if (parent.getLeft() != null) {
				addNode(parent.getLeft(), node);
			} else {
				parent.setLeft(node);
				// System.out.println("left node has been added");
			}
		}
	}

	/**
	 * prints an in order traversal of the binary tree
	 * @param node - a BST node containing a profile
	 */
	public void printAlphabetical(BSTNode node) {
		if (node.getLeft() != null) {
			printAlphabetical(node.getLeft());
		}
		System.out.println(node.getProfile().getName());
		if(node.getRight() != null) {
			printAlphabetical(node.getRight());
		}
	}
}

