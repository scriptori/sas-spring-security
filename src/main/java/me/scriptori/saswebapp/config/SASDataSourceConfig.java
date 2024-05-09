package me.scriptori.saswebapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * This class is used to configure the data source for the application. The data source is used to set up the database
 * connection for the application. The data source bean is created in this class and the properties for the data source
 * are set in this class.
 */
@Configuration
@ComponentScan("me.scriptori.saswebapp")
public class SASDataSourceConfig {

	/**
	 * This method is used to create a data source bean for the application. The data source bean is used to set up the
	 * data source properties for the application.
	 * 
	 * @return DataSource - Data source bean for the application.
	 */
	@Bean
	public DataSource dataSource() {
		// Setting up the data source bean for the application
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// Setting the data source properties
		dataSource.setUsername("root"); // The username for the database connection (root in this case)
		dataSource.setPassword("scriptori123"); // The password for the database connection
		dataSource.setUrl("jdbc:mysql://localhost:3306/sas-security"); // The URL for the database connection
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // The driver class name for the database connection.

		// Returning the data source bean for the application
		return dataSource;
	}
}
