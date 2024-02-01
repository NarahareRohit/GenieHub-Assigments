package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.User;

public interface userRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String username, String password);
	User findByUserName(String username);
}
