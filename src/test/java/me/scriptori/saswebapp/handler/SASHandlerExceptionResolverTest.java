package me.scriptori.saswebapp.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SASHandlerExceptionResolverTest {

	private SASHandlerExceptionResolver sasHandlerExceptionResolver;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@BeforeEach
	public void setUp() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		sasHandlerExceptionResolver = new SASHandlerExceptionResolver();
	}

	@Test
	public void testResolveException() {
		Exception exception = new Exception("Test exception");
		ModelAndView modelAndView = sasHandlerExceptionResolver.resolveException(request, response, null, exception);

		assertEquals("error", modelAndView.getViewName());
		assertEquals("A system error occurred: " + exception.getMessage(), modelAndView.getModel().get("errorMessage"));
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, modelAndView.getStatus());
	}
}
