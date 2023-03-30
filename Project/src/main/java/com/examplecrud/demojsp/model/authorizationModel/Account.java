/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.authorizationModel;

import com.examplecrud.demojsp.model.gradeModel.Instructor;
import com.examplecrud.demojsp.model.gradeModel.Student;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kmd
 */
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "username")
    private String username;
    @Column
    private String password;

    @OneToOne(mappedBy = "account")
    Student student;

    @OneToOne(mappedBy = "account")
    Instructor instructor;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
