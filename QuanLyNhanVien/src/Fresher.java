import java.sql.Date;

public class Fresher extends Employee{
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int id, String name, Date dob, String phone, String email, Employee_type employeeType, Date graduationDate, String graduationRank, String education) {
        super(id, name, dob, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher() {

    }

//    public Fresher(Date graduationDate, String graduationRank, String education) {
//        this.graduationDate = graduationDate;
//        this.graduationRank = graduationRank;
//        this.education = education;
//    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return id + name + dob + phone + email + employeeType + graduationDate + graduationRank + education;
    }
}
