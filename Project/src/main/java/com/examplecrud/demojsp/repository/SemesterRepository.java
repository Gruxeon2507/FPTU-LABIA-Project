/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Semester;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus
 */
public interface SemesterRepository extends CrudRepository<Semester, String>{
    
}
