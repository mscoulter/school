package com.allstate.repositories;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by localadmin on 2/9/17.
 */
public interface ITeacherRepository extends CrudRepository<Teacher, Integer>{
    public List<Teacher> findByGender(Gender gender);
    public List<Teacher> findByAgeGreaterThan(int age);
    public Teacher findByName(String name);
}
