package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.City;
import com.mindfulqatar.jobportal.entities.Country;
import com.mindfulqatar.jobportal.entities.Role;
import com.mindfulqatar.jobportal.dto.UserDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.mindfulqatar.jobportal.dto.AccountEditDTO;
import com.mindfulqatar.jobportal.dto.SearchUsersDTO;

public class AccountMapper {
	public static Account toAccount(SearchUsersDTO userDTO) {
		Account account = new Account();

		if (userDTO.getId() != null) {
			account.setId(userDTO.getId());
		}

		if (userDTO.getName() != null) {
			account.setName(userDTO.getName());
		}

		if (userDTO.getEmail() != null) {
			account.setEmail(userDTO.getEmail());
		}

		if (userDTO.getMobilePhone() != null) {
			account.setMobilePhone(userDTO.getMobilePhone());
		}

		if (userDTO.getCityId() != null) {
			account.setCity(new City(userDTO.getCityId()));
		}

		if (userDTO.getGender() != null) {
			account.setGender(userDTO.getGender());
		}

		if (userDTO.getRole() != null) {
			account.setRoles(Arrays.asList(new Role(userDTO.getRole(), LocalDateTime.now())));
		}

		return account;
	}

	public static Account toAccount(Account existing, UserDTO userDTO) {
		if (existing == null) {
			Account account = new Account();
			account.setRoles(Arrays.asList(new Role(userDTO.getRole(), LocalDateTime.now())));
			account.setName(userDTO.getName());
			account.setEmail(userDTO.getEmail());
			account.setUsername(userDTO.getUsername());
			account.setMobilePhone(userDTO.getMobilePhone());
			account.setNationality(new Country(userDTO.getNationality()));
			account.setPassword(userDTO.getPassword());
			account.setApproved(userDTO.getApproved());

			return account;
		} else {
			existing.setName(userDTO.getName());
			existing.setEmail(userDTO.getEmail());
			existing.setUsername(userDTO.getUsername());
			existing.setMobilePhone(userDTO.getMobilePhone());
			existing.setNationality(new Country(userDTO.getNationality()));
			existing.setApproved(userDTO.getApproved());

			if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty())
				existing.setPassword(userDTO.getPassword());

			return existing;
		}
	}

	public static AccountEditDTO toAccountEdit(Account currentLoggedInUser) {
		AccountEditDTO accountEditDTO = new AccountEditDTO();
		accountEditDTO.setName(currentLoggedInUser.getName());
		accountEditDTO.setGender(currentLoggedInUser.getGender());
		accountEditDTO.setMobilePhone(currentLoggedInUser.getMobilePhone());

		if (currentLoggedInUser.getCity() != null) {
			accountEditDTO.setCityId(currentLoggedInUser.getCity().getId());
		}

		if (currentLoggedInUser.getNationality() != null) {
			accountEditDTO.setCountryId(currentLoggedInUser.getNationality().getId());
		}
		accountEditDTO.setMaritalStatus(currentLoggedInUser.getMaritalStatus());
		accountEditDTO.setNumberOfDependents(currentLoggedInUser.getNumberOfDependents());
		if (currentLoggedInUser.getDob() != null) {
			// Format LocalDateTime
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDateTime = currentLoggedInUser.getDob().format(formatter);
			accountEditDTO.setDob(formattedDateTime);
		}
		accountEditDTO.setTelNo(currentLoggedInUser.getTelNo());
		accountEditDTO.setRpNo(currentLoggedInUser.getRpNo());
		accountEditDTO.setPassportNo(currentLoggedInUser.getPassportNo());
		accountEditDTO.setRpValidity(currentLoggedInUser.getRpValidity());
		accountEditDTO.setSponsor(currentLoggedInUser.getSponsor());
		accountEditDTO.setStatus(currentLoggedInUser.getStatus());
		accountEditDTO.setPassportValidity(currentLoggedInUser.getPassportValidity());

		return accountEditDTO;
	}

	public static Account toAccount(Account currentLoggedInUser, AccountEditDTO accountEditDTO) {
		currentLoggedInUser.setName(accountEditDTO.getName());
		currentLoggedInUser.setGender(accountEditDTO.getGender());
		currentLoggedInUser.setMobilePhone(accountEditDTO.getMobilePhone());
		currentLoggedInUser.setCity(new City(accountEditDTO.getCityId()));
		currentLoggedInUser.setNationality(new Country(accountEditDTO.getCountryId()));
		currentLoggedInUser.setMaritalStatus(accountEditDTO.getMaritalStatus());
		currentLoggedInUser.setNumberOfDependents(accountEditDTO.getNumberOfDependents());
		if (accountEditDTO.getDob() != null) {
			// Format LocalDateTime
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(accountEditDTO.getDob() + " 00:00", formatter);
			currentLoggedInUser.setDob(dateTime);
		}
		currentLoggedInUser.setTelNo(accountEditDTO.getTelNo());
		currentLoggedInUser.setRpNo(accountEditDTO.getRpNo());
		currentLoggedInUser.setPassportNo(accountEditDTO.getPassportNo());
		currentLoggedInUser.setRpValidity(accountEditDTO.getRpValidity());

		currentLoggedInUser.setSponsor(accountEditDTO.getSponsor());
		currentLoggedInUser.setStatus(accountEditDTO.getStatus());
		currentLoggedInUser.setPassportValidity(accountEditDTO.getPassportValidity());
		currentLoggedInUser.setUpdatedOn(LocalDateTime.now());
		currentLoggedInUser.setUpdatedBy(currentLoggedInUser.getId());

		return currentLoggedInUser;
	}
}
