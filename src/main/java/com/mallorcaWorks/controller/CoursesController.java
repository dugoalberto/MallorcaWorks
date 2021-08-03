package com.mallorcaWorks.controller;

import com.mallorcaWorks.dto.CourseForm;
import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Teacher;
import com.mallorcaWorks.service.CourseService;
import com.mallorcaWorks.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@Controller
public class CoursesController {
    
    private final CourseService courseService;
    private final TeacherService teacherService;

    @Autowired
    public CoursesController(CourseService cService, TeacherService tService) {
        courseService = cService;
        teacherService = tService;
    }

    @GetMapping(path = "/courses")
    public String showCourses(ModelMap model) {
        model.addAttribute("courseList", courseService.getAll());
        return "courses";
    }
    
    @GetMapping(path = "/courses/create")
    public String createCourse(CourseForm courseForm, ModelMap model){
        model.addAttribute("teachers", teacherService.getAll());
        return "createCourse";
    }

    @PostMapping(path = "/courses/store")
    public String storeCourse(@Valid CourseForm courseForm, BindingResult result) {
        if (result.hasErrors())
            return "createCourse";
        Course newCourse = new Course();
        newCourse.setBeginDate(courseForm.getBeginDate());
        newCourse.setEndDate(courseForm.getEndDate());
        newCourse.setLevel(courseForm.getLevel());
        newCourse.setTeacher(teacherService.getByUsername(courseForm.getTeacher()));
        return "redirect:/courses";
    }

    /* @RequestMapping(path = { "/modifyCourse/{id}"})
    public String editLav(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("course", courseService.getById(id));
        return "redirect:/courses";
    } */

    @RequestMapping(value = "/course/{id}/delete")
    public String deleteStudent(@PathVariable("id") int id){
        courseService.delete(id);
        return "redirect:/courses";

    }
}
