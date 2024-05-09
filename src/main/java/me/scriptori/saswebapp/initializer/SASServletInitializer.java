package me.scriptori.saswebapp.initializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import me.scriptori.saswebapp.config.SASWebConfig;
import me.scriptori.saswebapp.config.SASWebSecurityConfig;

/**
 * This class is used to initialize the Spring MVC framework in the web application. The Spring MVC framework is
 * initialized by extending the AbstractAnnotationConfigDispatcherServletInitializer class. The Spring MVC framework is
 * used to handle the web requests and responses in the application.
 */
@ComponentScan(basePackages = "me.scriptori.saswebapp")
public class SASServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * This method is used to get the configuration classes for the root application context. The root application
	 * context contains the beans that are shared across all the servlets in the application. The root application
	 * context is used to configure the security settings for the application.
	 * 
	 * @return Class[] - Array of configuration classes for the root application context.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Return the configuration classes for the root application context (security settings)
		return new Class<?>[] { SASWebSecurityConfig.class };
	}

	/**
	 * This method is used to get the configuration classes for the servlet application context. The servlet application
	 * context contains the beans that are specific to the servlet in the application. The servlet application context
	 * is used to configure the web settings for the application.
	 * 
	 * @return Class[] - Array of configuration classes for the servlet application context.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Return the configuration classes for the servlet application context (web settings)
		return new Class<?>[] { SASWebConfig.class };
	}

	/**
	 * This method is used to get the servlet mappings for the application. The servlet mappings are used to map the
	 * servlet to the URL patterns in the application. The servlet mappings are used to handle the web requests and
	 * responses in the application.
	 * 
	 * @return String[] - Array of servlet mappings for the application.
	 */
	@Override
	protected @NonNull String[] getServletMappings() {
		// Return the servlet mappings for the application (URL patterns)
		return new String[] { "/" };
	}
}
