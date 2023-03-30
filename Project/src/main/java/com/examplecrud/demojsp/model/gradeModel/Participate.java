/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.model.gradeModel;

import com.examplecrud.demojsp.modelkey.ParticipateKey;
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
@Table(name = "Participate")
public class Participate {

    @EmbeddedId
    ParticipateKey id;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    Group group;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    Student student;

    public ParticipateKey getId() {
        return id;
    }

    public void setId(ParticipateKey id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    

}
