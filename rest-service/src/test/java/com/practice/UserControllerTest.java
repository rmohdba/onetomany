package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.controller.UserController;
import com.practice.request.RequestHandler;
import com.practice.response.ResponseHandler;
import com.practice.response.ResponseParser;
import com.practice.service.UserService;

@RunWith (SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	
	@Mock private UserService userService;
	@Mock private ResponseParser responseParser;
	
	@InjectMocks private UserController controller = new UserController();
	
	private RequestHandler requestHandler;
	
	@Before
	public void setup(){
		requestHandler = Mockito.mock(RequestHandler.class);
	}
	
//	@Test(expected=java.lang.NullPointerException.class)
//	public void testProcessWithNullValues(){
//		UserController controller = new UserController();
//		controller.process(null);
//	}
	
	@Test
	public void testProcessWithValidInput(){
		mockWithValidData();
		ResponseHandler response = controller.process(requestHandler);
		List<Users> usersList = response.getUsers();
		Users user = usersList.get(0);
		
		List<Tasks> tasksList = user.getTask();
		
		assert user.getFirstname().equals("FirstName");
		assert user.getLastname().equals("LastName");
		assert user.getId() == 1;
		assert tasksList == null;
	}
	
	private void mockWithValidData(){
		Users user1 = new Users();
		user1.setFirstname("FirstName");
		user1.setId(1);
		user1.setLastname("LastName");
		List<Users> usersList = new ArrayList<>();
		usersList.add(user1);
		Mockito.when(userService.findAll()).thenReturn(usersList);
		
		requestHandler = Mockito.mock(RequestHandler.class);
		Mockito.when(requestHandler.getOperation()).thenReturn("all-users");
	}

}
