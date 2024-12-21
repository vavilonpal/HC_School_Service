package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.dto.CreateClassDTO;
import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository repository;
    public Optional<Class> findById(Long id){
        return repository.findById(id);
    }

    public void saveClass(Class clazz){
        repository.save(clazz);
    }


    public List<Class> findALlBySchool(School school){
        return repository.findAllBySchool(school);
    }




    public Class mapToClass(CreateClassDTO classDTO){
        return Class.builder()
                .name(classDTO.getName())
                .build();
    }

}
