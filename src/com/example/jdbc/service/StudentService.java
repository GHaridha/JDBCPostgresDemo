package com.example.jdbc.service;

import java.util.List;

import com.example.jdbc.model.Student;
import com.example.jdbc.repository.StudentRepository;

public class StudentService {

	private  StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository= studentRepository;
	}
	
	public void insert(Student student) {
		studentRepository.insert(student);
	}
	
	public void update(Student student) {
		studentRepository.update(student);
	}
	
	public void delete(Long id) {
		studentRepository.delete(id);
	}
	
	public Student fetchStudentById(Long id) {
		return studentRepository.getStudentById(id);
	}
	
	public List<Student> fetchAllStudents(){
		return studentRepository.getAllStudent();
	}
}
