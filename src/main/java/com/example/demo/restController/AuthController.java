package com.example.demo.restController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.LoginResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtils;
import com.example.demo.security.UserDetailsImpl;

@RestController
@RequestMapping(value="/api/enter")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		authentication.getAuthorities();
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetailsImpl.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(
				new LoginResponse(jwt, userDetailsImpl.getId(), userDetailsImpl.getUsername(),
				userDetailsImpl.getEmail(), roles, userDetailsImpl.getExpirationTime()));
		}
}
