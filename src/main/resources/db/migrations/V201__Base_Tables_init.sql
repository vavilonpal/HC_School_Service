CREATE SCHEMA IF NOT EXISTS ms_school_sc;
-- Таблица для учителей
CREATE TABLE IF NOT EXISTS ms_school_sc.teachers    (
                          id SERIAL PRIMARY KEY,
                          phone_number VARCHAR(20),
                          speciality VARCHAR(255),
                          birthday DATE,
                          school_id INT,
                          class_id INT,
                          FOREIGN KEY (school_id) REFERENCES schools(id),
                          FOREIGN KEY (class_id) REFERENCES classes(id)
);

-- Таблица для учеников
CREATE TABLE IF NOT EXISTS ms_school_sc.students (
                          id SERIAL PRIMARY KEY,
                          phone_number VARCHAR(20),
                          birthday DATE,
                          school_id INT,
                          class_id INT,
                          FOREIGN KEY (school_id) REFERENCES schools(id),
                          FOREIGN KEY (class_id) REFERENCES classes(id)
);

-- Таблица для классов
CREATE TABLE IF NOT EXISTS ms_school_sc.lasses (
                         id SERIAL PRIMARY KEY,
                         class_number INT NOT NULL,
                         class_letter CHAR(1) NOT NULL,
                         number_of_students INT
);

-- Таблица для школ
CREATE TABLE IF NOT EXISTS ms_school_sc.schools (
                         id SERIAL PRIMARY KEY,
                         school_name VARCHAR(255) NOT NULL,
                         phone_number VARCHAR(20),
                         street VARCHAR(255),
                         house_number INT,
                         teachers_quantity INT,
                         students_quantity INT,
);
