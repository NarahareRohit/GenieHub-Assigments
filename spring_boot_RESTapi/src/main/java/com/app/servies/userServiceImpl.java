package com.app.servies;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import com.app.resourseNotfound.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.userDto;
import com.app.entity.User;
import com.app.repository.userRepository;

@Service
@Transactional
public class userServiceImpl implements userService{
	
	@Autowired
	private userRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	@Override
	public userDto registerNewUser(userDto dto) {
		User user = mapper.map(dto,User.class);
		User persistentEntity= userRepo.save(user);
		return mapper.map(persistentEntity, userDto.class);
	}

	@Override
	public User logIn(String username, String password) {
		System.out.println("userSerive login impl"+username + ""+ password);
		User user = userRepo.findByUserNameAndPassword(username,password);
		System.out.println("userSerive login impl"+user);
		return user;
	}

	@Override
	public void removeUser(Long id) {
		User user = userRepo.findById(id).orElseThrow(()-> new ResourseNotFound("user not found"));
		userRepo.delete(user);;
	}

	
	
	
	
}
