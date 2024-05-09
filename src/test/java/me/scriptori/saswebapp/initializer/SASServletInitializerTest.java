package me.scriptori.saswebapp.initializer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.scriptori.saswebapp.config.SASWebConfig;
import me.scriptori.saswebapp.config.SASWebSecurityConfig;

public class SASServletInitializerTest {

	private SASServletInitializer sasservletInitializer;

	@BeforeEach
	public void setUp() {
		sasservletInitializer = new SASServletInitializer();
	}

	@Test
	public void testGetRootConfigClasses() {
		Class<?>[] expectedClasses = { SASWebSecurityConfig.class };
		Class<?>[] actualClasses = sasservletInitializer.getRootConfigClasses();
		assertArrayEquals(expectedClasses, actualClasses);
	}

	@Test
	public void testGetServletConfigClasses() {
		Class<?>[] expectedClasses = { SASWebConfig.class };
		Class<?>[] actualClasses = sasservletInitializer.getServletConfigClasses();
		assertArrayEquals(expectedClasses, actualClasses);
	}

	@Test
	public void testGetServletMappings() {
		String[] expectedMappings = { "/" };
		String[] actualMappings = sasservletInitializer.getServletMappings();
		assertArrayEquals(expectedMappings, actualMappings);
	}
}
