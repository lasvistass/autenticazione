package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class LoginResponse {

	private String token;
    private final String type = "Bearer  ";
    private  Integer id;
    private String username;
    private String email;
    private List<String> roles;
    private Date expirationTime;
    
    public LoginResponse ( String token, Integer id, String username, String email, List<String> roles, Date expirationTime) {
    	this.token = token;
    	this.id = id;
    	this.username = username;
    	this.email = email;
    	this.roles = roles;
    	this.expirationTime = expirationTime;
    }
    
}
