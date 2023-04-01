/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus
 */
public interface GradeCategoryReposity extends CrudRepository<GradeCategory, Integer> {

    @Query(value = "SELECT * FROM gradecategory gc\n"
            + "where gc.gradeItemName != 'Total' and gc.courseId= ?1 ",nativeQuery = true)
    public List<GradeCategory> getGradecateByCourseId(String courseId);

}
