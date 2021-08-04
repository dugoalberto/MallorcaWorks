package com.mallorcaWorks.controller;

import com.mallorcaWorks.dto.StudentForm;
import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Student;
import com.mallorcaWorks.service.CourseService;
import com.mallorcaWorks.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class StudentsController {
    private final CourseService courseService;
    private final StudentService studentService;
    @Autowired
    public StudentsController(CourseService cService, StudentService sService){
        courseService = cService;
        studentService = sService;
    }

    @GetMapping(path = { "/student"})
    public String showListaStudents(ModelMap model){
        List<Student> studentList= studentService.getAll();
        model.addAttribute("studentList", studentList);
        return "student";
    }
    @GetMapping("student/{id}")
    public String showStudent(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.getById(id); //student has all the attributes filled in
        model.addAttribute("student", student);
        return "studentDetails";
    }

    @RequestMapping(path = { "/student/create"})
    public String createStudent(ModelMap model, StudentForm studentForm){
        model.addAttribute("student", studentService.getAll());
        return "createStudent";
    }
    /* 
    @PostMapping(path = { "/student/store"})
    public String storeStudent(@Valid StudentForm studentForm, BindingResult result){
        if (result.hasErrors())
            return "createStudent";
        Student newStudent = new Student();
        newStudent.setName(studentForm.getName());
        newStudent.setSurname(studentForm.getSurname());
        newStudent.setWeeks(studentForm.getWeeks());
        newStudent.setImage(studentForm.getImage());
        newStudent.setDateOfBirth(studentForm.getDateOfBirth());
        newStudent.setLanguageLevel(studentForm.getLanguageLevel());
        newStudent.setNationality(studentForm.getNationality());
        newStudent.setCourses((Collection<Course>) courseService.getById(studentForm.getCourse()));
        return "redirect:/students";
    }
    @GetMapping("student/{id}/edit")
    public String editStudent(@PathVariable Integer id, ModelMap model, StudentForm studentForm) {
        Student student = studentService.getById(id); //student has all the attributes filled in
        studentForm.setName(student.getName());
        studentForm.setSurname(student.getSurname());
        studentForm.setWeeks(student.getWeeks());
        studentForm.setDateOfBirth(student.getDateOfBirth());
        studentForm.setLanguageLevel(student.getLanguageLevel());
        studentForm.setNationality(student.getNationality());
        studentForm.setCourse();
        model.addAttribute("student", courseService.getAll());
        return "modifyStudent";
    }
    @RequestMapping(path = { "/modifyStudent/{id}"})
    public String editStudent(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("student", studentService.getById(id));
        return "modifyStudent";
    }

    @RequestMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/students";
    } */
}
