package org.dbs.shop.infrastructure.user;

import java.util.List;

import org.dbs.shop.domain.user.User;
import org.dbs.shop.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	public User findByEmail(final String email) {
		return userJpaRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}

	@Override
	public User add(final User user) {
		return userJpaRepository.save(user);
	}

}
