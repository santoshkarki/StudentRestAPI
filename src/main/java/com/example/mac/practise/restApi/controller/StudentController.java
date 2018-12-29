package com.example.mac.practise.restApi.controller;



import com.example.mac.practise.restApi.model.Student;
import com.example.mac.practise.restApi.service.StudentService;
import com.example.mac.practise.restApi.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value="/students", method= RequestMethod.GET )
    public List<Student> getAllStudents(){
       return  studentService.getAllStudents();
    }

    @RequestMapping(value="/students/{id}",method=RequestMethod.GET)
    public Student getStudent(@PathVariable("id") Long id){
        Student student = studentService.getOneStudent(id);
        System.out.println("Getting student of Id:"+id);
        return student;

    }

    @RequestMapping(value="/students",method=RequestMethod.POST)
    public ResponseEntity<Object> saveStudent(@RequestBody Student student){
        System.out.println(student);
       Student savedStudent=  studentService.saveStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        System.out.println("New Student added");
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable("id") Long id){
        ResponseEntity<Object> updatedStudent= studentService.updateStudent(student,id);
        System.out.println("A student is updated with id:"+id);
        return updatedStudent;
    }

    /***
     * 
     * @param id
     */
    @RequestMapping(value="students/{id}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        System.out.println("Student deleted with id:"+id);
    }

    /***
     *
     * @param passportNumber
     * @return
     */
    @RequestMapping(value="/studentByPassportNumber/{passportNumber}",method=RequestMethod.GET)
    public Student getStudentByPassportNumber(@PathVariable("passportNumber") int passportNumber){
        Student student = studentService.getByPassportNo(passportNumber);
        System.out.println("Getting student of passportNumber:"+passportNumber);
        return student;

    }
}
