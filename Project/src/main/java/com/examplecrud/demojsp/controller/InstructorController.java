/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.gradeModel.Grade;
import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import com.examplecrud.demojsp.model.gradeModel.Instructor;
import com.examplecrud.demojsp.model.gradeModel.Semester;
import com.examplecrud.demojsp.model.gradeModel.Student;
import com.examplecrud.demojsp.modelkey.GradeKey;
import com.examplecrud.demojsp.repository.GradeCategoryRepository;
import com.examplecrud.demojsp.repository.GradeRepository;
import com.examplecrud.demojsp.repository.InstructorRepository;
import com.examplecrud.demojsp.repository.SemesterRepository;
import com.examplecrud.demojsp.repository.StudentRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kmd
 */
@Controller
@RequestMapping(path = "instructor")
public class InstructorController {

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    SemesterRepository semesterRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeCategoryRepository gradeCategoryRepository;
    
    @RequestMapping(path = "list", method = RequestMethod.GET)
    public String getAllInStructor(ModelMap modelMap) {
        Iterable<Instructor> instructors = instructorRepository.findAll();
        modelMap.addAttribute("instructors", instructors);
        return "instructorList";
    }
    
    @RequestMapping(path = "grade", method = RequestMethod.POST)
    public String getInstructorGroup(@RequestParam("studentId") List<String> studentId,
            @RequestParam("gradeValue") List<String> gradeValue,
            @RequestParam("gradeCategoryId") String gradeCategoryId,
            @RequestParam
            ModelMap modelMap) {

        Date date = Date.valueOf(LocalDate.now());
        Semester semester = semesterRepository.findByDate(date);
        for (int i = 0; i < studentId.size(); i++) {
            Grade grade = new Grade();
            GradeCategory gc = gradeCategoryRepository.getGradeCategory(gradeCategoryId);
            Student s =  studentRepository.getStudent(studentId.get(i));
            gc.setGradeCategoryId(Integer.parseInt(gradeCategoryId));
            s.setStudentId(studentId.get(i));
            grade.setGradeValue(Float.parseFloat(gradeValue.get(i)));
            grade.setGradeCategory(gc);
            grade.setId(new GradeKey(Integer.parseInt(gradeCategoryId), studentId.get(i), semester.getSemesterId()));
            grade.setSemester(semester);
            gradeRepository.save(grade);
        }
        return"gradeList";
    }
}
