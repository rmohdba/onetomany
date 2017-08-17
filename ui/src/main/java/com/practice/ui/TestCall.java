package com.practice.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.Users;
import com.practice.request.RequestHandler;
import com.practice.response.ResponseHandler;

@Component
public class TestCall {

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	public void fetchData(){
		ResponseEntity<ResponseHandler> response = restTemplate.exchange("http://localhost:7002/", HttpMethod.POST, getHttpEntity(), ResponseHandler.class);
		ResponseHandler responseHandler = response.getBody();
		List<Users> usersList = responseHandler.getUsers();
		for(Users user : usersList){
			System.out.println("ID: "+user.getId());
			System.out.println("Name: "+user.getFirstname()+" "+user.getLastname());
		}
		System.out.println(response.getBody());
	}
	
	private HttpEntity<RequestHandler> getHttpEntity(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		RequestHandler request = new RequestHandler();
		request.setOperation("all-users");
		
		HttpEntity<RequestHandler> entity = new HttpEntity<RequestHandler>(request, headers);
		return entity;
	}
	
}
