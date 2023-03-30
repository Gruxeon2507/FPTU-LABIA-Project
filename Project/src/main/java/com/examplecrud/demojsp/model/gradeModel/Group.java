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
@Table(name = "`Group`")
public class Group {

    @Id
    @Column(name = "groupId")
    private int groupId;

    @Column
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;
    
    @OneToMany(mappedBy = "group")
    List<Participate> participate;

    public List<Participate> getParticipate() {
        return participate;
    }

    public void setParticipate(List<Participate> participate) {
        this.participate = participate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
