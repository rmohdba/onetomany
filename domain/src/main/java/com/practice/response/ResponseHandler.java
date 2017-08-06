package com.practice.response;

import java.util.List;

import com.practice.Users;

public class ResponseHandler {

	private List<Users> users;
	private ExclusionaryConditions exclusionaryConditions;

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public ExclusionaryConditions getExclusionaryConditions() {
		return exclusionaryConditions;
	}

	public void setExclusionaryConditions(ExclusionaryConditions exclusionaryConditions) {
		this.exclusionaryConditions = exclusionaryConditions;
	}

}
