package com.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.students.dao.StudentsDAO;
import com.students.entity.Students;

@Transactional
@Service
public class StudentsServiceImp implements StudentsService {

	@Autowired
	private StudentsDAO studentsDAO;

	@Override
	public Students findStudentById(Integer Id) {
		return studentsDAO.findById(Id).get();
	}

	@Override
	public boolean deleteById(Integer Id) {
		studentsDAO.deleteById(Id);
		return true;
	}

	@Override
	public Students saveStudent(Students student) {
		return studentsDAO.save(student);
	}

	@Override
	public List<Students> listOfStudents() {
		return studentsDAO.findAll();
	}

}
