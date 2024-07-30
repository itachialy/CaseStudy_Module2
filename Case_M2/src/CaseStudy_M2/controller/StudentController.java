package CaseStudy_M2.controller;

import CaseStudy_M2.model.Student;
import CaseStudy_M2.service.IStudentService;
import CaseStudy_M2.service.StudentServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentController {
    private final IStudentService iStudentService = new StudentServiceImpl();
    public final static Scanner sc = new Scanner(System.in);

    public void getAllStudent(){
        List<Student> students = iStudentService.findAll();
        if (students.isEmpty()){
            System.out.println("Khong tim thay hoc vien.");
        } else {
            System.out.println("Danh sach hoc vien là: ");
            for (Student s : students){
                System.out.println(s);
            }
        }
    }

    public void addStudentToFile(){
        System.out.println("Nhap id hoc vien : ");
        int id = Integer.parseInt(sc.nextLine());
        Student student = getStudent(id);
        iStudentService.save(student);
        System.out.println("Them hoc vien thanh cong.");
    }
    public boolean isExist(int id){
        Student student = iStudentService.findById(id);
        return student != null ;
    }

    public void updateStudentToFile() {
        System.out.println("Nhap id hoc vien can chinh sua : ");
        int id = Integer.parseInt(sc.nextLine());
        if (isExist(id)){
            Student student = getStudent(id);
            iStudentService.update(student);
            System.out.println("Cap nhat hoc vien thanh cong.");
        } else {
            System.out.println("Khong tim thay hoc vien voi id la : " + id);
        }
    }

    public void deleteStudentToFile() {
        System.out.println("Nhap id can xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        if (isExist(id)){
            iStudentService.delete(id);
            System.out.println("Xoa hoc vien voi id " + id +" thanh cong.");
        } else {
            System.out.println("Khong tim thay hoc vien voi id la : " + id);
        }

    }
    private Student getStudent(int id){
        System.out.print("Nhap ma hoc vien: ");
        String code = sc.nextLine();
        System.out.print("Nhap ten hoc vien: ");
        String name = sc.nextLine();

        String temp;
        do {
            System.out.println("Nhap ngay sinh (yyyy-MM-dd): ");
            temp = sc.nextLine();
            if (checkPatternBirthday(temp)){
                System.out.println("Định dạng ko hợp lệ, vui lòng nhập lại: ");
            }
        } while (checkPatternBirthday(temp));
        LocalDate birthday = LocalDate.parse(temp);

        String email;
        do {
            System.out.println("Nhap email hoc vien: ");
            email = sc.nextLine();
            if (checkPatternEmail(email)){
                System.out.println("Định dạng ko hợp lệ, vui lòng nhập lại: ");
            }
        } while (checkPatternEmail(email));

        System.out.println("Nhap lop: ");
        String className = sc.nextLine();
        return new Student(id, code, name, birthday, email, className);
    }

    private boolean checkPatternBirthday(String birthday){
        String REGEX_BIRTHDAY = "^\\d{4}-\\d{2}-\\d{2}";
        return !Pattern.matches(REGEX_BIRTHDAY, birthday);
    }

    private boolean checkPatternEmail(String email){
        String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return !Pattern.matches(REGEX_EMAIL,email);
    }

    public void getStudentByName() {
        System.out.println("Nhập tên của học viên tìm kiếm: ");
        String name = sc.nextLine();
        List<Student> students = iStudentService.getStudentByName(name);
        if (!students.isEmpty()){
            System.out.println("Đã tìm thấy học viên với tên: " + name);
            for (Student s : students){
                System.out.println(s);
            }
        } else {
            System.out.println("Không tìm thấy học viên với tên: " + name);
        }
    }
}
