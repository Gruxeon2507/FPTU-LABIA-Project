/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import java.sql.Date;
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
@Table(name = "Semester")
public class Semester {

    @Id
    @Column(name = "semesterId")
    private String semesterId;

    @Column
    private String semesterName;
    private int year;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "semester")
    List<Grade> grade;

    public Semester() {
    }

    
    public Semester(String semesterId, String semesterName, int year, Date startDate, Date endDate, List<Grade> grade) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
    }

    
    public List<Grade> getGrade() {
        return grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
