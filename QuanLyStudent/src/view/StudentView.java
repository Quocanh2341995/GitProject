package view;


import model.Student;
import service.StudentService;
import java.util.Scanner;

public class StudentView {
    static Scanner sc = new Scanner(System.in);
    static StudentService studentService = new StudentService();



    public static void printClass() {
        while (true) {
            System.out.println("-----Quan Ly Danh Sach Hoc Sinh-----");
            System.out.println("1. In ra danh sach hoc sinh.");
            System.out.println("2. Them hoc sinh vao danh sach.");
            System.out.println("3. Cap nhat thong tin hoc sinh.");
            System.out.println("4. Kiem tra hoc sinh co nam trong danh sach khong theo ma hoc sinh.");
            System.out.println("5. Xoa hoc sinh theo ma hoc sinh trong danh sach.");
            System.out.println("6. Sap xep hoc sinh theo thu tu bang chu cai.");
            System.out.println("7. Sap xep hoc sinh theo diem giam dan.");
            System.out.println("8. Tim kiem hoc sinh theo ten hoc sinh.");
            System.out.println("9. Lay ra so luong hoc sinh trong danh sach.");
            System.out.println("0. Thoat.");
            int choice = getNumber("Nhap vao lua chon.");
            switch (choice) {
                case 1 -> {
                    printStudent();
                }
                case 2 -> {
                    createStudent();
                }
                case 3 -> {
                    updateStudent();
                }
            }
        }
    }

    private static void updateStudent() {
    }

    private static void createStudent() {
        studentService.createStudent(new Student(getString("Nhap ma hoc sinh"), getString("Nhap ten hoc sinh"), getNumber("Nhap tuoi hoc sinh"), getNumber("Nhap diem hoc sinh"), ));
    }

    private static void printStudent() {
        System.out.println("Id:      | Name:      | Age:      | Score:      ");
        for (var student: studentService.getStudent()) {
            System.out.printf("%s       | %s        | %s        | %s      |       %f%n", student.getId(), student.getName(), student.getAge(), student.getScore());
        }
    }

    public static int getNumber (String str) throws IndexOutOfBoundsException {
        System.out.println(str);
        int num;
        try {
            num = Integer.parseInt(sc.nextLine());
            return num;
        } catch (Exception e) {
            System.out.println("Du lieu nhap vao khong dung dinh dang.");
            return getNumber(str);
        }
    }

    public static String getString (String str) throws IndexOutOfBoundsException {
        System.out.println(str);
        return sc.nextLine();
    }
}
