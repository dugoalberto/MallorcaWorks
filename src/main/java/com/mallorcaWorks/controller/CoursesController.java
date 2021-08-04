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
        courseService.save(newCourse);
        return "redirect:/courses";
    }

    @GetMapping(path = "/courses/{id}/edit")
    public String editCourse(CourseForm courseForm, @PathVariable("id") int id, ModelMap model) {
        Course course = courseService.getById(id);
        courseForm.setBeginDate(course.getBeginDate());
        courseForm.setEndDate(course.getEndDate());
        courseForm.setLevel(course.getLevel());
        courseForm.setTeacher(course.getTeacher().getUsername());
        model.addAttribute("teachers", teacherService.getAll());
        return "editCourse";
    }

    @PostMapping(path = "/courses/{id}/store")
    public String storeCourse(@Valid CourseForm courseForm, @PathVariable("id") int id, BindingResult result) {
        if (result.hasErrors())
            return "editCourse";
        Course updatedCourse = courseService.getById(id);
        updatedCourse.setBeginDate(courseForm.getBeginDate());
        updatedCourse.setEndDate(courseForm.getEndDate());
        updatedCourse.setLevel(courseForm.getLevel());
        updatedCourse.setTeacher(teacherService.getByUsername(courseForm.getTeacher()));
        courseService.save(updatedCourse);
        return "redirect:/courses";
    }
    
    @GetMapping(value = "/course/{id}/delete")
    public String deleteStudent(@PathVariable("id") int id){
        courseService.delete(id);
        return "redirect:/courses";

    }
}
