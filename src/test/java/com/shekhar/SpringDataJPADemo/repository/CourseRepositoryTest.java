package com.shekhar.SpringDataJPADemo.repository;

import com.shekhar.SpringDataJPADemo.entity.Course;
import com.shekhar.SpringDataJPADemo.entity.CourseMaterial;
import com.shekhar.SpringDataJPADemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void createCourse(){
        Course course = Course.builder()
                .title("DotNet")
                .credit("10")
                .build();
        courseRepository.save(course);
        System.out.println("course = " + course);
        
    }
    @Test
    public void printCourse(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Vishal")
                .lastName("Dharankar")
                .build();
        Course course = Course.builder()
                .teacher(teacher)
                .title("EC2-Electronics Communication")
                .credit("9")
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courseList = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        int totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void sortRecords(){
        Pageable sortByTitle = PageRequest.of(0,3, Sort.by("title").ascending());
        Pageable sortByCredit = PageRequest.of(0,2, Sort.by("credit").descending());
        List<Course> courseListByTitleSort = courseRepository.findAll(sortByTitle).getContent();
        List<Course> courseListByCreditDescSort = courseRepository.findAll(sortByCredit).getContent();
        System.out.println("courseListByTitleSort = " + courseListByTitleSort);
        System.out.println("courseListByCreditDescSort = " + courseListByCreditDescSort);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable pageable = PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("o",pageable).getContent();
        System.out.println("courses = " + courses);
    }


}