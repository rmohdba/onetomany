package com.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Tasks;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, Integer> {	

}
