package org.combs.hc_school_service.controller;


import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.Student;
import org.combs.hc_school_service.entity.Teacher;
import org.combs.hc_school_service.request.StudentRequest;
import org.combs.hc_school_service.service.ClassService;
import org.combs.hc_school_service.service.SchoolService;
import org.combs.hc_school_service.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final SchoolService schoolService;
    private final ClassService classService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getStudentsBySchoolId(@PathVariable Long  schoolId){
        return schoolService.findById(schoolId)
                .map(studentService::findAllBySchool)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @GetMapping("/class/{classId}")
    public ResponseEntity<List<Student>> getStudentsByClassId(@PathVariable Long  classId){
        return classService.findById(classId)
                .map(studentService::findAllByClass)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Validated @RequestBody StudentRequest request,
                                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Student student = studentService.mapRequestToStudent(request);
        studentService.saveStudent(student);
        return ResponseEntity.ok().body(student);
    }

}
