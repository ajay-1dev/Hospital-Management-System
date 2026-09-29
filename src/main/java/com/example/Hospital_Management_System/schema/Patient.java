package com.example.Hospital_Management_System.schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.engine.internal.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.Hospital_Management_System.schema.Enums.BloodGroup;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient extends BaseEntity {


    @Column(nullable = false)
    private String name;
    

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;


    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

//    @Column(name = "deleted_at")
//    private LocalDateTime deletedAt;

    
    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "insurance_id") //Owning Side
    private Insurance insurance;

//    @JsonIgnore
//    @OneToMany(mappedBy = "patient",orphanRemoval = true, cascade = CascadeType.REMOVE)
//    @Builder.Default
//    private List<Appointment> appointments = new ArrayList<>();


}
