CREATE TABLE departments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    head_doctor_id BIGINT NOT NULL,
    deleted_at DATETIME(6),
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,

    CONSTRAINT fk_department_head_doctor
    FOREIGN KEY (head_doctor_id) REFERENCES doctors(id)
);