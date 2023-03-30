/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.gradeModel.Student;
import com.examplecrud.demojsp.repository.StudentRepository;
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
            
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String getAllStudent(ModelMap modelMap){

        Iterable<Student> students = studentRepository.findAll();
        
        modelMap.addAttribute("students",students);
        return "studentList";
    }
}
