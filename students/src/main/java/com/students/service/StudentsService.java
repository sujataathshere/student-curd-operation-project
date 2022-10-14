package com.students.service;

import java.util.List;

import com.students.entity.Students;

public interface StudentsService {
	Students findStudentById(Integer Id);

	boolean deleteById(Integer Id);

	Students saveStudent(Students student);

	List<Students> listOfStudents();
}
