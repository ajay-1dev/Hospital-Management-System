package com.example.Hospital_Management_System.schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "insurance")
@SQLDelete(sql = "UPDATE insurance SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class Insurance extends BaseEntity {

    @Column(name = "policy_number", nullable = false, length = 50)
    private String policyNumber;

    @Column(name = "provider", nullable = false, length = 100)
    private String provider;

    @Column(name = "valid_until", nullable = false)
    private LocalDate validUntil;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    //Inverse Side
    @OneToOne(mappedBy = "insurance")
    private Patient patient;


}
