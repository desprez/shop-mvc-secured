package org.dbs.shop.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	private static final String EXISTING_USER_EMAIL = "john.doe@gmail.com";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void add_user_with_valid_user_should_success() {
		// Given
		final User user = new User("john doe", EXISTING_USER_EMAIL);
		// When
		userRepository.add(user);
		// Then
		final List<?> ordersFound = entityManager.getEntityManager()
				.createQuery("select u from User u where u.email = :userEmail")
				.setParameter("userEmail", EXISTING_USER_EMAIL).getResultList();
		assertThat(ordersFound.size()).isEqualTo(1);
	}

	@Test
	public void findByEmail_with_existing_email_shoul_success() {
		// Given
		final User user = new User("john doe", EXISTING_USER_EMAIL);
		user.getRoles().add(RoleTypeEnum.ROLE_ADMIN);
		entityManager.persistAndFlush(user);
		// When
		final User found = userRepository.findByEmail(EXISTING_USER_EMAIL);
		// Then
		assertThat(found).isNotNull();
		assertThat(found.getRoles().size()).isEqualTo(1);
		assertThat(found.getRoles().iterator().next().name()).isEqualTo("ROLE_ADMIN");
	}

}
