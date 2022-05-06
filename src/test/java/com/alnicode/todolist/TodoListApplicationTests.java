package com.alnicode.todolist;

import com.alnicode.todolist.persistence.entity.Role;
import com.alnicode.todolist.persistence.entity.User;
import com.alnicode.todolist.persistence.repository.IRoleRepository;
import com.alnicode.todolist.persistence.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TodoListApplicationTests {
	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IRoleRepository roleRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Test
	void contextLoads() {
		Set<Role> roles = new HashSet<>();
		Set<User> users = new HashSet<>();

		var user = new User();
		user.setUsername("admin");
		user.setPassword(encoder.encode("adminRoot_123"));
		users.add(user);

		var role = new Role();
		role.setName("USER");
		roles.add(role);

		user.setRoles(roles);
		role.setUsers(users);

		assertNotNull(userRepo.save(user));
	}

}
