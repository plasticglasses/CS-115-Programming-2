
/**
 * this main method tests that the tree is prontedin alphabetical order.
 * @author liz
 *
 */
public class AlphaMain {
	public static void main(String args[]){
		//hard coding profiles
		Profile liz = new Profile("Liz", 13, 02, 1999, "Swansea", "England", "norweign", new String[] {"pasta", "swimming"});
		System.out.println(liz.toString());
		
		Profile ellis = new Profile("Ellis", 25, 05, 1999, "Manchester", "Colombia", "Welsh", new String[] {"climbing"});
		System.out.println(ellis.toString());
		
		Profile harry = new Profile("Harry Potter", 01, 07, 1989, "Little Winging", "London", "English", new String[] {"kiling moldly voldy"});
		
		Profile luke = new Profile("Luke", 01, 07, 1989, "Ling", "don", "Engsh", new String[] {"yoga"});

		Profile fred = new Profile("fred", 01, 07, 1989, "Ling", "frog", "jamiam", new String[] {"dancing", "gaming", "driving"});
		System.out.println(fred.toString());
		
		//mkaing a tree and adding profiles
		BST tree = new BST();
		tree.insertProfile(harry);
		tree.insertProfile(ellis);
		tree.insertProfile(liz);
		tree.insertProfile(luke);
		tree.insertProfile(fred);
		
		System.out.println(tree.getRoot().getProfile().getName());
		tree.printAlphabetical(tree.getRoot());
	}
}
