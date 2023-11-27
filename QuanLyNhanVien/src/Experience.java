import java.sql.Date;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    public Experience(int id, String name, Date dob, String phone, String email, Employee_type employeeType, int expInYear, String proSkill) {
        super(id, name, dob, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience() {

    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return id + name + dob + phone + email + employeeType + expInYear + proSkill;
    }
}
