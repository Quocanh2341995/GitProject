import java.sql.Date;

public class Intern extends Employee{
    private String majors;
    private int semester;
    private String universityName;

    public Intern(int id, String name, Date dob, String phone, String email, Employee_type employeeType, String majors, int semester, String universityName) {
        super(id, name, dob, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern() {

    }


    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return id + name + dob + phone + email + employeeType + majors + semester + universityName;
    }
}
