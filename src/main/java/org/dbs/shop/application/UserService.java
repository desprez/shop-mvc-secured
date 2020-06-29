package org.dbs.shop.application;

import java.util.List;

import org.dbs.shop.domain.user.User;

public interface UserService {

	List<User> findAll();

	void registerNewUserAccount(User user);

}
