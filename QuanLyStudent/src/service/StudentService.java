package service;

import model.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentService {
    private static final ArrayList<Student> students = new ArrayList<Student>();

    static {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.format(dob);
        try{
            students.add(new Student("1","Nguyen Van An", 20, 8.25, formatter.parse("10-12-2022")));
            students.add(new Student("2","Nguyen Thi Lan", 20, 9.25));
            students.add(new Student("3","Le Van Do", 20, 7.25));
            students.add(new Student("4","Nguyen Ngoc Nhan", 20, 6.25));
        }catch (Exception e){

        }

    }
    public List<Student> getStudent() {
        return students;
    }

    public void createStudent(Student student) {
        students.add(student);
    }
}
