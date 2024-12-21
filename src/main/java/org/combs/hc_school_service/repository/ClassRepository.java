package org.combs.hc_school_service.repository;

import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class,Long> {
    List<Class> findAllBySchool(School school);
}
