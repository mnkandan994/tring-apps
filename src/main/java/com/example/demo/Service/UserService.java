package com.example.demo.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.Privilege;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Set<Privilege> getPrivilegesForUser(long userId) throws Exception {
		User user = userRepository.findById(userId);
		if (user == null) {
			throw new Exception("User not found with id: " + userId);
		}
		Set<Privilege> privileges = new HashSet<>();
		for (Role role : user.getRoles()) {
			privileges.addAll(role.getPrivileges());
		}
		return privileges;
	}

}
