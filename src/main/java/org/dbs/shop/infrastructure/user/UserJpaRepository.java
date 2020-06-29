package org.dbs.shop.infrastructure.user;

import org.dbs.shop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
