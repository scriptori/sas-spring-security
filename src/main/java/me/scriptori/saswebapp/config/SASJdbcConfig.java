package me.scriptori.saswebapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * This class is used to configure the JDBC template for the application. The JDBC template is used to interact with the
 * database. The JDBC template is used to query and update data in the database.
 */
@Configuration
@ComponentScan("me.scriptori.saswebapp")
public class SASJdbcConfig {

	// Injecting the data source bean into the class using the @Autowired annotation and the dataSource property.
	@Autowired
	protected DataSource dataSource;

	/**
	 * This method is used to create a JDBC template bean for the application. The JDBC template bean is used to
	 * interact with the database. The JDBC template bean is used to query and update data in the database. The data
	 * source bean is injected into the JDBC template bean using the @Autowired annotation.
	 * 
	 * @return JdbcTemplate - JDBC template bean for the application.
	 * 
	 * @see JdbcTemplate
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	/**
	 * This method is used to create a JDBC user details manager bean for the application. The JDBC user details manager
	 * bean is used to manage the user details in the database. The data source bean is injected into the JDBC user
	 * details manager bean using the @Autowired annotation.
	 * 
	 * @return JdbcUserDetailsManager - JDBC user details manager bean for the application.
	 * 
	 * @see JdbcUserDetailsManager
	 */
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		return new JdbcUserDetailsManager(dataSource);
	}
}
