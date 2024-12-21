package org.combs.hc_school_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private int houseNumber;

    @Column(name = "teachers_quantity")
    private int teachersQuantity;

    @Column(name = "students_quantity")
    private int studentsQuantity;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL   )
    private List<Class> classes;
}

