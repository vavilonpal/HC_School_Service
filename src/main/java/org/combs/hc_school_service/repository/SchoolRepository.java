package org.combs.hc_school_service.repository;

import org.combs.hc_school_service.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {
}
