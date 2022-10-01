package io.springboot.springbootoauth2v1.controller;

import io.springboot.springbootoauth2v1.entity.Student;
import io.springboot.springbootoauth2v1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public ResponseEntity<String> readGreeting(){
        return new ResponseEntity<String>("GET", HttpStatus.OK);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> saveGreeting(){
        return new ResponseEntity<String>("POST", HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Integer id){
        Student student=studentService.getStudentById(id);
        if(student==null)
            return ResponseEntity.ok().body(null) ;
        else
            return ResponseEntity.ok().body(student);
    }

    @PostMapping("/students/")
    public ResponseEntity<Student> saveStudent(@RequestBody Student std){
        Student student=studentService.saveStudent(std);
        return ResponseEntity.ok(student);
    }
}
