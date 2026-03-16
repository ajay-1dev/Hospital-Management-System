package com.example.Hospital_Management_System.schema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.Hospital_Management_System.schema.Enums.BloodGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
@SQLDelete(sql = "UPDATE patients SET deleted_at = CURRENT_TIMESTAMP WHERE ID = ?")
@SQLRestriction("deleted_at IS NULL")
public class Patient extends BaseEntity {

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;
    
    @NotNull
    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id") //Owning Side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments = new ArrayList<>();


}
