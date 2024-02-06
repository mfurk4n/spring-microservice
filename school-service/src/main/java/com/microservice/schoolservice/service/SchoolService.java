package com.microservice.schoolservice.service;

import com.microservice.schoolservice.exception.SchoolNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SchoolService {

    public HashMap<Integer, String> getSchoolById(Integer schoolId) {
        if (schoolId == 1)
            return new HashMap<>() {{
                put(1, "Furkan School");
            }};
        else
            throw new SchoolNotFoundException("SCHOOL SERVICE school could not found by id: " + schoolId);
    }
}
