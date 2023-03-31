/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name="Curriculum")
public class Curriculum {

    @Id
    @Column
    private String curriculumId;

    @Column
    private String curriculumName;

    @OneToMany(mappedBy = "curriculum")
    List<Curriculum_Course> curriculum_Courses;

    @OneToMany(mappedBy = "curriculum")
    List<Student> student;

    public Curriculum() {
    }

    
    public Curriculum(String curriculumId, String curriculumName, List<Curriculum_Course> curriculum_Courses, List<Student> student) {
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.curriculum_Courses = curriculum_Courses;
        this.student = student;
    }

    
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }



    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public List<Curriculum_Course> getCurriculum_Courses() {
        return curriculum_Courses;
    }

    public void setCurriculum_Courses(List<Curriculum_Course> curriculum_Courses) {
        this.curriculum_Courses = curriculum_Courses;
    }

}
