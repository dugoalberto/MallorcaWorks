package com.mallorcaWorks.controller;

import com.mallorcaWorks.model.Student;
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

    @GetMapping(path = { "/students"})
    public String showListaStudents(ModelMap model){
        List<Student> studentList= studentService.getAll();
        model.addAttribute("studentList", studentList);
        return "students";
    }
    @GetMapping("students/{id}")
    public String showStudent(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.getById(id); //student has all the attributes filled in
        model.addAttribute("student", student);
        return "studentDetails";
    }
    @GetMapping("students/{id}/edit")
    public String getEditStudentPage(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.getById(id); //student has all the attributes filled in
        model.addAttribute("student", student);
        return "modifyStudent";
    }

    @RequestMapping(path = { "/addStudents"}, method = RequestMethod.GET)
    public String createStudent(ModelMap model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "addStudents";
    }
    @RequestMapping(path = { "/addStudents"}, method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student")Student student){
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
