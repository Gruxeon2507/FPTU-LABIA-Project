/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.authorizationModel;

import com.examplecrud.demojsp.model.gradeModel.Curriculum_Course;
import com.examplecrud.demojsp.model.gradeModel.Instructor;
import com.examplecrud.demojsp.model.gradeModel.Student;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "account")
    List<Account_Role> account_Role;

    public Account() {
    }

    public Account(String username, String password, Student student, Instructor instructor, List<Account_Role> account_Role) {
        this.username = username;
        this.password = password;
        this.student = student;
        this.instructor = instructor;
        this.account_Role = account_Role;
    }
    
    public List<Account_Role> getAccount_Role() {
        return account_Role;
    }
    
    public void setAccount_Role(List<Account_Role> account_Role) {
        this.account_Role = account_Role;
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

}
