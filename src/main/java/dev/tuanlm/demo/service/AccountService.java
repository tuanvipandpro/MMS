package dev.tuanlm.demo.service;

import dev.tuanlm.demo.request.LoginRequest;
import dev.tuanlm.demo.response.LoginResponse;

public interface AccountService {
	/**
	 * Gets the login response.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the login response
	 */
	LoginResponse getTokenByUsernameAndPassword(LoginRequest request);
}
