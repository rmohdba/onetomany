package com.practice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.dao.UserRepo;
import com.practice.domain.Users;
import com.practice.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<Users> findAll() {
		return userRepo.findAll() ;
	}

	@Override
	public Users findOne(int id) {
		return userRepo.findOne(id);
	}

	@Override
	public void delete(int id) {
		userRepo.delete(id);
	}

	@Override
	public void save(Users user) {
		userRepo.save(user);
	}

}
