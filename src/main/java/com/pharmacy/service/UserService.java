package com.pharmacy.service;

import com.pharmacy.bean.User;
import com.pharmacy.generic.GenericService;

public interface UserService extends GenericService<User> {

	boolean authenticate(String email, String password);
	
	User findByEmail(String email);
	
}
