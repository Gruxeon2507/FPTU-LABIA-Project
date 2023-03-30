/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Instructor;
import javax.persistence.Embeddable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kmd
 */
@Embeddable
public interface InstructorRepository extends CrudRepository<Instructor, String>{
    
}
