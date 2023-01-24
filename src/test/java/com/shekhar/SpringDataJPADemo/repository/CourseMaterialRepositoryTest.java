package com.shekhar.SpringDataJPADemo.repository;

import com.shekhar.SpringDataJPADemo.entity.Course;
import com.shekhar.SpringDataJPADemo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("SpringBootJPA")
                .credit("8")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://www.w3schools.com/css")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void getCourseMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}