package org.combs.hc_school_service.repository;

import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllBySchool(School school);
    List<Student> findAllByClass(Class clazz);
}
