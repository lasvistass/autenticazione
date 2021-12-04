package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "auth_role")
	@SequenceGenerator(name="auth_role", sequenceName = "role_seq")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	
	

}
