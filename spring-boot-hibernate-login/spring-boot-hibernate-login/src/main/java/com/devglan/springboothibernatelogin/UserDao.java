package com.devglan.springboothibernatelogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	
	
    User findByUsername(String username);

    User findByEmail(String email);
	
	
	

}
