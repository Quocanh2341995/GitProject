import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public static Scanner sc = new Scanner(System.in);
    private List<Employee> employeeList = new ArrayList<>();
    private static int currentId = 0;
    public EmployeeService() {
    }

    public List<Employee> getAll() {
        return employeeList;
    }


    public boolean deleteEmployeeById(int id) {
        var sizeOld = employeeList.size();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(i);
                return sizeOld != employeeList.size();
            }
        }
        return false;
    }

    public boolean deleteEmployeeByName(String name) {
        var sizeOld = employeeList.size();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equals(name)) {
                employeeList.remove(i);
                return sizeOld != employeeList.size();
            }
        }
        return false;
    }

    public boolean updateEmployee(Employee employee) {
        for ( var e : employeeList) {
            if (e.getId() == employee.getId()) {
                e.setName(employee.getName());
                e.setEmail(employee.getEmail());
                e.setPhone(employee.getPhone());
                e.setEmployeeType(employee.getEmployeeType());
                return true;
            }
        }
        return false;
    }
}
