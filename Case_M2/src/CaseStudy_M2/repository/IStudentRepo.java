package CaseStudy_M2.repository;

import CaseStudy_M2.model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> findAll();

    void save(Student student);
    void update(Student student);
    Student findById(int id);
    void delete(int id);
    List<Student> getStudentByName(String name);
}
