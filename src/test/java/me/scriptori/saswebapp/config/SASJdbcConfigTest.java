package me.scriptori.saswebapp.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class SASJdbcConfigTest {

	private SASJdbcConfig sasJdbcConfig;
	private DataSource dataSource;

	@BeforeEach
	public void setUp() {
		dataSource = mock(DataSource.class);
		sasJdbcConfig = new SASJdbcConfig();
		sasJdbcConfig.dataSource = dataSource;
	}

	@Test
	public void testJdbcTemplate() {
		JdbcTemplate jdbcTemplate = sasJdbcConfig.jdbcTemplate();
		assertNotNull(jdbcTemplate);
	}

	@Test
	public void testJdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = sasJdbcConfig.jdbcUserDetailsManager();
		assertNotNull(jdbcUserDetailsManager);
	}
}
