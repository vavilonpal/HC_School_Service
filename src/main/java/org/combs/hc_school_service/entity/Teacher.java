package org.combs.hc_school_service.entity;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "teachers", schema = "ms_school_sc")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    private String speciality;

    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classEntity;
}

