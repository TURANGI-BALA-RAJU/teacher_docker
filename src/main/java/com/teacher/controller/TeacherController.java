package com.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.entity.Teacher;
import com.teacher.repository.TeacherRepository;
import com.teacher.service.TeacherServiceImp;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}, maxAge = 3600L, exposedHeaders = "Access-Control-Allow-Origin")
public class TeacherController {
	
	@Autowired
	private TeacherServiceImp teacherServiceImp;
	
	@PostMapping("/save")
	public Teacher save(@RequestBody Teacher teacher)
	{
		return teacherServiceImp.saveDetails(teacher);
	}
	@GetMapping("get/{id}")
	public Teacher searchByTeacher(@PathVariable("id") long id)
	{
		return teacherServiceImp.searchByTeacher(id);
	}
	
	@PutMapping("/update")
	public Teacher update(@RequestBody Teacher teacher)
	{
		return teacherServiceImp.update(teacher);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id")int id)
	{
		return teacherServiceImp.delete(id);
	}
	
	@GetMapping("/allteacher")
	public List<Teacher> getAllTeachers()
	{
		return teacherServiceImp.getAllTeacherDetails();
	}
	
	
}
