package dev.tuanlm.demo.exception;

public class JwtInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JwtInvalidException(String str) {
		super(str);
	}

}
