package org.combs.hc_school_service.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "lasses", schema = "ms_school_sc")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_number", nullable = false)
    private Integer classNumber;

    @Column(name = "class_letter", nullable = false, length = 1)
    private String classLetter;

    @Column(name = "number_of_students")
    private Integer numberOfStudents;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Teacher> teachers;
}
