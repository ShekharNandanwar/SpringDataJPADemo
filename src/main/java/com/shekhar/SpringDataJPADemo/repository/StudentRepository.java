package com.shekhar.SpringDataJPADemo.repository;

import com.shekhar.SpringDataJPADemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String studentName);
    List<Student> findByFirstNameContains(String name);
    List<Student> findByFirstNameIgnoreCaseContaining(String name);
    List<Student> findByLastNameNotNull();

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //Native Query
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmail(String emailId);

    //Native named parameter query
   /* @Query(
            value = "select student_id, first_name, last_name from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    List<Student> getStudentNameByEmail(@Param("emailId") String emailId);*/

    @Transactional
    @Modifying
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentByEmailId(String firstName, String emailId);
}
