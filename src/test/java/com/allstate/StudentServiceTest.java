package com.allstate;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value={"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewStudent() throws Exception {
        Student student = this.studentService.create("bob@example.com");
        Student student2 = this.studentService.create("bob2@example.com");
        assertEquals(5, student.getId());
        assertEquals("bob2@example.com",student2.getEmail());
    }

    @Test
    public void shouldFindStudentByID() throws Exception{
        Student student = this.studentService.findById(3);
        assertEquals(3, student.getId());
        assertEquals("ccc@example.com", student.getEmail());
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception{
        Student student = this.studentService.findByEmail("ccc@example.com");
        assertEquals(3, student.getId());
        assertEquals("ccc@example.com", student.getEmail());
    }}