package net.springbootcourse.springBootDemo.service;

import net.springbootcourse.springBootDemo.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void createStudent(Student stu);
    void updateStudent(Student stu);
    void deleteStudent(Long id);
}
