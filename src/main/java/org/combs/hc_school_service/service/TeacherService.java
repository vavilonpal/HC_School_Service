package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.repository.SchoolRepository;
import org.combs.hc_school_service.repository.TeacherRepository;
import org.combs.hc_school_service.request.TeacherRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;

    public Optional<Teacher> findById(Long id){
        return repository.findById(id);
    }

    public List<Teacher> getTeachersBySchool(School school){
        return repository.getTeachersBySchool(school);
    }

    public void saveTeacher(Teacher teacher){
        repository.save(teacher);
    }

    public Teacher mapRequestToTeacher(TeacherRequest request){
        return Teacher.builder()
                .phoneNumber(request.getPhoneNumber())
                .speciality(request.getSpeciality())
                .birthday(request.getBirthday())
                .build();
    }
}
