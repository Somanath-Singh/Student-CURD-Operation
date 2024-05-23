package com.mgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgmt.entity.Student;

public interface IStudentMgmtRepo extends JpaRepository<Student, Integer> {
	
	public Student findByRedgno(String redgno);
	
	public List<Student> findAll();

}
