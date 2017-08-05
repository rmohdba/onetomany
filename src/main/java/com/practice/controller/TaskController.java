package com.practice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.domain.Tasks;
import com.practice.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/all-tasks")
	public @ResponseBody
	List<Tasks> allTasks() {
		return taskService.findAll();
	}
		
	@GetMapping("/task")
	public @ResponseBody
	Tasks task(@RequestParam int id) {
		return taskService.findOne(id);
	}
	
	@GetMapping("/delete-task")
	public @ResponseBody
	String delete(@RequestParam int id) {
		 taskService.delete(id);
		 return "Task "+id+" deleted";
	}
	
	@GetMapping("/save-task")
	public @ResponseBody
	String save(@RequestParam String name,@RequestParam String desc ) {
		Tasks task = new Tasks(name, desc, new Date(),false);
		 taskService.save(task);
		 return "Task "+name+" saved";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "redirect:/all-tasks";
	}
	
	

}
