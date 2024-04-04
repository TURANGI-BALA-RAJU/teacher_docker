package com.teacher.service;

import java.util.List;

import com.teacher.entity.Teacher;

public interface TeacherService {
	
	public Teacher saveDetails(Teacher teacher);
	
	public List<Teacher> getAllTeacherDetails();
	
	public String delete(long id);
	
	public Teacher update(Teacher teacher);

}
