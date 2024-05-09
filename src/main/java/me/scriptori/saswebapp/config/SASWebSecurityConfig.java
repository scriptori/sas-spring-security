package me.scriptori.saswebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * This class is used to configure the security requirements for the application. The security requirements are set up
 * using the security filter chain bean. The security filter chain bean is used to set up the security requirements for
 * the application.
 */
@Configuration 	 // Indicates that this class is a configuration class for the application. The configuration class is
				 // used to configure the security requirements for the application.
				 // The security requirements are set up using the security filter chain bean.
@EnableWebSecurity(debug = true) // Enable web security with debug mode enabled. Debug mode is enabled for development.
								 // In production, debug mode should be disabled.
@ComponentScan("me.scriptori.saswebapp") // Scan the components in the application for security configuration.
										 // The components are scanned for security configuration to set up the security
										 // requirements.
public class SASWebSecurityConfig {

	// Injecting the HttpSecurity bean into the class using the @Autowired annotation and the httpSec property.
	@Autowired
	private HttpSecurity httpSec;

	/**
	 * This method is used to create a security filter chain bean for the application. The security filter chain is used
	 * to set up the security requirements for the application.
	 * 
	 * @return SecurityFilterChain - Security filter chain for the application.
	 * 
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
						"/sasAccountCreated",
						"/WEB-INF/views/**",
						"/WEB-INF/resources/**"
					).permitAll()
					.requestMatchers("/welcome").authenticated()
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
	 * This method is used to create a handler mapping introspector bean for mapping the handler methods to the request
	 * paths. Without this bean, the handler methods will not be mapped to the request paths, and the application will
	 * not work as expected. It will also throw an error if the handler methods are not mapped to the request paths.
	 * 
	 * @return HandlerMappingIntrospector - Introspector for handler mappings.
	 */
	@Bean(name = "mvcHandlerMappingIntrospector") // Name of the bean is set to "mvcHandlerMappingIntrospector".
	public HandlerMappingIntrospector handlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}

	/**
	 * This method is used to create a BCrypt password encoder bean for encoding passwords in the application. The
	 * BCrypt password encoder is used to encode the passwords in the application. The encoded passwords are then stored
	 * in the database.
	 * 
	 * @return BCryptPasswordEncoder - BCrypt password encoder for encoding passwords in the application.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Setting up the BCrypt password encoder bean for encoding passwords in the application
		return new BCryptPasswordEncoder();
	}
}
