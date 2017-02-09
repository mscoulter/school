package com.allstate;

import com.allstate.entities.Klass;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 2/9/17.
 */
@Service
public class KlassService {

    private IKlassRepository klassRepository;

    @Autowired
    public void setKlassRepository(IKlassRepository klassRepository){
        this.klassRepository = klassRepository;
    }
    public Klass findById(Integer id){
        return this.klassRepository.findOne(id);
    }

    public Klass findByName(String name){
        return this.klassRepository.findByName(name);
    }
}



