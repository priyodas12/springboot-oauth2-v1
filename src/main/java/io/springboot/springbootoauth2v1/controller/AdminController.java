package io.springboot.springbootoauth2v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/v1")
public class AdminController {

    @GetMapping("/greet/admin")
    public ResponseEntity<String> getResponse(@PathVariable("name") String name){
        return new ResponseEntity<String>("Hi ,"+name.toUpperCase(), HttpStatus.OK);
    }
}