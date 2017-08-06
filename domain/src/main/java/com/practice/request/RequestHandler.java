package com.practice.request;

import java.util.List;

import com.practice.Users;

public class RequestHandler {

	private String operation;
	private List<Users> users;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
