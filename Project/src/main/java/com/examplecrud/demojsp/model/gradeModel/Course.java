/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "Course")
public class Course {
    @Id
    @Column(name="courseId")
    private String courseId;
    
    @Column
    private String courseName;
    
    @OneToMany(mappedBy = "course")
    List<Curriculum_Course> curriculum_Courses;

    @OneToMany(mappedBy = "course")
    List<Group> group;
    
    @OneToMany(mappedBy = "course")
    List<GradeCategory> gradeCategory;

    public List<GradeCategory> getGradeCategory() {
        return gradeCategory;
    }

    public void setGradeCategory(List<GradeCategory> gradeCategory) {
        this.gradeCategory = gradeCategory;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Curriculum_Course> getCurriculum_Courses() {
        return curriculum_Courses;
    }

    public void setCurriculum_Courses(List<Curriculum_Course> curriculum_Courses) {
        this.curriculum_Courses = curriculum_Courses;
    }
    
    
}
