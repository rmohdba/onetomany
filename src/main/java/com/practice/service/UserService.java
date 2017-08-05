package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.domain.Users;

@Service
public interface UserService {
	public List<Users> findAll();
	public Users findOne(int id);
	public void delete(int id);
	public void save(Users user);

}
