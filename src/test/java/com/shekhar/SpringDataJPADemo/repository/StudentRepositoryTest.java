package com.shekhar.SpringDataJPADemo.repository;

import com.shekhar.SpringDataJPADemo.entity.Guardian;
import com.shekhar.SpringDataJPADemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

  /*  @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Chandrashekhar")
                .lastName("Nandanwar")
                .emailId("shekhar15jan@gmail.com")
                .guardianName("Tulshiram")
                .guardianEmail("tsnandanwar@gmail.com")
                .guardianMobile("7276553814")
                .build();
        studentRepository.save(student);
    }*/

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Shekhar")
                .email("Shekhar@gmail.com")
                .mobile("9876543210")
                .build();
        Student student = Student.builder()
                .firstName("Hansh")
                .lastName("Nandanwar")
                .emailId("hansh@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void whenStudentFirstName_thenStudentWithMatchingList(){
        List<Student> studentList = studentRepository.findByFirstName("Chandrashekhar");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void whenStudentFirstNameContainsString_thenStudentWithMatchingList(){
        List<Student> studentList = studentRepository.findByFirstNameContains("shekhar");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void whenStudentFirstNameStringIgnoreCase_thenStudentWithMatchingList(){
        List<Student> studentList = studentRepository.findByFirstNameIgnoreCaseContaining("shekhar");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void findByLastNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void whenStudentEmail_thenStudent(){
        Student student = studentRepository.getStudentByEmailAddress("shekhar15jan@gmail.com");
        System.out.println("student = " + student);
    }
    
    /*@Test
    public void whenStudentEmail_thenStudentFirstNameAndLastName(){
        List<Student> student = studentRepository.getStudentNameByEmail("shekhar15jan@gmail.com");
        System.out.println("student = " + student);
    }*/

    @Test
    public void whenStudentEmail_thenUpdateFirstName(){
        int updatedId = studentRepository.updateStudentByEmailId("Shekhar", "shekhar15jan@gmail.com");
        System.out.println("updatedId = " + updatedId);
    }
}