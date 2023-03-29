package com.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {

    @GetMapping("/getData")
    public Map<String, Object> getData(@RequestParam String email, @RequestParam String password) {
        try {
            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_400);
            }
            return new HashMap<>();
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessages.ERROR_500);
        }
    }

    @PostMapping("/postData")
    public Map<String, Object> postData(@RequestParam String email, @RequestParam String password) {
        try {
            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_400);
            }
            return new HashMap<>();
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessages.ERROR_500);
        }
    }
}
