package com.example.mac.practise.restApi.service;

import com.example.mac.practise.restApi.Repository.StudentRepository;
import com.example.mac.practise.restApi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student getOneStudent(Long id);
    public List<Student> getAllStudents();
    public Student saveStudent(Student student);
    public ResponseEntity<Object> updateStudent(Student student, Long id);
    public void deleteStudent(Long id);
    public Student getByPassportNo(int number);

}
