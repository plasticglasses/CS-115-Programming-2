import java.util.Scanner;
/**
 * tests that a file can be accessed and used to get profiles into a BST.
 * @author lizks
 *
 */
public class FileReaderMain {

	public static void main(String args[]) {
		//makes tree and adds data (profiles) to BST
		BST tree;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter filename: ");
		String filename = input.next();
		input.close();

		tree = FileReader.readProfiles(filename);
		System.out.println(tree);
	}
}
