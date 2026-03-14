CREATE TABLE IF NOT EXISTS patients(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    blood_group VARCHAR(255) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6),
    deleted_at DATETIME(6)
);