package cafemanage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.TaiKhoan;
import cafemanage.jwt.JWTProvider;

@RestController
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTProvider jwtProvider;
	
	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody TaiKhoan taiKhoan){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(taiKhoan.getUsername(), taiKhoan.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateToken((UserDetails) authentication.getPrincipal());
		
		return ResponseEntity.ok().body(jwt);
	}
	
}
