package com.practice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.dao.TaskRepo;
import com.practice.domain.Tasks;
import com.practice.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	@Override
	public List<Tasks> findAll() {
		return taskRepo.findAll();
	}
	@Override
	public Tasks findOne(int id) {
		return taskRepo.findOne(id);
	}
	@Override
	public void delete(int id) {
		taskRepo.delete(id);
	}
	@Override
	public void save(Tasks task) {
		taskRepo.save(task);
	}
	

}
