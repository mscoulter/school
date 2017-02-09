package com.allstate;

import com.allstate.entities.Klass;
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

public class KlassServiceTest {

    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception{

    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void shouldFindClassByID() throws Exception{
        Klass klass = this.klassService.findById(2);
        assertEquals(2, klass.getId());
        assertEquals("Electrical Engineering 101", klass.getName());
    }

    @Test
    public void shouldFindClassByName() throws Exception{
        Klass klass= this.klassService.findByName("Electrical Engineering 101");
        assertEquals(2,klass.getId());
    }
}
