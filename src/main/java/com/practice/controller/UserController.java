package com.practice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.domain.Tasks;
import com.practice.domain.Users;
import com.practice.service.UserService;

@RestController
public class UserController {
			
		@Autowired
		private UserService userService;
		
		
		@GetMapping("/all-users")
		public List<Users> allUsers() {
			return userService.findAll();
		}
			
		@GetMapping("/user")
		public @ResponseBody
		Users user(@RequestParam int id) {
			return userService.findOne(id);
		}
		
		@GetMapping("/delete-user")
		public @ResponseBody
		String delete(@RequestParam int id) {
			userService.delete(id);
			 return "User "+id+" deleted";
		}
		
		@GetMapping("/save-user")
		public @ResponseBody
		String save(@RequestParam Map< String, String> values) {
			Users user = new Users(values.get("first"), values.get("last"));
			
			boolean finished= values.get("status").equals("true")?true:false;
			Tasks task = new Tasks(values.get("taskname"),values.get("description"), new Date(),finished);
			
			
			/*task.setName("test taks");
			task.setDescription("test desp");
			task.setDate_created(new Date());
			task.setFinished(false);*/
			
			/*user.setFirstname("test first");
			user.setLastname("testlast");*/
			List <Tasks> tasks = new ArrayList<>();
			tasks.add(task);
			
			user.setTask(tasks);
			
			userService.save(user);
			 return "User saved";
		}
		
		@GetMapping("/test3")
		public @ResponseBody String test2() {
			return "redirect:/all-users";
		}
}
