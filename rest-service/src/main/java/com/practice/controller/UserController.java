package com.practice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Tasks;
import com.practice.Users;
import com.practice.request.RequestHandler;
import com.practice.response.ResponseHandler;
import com.practice.response.ResponseParser;
import com.practice.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	ResponseParser responseParser;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseHandler process(@RequestBody RequestHandler requestHandler) {
		ResponseHandler response = new ResponseHandler();
		try {
			String operation = requestHandler.getOperation();

			List<Users> users = null;

			switch (operation) {
			case "all-users":
				users = allUsers();
				break;
			default:
				throw new Exception("Invalid request received with " + operation);
			}
			response.setUsers(users);
			return response;
		} catch (Exception e) {
			return responseParser.handleResponse(e);
		}
	}

	@RequestMapping("/all-users")
	public List<Users> allUsers() {
		List<Users> usersList = userService.findAll();
//		try{Thread.sleep(5000);}catch(Exception e){e.printStackTrace();}
		return usersList;
	}

	@GetMapping("/user")
	public @ResponseBody Users user(@RequestParam int id) {
		return userService.findOne(id);
	}

	@GetMapping("/delete-user")
	public @ResponseBody String delete(@RequestParam int id) {
		userService.delete(id);
		return "User " + id + " deleted";
	}

	@GetMapping("/save-user")
	public String save(@RequestParam Map<String, String> values) {
		Users user = new Users(values.get("first"), values.get("last"));

		boolean finished = values.get("status").equals("true") ? true : false;
		Tasks task = new Tasks(values.get("taskname"), values.get("description"), new Date(), finished);
		task.setUser(user);

		List<Tasks> tasks = new ArrayList<>();
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
