package com.test.tennis;

public class InputValidator {
	
	public static void validate(String input) {
		
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("Input cannot be null or empty");
		}

		for (char c : input.toCharArray()) {
			if (c != 'A' && c != 'B') {
				throw new IllegalArgumentException("Invalid input character: " + c);
			}
		}
	}

}
