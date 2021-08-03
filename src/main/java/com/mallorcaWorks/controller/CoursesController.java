package com.mallorcaWorks.controller;

import com.mallorcaWorks.dto.CourseForm;
import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Teacher;
import com.mallorcaWorks.service.CourseService;
import com.mallorcaWorks.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public String showCourses(ModelMap model){
        model.addAttribute("courses", courseService.getAll());
        return "courses";
    }
    /**
     *save tutto in add newCourse??
     */
    @GetMapping(path = "/courses/create")
    public String createCourse(CourseForm courseForm, ModelMap model) {
        model.addAttribute("teachers", teacherService.getAll());
        return "createCourse";
    }

    @PostMapping(path = "/courses/store")
    public String storeCourse(@Valid CourseForm courseForm, BindingResult result) {
        if (result.hasErrors())
            return "createCourse";
        Course newCourse = new Course();
        newCourse.setLevel(courseForm.getLevel());
        newCourse.setBeginDate(courseForm.getBeginDate());
        newCourse.setEndDate(courseForm.getEndDate());
        newCourse.setTeacher(teacherService.getByUsername(courseForm.getTeacher()));
        courseService.save(newCourse);
        return "redirect:/courses";
    }

    /* @RequestMapping(path = { "/modifyCourse/{id}"})
    public String editLav(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("course", courseService.getById(id));
        return "redirect:/courses";
    } */



    @RequestMapping(value = "/courses/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        courseService.delete(id);
        return "redirect:/courses";

    }
}
