package com.react.kodbook.services;
import java.util.List;

import com.react.kodbook.entities.Post;
import com.react.kodbook.entities.User;
public interface UserService {

	void addUser(User user);

	boolean userExists(String username, String email);

	boolean validateUser(String username, String password);

	User getUser(String username);

	void updateUser(User user);

	User getUserById(Long id);

	
}