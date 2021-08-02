package com.mallorcaWorks.controller;

import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Student;
import com.mallorcaWorks.service.CourseService;
import com.mallorcaWorks.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = { "/"})
    public String showListaStudents(ModelMap model){
        List<Student> studentList= studentService.getAll();
        model.addAttribute("studentList", studentList);
        return "students";
    }
    /**
     *save tutto in add newStudent??
     */
    @RequestMapping(path = { "/"}, method = RequestMethod.GET)
    public String addNewStudent(ModelMap model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "addStudent";
    }
    @RequestMapping(path = { "/"}, method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student")Student student){
        studentService.save(student);
        return "redirect:/students";
    }
    @RequestMapping(path = { "/modifyStudent/{id}"})
    public String editStudent(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("student", studentService.getById(id));
        return "redirect:/students";
    }

    @RequestMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/students";
    }
}
