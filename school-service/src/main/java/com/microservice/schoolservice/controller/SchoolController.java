package com.microservice.schoolservice.controller;

import com.microservice.schoolservice.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    Logger logger = LoggerFactory.getLogger(SchoolController.class);

    private final SchoolService schoolService;

    @GetMapping("/{schoolId}")
    public ResponseEntity<HashMap<Integer,String>> getSchoolById(@PathVariable Integer schoolId){
        logger.info("schoolId: " + schoolId);
        return ResponseEntity.ok(schoolService.getSchoolById(schoolId));
    }
}
