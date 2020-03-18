/**
 * This is abstract class that keeps the password for administrator and branch classes and implement LogIn interface
 * @author Mustafa Tokgöz 171044077
 *
 */
public abstract class EnteringSystem implements LogIn{
	/**
	 * This is string that keeps the password
	 */
	private String password;
	/**
	 * This is getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * This is setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
