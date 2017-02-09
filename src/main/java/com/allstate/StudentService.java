package com.allstate;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private IStudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student create(String email){
        Student student = new Student(email);
        return this.studentRepository.save(student);
    }

    public Student findById(Integer id){
        return this.studentRepository.findOne(id);
    }

    public Student findByEmail(String email){
        return this.studentRepository.findByEmail(email);
    }


}
