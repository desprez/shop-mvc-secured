
create table if not exists persistent_logins (
  username varchar(100) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
);

delete from user_roles;
delete from users;

INSERT INTO users (id, email, password, name) VALUES
(-1, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(-2, 'user@gmail.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'User');

insert into user_roles(user_id, roles) values
(-1,'ROLE_ADMIN'),
(-1,'ROLE_USER'),
(-2,'ROLE_USER')
;
