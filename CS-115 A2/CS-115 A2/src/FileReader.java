import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * this class reads from a file, sets up profiles.
 * @author lizks
 *
 */
public class FileReader {

	/**
	 * Reads the contents of the file as specified.
	 * For each line of the file, creates a Profile
	 * For each Profile, it uses insertProfile to place it in the correct place of the BST
	 * Commas (,) and semi-colons (;) are used to separate data in the file
	 * @param filename, the name of the text file which is copied to the scanner
	 */
	public static BST readProfiles(String filename) {
		try {
			BST tree = new BST();
			File file = new File(filename);
			Scanner in = new Scanner(file);
			in.useDelimiter(",");
			
			//for each line in the file, takes the line and makes a profile, adds it to the tree
			Profile newProfile = null;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				newProfile = inLine(line);
				tree.insertProfile(newProfile);
				//(tree.printAlphabetical(tree.getRoot());
			}
			return tree;
		} catch (FileNotFoundException e) {
			System.out.println("The file has not been found in the tree! :( ");
		}
		return null;
	}
	
	/**
	 * takes input from the scanner and sets it to variables
	 * @param line - one line in the file
	 * @return a profile
	 */
	public static Profile inLine(String line) {
		Scanner in = new Scanner(line);
		in.useDelimiter(",");
		String name = in.next();
		int dayOB = in.nextInt();
		int monthOB = in.nextInt();
		int yearOB = in.nextInt();
		String town = in.next();
		String country = in.next();
		String nationality = in.next();
		line = in.nextLine();
		in.close();
		
		String[] interests = addInterest(line);
		Profile newProfile = new Profile(name, dayOB, monthOB, yearOB, town, country, nationality, interests);
		
		//System.out.println(newProfile.toString());
		return newProfile;	
	}
	
	/**
	 * loops through to find the number of interests defines an array of the number
	 * of interests adds the interests to the correct sized array
	 * 
	 * @param line
	 * @return array of interests
	 */
	public static String[] addInterest(String line) {
		String[] interests = null;
		Scanner in = new Scanner(line);

		interests = line.split(";");

		return interests;
	}
	
}
