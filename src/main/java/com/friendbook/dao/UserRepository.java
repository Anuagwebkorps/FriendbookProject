package com.friendbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.friendbook.entites.User;

public interface UserRepository extends JpaRepository<User, String>{
 
	 @Query(value="select * from user",nativeQuery = true)
     public List<User> getUserss();
	 
	public List<User> findByEmail(String email);
     
	 @Query("select u from User u where u.email = :email and u.password = :password")
	 public User getUserByEmailandPassword5(@Param("email") String email,@Param("password") String password);
	 
	

	
	 
	 
	 
}
