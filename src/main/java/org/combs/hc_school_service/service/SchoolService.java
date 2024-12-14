package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    public Optional<School> findById(Long id){
        return repository.findById(id);
    }
}
