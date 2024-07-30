package CaseStudy_M2.service;

import CaseStudy_M2.model.Student;
import CaseStudy_M2.repository.IStudentRepo;
import CaseStudy_M2.repository.StudentRepoImpl;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    public final IStudentRepo iStudentRepo = new StudentRepoImpl();
    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public void update(Student student) {

        iStudentRepo.update(student);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepo.findById(id);
    }

    @Override
    public void delete(int id) {
        iStudentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return iStudentRepo.getStudentByName(name);
    }
}
