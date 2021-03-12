import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * this class tests the graph. 
 * It automatically loads files - test file which holds profile data 
 * and friendships which holds names of friends
 * @author liz
 *
 */
public class GraphMain {
	public static void main(String args[]) {
		//makes tree
		BST tree;

		//optional user entry of file names
		//Scanner input = new Scanner(System.in);
		//System.out.println("Enter filename: ");
		String filename = "src/data/testFile.txt";

		//makes a tree of profiles
		tree = FileReader.readProfiles(filename);
		
		//optional user entry of file names
		//System.out.println("Enter filename: ");
		//String friendsFilename = input.next();
		String friendsFilename = "src/data/friendships";
		//input.close();
		
		//makes a new graph connecting profiles together
		Graph graph = new Graph(friendsFilename, tree);
		//System.out.println(tree.getRoot().getProfile().getFriend(0));
		
		BST partayTree = new BST();
		ArrayList<Profile> invitations = new ArrayList<Profile>() ;
		invitations.add(tree.getRoot().getProfile());

		partayTree = graph.bigParty(invitations);
		partayTree.printAlphabetical(partayTree.getRoot());
	}
}
