package com.mindfulqatar.jobportal.services.impl;

import java.util.Random;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.services.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {

	// This our Password generating method
	// We have use static here, so that we not to
	// make any object for it
	public char[] getRandomPassword(int len) {
		// A strong password has Cap_chars, Lower_chars,
		// numeric value and symbols. So we are using all of
		// them to generate our password
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		// Using random method
		Random rndmMethod = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			password[i] = values.charAt(rndmMethod.nextInt(values.length()));

		}
		return password;
	}
}