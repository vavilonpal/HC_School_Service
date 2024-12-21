package org.combs.hc_school_service.service;

import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.repository.SchoolRepository;
import org.combs.hc_school_service.request.SchoolRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;

    public Optional<School> findById(Long id) {
        return repository.findById(id);
    }

    public void saveSchool(School school) {
        repository.save(school);
    }


    public boolean isSchoolExists(String schoolName, Integer houseNumber){
        return repository.existsBySchoolName(schoolName) || repository.existsByHouseNumber(houseNumber);
    }
    public School mapRequestToSchool(SchoolRequest request) {
        return School.builder()
                .schoolName(request.getSchoolName())
                .phoneNumber(request.getPhoneNumber())
                .street(request.getStreet())
                .houseNumber(request.getHouseNumber())
                .build();
    }
}
