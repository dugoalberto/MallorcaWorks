DROP TABLE courses_students;

ALTER TABLE students ADD COLUMN course int REFERENCES courses(id) ON DELETE SET NULL ON UPDATE CASCADE;