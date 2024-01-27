package com.app.servies;

import java.util.List;

import com.app.dto.userDto;
import com.app.entity.User;

public interface userService  {
	List<User> getAll();
	userDto registerNewUser(userDto dto);
	User logIn(String username,String password);
	void removeUser(Long id);
}
