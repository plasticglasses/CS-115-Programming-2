/**
 * this class tests if profiles can be made.
 * it tests all setters and getters.
 * @author liz
 *
 */

public class ProfileMain {

	public static void main(String args[]) {
		
		Profile liz = new Profile("Liz", 13, 02, 1999, "Swansea", "England", "norweign", new String[] {"pasta", "swimming"});
		System.out.println(liz.toString());
		
	
		Profile ellis = new Profile("Ellis", 25, 05, 1999, "Manchester", "Colombia", "Welsh", new String[] {"climbing"});
		System.out.println(ellis.toString());
		
		Profile harry = new Profile("Harry Potter", 01, 07, 1989, "Little Winging", "London", "English", new String[] {"kiling moldly voldy"});
		
		//name methods
		System.out.println(liz.getName());
		
		//town methods
		System.out.println("Harry lives in the town " + harry.getTown());
		harry.setTown("Godricks Hollow");
		System.out.println("Harry lives in the town " + harry.getTown());
		
		//country methods
		System.out.println("Ellis lives in " + ellis.getCountry());
		ellis.setCountry("Kyrgyzstan");
		System.out.println("Ellis lives in " + ellis.getCountry());
		
		//nationality methods
		System.out.println("liz is " + liz.getNationality());
		liz.setNationality("Welsh");
		System.out.println("Liz's nationality is" + liz.getNationality() );
		
		//interests methods
		System.out.println("Harrys interests are: " + harry.getInterests());
		System.out.println("Harrys interests are: " + harry.getInterests());
		
		//DOB testing
		System.out.println("Ellis's date of birth is " + ellis.getDateOfBirth());
		
		//friend testing
		ellis.addFriend(liz);
		ellis.addFriend(harry);
		
		//to string method test
		System.out.println(ellis.toString());
		
		System.out.println("Ellis has a friend " + ellis.getFriend(1).getName());
		
		System.out.println("Interests" + liz.getInterests());
}


}


