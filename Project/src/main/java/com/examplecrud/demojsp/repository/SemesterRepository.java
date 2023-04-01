/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Semester;
import java.sql.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author kmd
 */
public interface SemesterRepository extends CrudRepository<Semester, String>{
    @Query(value = "Select * from Semester s where ?1 between s.startDate and s.endDate",nativeQuery = true)
    public Semester findByDate(Date currentDate);
}
