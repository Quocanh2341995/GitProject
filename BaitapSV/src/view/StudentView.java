package view;

import model.Student;
import service.StudentService;
import utils.AppUtils;

import java.util.Scanner;

import static utils.AppUtils.*;

public class StudentView {
    static StudentService studentService = new StudentService();
    public static void printSoftware() {
        while (true) {
            System.out.println("+-----------------------------------------------+");
            System.out.println("|               Manager Student                 |");
            System.out.println("+-----------------------------------------------+");
            System.out.println("| 1. Displays the list of students.             |");
            System.out.println("| 2. Create Student.                            |");
            System.out.println("| 3. Update Student.                            |");
            System.out.println("| 4. Delete Student.                            |");
            System.out.println("| 5. Sort Student.                              |");
            System.out.println("| 6. Find Student By Name.                      |");
            System.out.println("| 7. Count Student.                             |");
            System.out.println("| 8. Empty Student List                         |");
            System.out.println("| 0. Exit                                       |");
            System.out.println("+-----------------------------------------------+");
            int choice = AppUtils.getNumberMinMax("Please choice function :", 0, 7);
            switch (choice) {
                case 1:
                    studentService.sortStudentById();
                    showStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudent();
                    break;
                case 6:
                    findStudentByName();
                    break;
                case 7:
                    System.out.println("Number Student in List : " + studentService.countStudent());
                    break;
            }
        }
    }

    private static void findStudentByName() {
        System.out.println("Enter Name Student Find : ");
        String name = scanner.nextLine();
        studentService.findStudent(name);

    }

    private static void sortStudent() {
        System.out.println("5.1 Sort Student By Id :");
        System.out.println("5.2 Sort Student By Name :");

        int choice = getNumberMinMax("Please choice : ", 0, 3);
        switch (choice) {
            case 1: {
                studentService.sortStudentById();
                showStudents();
                break;
            }
            case 2: {
                studentService.sortStudentByName();
                showStudents();
                break;
            }

        }

    }

    private static void deleteStudent() {
        System.out.println("4.1 Delete Student By Id : ");
        System.out.println("4.2 Delete Student By Name :");

        int choice = getNumberMinMax("Please choose : ", 1, 2);
        switch (choice) {
            case 1: {
                showStudents();
                boolean isSuccess = studentService.deleteStudentById(getNumber("Enter Id Student to Delete :"));
                if (isSuccess) {
                    System.out.println("Delete Success !");
                } else {
                    System.out.println("Student Id not found !");
                }
                break;
            }
            case 2: {
                showStudents();
                boolean isSuccess = studentService.deleteStudentByName(getString("Enter Name Student to Delete :"));
                if (isSuccess) {
                    System.out.println("Delete Success !");
                } else {
                    System.out.println("Student Name not found !");
                }
                break;
            }
        }
    }

    private static void updateStudent() {
        showStudents();
        boolean isSuccess = studentService.updateStudent(new Student(getNumber("Enter Id update Student :"),
                getString("Enter Name update Student :"),
                getDate("Enter Date Of Birth update Student :"),
                getGender1("Enter Gender update Student :"),
                getScore("Enter Student Score")));
    }

    private static void createStudent() {
        studentService.createStudent(new Student(0, getString("Enter Student name: "),
                getDate("Enter Student Date Of Birth:"),
                getGender1("Enter Student Gender:"),
                getScore("Enter Student Score")));
    }

    private static void showStudents() {
        System.out.println("-----------------Students List-----------------");
        System.out.println(String.format("| %-7s | %-15s | %-15s | %-10s | %-10s ", "Id", "Name", "Date Of Birth", "Gender", "Score"));
        for (var student : studentService.getStudents()) {
            System.out.printf("| %-7s | %-15s | %-15s | %-10s | %-10s ",
                    student.getId(),
                    student.getName(),
                    student.getDob(),
                    student.getGender(),
                    student.getScore());
            System.out.println("\n");

        }

    }
}
