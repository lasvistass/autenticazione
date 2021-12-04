package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {

	
	private Integer id;
	private String email;
	private String username;
	@JsonIgnore
	private String password;
	private boolean accountNotLocked = true;
	private boolean accountNotExpired = true;
	private boolean credentialsNotExpired = true;
	private boolean enabled = true;
	private Date expirationTime;
	
	private Collection< ? extends  GrantedAuthority > authorities;
	
	public UserDetailsImpl(Integer id, String username, String email, String password, boolean enabled, 
							Collection< ? extends  GrantedAuthority > authorities) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.accountNotExpired = enabled;
		this.accountNotLocked = enabled;
		this.credentialsNotExpired = enabled;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> list = user.getRoles().stream()
											.map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
											.collect(Collectors.toList());
		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.isActive(), list);													
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isAccountNotLocked() {
		return accountNotLocked;
	}


	public void setAccountNotLocked(boolean accountNotLocked) {
		this.accountNotLocked = accountNotLocked;
	}


	public boolean isAccountNotExpired() {
		return accountNotExpired;
	}


	public void setAccountNotExpired(boolean accountNotExpired) {
		this.accountNotExpired = accountNotExpired;
	}


	public boolean isCredentialsNotExpired() {
		return credentialsNotExpired;
	}


	public void setCredentialsNotExpired(boolean credentialsNotExpired) {
		this.credentialsNotExpired = credentialsNotExpired;
	}


	public Date getExpirationTime() {
		return expirationTime;
	}


	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
