package com.example.mac.practise.restApi.service;


import com.example.mac.practise.restApi.ExceptionHandling.StudentNotFoundException;
import com.example.mac.practise.restApi.Repository.StudentRepository;
import com.example.mac.practise.restApi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getOneStudent(Long id) throws StudentNotFoundException  {
        Student student= studentRepository.getOne(id);
        if(student!=null) {
            return student;
        } else throw new StudentNotFoundException("Student not found with Id:"+ id);

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
    public void deleteStudent(Long id) throws StudentNotFoundException{
        try {
            studentRepository.deleteById(id);
        } catch (Exception exp){
            throw new StudentNotFoundException("Student not found with id:"+ id);
        }

    }

    @Override
    public Student getByPassportNo(int number) {
        Student student = studentRepository.findByPassportNumber(number);
        if(student!=null) {
            return student;
        } else throw new StudentNotFoundException("Student not found with Pnumber:"+ number);

    }
}
