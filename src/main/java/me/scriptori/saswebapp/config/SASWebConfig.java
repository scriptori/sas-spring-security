package me.scriptori.saswebapp.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("me.scriptori.saswebapp")
public class SASWebConfig {
	
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		return viewResolver;
	}
	
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// Add CSS and JS resources
    	registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/", "/WEB-INF/resources/css/");
    }
	
    @Bean
    public HandlerExceptionResolver exceptionResolver() {
        // Configuring exception resolver"
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("InvalidLoginException", "loginError");
        mappings.setProperty("java.lang.Exception", "error");
        resolver.setExceptionMappings(mappings);
        resolver.setDefaultErrorView("error");
        resolver.setExceptionAttribute("ex");
        return resolver;
    }
}

