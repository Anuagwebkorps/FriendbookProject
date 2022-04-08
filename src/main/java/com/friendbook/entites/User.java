package com.friendbook.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
@Column(name="FullName")	
 private String  name;
 @Id
 private String  email;
 private String  password;
 private String  username;
 
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}


@Override
public String toString() {
	return "User [name=" + name + ", email=" + email + ", password=" + password + ", username=" + username + "]";
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

 
}
