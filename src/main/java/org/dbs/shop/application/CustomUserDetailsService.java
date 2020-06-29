package org.dbs.shop.application;

import java.util.Collection;

import org.dbs.shop.domain.exception.NotFoundException;
import org.dbs.shop.domain.user.User;
import org.dbs.shop.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	private static final String USER_NOT_FOUND = "USER_NOT_FOUND";

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {

		final User user = userRepository.findByEmail(userName);
		if (user == null) {
			throw new NotFoundException(USER_NOT_FOUND, "Email " + userName + " not found");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(final User user) {
		final String[] userRoles = user.getRoles().stream().map((role) -> role.name()).toArray(String[]::new);
		final Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
}
