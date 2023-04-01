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

    @Query(value = "Select * from Curriculum cu\n"
            + "inner join Curriculum_Course  cc on cc.curriculumId = cu.curriculumId\n"
            + "inner join Course co on co.courseId = cc.courseId\n"
            + "inner join Student s on s.curriculumId = cu.curriculumId\n"
            + "left join `Group` gr on gr.courseId = co.courseId\n"
            + "left join GradeCategory gc on gc.courseId = co.courseId\n"
            + "left join Grade g on g.gradeCategoryId = gc.gradeCategoryId and g.studentId = s.studentId\n"
            + "left join Semester sem on sem.semesterId = g.semesterId\n"
            + "where s.studentId = ?1 ORDER BY sem.startDate ASC", nativeQuery = true)
    public List<Curriculum> getStudentCurriculumGrade(String studentId);
}
