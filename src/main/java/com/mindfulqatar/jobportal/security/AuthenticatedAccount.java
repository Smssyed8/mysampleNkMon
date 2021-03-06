package com.mindfulqatar.jobportal.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.mindfulqatar.jobportal.entities.Account;
import com.mindfulqatar.jobportal.entities.Role;

public class AuthenticatedAccount extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private Account user;

	public AuthenticatedAccount(Account user) {
		super(user.getEmail(), user.getPassword(), getAuthorities(user));
		this.user = user;
	}

	public Account getUser() {
		return user;
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(Account user) {
		Set<String> roleAndPermissions = new HashSet<>();
		List<Role> roles = user.getRoles();

		for (Role role : roles) {
			roleAndPermissions.add(role.getRole());
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
}
