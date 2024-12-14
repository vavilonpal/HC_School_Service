package org.combs.hc_school_service.controller;


import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Student;
import org.combs.hc_school_service.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;


    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id){
        return schoolService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
