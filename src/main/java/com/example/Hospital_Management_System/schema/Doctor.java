package com.example.Hospital_Management_System.schema;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctor extends BaseEntity{
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

//    @Column(name = "deleted_at")
//    private LocalDateTime deletedAt;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "doctors")
//    @Builder.Default
//    private Set<Department> departments = new HashSet<>();
}
