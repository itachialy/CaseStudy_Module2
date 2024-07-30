package CaseStudy_M2.repository;

import CaseStudy_M2.model.Student;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepoImpl implements IStudentRepo{
    private static final List<Student> students = new ArrayList<>();
    public static String PATH = "src/CaseStudy_M2/data/student.csv" ;
//    static {
//        students.add(new Student(1, "HV-001", "Viet", LocalDate.parse("2000-11-11"), "vietcg@gmail.com", "C0324"));
//        students.add(new Student(2, "HV-002", "Nam", LocalDate.parse("2000-11-11"), "namcg@gmail.com", "C0324"));
//        students.add(new Student(3, "HV-003", "Tam", LocalDate.parse("2000-11-11"), "tamcg@gmail.com", "C0324"));
//    }


    @Override
    public List<Student> findAll() {

        List<Student> list = new ArrayList<>();
        try(
                FileReader fileReader = new FileReader(PATH);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null) {
                arrData = temp.split(",");
                list.add(new Student(Integer.parseInt(arrData[0]),
                        arrData[1],
                        arrData[2],
                        LocalDate.parse(arrData[3]),
                        arrData[4],
                        arrData[5]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void save(Student student) {
        try(
                FileWriter fileWriter = new FileWriter(PATH, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(student.convertToLine());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        List<Student> list = findAll();
            for (int i = 0 ; i < list.size() ; i++) {
                if (list.get(i).getId() == student.getId()) {
                    list.set(i, student);
                    break;
                }
            }
        saveListStudentToFile(list);
    }

    @Override
    public Student findById(int id) {
        List<Student> list = findAll();
        for ( Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        List<Student> list = findAll();
        for (int i = 0 ; i < list.size() ; i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
        saveListStudentToFile(list);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        List<Student> list =new ArrayList<>();
        try(
                FileReader fileReader = new FileReader(PATH);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ){
            String temp;
            String[] arrData;
            while ((temp = bufferedReader.readLine()) != null) {
                arrData = temp.split(",");
                String getByName = arrData[2];
                if (getByName.equalsIgnoreCase(name)){
                    list.add(new Student(Integer.parseInt(arrData[0]),
                            arrData[1],
                            arrData[2],
                            LocalDate.parse(arrData[3]),
                            arrData[4],
                            arrData[5]));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
       return list;
    }

    public void saveListStudentToFile(List<Student> students) {
        try(
                FileWriter fileWriter = new FileWriter(PATH);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for (Student s : students) {
                bufferedWriter.write(s.convertToLine());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
