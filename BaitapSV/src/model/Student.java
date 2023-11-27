package model;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private Date dob;
    private boolean gender;
    private float score;


    public Student(int id, String name, Date dob, boolean gender, float score) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.score = score;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + dob + "," + gender + "," + score;
    }
}