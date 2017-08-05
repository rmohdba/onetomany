package com.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.domain.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

}
