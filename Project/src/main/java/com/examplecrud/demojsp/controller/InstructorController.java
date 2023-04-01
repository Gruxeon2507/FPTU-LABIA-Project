/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.authorizationModel.Account;
import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import com.examplecrud.demojsp.model.gradeModel.Group;
import com.examplecrud.demojsp.model.gradeModel.Instructor;
import com.examplecrud.demojsp.model.gradeModel.Student;
import com.examplecrud.demojsp.repository.GradeCategoryReposity;
import com.examplecrud.demojsp.repository.GroupRepository;
import com.examplecrud.demojsp.repository.InstructorRepository;
import com.examplecrud.demojsp.repository.StudentRepository;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GradeCategoryReposity gradeCategoryReposity;

    @RequestMapping(path = "list", method = RequestMethod.GET)
    public String getAllInStructor(ModelMap modelMap) {
        Iterable<Instructor> instructors = instructorRepository.findAll();
        modelMap.addAttribute("instructors", instructors);
        return "instructorList";
    }

    @RequestMapping(path = "insertGrade", method = RequestMethod.GET)
    public String viewInsertGrade(@RequestParam(value = "groupId", required = false) String groupId,
             @RequestParam(value = "courseId", required = false) String courseId,
             @RequestParam(value = "gradeCategoryId", required = false) String gradeCategoryId,
             ModelMap modelMap, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        List<Group> groups = groupRepository.findByInstructorId(account.getInstructor().getInstructorId());
        if (groupId == null) {
            groupId = groups.get(0).getGroupId() + "";
        }
//        List<Student> students = studentRepository.getStudentByGroup(account.getInstructor().getInstructorId(), Integer.parseInt(groupId));
        if (courseId == null) {
            courseId = groups.get(0).getCourse().getCourseId();
        }
        List<GradeCategory> gradeCategorys = gradeCategoryReposity.getGradecateByCourseId(courseId);
        if (gradeCategoryId == null) {
            gradeCategoryId =gradeCategorys.get(0).getGradeCategoryId()+"";
        }
        List<Student> students = studentRepository.getStudentByInAndGroupAndGc(account.getInstructor().getInstructorId(),
                Integer.parseInt(groupId),
                Integer.parseInt(gradeCategoryId));
        modelMap.addAttribute("gradeCategorys", gradeCategorys);
        modelMap.addAttribute("groups", groups);
        modelMap.addAttribute("students", students);
        return "insertGrade";
    }
}
