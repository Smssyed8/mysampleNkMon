package com.mindfulqatar.jobportal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mindfulqatar.jobportal.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
	Optional<Account> findByEmail(String email);

	Optional<Account> findByUsername(String userName);
}
