/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Grade;
import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import com.examplecrud.demojsp.modelkey.GradeKey;
import java.util.List;
import javax.persistence.Embeddable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kmd
 */
@Embeddable
public interface GradeRepository extends CrudRepository<Grade, GradeKey> {

    @Query(value = "Select * FROM Grade g \n"
            + "	inner join GradeCategory gc on g.gradeCategoryId=gc.gradeCategoryId\n"
            + "	inner join Course c on c.courseId=gc.courseId\n"
            + "	inner join Student s on s.studentId=g.studentId\n"
            + "	inner join Semester sem on sem.semesterId=g.semesterId\n"
            + "	where s.studentId = ?1 and sem.semesterId= ?2 and c.courseId= ?3", nativeQuery = true)
    public List<Grade> getStudentGrade(String studentId, String semesterId, String courseId);

    @Query(value = "select * from grade g\n"
            + "right join student s on s.studentId = g.studentId\n"
            + "inner join participate p on p.studentId = s.studentId\n"
            + "inner join `group` gr on gr.groupId = p.groupId\n"
            + "inner join instructor i on i.instructorId = gr.instructorId\n"
            + "where i.instructorId='sonnt5' and gr.groupId = 15 and g.gradeCategoryId = 223 ", nativeQuery = true)
    public List<Grade> getStudentGradeByInstructor(String instructorId, int groupId, int gradeCategoryId);

}
