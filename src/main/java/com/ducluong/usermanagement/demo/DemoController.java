package com.ducluong.usermanagement.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("welcome");
    }
}
