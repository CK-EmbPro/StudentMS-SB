package net.springbootcourse.springBootDemo.service;

import net.springbootcourse.springBootDemo.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void createStudent(Student stu);
}
