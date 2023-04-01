/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Grade;
import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import com.examplecrud.demojsp.model.gradeModel.Student;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kmd
 */
public interface StudentRepository extends CrudRepository<Student, String> {
    //Select s FROM Student s join s.grade g join g.semester sem join g.gradeCategory gc join gc.course c   where s.studentId = 'HE170996' and sem.semesterId = 'SP2023' and c.courseId = 'PRJ301'

    @Query(value = "SELECT DISTINCT s FROM Student s \n"
            + "JOIN s.grade g \n"
            + "JOIN g.semester sek \n"
            + "JOIN g.gradeCategory gc \n"
            + "JOIN gc.course c \n"
            + "JOIN g.semester sem \n"
            + "WHERE s.studentId = ?1 AND c.courseId= ?2 AND sem.semesterId = ?3")
    public List<Student> getStudentGrade(String studentId, String courseId, String semesterId);

    @Query(value = "select * from student s\n"
            + "inner join participate p on s.studentId = p.studentId\n"
            + "inner join `group` g on g.groupId = p.groupId\n"
            + "inner join instructor i on g.instructorId = i.instructorId\n"
            + "where i.instructorId= ?1 and g.groupId = ?2", nativeQuery = true)
    public List<Student> getStudentByGroup(String instructorId, int groupId);

    @Query(value = "select distinct * from student s\n"
            + "inner join participate p on s.studentId = p.studentId\n"
            + "inner join `group` g on g.groupId = p.groupId\n"
            + "inner join instructor i on g.instructorId = i.instructorId\n"
            + "left join grade gr on gr.studentId = s.studentId \n"
            + "where i.instructorId= ?1 and g.groupId = ?2 and gr.gradeCategoryId = ?3\n",nativeQuery = true)
    public List<Student> getStudentByInAndGroupAndGc(String instructorId,int groupId,int gradeCategoryId);

    @Query(value = "SELECT * FROM Student s WHERE s.studentId= ?1", nativeQuery = true)
    public Student getStudent(String studentId);
}
