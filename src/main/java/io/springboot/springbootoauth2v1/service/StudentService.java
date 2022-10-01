package io.springboot.springbootoauth2v1.service;

import io.springboot.springbootoauth2v1.entity.Student;
import io.springboot.springbootoauth2v1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Integer id) {
        Optional<Student> s=Optional.empty();
        try {
            s= Optional.of(studentRepository.getReferenceById(id));
        }catch(PersistenceException e){
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Service Student:: "+s.get().toString());
        return s.orElse(null);
    }

    public Student saveStudent(Student std) {
        Student student=studentRepository.save(std);
        return student;
    }
}
