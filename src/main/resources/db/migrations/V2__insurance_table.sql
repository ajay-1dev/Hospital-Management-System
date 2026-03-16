CREATE TABLE IF NOT EXISTS insurance (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    policy_number VARCHAR(50) NOT NULL,
    provider VARCHAR(100) NOT NULL,
    valid_until DATE NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    deleted_at DATETIME(6)
);


ALTER TABLE patients ADD COLUMN insurance_id BIGINT;

ALTER TABLE patients
ADD CONSTRAINT fk_insurance FOREIGN KEY (insurance_id) REFERENCES insurance(id);