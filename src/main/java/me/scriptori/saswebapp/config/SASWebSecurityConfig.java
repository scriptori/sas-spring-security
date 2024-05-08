package me.scriptori.saswebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * This class is used to configure the security requirements for the
 * application. The security requirements are set up using the security filter
 * chain bean. The security filter chain bean is used to set up the security
 * requirements for the application.
 */
@Configuration
@EnableWebSecurity(debug = true) // the debug flag is set to true to enable debugging, which will print out the security configuration details to the console.
								 // This is useful for troubleshooting security configuration issues. In production, this flag should be set to false.
public class SASWebSecurityConfig {
	
	@Autowired
	private HttpSecurity httpSec;
	
	/**
	 * This method is used to create a security filter chain bean for the application. 
	 * The security filter chain is used to set up the security requirements for the application.
	 * 
	 * @return SecurityFilterChain - Security filter chain for the application.
	 * @throws Exception - Exception thrown if there is an error in setting up the security filter chain.
	 */
	@Bean
    public SecurityFilterChain httpSecurityConfiguration() throws Exception {
		// Setting up security filter chain
		return httpSec
			.authorizeHttpRequests(authorize -> {
				authorize
					.requestMatchers(
						"/", 
						"/sasCreateAccount", 
						"/sasProcessAccount", 
						"/sasAccountCreation", 
						"/sasLogin", 
						"/error", 
						"/WEB-INF/views/**",
						"/WEB-INF/resources/**"
					).permitAll()
					.anyRequest().authenticated();
			})
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults())
			// Temporarily disabling CSRF protection for simplicity. In production, CSRF protection should be enabled.
			// CSRF protection is used to prevent Cross-Site Request Forgery (CSRF) attacks.
			// In this case, it will affect all the POST requests in the application, not the GET requests.
			// For more information on CSRF protection, see https://owasp.org/www-community/attacks/csrf
			.csrf(csrf -> csrf.disable())
			.build();
    }
	
	/**
	 * This method is used to create a handler mapping introspector bean for mapping the handler methods to the request paths.
	 * Without this bean, the handler methods will not be mapped to the request paths, and the application will not work as expected.
	 * It will also throw an error if the handler methods are not mapped to the request paths.
	 * 
	 * @return HandlerMappingIntrospector - Introspector for handler mappings.
	 */
	@Bean(name = "mvcHandlerMappingIntrospector")
	public HandlerMappingIntrospector handlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}

	/**
	 * This method is used to create a user details service bean for the administrator user.
	 * It can be used to create user details service beans for other users as well.
	 * In this case, the administrator user details service is created and stored in memory (not recommended for production).
	 * 
	 * @return UserDetailsService - Interface to retrieve user-related data
	 */
    @Bean
    public UserDetailsService userDetailsService() {
        // Setting up the administrator user details service
        UserDetails admin = User
        	// Setting the administrator username and the returns the user builder object
        	.withUsername("admin")
            // Setting the administrator password encoded using BCrypt encoder from https://www.bcryptcalculator.com/encode
            .password("$2a$10$UKKwLm6v/up9P2XO0.3p4eWC3L2JUiqc6ypxOcHt0H7GAOQUijMOW")
            // Setting the roles of the administrator as ADMIN and USER
            .roles("ADMIN", "USER")
            // Building the user details object
            .build();
        
		UserDetails scriptoriUser = User
				// Setting the scriptori username and the returns the user builder object
				.withUsername("scriptori")
				// Setting the user password using BCrypt encoder from https://www.bcryptcalculator.com/encode
				.password("$2a$10$Ud08NaReokXXv0gYOHXCXu8i1jvGChDlq1DOQVh5EWC7AFP6Cmkee")
				// Setting the roles of the administrator as ADMIN and USER
				.roles("USER")
				// Building the user details object
				.build();

        // User details service configured and stored in memory for all the users created above (not recommended for production)
		// In production, user details should be stored in a database by using the JdbcUserDetailsManager or another implementation of the UserDetailsService interface.
        return new InMemoryUserDetailsManager(admin, scriptoriUser);
    }
    
    /**
     * This method is used to create a BCrypt password encoder bean for encoding passwords in the application.
     * 
     * @return BCryptPasswordEncoder
     */
    @Bean
	public PasswordEncoder passwordEncoder() {
		// Setting up the BCrypt password encoder bean for encoding passwords in the application
		return new BCryptPasswordEncoder();
	}
}
