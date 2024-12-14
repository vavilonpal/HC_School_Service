package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.repository.SchoolRepository;
import org.combs.hc_school_service.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;

    public Optional<Teacher> findById(Long id){
        return repository.findById(id);
    }
}
