package com.shekhar.SpringDataJPADemo.repository;

import com.shekhar.SpringDataJPADemo.entity.Course;
import com.shekhar.SpringDataJPADemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course kotlinCourse = Course.builder()
                .title("Kotlin")
                .credit("9")
                .build();
        Course csCourse = Course.builder()
                .title("CSharp")
                .credit("8")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Shubhangi")
                .lastName("Desale")
                .build();
        teacherRepository.save(teacher);
    }

}