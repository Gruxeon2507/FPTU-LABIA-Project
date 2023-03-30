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
public class ParticipateKey implements Serializable{
    @Column(name = "groupId")
    int groupId;

    @Column(name = "studentId")
    String studentId;
    
}
