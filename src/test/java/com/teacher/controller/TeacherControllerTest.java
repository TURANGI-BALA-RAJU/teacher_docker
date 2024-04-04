package com.teacher.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.teacher.entity.Teacher;
import com.teacher.service.TeacherServiceImp;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherControllerTest {

    @InjectMocks
    private TeacherController teacherController;

    @Mock
    private TeacherServiceImp teacherServiceImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Teacher teacher = new Teacher(); // Create a Teacher object with necessary data
        when(teacherServiceImp.saveDetails(any(Teacher.class))).thenReturn(teacher);

        Teacher savedTeacher = teacherController.save(teacher);

        assertEquals(teacher, savedTeacher);
        verify(teacherServiceImp, times(1)).saveDetails(teacher);
    }

    @Test
    public void testSearchByTeacher() {
        long teacherId = 1L;
        Teacher teacher = new Teacher(); // Create a Teacher object with necessary data
        when(teacherServiceImp.searchByTeacher(teacherId)).thenReturn(teacher);

        Teacher foundTeacher = teacherController.searchByTeacher(teacherId);

        assertEquals(teacher, foundTeacher);
        verify(teacherServiceImp, times(1)).searchByTeacher(teacherId);
    }

    @Test
    public void testUpdate() {
        Teacher teacher = new Teacher(); // Create a Teacher object with necessary data
        when(teacherServiceImp.update(any(Teacher.class))).thenReturn(teacher);

        Teacher updatedTeacher = teacherController.update(teacher);

        assertEquals(teacher, updatedTeacher);
        verify(teacherServiceImp, times(1)).update(teacher);
    }

    @Test
    public void testDelete() {
        int teacherId = 1;
        when(teacherServiceImp.delete(teacherId)).thenReturn("Deleted");

        String result = teacherController.delete(teacherId);

        assertEquals("Deleted", result);
        verify(teacherServiceImp, times(1)).delete(teacherId);
    }

    @Test
    public void testGetAllTeachers() {
        List<Teacher> teachers = Arrays.asList(new Teacher(), new Teacher()); // Create a list of Teacher objects with necessary data
        when(teacherServiceImp.getAllTeacherDetails()).thenReturn(teachers);

        List<Teacher> allTeachers = teacherController.getAllTeachers();

        assertEquals(teachers.size(), allTeachers.size());
        assertEquals(teachers.get(0), allTeachers.get(0));
        assertEquals(teachers.get(1), allTeachers.get(1));
        verify(teacherServiceImp, times(1)).getAllTeacherDetails();
    }
}
