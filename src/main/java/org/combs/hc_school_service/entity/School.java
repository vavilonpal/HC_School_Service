package org.combs.hc_school_service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "schools", schema = "ms_school_sc")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    private String street;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "teachers_quantity")
    private Integer teachersQuantity;

    @Column(name = "students_quantity")
    private Integer studentsQuantity;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Class> classes;
}

