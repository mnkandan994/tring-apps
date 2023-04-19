package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privileges",schema = "tring-apps")
public class Privilege {

	@Id
	@Column(name="privilege_id")
	private Long id;

	@Column(name="privilege_name")
	private String name;

	@ManyToMany(mappedBy = "privileges")
	private Set<Role> roles = new HashSet<>();

	public Privilege() {

	}

	public Privilege(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
