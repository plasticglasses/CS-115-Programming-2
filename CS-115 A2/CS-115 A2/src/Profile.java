import java.util.ArrayList;
/**
 * this class makes a profile and encapsulates it.
 * @author liz
 *
 */
public class Profile {
	
	private String name;
	private int dayOB;
	private int monthOB;
	private int yearOB;
	private String town;
	private String country;
	private String nationality;
	
	String[] interests;
	ArrayList<Profile> friends = new ArrayList<Profile>();
	
	/**
	 * This creates a new profile
	 * @param name name of the person
	 * @param dayOB the day that the person was born
	 * @param monthOB the month that the person was born
	 * @param yearOB the year that the person was born
	 * @param town the town where the person lives
	 * @param country the country where the person lives
	 * @param interests an array list holding a list of all the persons different interests
	 */
	
	public Profile(String name, int dayOB, int monthOB, int yearOB, String town, String country, String nationality, String interests[]){
		
		this.name = name.toLowerCase();
		this.dayOB = dayOB;
		this.monthOB = monthOB;
		this.yearOB = yearOB;
		setTown(town);
		setCountry(country);
		setNationality(nationality);
		setInterests(interests);
	}

	/**
	 * 
	 * @return the persons name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return the town where the person lives
	 */
	public String getTown() {
		return this.town;
	}
	
	/**
	 * 
	 * @param town the town where the person lives
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * 
	 * @return country where the person lives
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * 
	 * @param country country where the person lives
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * 
	 * @return the nation to which the person belongs
 	 */
	public String getNationality() {
		return this.nationality;
	}
	
	/**
	 * 
	 * @param nationality the nation to which the person belongs
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * 
	 * @return interests, an array containing a list of all the Profiles interests
	 */
	public String getInterests() {
		String result = "";
		for (int i = 0; i < interests.length; i++) {
			result += interests[i] + " ";
		}
		return result;
	}
	
	/**
	 * 
	 * @param interests an array of strings that a profile likes to do
	 */
	public void setInterests(String[] interests) {
		//for each element in the array being passed in, add to the array in this profile instance
		this.interests = interests;
	}
	
	/**
	 * 
	 * @param interest a new activity which will be added at the end of array
	 */
	//public void addInterest(String interest) {
	//	int length = this.interests.length;
	//	this.interests[length - 1] = interest;
	//}
	//
	/**
	 * 
	 * @return numerical day of birth
	 */
	public int getDay() {
		return this.dayOB;
	}
	
	/**
	 * 
	 * @return month of birth
	 */
	public int getMonth() {
		return this.monthOB;
	}
	
	/**
	 * 
	 * @return year of birth
	 */
	public int getYear() {
		return this.yearOB;
	}
	
	/**
	 * 
	 * @return a string with a formatted date
	 */
	public String getDateOfBirth() {
		String DOB = (getDay() + "/" + getMonth() + "/" + getYear());
		return DOB;
	}
	
	/**
	 * adds a friend to the 'friends' arraylist
	 * @param p which is a profile of a different user
	 */
	void addFriend(Profile p) {
		friends.add(p);
	}
	
	/**
	 * 
	 * @param i index of the friends profile 
	 * @return the friends profile at index i
	 */
	Profile getFriend(int i) {
		return friends.get(i);
	}
	
	/**
	 * 
	 * @return length of the array list containing the Profiles friend's names
	 */
	int numOfFriends() {
		return friends.size();
	}
	
	/**
	 * method to convert a persons profile to a string
	 */
	//do we need @override here?
	public String toString () {
    	String result = "This is a profile for " + this.name + 
    			"\nWith birthday " + getDateOfBirth() + " " + 
    			this.name + " lives in " + this.town + ", " + this.country
    			+ " and is " + this.nationality;
    	//result += super.toString ();
    	result += ".\nTheir interests are: " ;
    	for (String interest : this.interests) {
    		result += interest + ", ";
    	}
    	result+= " and they have " + numOfFriends() + " friends. ";
    	for (Profile person : friends) {
    		result += person.getName() + ",\n";
    	}
    	return result;
	}
}
