/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.gradeModel.Group;
import com.examplecrud.demojsp.model.gradeModel.Instructor;
import com.examplecrud.demojsp.repository.GroupRepository;
import com.examplecrud.demojsp.repository.InstructorRepository;
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
@RequestMapping(path="instructor")
public class InstructorController {
    @Autowired
    InstructorRepository instructorRepository;
    
    @RequestMapping(path="list", method = RequestMethod.GET)
    public String getAllInStructor(ModelMap modelMap){
        Iterable<Instructor> instructors = instructorRepository.findAll();
        modelMap.addAttribute("instructors",instructors);
        return "instructorList";
    }
}
