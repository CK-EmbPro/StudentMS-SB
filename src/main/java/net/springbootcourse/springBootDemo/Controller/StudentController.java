package net.springbootcourse.springBootDemo.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.springbootcourse.springBootDemo.Model.Student;
import net.springbootcourse.springBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    public final StudentService stuService;

    @GetMapping("/get")
    public String getAllStudents(Model model){
        model.addAttribute("students", stuService.getAllStudents());
        return "students";
    }

    @GetMapping("/form")
    public String createStudentForm(Model model){
            Student student = new Student();
            model.addAttribute("student", student);
            return "createStudent";
    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student stu){
        stuService.createStudent(stu);
        return "redirect:/student/get";
    }

    @GetMapping("/editStu/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Student student = stuService.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student){
        Student student2 = stuService.getStudentById(id);
        student2.setFirstName(student.getFirstName());
        student2.setLastName(student.getLastName());
        student2.setEmail(student.getEmail());

        stuService.updateStudent(student2);

        return "redirect:/student/get";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        stuService.deleteStudent(id);
        return "redirect:/student/get";
    }

}
