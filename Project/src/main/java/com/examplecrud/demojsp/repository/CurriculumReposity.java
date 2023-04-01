/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Curriculum;
import com.examplecrud.demojsp.model.gradeModel.Grade;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus
 */
public interface CurriculumReposity extends CrudRepository<Curriculum, String> {

    @Query(value = "Select * from curriculum cu\n"
            + "inner join curriculum_course  cc on cc.curriculumId = cu.curriculumId\n"
            + "inner join course co on co.courseId = cc.courseId\n"
            + "inner join student s on s.curriculumId = cu.curriculumId\n"
            + "left join `group` gr on gr.courseId = co.courseId\n"
            + "left join gradecategory gc on gc.courseId = co.courseId\n"
            + "left join grade g on g.gradeCategoryId = gc.gradeCategoryId and g.studentId = s.studentId\n"
            + "left join semester sem on sem.semesterId = g.semesterId\n"
            + "where s.studentId = ?1 ", nativeQuery = true)
    public List<Curriculum> getStudentCurriculumGrade(String studentId);
}
