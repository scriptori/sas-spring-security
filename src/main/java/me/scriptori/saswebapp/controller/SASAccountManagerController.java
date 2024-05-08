package me.scriptori.saswebapp.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.scriptori.saswebapp.dto.AddAccountDTO;
import me.scriptori.saswebapp.util.Constants;


/**
 * This class is used to manage user accounts in the application. The class provides methods to create new user accounts, 
 * update user accounts, and delete user accounts.
 * 
 * The class is annotated with @Controller to indicate that it is a Spring MVC controller class.
 */
@Controller
public class SASAccountManagerController {
	
	// InMemoryUserDetailsManager object to manage user details using an in-memory user store
	private InMemoryUserDetailsManager userDetailsManager;
	// PasswordEncoder object to encode passwords using BCrypt hashing algorithm
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Constructor for the SASAccountManagerController class.
	 * 
	 * @param userDetailsManager - InMemoryUserDetailsManager object to manage user details, injected by Spring.
	 * @param passwordEncoder - PasswordEncoder object to encode passwords, injected by Spring.
	 * @return SASAccountManagerController - Instance of the SASAccountManagerController class.
	 * @throws Exception - Exception thrown if there is an error in creating the SASAccountManagerController instance.
	 */
	@Lazy // Lazy initialization of the bean to avoid circular dependencies
	public SASAccountManagerController(InMemoryUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
		this.userDetailsManager = userDetailsManager;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/sasCreateAccount")	
	public String createAccount(Model model) {
		// Add an AddAccountDTO object to the model
		AddAccountDTO addAccountDTO = new AddAccountDTO();
		// And set the default values for the email, username, and password fields
		addAccountDTO.setEmail("your@email.now");
		addAccountDTO.setUsername("yourusername");
		addAccountDTO.setPassword("modify%this$temp&password");
		// Add the AddAccountDTO object to the model to be used in the view
		model.addAttribute("addAccount", addAccountDTO);
		// Return the view name for the create account page (sasAddAccount.jsp)
		return Constants.SAS_ADD_ACCOUNT;
	}

	/**
	 * This method is used to process the account creation request, and create a new account for the user.
	 * The method takes an AddAccountDTO object as input, and creates a new account for the user using the provided details.
	 * 
	 * @param addAccountDto - AddAccountDTO object containing the details of the account to be created.
	 * @return String - Message indicating that the account has been created for the user.
	 */
	@ResponseBody
	@PostMapping("/sasProcessAccount")
	public String processAccount(AddAccountDTO addAccountDto) {
		// Create a new UserDetails object with the provided username, email, and password
		UserDetails userDetails = User
			.withUsername(addAccountDto.getUsername())
			.password(passwordEncoder.encode(addAccountDto.getPassword()))
			.roles("USER")
			.build();
		// Create a new user account using the UserDetails object created above.
		userDetailsManager.createUser(userDetails);
		// Return a message indicating that the account has successfully been created for the user.
		// If time permit, I will add another JSP page to display the message is not necessary, as the message is returned as a response to the request.
		return "The account has been created for " + addAccountDto.getEmail() + " with username " + addAccountDto.getUsername() + "...";
	}
	
	@GetMapping("/sasAccountCreated")
	public String accountCreated(@ModelAttribute("addAccount") AddAccountDTO addAccountDTO, Model model) {
		return Constants.SAS_ACCOUNT_CREATED;
	}
	
}
