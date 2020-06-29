package org.dbs.shop.presentation.user;

import org.dbs.shop.domain.user.RoleTypeEnum;
import org.dbs.shop.domain.user.User;
import org.dbs.shop.presentation.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<UserDTO, User> {

	@Override
	public UserDTO mapToDto(final User entity) {
		final UserDTO dto = new UserDTO();
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());

		final StringBuilder roles = new StringBuilder();

		for (final RoleTypeEnum roleType : entity.getRoles()) {
			roles.append(roleType).append(" ");
		}
		dto.setRoles(roles.toString());
		return dto;
	}

	@Override
	public User mapToDomain(final UserDTO dto) {
		final User entity = new User(dto.getName(), dto.getEmail());
		return entity;
	}

}
