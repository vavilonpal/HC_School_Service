package org.combs.hc_school_service.controller;


import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.request.TeacherRequest;
import org.combs.hc_school_service.service.SchoolService;
import org.combs.hc_school_service.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final SchoolService schoolService;
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id){
        return teacherService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Teacher>> getTeachersBySchool(@PathVariable Long schoolId){
        Optional<School> school = schoolService.findById(schoolId);
        if (school.isPresent()){
            List<Teacher> teachers = teacherService.getTeachersBySchool(school.get());
            return ResponseEntity.ok(teachers);

        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@Validated @RequestBody TeacherRequest request,
                                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Teacher teacher = teacherService.mapRequestToTeacher(request);
        teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(teacher);
    }
}
