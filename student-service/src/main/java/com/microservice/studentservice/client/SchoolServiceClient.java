package com.microservice.studentservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@FeignClient(name = "school-service", path = "/v1/school")
public interface SchoolServiceClient {
    Logger logger = LoggerFactory.getLogger(SchoolServiceClient.class);

    @GetMapping("/{schoolId}")
    @CircuitBreaker(name = "getSchooldByIdCircuitBreaker", fallbackMethod = "getSchoolFallback")
    ResponseEntity<HashMap<Integer, String>> getSchoolById(@PathVariable(value = "schoolId") Integer schoolId);

    default ResponseEntity<HashMap<Integer, String>> getSchoolFallback(Integer schoolId, Exception exception) {
        logger.info("School not found by id " + schoolId);
        return ResponseEntity.ok(new HashMap<>() {{
            put(schoolId, "FallBack Shcool");
        }});
    }
}
