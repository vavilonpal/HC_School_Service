CREATE SCHEMA IF NOT EXISTS ms_school_sc;

-- Таблица для школ
CREATE TABLE IF NOT EXISTS ms_school_sc.schools (
                                                    id SERIAL PRIMARY KEY,
                                                    statistic_id int,
                                                    school_name VARCHAR(255) NOT NULL,
                                                    phone_number VARCHAR(20),
                                                    street VARCHAR(255),
                                                    house_number INT,
                                                    teachers_quantity INT,
                                                    students_quantity INT
);

-- Таблица для классов
CREATE TABLE IF NOT EXISTS ms_school_sc.classes (
                                                    id SERIAL PRIMARY KEY,
                                                    school_id INT,
                                                    class_name VARCHAR(15) NOT NULL,
                                                    students_quantity INT,
                                                    CONSTRAINT fk_school FOREIGN KEY (school_id) REFERENCES ms_school_sc.schools(id)
);

-- Таблица для учителей
CREATE TABLE IF NOT EXISTS ms_school_sc.teachers (
                                                     id SERIAL PRIMARY KEY,
                                                     phone_number VARCHAR(20),
                                                     speciality VARCHAR(255),
                                                     birthday DATE
);

-- Таблица для учеников
CREATE TABLE IF NOT EXISTS ms_school_sc.students (
                                                     id SERIAL PRIMARY KEY,
                                                     phone_number VARCHAR(20),
                                                     birthday DATE,
                                                     school_id INT,
                                                     class_id INT,
                                                     FOREIGN KEY (school_id) REFERENCES ms_school_sc.schools(id),
                                                     FOREIGN KEY (class_id) REFERENCES ms_school_sc.classes(id)
);
CREATE TABLE IF NOT EXISTS ms_school_sc.teacher_class(
    id int generated always as identity primary key,
    teacher_id int not null,
    school_id int not null,
    CONSTRAINT fk_student FOREIGN KEY (teacher_id) REFERENCES ms_school_sc.teachers(id) ON DELETE CASCADE,
    CONSTRAINT fk_school FOREIGN KEY (school_id) REFERENCES ms_school_sc.schools(id) ON DELETE CASCADE
);
