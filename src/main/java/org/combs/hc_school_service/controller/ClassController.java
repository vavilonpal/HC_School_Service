package org.combs.hc_school_service.controller;


import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.dto.CreateClassDTO;
import org.combs.hc_school_service.entity.Class;
import org.combs.hc_school_service.service.ClassService;
import org.combs.hc_school_service.service.SchoolService;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;
    private final SchoolService schoolService;
    private final MessageSource messageSource;

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
        return classService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //todo to end
    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Class>> getClassesBySchoolId(@PathVariable Long schoolId){
        return schoolService.findById(schoolId)
                .map(classService::findALlBySchool)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createClass(@Validated @RequestBody CreateClassDTO classDTO,
                                         BindingResult bindingResult,
                                         UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(bindingResult.getAllErrors());
        } else {
            Class clazz = this.classService.mapToClass(classDTO);
            this.classService.saveClass(clazz);
            return ResponseEntity
                    .created(
                            uriComponentsBuilder
                                    .replacePath("/api/v1/class/{id}")
                                    .build(Map.of("classID", clazz.getId())))
                    .body(clazz);
        }
    }
}

