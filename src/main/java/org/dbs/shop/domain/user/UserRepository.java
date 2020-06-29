package org.dbs.shop.domain.user;

import java.util.List;

public interface UserRepository {

	User findByEmail(String userName);

	List<User> findAll();

	User add(User user);

}
