/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Course;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kmd
 */
public interface CourseRepository extends CrudRepository<Course, String> {

    @Query(value = "SELECT * FROM course c\n"
            + "inner join gradecategory gc on gc.courseId = c.courseId\n"
            + "inner join grade g on gc.gradeCategoryId = g.gradeCategoryId\n"
            + "inner join semester sem on sem.semesterId = g.semesterId\n"
            + "where g.studentId = ?1 and sem.semesterId= ?2 and gc.gradeCategoryName='Final Exam' and gc.gradeItemName='Total' ", nativeQuery = true)
    public List<Course> getCourseBySemester(String studentId, String semesterId);
}
