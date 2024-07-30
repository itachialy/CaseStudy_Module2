package CaseStudy_M2.service;

import CaseStudy_M2.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    void update(Student student);
    Student findById(int id);
    void delete(int id);
    List<Student> getStudentByName(String name);
}
