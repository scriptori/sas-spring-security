package me.scriptori.saswebapp.service;

public class SASAuthenticationService {
	public static boolean authenticate(String username, String password) {
        // Placeholder logic for authentication
        return "admin".equals(username) && "password123".equals(password);
    }
}
