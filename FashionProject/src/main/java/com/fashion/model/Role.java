package com.fashion.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_role")
public class Role {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "role")
	private Set<UserRole> roleUsers;
	

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, Set<UserRole> roleUsers) {
		super();
		this.id = id;
		this.name = name;
		this.roleUsers = roleUsers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRole> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(Set<UserRole> roleUsers) {
		this.roleUsers = roleUsers;
	}
	
	
}
