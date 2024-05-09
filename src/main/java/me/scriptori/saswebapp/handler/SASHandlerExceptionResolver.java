package me.scriptori.saswebapp.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class is used to handle exceptions that occur in the application. The exception resolver is used to resolve the
 * exceptions that occur in the application. The exception resolver is used to handle the exceptions that occur in the
 * application and display an error message to the user.
 */
public class SASHandlerExceptionResolver implements HandlerExceptionResolver {

	// Logger for logging exceptions
	private static final Logger logger = LoggerFactory.getLogger(SASHandlerExceptionResolver.class);

	/**
	 * This method is used to resolve the exception that occurred in the application. The method is called when an
	 * exception occurs in the application. The method logs the exception and returns a model and view object with the
	 * error message to be displayed to the user.
	 * 
	 * @param request  - The HTTP servlet request object.
	 * @param response - The HTTP servlet response object.
	 * @param handler  - The handler object that caused the exception.
	 * @param ex       - The exception that occurred in the application.
	 * 
	 * @return ModelAndView - The model and view object with the error message to be displayed to the user.
	 * 
	 * @see ModelAndView
	 * @see HttpServletRequest
	 * @see HttpServletResponse
	 */
	@Override
	@Nullable
	public ModelAndView resolveException(
		@NonNull HttpServletRequest request,
		@NonNull HttpServletResponse response,
		@Nullable Object handler,
		@NonNull Exception ex
	) {
		logger.error("Exception occurred", ex);
		ModelAndView modelAndView = new ModelAndView();
		// Set the view name to error page (error.jsp)
		modelAndView.setViewName("error");
		// Add the error message to the model and view object to be displayed to the user on the error page (error.jsp)
		modelAndView.addObject("errorMessage", "A system error occurred: " + ex.getMessage());

		// Set the HTTP status code to 500 (Internal Server Error)
		modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return modelAndView;
	}

}
