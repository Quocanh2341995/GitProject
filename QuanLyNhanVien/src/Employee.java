import java.sql.Date;

public class Employee {
    public int id;
    public String name;
    public Date dob;
    public String phone;
    public String email;
    public Employee_type employeeType;

    public Employee(int id, String name, Date dob, String phone, String email, Employee_type employeeType) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
    }

    public Employee() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + name + dob + phone + email + employeeType;
    }

    public Employee_type getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Employee_type employeeType) {
        this.employeeType = employeeType;
    }
}
