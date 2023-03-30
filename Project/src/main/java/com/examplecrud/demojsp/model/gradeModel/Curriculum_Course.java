/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import com.examplecrud.demojsp.modelkey.Curriculum_CourseKey;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "Curriculum_Course")
public class Curriculum_Course {
    @EmbeddedId
    Curriculum_CourseKey id;
    
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name="courseId")
    Course course;
    
    @ManyToOne
    @MapsId("curriculumId")
    @JoinColumn(name="curriculumId")
    Curriculum curriculum;
    
    

    public Curriculum_CourseKey getId() {
        return id;
    }

    public void setId(Curriculum_CourseKey id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
    
    
}
