/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "`GradeCategory`")
public class GradeCategory {

    @Id
    @Column(name = "gradeCategoryId")
    private int gradeCategoryId;

    @Column
    private String gradeCategoryName;
    private String gradeItemName;
    private float weight;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;

    @OneToMany(mappedBy = "gradeCategory")
    List<Grade> grade;

    public GradeCategory() {
    }

    
    public GradeCategory(int gradeCategoryId, String gradeCategoryName, String gradeItemName, float weight, Course course, List<Grade> grade) {
        this.gradeCategoryId = gradeCategoryId;
        this.gradeCategoryName = gradeCategoryName;
        this.gradeItemName = gradeItemName;
        this.weight = weight;
        this.course = course;
        this.grade = grade;
    }

    
    public List<Grade> getGrade() {
        return grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

    public int getGradeCategoryId() {
        return gradeCategoryId;
    }

    public void setGradeCategoryId(int gradeCategoryId) {
        this.gradeCategoryId = gradeCategoryId;
    }

    public String getGradeCategoryName() {
        return gradeCategoryName;
    }

    public void setGradeCategoryName(String gradeCategoryName) {
        this.gradeCategoryName = gradeCategoryName;
    }

    public String getGradeItemName() {
        return gradeItemName;
    }

    public void setGradeItemName(String gradeItemName) {
        this.gradeItemName = gradeItemName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
