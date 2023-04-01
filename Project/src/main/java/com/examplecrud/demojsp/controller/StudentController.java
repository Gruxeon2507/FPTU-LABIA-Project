/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examplecrud.demojsp.controller;

import com.examplecrud.demojsp.model.authorizationModel.Account;
import com.examplecrud.demojsp.model.gradeModel.Course;
import com.examplecrud.demojsp.model.gradeModel.Curriculum;
import com.examplecrud.demojsp.model.gradeModel.Grade;
import com.examplecrud.demojsp.model.gradeModel.GradeCategory;
import com.examplecrud.demojsp.model.gradeModel.Semester;
import com.examplecrud.demojsp.model.gradeModel.Student;
import com.examplecrud.demojsp.repository.CourseRepository;
import com.examplecrud.demojsp.repository.CurriculumReposity;
import com.examplecrud.demojsp.repository.GradeRepository;
import com.examplecrud.demojsp.repository.SemesterRepository;
import com.examplecrud.demojsp.repository.StudentRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private CurriculumReposity curriculumReposity;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private CourseRepository courseRepository;

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
    public String getGrade1(@RequestParam(value = "semesterId", required = false) String semesterId, @RequestParam(value = "courseId", required = false) String courseId, ModelMap modelMap, HttpSession session) {

//        Optional<Student> students = studentRepository.findById("HE170996");
//        Student student = students.orElse(new Student("defaultName", 0));
//        modelMap.addAttribute("students", student);
        Account account = (Account) session.getAttribute("account");
        Iterable<Semester> semesters = semesterRepository.findAll();
        if (semesterId == null) {
            semesterId = "SP2023";
        }
        if (courseId == null) {
            courseId = "PRJ301";
        }
        if (account == null) {
            return "../authorization/login";
        }
        List<Course> courses = courseRepository.getCourseBySemester(account.getStudent().getStudentId(), semesterId);
        List<Grade> grades = gradeRepository.getStudentGrade(account.getStudent().getStudentId(), semesterId, courseId);
        modelMap.addAttribute("courses", courses);
        modelMap.addAttribute("grades", grades);
        modelMap.addAttribute("semesters", semesters);
        return "gradeList";
    }

    @RequestMapping(value = "curriculumReport", method = RequestMethod.GET)
    public String getCurriculum(ModelMap modelMap, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return "../authorization/login";
        }
        List<Curriculum> curriculums = curriculumReposity.getStudentCurriculumGrade(account.getStudent().getStudentId());
        modelMap.addAttribute("curriculums", curriculums);
        return "studentCurriculum";

    }
}
