package com.example.demo.entity;

import java.util.Date;
import java.util.List;

public class LoginResponse {

	private String token;
	private final String type = "Bearer  ";
	private Integer id;
	private String username;
	private String email;
	private List<String> roles;
	private Date expirationTime;

	public LoginResponse() {
	}

	public LoginResponse(String token, Integer id, String username, String email, List<String> roles,
			Date expirationTime) {
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.expirationTime = expirationTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getType() {
		return type;
	}

}
