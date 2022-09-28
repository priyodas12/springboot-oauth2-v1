package io.springboot.springbootoauth2v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/v1")
public class BaseController {

    @GetMapping("/base/{name}")
    public ResponseEntity<String> getResponse(){
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
