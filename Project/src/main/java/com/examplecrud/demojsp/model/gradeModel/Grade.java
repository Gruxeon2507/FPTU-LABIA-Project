/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import com.examplecrud.demojsp.modelkey.GradeKey;
import javax.persistence.Column;
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
@Table(name = "Grade")
public class Grade {
    @EmbeddedId
    GradeKey id;
    
    @Column()
    private float gradeValue;
    
    @ManyToOne
    @MapsId("gradeCategoryId")
    @JoinColumn(name="gradeCategoryId")
    GradeCategory gradeCategory;
    
    @ManyToOne
    @MapsId("semesterId")
    @JoinColumn(name="semesterId")
    Semester semester;
    
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name="studentId")
    Student student;

    public Grade() {
    }

    
    public Grade(GradeKey id, float gradeValue, GradeCategory gradeCategory, Semester semester, Student student) {
        this.id = id;
        this.gradeValue = gradeValue;
        this.gradeCategory = gradeCategory;
        this.semester = semester;
        this.student = student;
    }

    
    public GradeKey getId() {
        return id;
    }

    public void setId(GradeKey id) {
        this.id = id;
    }

    public float getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(float gradeValue) {
        this.gradeValue = gradeValue;
    }

    public GradeCategory getGradeCategory() {
        return gradeCategory;
    }

    public void setGradeCategory(GradeCategory gradeCategory) {
        this.gradeCategory = gradeCategory;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
