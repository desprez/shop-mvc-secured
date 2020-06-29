package org.dbs.shop.domain.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 4)
	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	@Email(message = "{errors.invalid_email}")
	private String email;

	@Column(nullable = false)
	private String password;

	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<RoleTypeEnum> roles = new HashSet<>();

	/**
	 * Needed by hibernate
	 */
	public User() {

	}

	public User(@Size(min = 4) final String name, @Email(message = "{errors.invalid_email}") final String email) {
		super();
		this.name = name;
		this.email = email;
		password = "change_me";
		roles.add(RoleTypeEnum.ROLE_USER);
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Set<RoleTypeEnum> getRoles() {
		return roles;
	}

	public void setRoles(final Set<RoleTypeEnum> roles) {
		this.roles = roles;
	}

}
