package me.scriptori.saswebapp.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import me.scriptori.saswebapp.util.Constants;

@Controller
public class SASAuthenticationController {
	Logger log = Logger.getLogger(SASAuthenticationController.class.getName());
	
	@GetMapping("/sasLogin")
	public String showSASLoginPage() {
		return Constants.SAS_LOGIN_VIEW;
	}
}
