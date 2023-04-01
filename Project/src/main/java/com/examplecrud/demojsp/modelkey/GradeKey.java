/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.modelkey;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kmd
 */
@Embeddable
public class GradeKey implements Serializable {

    @Column(name = "gradeCategoryId")
    int gradeCategoryId;

    @Column(name = "studentId")
    String studentId;

    @Column(name = "semesterId")
    String semesterId;

    public GradeKey() {
    }

    public GradeKey(int gradeCategoryId, String studentId, String semesterId) {
        this.gradeCategoryId = gradeCategoryId;
        this.studentId = studentId;
        this.semesterId = semesterId;
    }

}
