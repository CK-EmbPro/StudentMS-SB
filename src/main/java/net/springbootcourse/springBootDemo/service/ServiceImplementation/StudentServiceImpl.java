package net.springbootcourse.springBootDemo.service.ServiceImplementation;

import net.springbootcourse.springBootDemo.Model.Student;
import net.springbootcourse.springBootDemo.Repository.StudentRepository;
import net.springbootcourse.springBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepository stuRepository;
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = stuRepository.findAll();
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return stuRepository.findById(id).get();
    }

    @Override
    public void createStudent(Student stu) {
        stuRepository.save(stu);
    }

    @Override
    public void updateStudent(Student stu) {
        stuRepository.save(stu);
    }

    @Override
    public void deleteStudent(Long id) {
        stuRepository.deleteById(id);
    }
}
