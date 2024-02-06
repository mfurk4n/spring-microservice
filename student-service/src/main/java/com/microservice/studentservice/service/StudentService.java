package com.microservice.studentservice.service;

import com.microservice.studentservice.client.SchoolServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final SchoolServiceClient schoolServiceClient;

    public HashMap<Integer, String> getStudents() {
        return new HashMap<>() {{
            put(1, "Furkan");
            put(2, "Zeynep");
            put(3, "Kemal");
        }};
    }

    public HashMap<String, HashMap<Integer, String>> setStudentsSchool(Integer studentNumber, Integer schoolNumber) {
        String studentName = getStudents().get(studentNumber);
        return new HashMap<>() {{
            put(studentName, schoolServiceClient.getSchoolById(schoolNumber).getBody());
        }};
    }
}
