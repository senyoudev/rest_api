package com.senyoudev.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }



    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestBody(required = false) StudentDTO infos) {
        studentService.updateStudent(studentId,infos.getName(),infos.getEmail());
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
            studentService.deleteStudent(studentId);

    }
}
