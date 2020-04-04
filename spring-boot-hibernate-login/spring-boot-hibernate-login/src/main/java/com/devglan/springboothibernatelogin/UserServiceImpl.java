package com.devglan.springboothibernatelogin;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
    private UserDao userDao;

    @Autowired
    private UserDaoImpl userDaoImpl;
    
    

	public ApiResponse signUp(SignUpDto signupDto) {
		
		User user = new User();
		
		validateSignUp(signupDto);
		BeanUtils.copyProperties(signupDto, user);
		   userDaoImpl.save(user);
	        return new ApiResponse(200, "success", user);
		
		
	}
	
	
	
	
	
	 private void validateSignUp(SignUpDto signUpDto) {
	    }
	
	
	 public ApiResponse login(LoginDto loginDto) {
		  
		    User u = userDao.findByUsername(loginDto.getUsername());
		    
		    if(u == null) {
		    	
		    	 throw new RuntimeException("User does not exist.");
		    	
		    }
		  /*  
		    if(!u.getPassword().equals(loginDto.getPassword())) {
		    	
		    	throw new RuntimeException("Password mismatch");
		    	
		    }*/
		    
		    
		return new ApiResponse(200,"Login success",null);
		
		
		
		
	}

}
