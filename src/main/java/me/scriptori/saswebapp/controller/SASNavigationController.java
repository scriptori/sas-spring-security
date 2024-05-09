package me.scriptori.saswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class is used to handle the requests for the page navigation of the application. The home page ("index.jsp") of
 * the application is the main page that is displayed when the application is accessed. The other pages are used for the
 * user to navigate through the application.
 */
@Controller
public class SASNavigationController {

	/**
	 * This method is used to handle the request for the home page ("/") of the application. The home page is the main
	 * page that is displayed when the application is accessed.
	 * 
	 * @return String - The name of the view to be displayed for the home page (index.jsp).
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * This method is used to handle the request for the registered confirmation page ("/registered") of the
	 * application. The registered page is displayed when the user successfully created an account by providing an
	 * unique username and a valid password.
	 * 
	 * @return String - The name of the view to be displayed for the registered page (registered.jsp).
	 */
	@GetMapping("/registered")
	public String registered() {
		return "registered";
	}

	/**
	 * This method is used to handle the request for the error page ("/error") of the application. The error page is
	 * displayed when an error occurs in the application.
	 * 
	 * @return String - The name of the view to be displayed for the error page (error.jsp).
	 */
	@GetMapping("/error")
	public String error() {
		return "error";
	}

	/**
	 * This method is used to handle the request for the welcome page ("/welcome") of the application. The welcome page
	 * is displayed after the user has successfully logged in to the application.
	 * 
	 * @return String - The name of the view to be displayed for the welcome page (welcome.jsp).
	 */
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
