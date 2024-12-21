package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Student;
import org.combs.hc_school_service.repository.StudentRepository;
import org.combs.hc_school_service.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Optional<Student> findById(Long id){
        return repository.findById(id);
    }

    public List<Student> findAllByClass(Class clazz){
        return repository.findAllByClass(clazz);
    }
    public List<Student> findAllBySchool(School school){
        return repository.findAllBySchool(school);
    }

    public void saveStudent(Student student){
        repository.save(student);

    }

    public Student mapRequestToStudent(StudentRequest request){
        return Student.builder()
                .phoneNumber(request.getPhoneNumber())
                .birthday(request.getBirthday())
                .clazz(request.getClazz())
                .school(request.getSchool())
                .build();
    }


}
