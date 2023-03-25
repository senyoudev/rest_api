package com.senyoudev.Students;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;
    List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            try {
                throw new IllegalAccessException("Email Taken");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists) {
            try {
                throw new IllegalAccessException("Student does not exist");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long studentId, String name,String email) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(() ->  new IllegalAccessException("not found"));
            student.setEmail(email);
            student.setName(name);
            System.out.println("name"+name);
            System.out.println(student);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
