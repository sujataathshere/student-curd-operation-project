package com.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.entity.Students;
import com.students.response.Response;
import com.students.service.StudentsService;

@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	StudentsService studentsService;

	@GetMapping("/get-all-students")
	public ResponseEntity<?> findAllStudents() {
		try {
			List<Students> listOfStudents = studentsService.listOfStudents();
			if (listOfStudents != null) {
				return Response.success(listOfStudents);
			} else {
				return Response.error("Student list is empty.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) {
		try {
			 Students student = studentsService.findStudentById(id);
			if (student != null) {
				return Response.success(student);
			} else {
				return Response.error("Student not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable int id) {
		try {
			  boolean flag = studentsService.deleteById(id);
			if(flag) {
				return Response.success("Student deleted successfully. Student id : "+id);
			} else {
				return Response.error("Error while deleting student.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error(e.getMessage());
		}
	}

	@PutMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody Students student) {
		
		try {
			 Students student1 = studentsService.saveStudent(student);
			if (student1 != null) {
				return Response.success(student1);
			} else {
				return Response.error("Error while saving student.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error(e.getMessage());
		}
	}
	
	@PutMapping("/update-student")
	public ResponseEntity<?> updateStudent(@RequestBody Students student) {
		
		try {
			 Students std = studentsService.findStudentById(student.getId());
			 std.setFirstName(student.getFirstName());
			 std.setLastName(student.getLastName());
			 std.setAge(student.getAge());
			 std.setDivison(student.getDivison());
			 std.setGender(student.getGender());
			 std.setStandard(student.getStandard());
			 
			 Students student1 = studentsService.saveStudent(std);
			if (student1 != null) {
				return Response.success(student1);
			} else {
				return Response.error("Error while saving student.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error(e.getMessage());
		}
	}
}
