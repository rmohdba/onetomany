package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.Tasks;
//@Component
@Service
public interface TaskService {

	public List<Tasks> findAll();
	public Tasks findOne(int id);
	public void delete(int id);
	public void save(Tasks task);
}
