package com.devglan.springboothibernatelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@PostMapping("/signup")
	public ApiResponse signUp(@RequestBody SignUpDto signupDto) {
		return userService.signUp(signupDto);
		
	}
	
	@PostMapping("/login")
	public ApiResponse login(@RequestBody LoginDto loginDto) {
		return userService.login(loginDto);
		
	}
}

