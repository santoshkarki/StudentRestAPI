package com.example.mac.practise.restApi.service;


import com.example.mac.practise.restApi.Repository.StudentRepository;
import com.example.mac.practise.restApi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getOneStudent(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public List<Student> getAllStudents() {
       return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        Long id = student.getId();
        Student studentSaved =  studentRepository.getOne(id);
        return studentSaved;
    }

    @Override
    public ResponseEntity<Object> updateStudent(Student student, Long id) {
    student.setId(id);
    studentRepository.save(student);
    return ResponseEntity.noContent().build();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student getByPassportNo(int number) {
        return studentRepository.findByPassportNumber(number);
    }
}
