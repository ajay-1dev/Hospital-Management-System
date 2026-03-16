-- V3__create_department_doctors_table.sql
CREATE TABLE department_doctors (
    department_id BIGINT NOT NULL,
    doctor_id BIGINT NOT NULL,
    PRIMARY KEY (department_id, doctor_id),
    CONSTRAINT fk_dep_doc_department FOREIGN KEY (department_id) REFERENCES departments(id),
    CONSTRAINT fk_dep_doc_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);