package com.iffat.springchadmvc.controller;

import com.iffat.springchadmvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        return "student-confirmation";
    }
}
