/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.gradeModel.Course;
import com.examplecrud.demojsp.repository.CourseRepository;
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
@RequestMapping(path="course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    
    @RequestMapping(path="list", method = RequestMethod.GET)
    public String getAllCourse(ModelMap modelMap){
        Iterable<Course> courses = courseRepository.findAll();
        modelMap.addAttribute("courses",courses);
        return "courseList";
    }
}
