package me.scriptori.saswebapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.ui.Model;

import me.scriptori.saswebapp.dto.AddAccountDTO;

public class SASAccountManagerControllerTest {

	private SASAccountManagerController sasAccountManagerController;
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	private PasswordEncoder passwordEncoder;
	private Model model;

	@BeforeEach
	public void setUp() {
		jdbcUserDetailsManager = mock(JdbcUserDetailsManager.class);
		passwordEncoder = mock(PasswordEncoder.class);
		model = mock(Model.class);
		sasAccountManagerController = new SASAccountManagerController(jdbcUserDetailsManager, passwordEncoder);
	}

	@Test
	public void testCreateAccount() {
		String viewName = sasAccountManagerController.createAccount(model);
		assertEquals("sasAddAccount", viewName);
	}

	@Test
	public void testProcessAccount() {
		AddAccountDTO addAccountDto = new AddAccountDTO();
		addAccountDto.setUsername("testUser");
		addAccountDto.setPassword("testPassword");
		when(passwordEncoder.encode(addAccountDto.getPassword())).thenReturn("encodedPassword");

		String viewName = sasAccountManagerController.processAccount(addAccountDto, model);
		assertEquals("registered", viewName);
	}
}
