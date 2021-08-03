package com.mallorcaWorks.controller;

import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Teacher;
import com.mallorcaWorks.service.CourseService;
import com.mallorcaWorks.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoursesController {
    @Autowired
    CourseService courseService;
    TeacherService teacherService;

    @GetMapping(path = { "/courses"})
    public String showListaCourses(ModelMap model){
        List<Course> courseList= courseService.getAll();
        model.addAttribute("courseList", courseList);
        return "courses";
    }
    /**
     *save tutto in add newCourse??
     */
    @RequestMapping(path = { "/addCourse"}, method = RequestMethod.GET)
    public String addNewCourse(ModelMap model){
        Course course = new Course();
        model.addAttribute("course", course);
        List<Teacher> teacherList = teacherService.getAll();
        model.addAttribute("teacherList", teacherList);
        return "addCourse";
    }

    @RequestMapping(path = { "/modifyCourse/{id}"})
    public String editLav(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("course", courseService.getById(id));
        return "redirect:/courses";
    }

    @RequestMapping(value = "/deleteCourse/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        courseService.delete(id);
        return "redirect:/courses";

    }
}
