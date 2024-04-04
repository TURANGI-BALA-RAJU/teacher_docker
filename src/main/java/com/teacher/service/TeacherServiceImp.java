package com.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.entity.Teacher;
import com.teacher.exception.ResourceNotFoundException;
import com.teacher.repository.TeacherRepository;
@Service
public class TeacherServiceImp implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	@Override
	public Teacher saveDetails(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeacherDetails() {
		
		return teacherRepository.findAll();
	}

	@Override
	public String delete(long id) {
		
		
		if(searchByTeacher(id)==null)
		{
			throw new ResourceNotFoundException("Teacher not found for Id");
		}
		teacherRepository.deleteById(id);
		return "delete successfully";
	}

	@Override
	public Teacher update(Teacher teacher) {
		if(searchByTeacher(teacher.getTeacherId())==null)
		{
			throw new ResourceNotFoundException("Teacher not found for Id");
		}
		return teacherRepository.save(teacher);
	}
	
	public Teacher searchByTeacher(long id)
	{
		teacherRepository.findByTeacherId(id).orElseThrow(
				()-> new ResourceNotFoundException("No Teacher is found"));
	
		return teacherRepository.findByTeacherId(id).get();
	}

}
