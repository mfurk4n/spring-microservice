package com.microservice.studentservice.controller;

import com.microservice.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;
    private final Environment environment;

    @GetMapping
    public ResponseEntity<HashMap<Integer, String>> getStudents() {
        logger.info("Service on port number " + environment.getProperty("local.server.port"));

        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/setschool")
    public ResponseEntity<HashMap<String, HashMap<Integer, String>>> setStudentsSchool(
            @RequestParam(value = "studentNumber") Integer studentNumber,
            @RequestParam(value = "schoolNumber") Integer schoolNumber
    ) {
        return ResponseEntity.ok(studentService.setStudentsSchool(studentNumber, schoolNumber));
    }

}
