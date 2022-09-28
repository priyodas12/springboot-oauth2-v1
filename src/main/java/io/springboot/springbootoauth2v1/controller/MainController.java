package io.springboot.springbootoauth2v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    public ResponseEntity<String> readGreeting(){
        return new ResponseEntity<String>("GET", HttpStatus.OK);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> saveGreeting(){
        return new ResponseEntity<String>("POST", HttpStatus.OK);
    }
}
