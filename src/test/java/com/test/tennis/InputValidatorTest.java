package com.test.tennis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class InputValidatorTest {
	
	@Test
	public void testValidInput() {
		InputValidator.validate("ABAB");
	}

	@Test
	public void testNullInput() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
		InputValidator.validate(null);
		});
		assertEquals("Input cannot be null or empty", exception.getMessage());
	}

	@Test
	public void testEmptyInput() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
		InputValidator.validate("");
		});
		assertEquals("Input cannot be null or empty", exception.getMessage());
	}

	@Test
	public void testInvalidCharacter() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
		InputValidator.validate("AAXBB");
		});
		assertEquals("Invalid input character: X", exception.getMessage());
	}

}
