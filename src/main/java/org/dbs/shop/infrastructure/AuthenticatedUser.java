package org.dbs.shop.infrastructure;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.dbs.shop.domain.user.RoleTypeEnum;
import org.dbs.shop.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

	private final User user;

	public AuthenticatedUser(final User user) {
		super(user.getEmail(), user.getPassword(), getAuthorities(user));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(final User user) {
		final Set<String> roleAndPermissions = new HashSet<>();
		final Set<RoleTypeEnum> roles = user.getRoles();

		for (final RoleTypeEnum role : roles) {
			roleAndPermissions.add(role.name());
		}
		final String[] roleNames = new String[roleAndPermissions.size()];
		final Collection<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
}
