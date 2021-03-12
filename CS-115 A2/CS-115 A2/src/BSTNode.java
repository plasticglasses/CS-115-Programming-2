/**
 * setter and getters for one node on the Binary search tree
 * @author liz
 *
 */
public class BSTNode {

	Profile data; //reference to the data
	BSTNode left; //reference to left node
	BSTNode right;//reference to right node
	
	/**
	 * constructor to make a binary search tree node
	 * @param data, a reference to a Profile object
	 */
	BSTNode(Profile data){
		this.data = data;
	}
	
	/**
	 * 
	 * @return reference to the Profile object
	 */
	public Profile getProfile() {
		return data;
	}
	
	/**
	 * Any data whcih is to the left of a node, is smaller than the parent node
	 * @param l, reference to the child node to the left of the parent node.
	 */
	public void setLeft(BSTNode l) {
		this.left = l;
	}
	
	/**
	 * The right node has a name which is after, or the same as the parent node
	 * @param r, reference to the child node to the right of the current node.
	 */
	public void setRight(BSTNode r) {
		this.right = r;
	}
	
	/**
	 * 
	 * @return left, returns the reference to the left child node
	 */
	public BSTNode getLeft() {
		return left;
	}
	
	/**
	 * 
	 * @return right, reference to the right child node
	 */
	public BSTNode getRight() {
		return right;
	}
	
}
