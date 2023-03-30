/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Student;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kmd
 */
public interface StudentRepository extends CrudRepository<Student,String>{
    
}
