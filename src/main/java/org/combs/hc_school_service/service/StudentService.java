package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.Student;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.repository.SchoolRepository;
import org.combs.hc_school_service.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Optional<Student> findById(Long id){
        return repository.findById(id);
    }
}
