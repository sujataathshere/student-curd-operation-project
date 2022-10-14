package com.students.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.entity.Students;

public interface StudentsDAO extends JpaRepository<Students, Integer> {
	
}
