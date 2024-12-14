package org.combs.hc_school_service.repository;

import org.combs.hc_school_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
