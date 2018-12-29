package com.example.mac.practise.restApi.Repository;

import com.example.mac.practise.restApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*Custom method definition*/
    @Query("select s from Student s where s.passportNumber = :passportNumber")
    Student findByPassportNumber(@Param("passportNumber") int passportNumber);
}
