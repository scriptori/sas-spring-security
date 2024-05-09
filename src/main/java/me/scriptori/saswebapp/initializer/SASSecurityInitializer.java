package me.scriptori.saswebapp.initializer;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class is used to initialize Spring Security in the web application by delegating the filter proxy to the Spring
 * Security filter chain. The filter proxy is used to intercept the HTTP requests and apply the security requirements to
 * the requests. The Spring Security filter chain is used to set up the security requirements for the application.
 */
public class SASSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	// No customizations needed, but this class is required to initialize Spring Security in the web application.
}
