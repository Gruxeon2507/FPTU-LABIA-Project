/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import com.examplecrud.demojsp.model.authorizationModel.Account;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "studentId")
    private String studentId;
    @Column
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "curriculumId")
    Curriculum curriculum;

    @OneToMany(mappedBy = "student")
    List<Participate> participate;

    @OneToMany(mappedBy = "student")
    List<Grade> grade;

    @OneToOne
    @JoinColumn(name="username")
    private Account account;

    public Student() {
    }

    public Student(String studentId, String studentName, Curriculum curriculum, List<Participate> participate, List<Grade> grade, Account account) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.curriculum = curriculum;
        this.participate = participate;
        this.grade = grade;
        this.account = account;
    }
    

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Grade> getGrade() {
        return grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

    public List<Participate> getParticipate() {
        return participate;
    }

    public void setParticipate(List<Participate> participate) {
        this.participate = participate;
    }



    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Student(String defaultName, int par) {

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
