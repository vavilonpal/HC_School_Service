package org.combs.hc_school_service.repository;

import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    List<Teacher> getTeachersBySchool(School school);
}
