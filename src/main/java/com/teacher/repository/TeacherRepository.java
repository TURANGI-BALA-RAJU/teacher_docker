package com.teacher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.teacher.entity.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher, Long>{
	
	public Optional<Teacher> findByTeacherId(long id);
	

}
