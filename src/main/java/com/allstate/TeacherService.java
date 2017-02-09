package com.allstate;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by localadmin on 2/9/17.
 */
@Service
public class TeacherService {
    private ITeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(ITeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher create(String name, Gender gender, int age){
        Teacher teacher = new Teacher(name, gender, age);
        return this.teacherRepository.save(teacher);
    }

    public Teacher findById(Integer id){
        return this.teacherRepository.findOne(id);
    }

    public List<Teacher> findByGender(Gender gender){
        return this.teacherRepository.findByGender(gender);
    }

    public Teacher findByName(String name){
        return this.teacherRepository.findByName(name);
    }

    public List<Teacher> findByAgeGreaterThan(int age) {
        return  this.teacherRepository.findByAgeGreaterThan(age);
    }
}
