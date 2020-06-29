package org.dbs.shop.application;

import java.util.List;

import org.dbs.shop.domain.user.User;
import org.dbs.shop.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void registerNewUserAccount(final User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.add(user);
	}

}
