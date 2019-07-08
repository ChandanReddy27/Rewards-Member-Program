package lab6_part2;

/**
 * Definition of the User class
 * @author 
 * @author
 * CIS 36B
 * Lab 4.1
 */

public class User {

    private String name;
    private String gender;
    private String phone;
    private String email;
    private String password;
    private static int numUsers = 0;


    /**
     * Default constructor - assigns
     * all member variables to the value
     * "<variable>  unknown"
     * e.g. "name unknown"
     */
    public User() {
    	name = "name unknown";
    	gender = "gender unknown";
    	phone = "phone unknown";
    	email = "email unknown";
    	password = "password unknown";
    }
    
    /**
     * Constructor for the User class
     * @param theName the User name
     * @param theGender the User gender
     * @param thePhone the User phone
     * @param theEmail the User email
     * @param thePassword the User password
     */
    public User(String theName, String theGender, String thePhone, String theEmail, String thePassword)     {
    	name = theName;
    	gender = theGender;
    	phone = thePhone;
    	email = theEmail;
    	password = thePassword;
    }
    
    /**
     * Returns the first and last name
     * @return the user name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the gender (F, M, or O)
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    
    /**
     * Returns a phone number formatted 
     * in the style (XXX) XXX-XXXX
     * @return the formatted phone number
     */
    public String getFormattedPhone() {
        return "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
    }
    
    /**
     * Returns the user email
     * @return the user email
     */
    public String getEmail() {
        return email;
    }
    
    public static int getNumUsers() {
    	return numUsers;
    }
    
    /**
     * Verifies that password equals the
     * password on file for the user
     * @param userInput the password entered
     * @return whether the password entered matches
     * the password stored
     */
    public boolean verifyPassword(String userInput) {
        return userInput.equals(password);
    }
    
    /**
     * Assigns the user a first and last name
     * @param user_name the name of the user
     */
    public void setName(String user_name) {
        name = user_name;
    }
    
    /**
     * Assigns a value to the gender field 
     * @param user_gender a gender F, M or O
     */
    public void setGender(String user_gender) {
        gender = user_gender;
    }
    
    /**
     * Assigns a phone number to the phone field
     * @param user_phone the phone number to assign
     */
    public void setPhone(String user_phone) {
        phone = user_phone;
    }
    
    /**
     * Assigns an email address to the email field
     * @param user_email the email address to assign
     */
    public void setEmail(String user_email) {
        email = user_email;
    }
    
    /**
     * Assigns a password to the password field
     * @param user_password the password to assign
     */
    public void setPassword(String user_password) {
        password = user_password;
    }
    
    public static void updateNumUsers() {
    	numUsers++;
    }
    /**
     * Returns the formatted User info as a String 
     */
    @Override public String toString() {
        return "Name: " + name + "\nGender: " + gender + "\nPhone: " + "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6) + "\nEmail: " + email;
    }
}