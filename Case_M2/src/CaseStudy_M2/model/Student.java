package CaseStudy_M2.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Student extends Person{
    private String className;

    public Student(int id, String code, String name, LocalDate birthday, String email, String className) {
        super(id, code, name, birthday, email);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", className='" + className + '\'' +
                '}';
    }
    public String convertToLine(){
        return super.getId() + "," + super.getCode()+ "," + super.getName()+ "," +
                super.getBirthday()+ "," + super.getEmail()+ "," + className;
    }
//    public void inputForm(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap id hoc vien : ");
//        int id = Integer.parseInt(sc.nextLine());
//        System.out.print("Nhap ma hoc vien : ");
//        String code = sc.nextLine();
//        System.out.print("Nhap ten hoc vien: ");
//        String name = sc.nextLine();
//        System.out.println("Nhap ngay sinh (xxxx/yy/zz) : ");
//        String temp = sc.nextLine();
//        LocalDate birthday = LocalDate.parse(temp);
//        System.out.println("Nhap email hoc vien : ");
//        String email = sc.nextLine();
//        System.out.println("Nhap lop : ");
//        String className = sc.nextLine();
//    }
}
