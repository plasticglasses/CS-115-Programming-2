/**
 * this class tests that nodes can be set, left and right and that data can be added
 * @author liz
 *
 */
public class BSTNodeMain {
	
	public static void main(String args[]) {
		//hard coding profiles
		Profile liz = new Profile("Liz", 13, 02, 1999, "Swansea", "England", "norweign", new String[] {"pasta", "swimming"});
		System.out.println(liz.toString());
		
		Profile ellis = new Profile("Ellis", 25, 05, 1999, "Manchester", "Colombia", "Welsh", new String[] {"climbing"});
		System.out.println(ellis.toString());
		
		Profile harry = new Profile("Harry Potter", 01, 07, 1989, "Little Winging", "London", "English", new String[] {"kiling moldly voldy"});
		
		//make BST nodes with a profile attached as data
		BSTNode Ellis = new BSTNode(ellis);
		BSTNode Liz = new BSTNode(liz);
		BSTNode Harry = new BSTNode(harry);
		
		//test set methods
		Harry.setLeft(Ellis);
		Harry.setRight(Liz);
		
		//show set methods print correctly
		System.out.println(Harry.getLeft().getProfile().getName());
		System.out.println(Harry.getRight().getProfile().getTown());
	}
	


}
