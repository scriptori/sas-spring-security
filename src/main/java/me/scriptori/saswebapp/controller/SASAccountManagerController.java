package me.scriptori.saswebapp.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import me.scriptori.saswebapp.dto.AddAccountDTO;

/**
 * This class is used to manage user accounts in the application. The class provides methods to create new user
 * accounts, update user accounts, and delete user accounts.
 * 
 * The class is annotated with @Controller to indicate that it is a Spring MVC controller class.
 */
@Controller
public class SASAccountManagerController {

	// JdbcUserDetailsManager object to manage user details using a JDBC user store (database).
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	// PasswordEncoder object to encode passwords using BCrypt hashing algorithm
	private PasswordEncoder passwordEncoder;

	/**
	 * Constructor for the SASAccountManagerController class.
	 * 
	 * @param jdbcUserDetailsManager - JdbcUserDetailsManager object to manage user details, injected by Spring.
	 * @param passwordEncoder        - PasswordEncoder object to encode passwords, injected by Spring.
	 * 
	 * @return SASAccountManagerController - Instance of the SASAccountManagerController class.
	 * 
	 * @throws Exception - Exception thrown if there is an error in creating the SASAccountManagerController instance.
	 */
	@Lazy // Lazy initialization of the bean to avoid circular dependencies
	public SASAccountManagerController(
		JdbcUserDetailsManager jdbcUserDetailsManager,
		PasswordEncoder passwordEncoder
	) {
		// this.userDetailsManager = userDetailsManager;
		this.jdbcUserDetailsManager = jdbcUserDetailsManager;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * This method is used to display the create account page. The method returns the view name for the create account
	 * page (sasAddAccount.jsp).
	 * 
	 * @param model - Model object to add attributes to the view.
	 * 
	 * @return String - View name for the create account page (sasAddAccount.jsp).
	 */
	@GetMapping("/sasCreateAccount")
	public String createAccount(Model model) {
		// Add an AddAccountDTO object to the model
		AddAccountDTO addAccountDTO = new AddAccountDTO();
		// And set the default values for the username and password fields
		addAccountDTO.setUsername(null);
		addAccountDTO.setPassword(null);
		// Add the AddAccountDTO object to the model to be used in the view
		model.addAttribute("addAccount", addAccountDTO);
		// Return the view name for the create account page (sasAddAccount.jsp)
		return "sasAddAccount"; // The create account page endpoint (sasAddAccount.jsp)
	}

	/**
	 * This method is used to process the account creation request, and create a new account for the user. The method
	 * takes an AddAccountDTO object as input, and creates a new account for the user using the provided details.
	 * 
	 * @param addAccountDto - AddAccountDTO object containing the details of the account to be created.
	 * 
	 * @return String - Message indicating that the account has been created for the user.
	 */
	// @ResponseBody
	@PostMapping("/sasProcessAccount")
	public String processAccount(AddAccountDTO addAccountDto, Model model) {
		// Create a new UserDetails object with the provided username, email, and password
		UserDetails userDetails = User
			.withUsername(addAccountDto.getUsername())
			.password(passwordEncoder.encode(addAccountDto.getPassword()))
			.roles("USER")
			.build();
		// Create a new user account using the UserDetails object created above.
		jdbcUserDetailsManager.createUser(userDetails);
		// Add a message to the model to display on the account created page (sasAccountCreated.jsp)
		model.addAttribute(
			"message",
			"Account successfully created for " + addAccountDto.getUsername()
		);
		// Return the view name for the account created page (sasAccountCreated.jsp)
		return "registered";
	}
}
