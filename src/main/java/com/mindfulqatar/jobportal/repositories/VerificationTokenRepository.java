package com.mindfulqatar.jobportal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mindfulqatar.jobportal.entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	Optional<VerificationToken> findByVerificationToken(String verificationToken);

	VerificationToken save(String verificationToken);

	void deleteByAccountId(Long accountId);
}
