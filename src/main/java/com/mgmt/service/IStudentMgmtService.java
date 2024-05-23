package com.mgmt.service;

import java.util.List;

import com.mgmt.entity.Student;

public interface IStudentMgmtService {
	
	public Student addStudent(Student stu);
	
	public List<Student> getAllStudent();

}
