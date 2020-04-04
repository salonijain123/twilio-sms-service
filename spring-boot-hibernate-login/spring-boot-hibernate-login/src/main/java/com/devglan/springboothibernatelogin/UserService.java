/*package com.devglan.springboothibernatelogin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class UserService {
	
	
	
	
	@Autowired    
	private UserRepository userRepository;    
	public List<User> getAllUsers()  
	{    
	List<User>userRecords = new ArrayList<>();    
	userRepository.findAll().forEach(userRecords::add);    
	return userRecords;    
	}    
	public void addUser(User userRecord)  
	{    
	userRepository.save(userRecord);    
	}    

}
*/