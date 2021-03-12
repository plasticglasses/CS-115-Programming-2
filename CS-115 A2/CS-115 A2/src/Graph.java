import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this graph class connects friends together. It takes data from a friends
 * file, checks if the profiles exist using a post order traversal makes an
 * array list of profiles makes an array list for a party, adding the root nodes
 * friends only into an array list.
 * 
 * @author lizks
 *
 */
public class Graph {

	BST tree;

	// list of profile
	/**
	 * takes data from a file of friendships
	 * adds names to an array list to get one line from the file
	 * adds profiles to an array list to check if the profiles exist
	 * @param filename - the name of the friendship file
	 * @param tree - a BS tree
	 */
	public Graph(String filename, BST tree) {
		try {
			File file = new File(filename);
			Scanner in = new Scanner(file);
			in.useDelimiter(",");
			
			//for each line of the file
			while (in.hasNextLine()) {
				String line = in.nextLine();

				ArrayList<String> names = readNames(line); // gets two names
				ArrayList<Profile> profilesFound = new ArrayList<Profile>();

				//Verifies that names belong to profiles
				checkName(tree.getRoot(), names.get(0), profilesFound);
				checkName(tree.getRoot(), names.get(1), profilesFound);

				//if a profile does not exist, an error message is shown and the program stops
				try {
					profilesFound.get(1).getName();
				} catch (IndexOutOfBoundsException e) {
					System.out.println("The profile has not been found in the tree! :( ");
				}
				
				//adds each profile to the friends "friend" array list in the Profile class
				profilesFound.get(0).addFriend(profilesFound.get(1));
				profilesFound.get(1).addFriend(profilesFound.get(0));

			}

		} catch (FileNotFoundException e) {
			System.out.println("The file has not been found! :( ");
		}
	}

	/**
	 * this method takes one line of the file, splits it into variables, 
	 * nameOne is the first friends name
	 * nameTwo is the second friend name
	 * adds the friends to an array lists
	 * @param line - one line of the file
	 * @return aray list of the two friend names 
	 */
	public ArrayList readNames(String line) {
		Scanner in = new Scanner(line);
		in.useDelimiter(",");

		String nameOne = in.next();
		String nameTwo = in.next();

		ArrayList<String> names = new ArrayList<String>();
		names.add(nameOne);
		names.add(nameTwo);

		return names;
	}
	
	/**
	 * uses a post order traversal to check whether a friend name is valid and has a profile
	 * @param n - node
	 * @param name - the name of the friend
	 * @param profilesFound - an array list, profiles get added if they exist with the same name as the name variable
	 */
	// postOrder traversal
	public void checkName(BSTNode n, String name, ArrayList<Profile> profilesFound) {
		if (n.getLeft() != null) {
			checkName(n.getLeft(), name, profilesFound);
		}
		if (n.getRight() != null) {
			checkName(n.getRight(), name, profilesFound);
		}
		if (n.getProfile().getName().equalsIgnoreCase(name)) {
			profilesFound.add(n.getProfile());
		}
	}

	/**
	 * this method looks at the profile(s) on the invitation array list.
	 * adds the profile to a binary tree
	 * Adds all their friends profiles to a binary tree
	 * @param invitations - array list containing one or more profiles
	 * @return a binary tree with all friends of the root node
	 */
	public BST bigParty(ArrayList<Profile> invitations) {
		BST tree = new BST();
		for (Profile p : invitations) {
			tree.insertProfile(p);
			for (int n = 0; n < p.numOfFriends(); n++) {
				if (!invitations.contains(p.getFriend(n))) {
					tree.insertProfile(p.getFriend(n));
				}
			}
		}
		return tree;
	}
}
