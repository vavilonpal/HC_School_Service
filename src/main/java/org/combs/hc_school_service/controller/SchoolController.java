package org.combs.hc_school_service.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.combs.hc_school_service.entity.School;
import org.combs.hc_school_service.entity.Student;
import org.combs.hc_school_service.request.SchoolRequest;
import org.combs.hc_school_service.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<?> createSchool(@Validated @RequestBody SchoolRequest request,
                                          BindingResult bindingResult){
        if (bindingResult.hasErrors()){
             return  ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (schoolService.isSchoolExists(request.getSchoolName(), request.getHouseNumber())){
            return ResponseEntity.badRequest().body("Школа с данным именем уже существует");
        }
        School school = schoolService.mapRequestToSchool(request);

        schoolService.saveSchool(school);
        return ResponseEntity.ok(school);
    }

}
