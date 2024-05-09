package me.scriptori.saswebapp.dto;

/**
 * Data Transfer Object for adding an account.
 * 
 * This DTO is used to transfer data from the client to the server when adding an account.
 */
public class AddAccountDTO {
	private String username;
	private String password;

	/**
	 * Get the username. 
	 * The username is the unique identifier for the account.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username.
	 * 
	 * @param username - the username value to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the password.
	 * The password is the secret key used to authenticate the account.
	 * It will be hashed before storing it in the database.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password.
	 * It will be hashed before storing it in the database.
	 * 
	 * @param password - the password value to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
