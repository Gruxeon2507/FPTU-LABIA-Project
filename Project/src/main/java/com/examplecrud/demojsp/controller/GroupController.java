/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.gradeModel.Course;
import com.examplecrud.demojsp.model.gradeModel.Group;
import com.examplecrud.demojsp.repository.CourseRepository;
import com.examplecrud.demojsp.repository.GroupRepository;
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
@RequestMapping(path="group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    
    @RequestMapping(path="list", method = RequestMethod.GET)
    public String getAllGroup(ModelMap modelMap){
        Iterable<Group> groups = groupRepository.findAll();
        modelMap.addAttribute("groups",groups);
        return "groupList";
    }
}
