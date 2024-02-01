package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JwtAuthRequest;
import com.app.dto.JwtAuthResponse;
import com.app.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	private String generateToken;	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken( @RequestBody JwtAuthRequest request){
		this.authenticate(request.getUseername(),request.getPassword());
		UserDetails userdetails =this.userDetailsService.loadUserByUsername(request.getUseername());
		String token = this.jwtTokenHelper.generateToken(userdetails);
		JwtAuthResponse jwtResponse  =  new JwtAuthResponse();
		jwtResponse.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(jwtResponse,HttpStatus.OK);
	}

	private void authenticate(String useername, String password) {
		UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(useername, password);  
		this.authenticationManager.authenticate(authtoken);
		
		
	}  

}
