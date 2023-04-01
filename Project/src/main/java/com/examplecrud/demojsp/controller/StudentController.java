/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.authorizationModel.Account;
import com.examplecrud.demojsp.model.gradeModel.Curriculum;
import com.examplecrud.demojsp.model.gradeModel.Grade;
import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import com.examplecrud.demojsp.model.gradeModel.Student;
import com.examplecrud.demojsp.repository.CurriculumReposity;
import com.examplecrud.demojsp.repository.GradeRepository;
import com.examplecrud.demojsp.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmd
 */
@Controller
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;
    
    @Autowired
    private CurriculumReposity curriculumReposity;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getAllStudent(ModelMap modelMap) {

        Iterable<Student> students = studentRepository.findAll();

        modelMap.addAttribute("students", students);
        return "studentList";
    }

//    @RequestMapping(value = "gradeReport", method = RequestMethod.GET)
//    public String getGrade(ModelMap modelMap) {
//
////        Optional<Student> students = studentRepository.findById("HE170996");
////        Student student = students.orElse(new Student("defaultName", 0));
////        modelMap.addAttribute("students", student);
//        List<Student> students = studentRepository.getStudentGrade("HE170996","PRJ301","SP2023");
//        modelMap.addAttribute("students", students);
//        return "studentList";
//    }
    @RequestMapping(value = "gradeReport", method = RequestMethod.GET)
    public String getGrade1(ModelMap modelMap,HttpSession session) {

//        Optional<Student> students = studentRepository.findById("HE170996");
//        Student student = students.orElse(new Student("defaultName", 0));
//        modelMap.addAttribute("students", student);
    
        List<Grade> grades = gradeRepository.getStudentGrade("HE170996","SP2023","PRJ301");
        modelMap.addAttribute("grades", grades);
        return "gradeList";
    }
    
    @RequestMapping(value="curriculumReport", method = RequestMethod.GET)
    public String getCurriculum(ModelMap modelMap){
        List<Curriculum> curriculums = curriculumReposity.getStudentCurriculumGrade("HE170907");
        modelMap.addAttribute("curriculums",curriculums);
        return "studentCurriculum";
        
    }
}
