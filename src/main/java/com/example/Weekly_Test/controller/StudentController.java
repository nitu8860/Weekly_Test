package com.example.Weekly_Test.controller;

import com.example.Weekly_Test.MailService;
import com.example.Weekly_Test.Student;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController {

    @Autowired
    private Student student;

    @Autowired
    private MailService mailService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(student);
    }

    @GetMapping("/sendmail")
    public String sendMail() throws MessagingException {
        String objectDetails = student.toString();
        mailService.sendEmail("Student Details", objectDetails);
        return "Email sent successfully!";
    }
}
