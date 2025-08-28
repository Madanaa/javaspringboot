package com.beginner.beginner.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student updateStudent(String id, Student updated) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updated.getName());
                    student.setEmail(updated.getEmail());
                    student.setAge(updated.getAge());
                    student.setCourse(updated.getCourse());
                    return studentRepository.save(student);
                })
                .orElse(null);
    }
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student deleted with id: " + id;
    }
}
