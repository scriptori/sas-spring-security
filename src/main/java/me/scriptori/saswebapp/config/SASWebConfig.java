package me.scriptori.saswebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import me.scriptori.saswebapp.handler.SASHandlerExceptionResolver;

/**
 * This class is used to configure the web application. The web application configuration includes view resolver,
 * resource handlers and exception resolver. The view resolver is used to resolve the view names to the actual view
 * files. The resource handlers are used to serve static resources like CSS and JS files. The exception resolver is used
 * to handle exceptions in the application.
 */
@Configuration
@ComponentScan("me.scriptori.saswebapp")
public class SASWebConfig {

	/**
	 * This method is used to create a view resolver bean for the application. The view resolver bean is used to resolve
	 * the view names to the actual view files.
	 * 
	 * @return InternalResourceViewResolver - View resolver bean for the application.
	 * 
	 * @see InternalResourceViewResolver
	 */
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		return viewResolver;
	}

	/**
	 * This method is used to add resource handlers for the application. The resource handlers are used to serve static
	 * resources like CSS and JS files.
	 * 
	 * @param registry - Resource handler registry to add resource handlers.
	 * 
	 * @see ResourceHandlerRegistry
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Add CSS and JS resources
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("/WEB-INF/resources/", "/WEB-INF/resources/css/");
	}

	/**
	 * This method is used to create an exception resolver bean for the application. The exception resolver bean is used
	 * to handle exceptions in the application.
	 * 
	 * @return HandlerExceptionResolver - Exception resolver bean for the application.
	 * 
	 * @see HandlerExceptionResolver
	 */
	@Bean
	public HandlerExceptionResolver exceptionResolver() {
		SASHandlerExceptionResolver resolver = new SASHandlerExceptionResolver();
		return resolver;
	}
}
