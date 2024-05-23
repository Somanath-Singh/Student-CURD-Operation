package com.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmt.entity.Student;
import com.mgmt.repo.IStudentMgmtRepo;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	
	@Autowired
	private IStudentMgmtRepo repo;

	@Override
	public Student addStudent(Student stu) {
		
		return repo.save(stu);
		
	}

	@Override
	public List<Student> getAllStudent() {

		return repo.findAll();
		
	}

}
