package com.example.demo.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.entity.Privilege;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/privileges/{id}")
	public Set<Privilege> getPrivilegesForUser(@PathVariable long id) throws Exception {
		Set<Privilege> privilegeSet = userService.getPrivilegesForUser(id);
		privilegeSet.stream().forEach(t->System.out.println(t.getRoles().toString()));
		return privilegeSet;
	}
}
