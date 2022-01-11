package com.mindfulqatar.jobportal.dto;

public class PasswordEditDTO {
	private String newPassword;
	private String newConfirmPassword;

	// Getters and Setters
	// ===================

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewConfirmPassword() {
		return newConfirmPassword;
	}

	public void setNewConfirmPassword(String newConfirmPassword) {
		this.newConfirmPassword = newConfirmPassword;
	}
}
