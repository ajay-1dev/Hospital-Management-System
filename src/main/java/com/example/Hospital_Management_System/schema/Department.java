package com.example.Hospital_Management_System.schema;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department extends BaseEntity {
    
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_doctor_id", nullable = false)
    private Doctor headDoctor;

//    @Column(name = "deleted_at")
//    private LocalDateTime deletedAt;

    @ManyToMany
    @JoinTable(
        name = "department_doctors",
        joinColumns = @JoinColumn(name = "department_id"),
        inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    @Builder.Default
    private Set<Doctor> doctors = new HashSet<>();

}
