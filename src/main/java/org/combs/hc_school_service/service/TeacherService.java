package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.repository.SchoolRepository;
import org.combs.hc_school_service.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;
}
