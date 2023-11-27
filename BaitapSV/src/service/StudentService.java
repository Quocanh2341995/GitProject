package service;

import model.Student;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentService {
    private static List<Student> students = new ArrayList<>();
    private static StudentService studentService = new StudentService();
    private static int currentId = 0;

    static {
        Student student1 = new Student(1, "Quoc Anh", Date.valueOf("1995-04-23"), true, 9.5f);
        Student student2 = new Student(2, "Quoc Bao", Date.valueOf("1995-05-20"), true, 8.5f);
        Student student3 = new Student(3, "Anh Quoc", Date.valueOf("1995-08-13"), false, 7.5f);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        readData();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void createStudent(Student student) {
        student.setId(++ currentId);
        students.add(student);
        writeFile();
    }

    public boolean updateStudent(Student student) {
        for (var st : students) {
            if (st.getId() == student.getId()) {
                st.setName(student.getName());
                st.setGender(student.getGender());
                st.setDob(student.getDob());
                st.setScore(student.getScore());
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudentById(int id) {
        var sizeOld = students.size();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                writeFile();
                return sizeOld != students.size();
            }
        }
        return false;
    }

    public boolean deleteStudentByName(String name) {
        var sizeOld = students.size();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                writeFile();
                return sizeOld != students.size();
            }
        }
        return false;
    }

    public void sortStudentById() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getId() - s2.getId();
            }
        });
    }

    public void sortStudentByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    public void findStudent(String name) {
        for (Student student : students) {
            if (student.getName().indexOf(name) >= 0) {
                System.out.printf("| %-7s | %-15s | %-15s | %-10s | %-10s \n",
                        student.getId(),
                        student.getName(),
                        student.getDob(),
                        student.getGender(),
                        student.getScore());
            }
        }
    }

    public int countStudent() {
        return students.size();
    }

    private static void readData() {
        try {
            File fileWriter = new File("data/students.txt");
            FileReader fileReader = new FileReader(fileWriter);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null && !line.equals(" ")) {
                String [] data = line.split(",");
                currentId = Integer.parseInt(data[0]);
                //1,Quang,2023-12-12,true,8
                Student student = new Student(Integer.parseInt(data[0]),
                        data[1],
                        Date.valueOf(data[2]),
                        Boolean.valueOf(data[3]),
                        Float.parseFloat(data[4])
                        );
                students.add(student);

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/students.txt"));
            for (var student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
