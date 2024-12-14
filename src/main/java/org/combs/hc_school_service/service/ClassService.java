package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.dto.CreateClassDTO;
import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository repository;
    public Optional<Class> findById(Long id){
        return repository.findById(id);
    }

    public Class saveClass(Class clazz){
        return repository.save(clazz);
    }

    public Class mapToClass(CreateClassDTO classDTO){
        return Class.builder()
                .name(classDTO.getName())
                .build();
    }

}
