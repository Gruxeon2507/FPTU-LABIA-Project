/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examplecrud.demojsp.repository;

import com.examplecrud.demojsp.model.gradeModel.Group;
import java.util.List;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kmd
 */
@Embeddable
public interface GroupRepository extends CrudRepository<Group, Integer> {

    @Query(value = "select * from `group` g\n"
            + "inner join course c on c.courseId = g.courseId\n"
            + "where g.instructorId='sonnt5' ",nativeQuery = true)
    List<Group> findByInstructorId(String instructorId);

}
