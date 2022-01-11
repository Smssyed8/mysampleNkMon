package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.dto.AccountRegistrationDTO;
import com.mindfulqatar.jobportal.dto.UserDTO;
import com.mindfulqatar.jobportal.entities.Account;

public interface AccountService {
	Account getAccountByEmail(String email);

	List<Account> getAllAccounts();

	Account save(AccountRegistrationDTO registration);

	Account save(UserDTO userDTO);

	List<Account> searchAccounts(Account account);

	Account save(Account account);

	void deleteAccount(Long id);

	Account savePassword(Account account, String password);

}
