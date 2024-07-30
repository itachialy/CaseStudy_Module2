package CaseStudy_M2.view;

import CaseStudy_M2.controller.StudentController;

import java.util.Scanner;

public class Management {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        chooseMainFunc();
    }

    public static void chooseMainFunc(){
        do {
            System.out.println("Lựa chọn chức năng: \n" +
                    "1.Quản lí sinh viên. \n" +
                    "2.Quản lí giảng viên. \n" +
                    "3.Kết thúc chương trình.");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    chooseFunctionStudent();
                    break;
                case 2:
//                    chooseTeacherFunction();
                    System.out.println("Chưa hoàn thành xong chức năng này.");
                    break;
                case 3:
                    System.exit(1);
                default:
                    System.out.println("Vui lòng nhập đúng lựa chọn.");
            }
        } while (true);
    }
    public static void chooseFunctionStudent(){
        StudentController studentController = new StudentController();
        do {
            System.out.println("Lựa chọn chức năng: \n" +
                    "1.Hien thi danh sach \n" +
                    "2.Them moi sinh vien. \n" +
                    "3.Chinh sua sinh vien. \n" +
                    "4.Xoa sinh vien. \n" +
                    "5.Tìm kiếm sinh viên theo tên. \n" +
                    "0.Quay ve Menu chính.") ;
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    return;
                case 1:
                    studentController.getAllStudent();
                    break;
                case 2:
                    studentController.addStudentToFile();
                    break;
                case 3:
                    studentController.updateStudentToFile();
                    break;
                case 4:
                    studentController.deleteStudentToFile();
                    break;
                case 5:
                    studentController.getStudentByName();
                    break;
            }
        } while (true);
    }
}

