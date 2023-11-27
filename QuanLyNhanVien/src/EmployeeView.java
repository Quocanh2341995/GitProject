import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class EmployeeView {
    static EmployeeService employeeService = new EmployeeService();
    private static final String REGEX_NUMBER = "\\d+";
    private static final String REGEX_PHONE = "^0\\d{9}$";

    public static void employeeViewMenu() throws IOException {
        int choice;
        do {
            System.out.println("+------------------------------------------+");
            System.out.println("|                 Company                  |");
            System.out.println("+------------------------------------------+");
            System.out.println("| 1. Hien thi nhan vien trong cong ty      |");
            System.out.println("| 2. Them nhan vien                        |");
            System.out.println("| 3. Xoa nhan vie                          |");
            System.out.println("| 4. Cap nhat thong tin nhan vien          |");
            System.out.println("| 0. Exit                                  |");
            System.out.println("+------------------------------------------+");

            choice = getNumberMinMax("Nhap vao lua chon : ", 0, 4);
            switch (choice) {
                case 1: {
                    showEmployee();
                    break;
                }
                case 2: {
                    createEmployee();
                    break;
                }
                case 3 : {
                    deleteEmployee();
                    break;
                }
                case 4 : {
//                    updateEmployee();
                    break;
                }

            }

        }
        while (choice != 0);
    }

//    private static void updateEmployee() {
//        showEmployee();
//        boolean isSuccess = employeeService.updateEmployee(new Employee(getNumber("Nhap id nhan vien muon cap nhat thong tin : "),
//                getString("Nhap ten moi cua nhan vien : "), getDate("Nhap ngay sinh moi cua nhan vien : "),
//                getString("Nhap so dien thoai moi cua nhan vien : "), getString("Nhap email moi cua nhan vien : "),
//                ));
//    }

    private static void deleteEmployee() {
        System.out.println("1. Xoa theo id nhan vien.");
        System.out.println("2. Xoa theo ten nhan vien.");
        int choice = getNumberMinMax("Nhap vao lua chon xoa : ", 1, 2);
        switch (choice) {
            case 1 : {
                showEmployee();
                boolean isSuccess = employeeService.deleteEmployeeById(getNumber("Nhap vao id nhan vien muon xoa : "));
                if (isSuccess) {
                    System.out.println("Xoa nhan vien thanh cong.");
                } else {
                    System.out.println("Khong tim thay Id nhan vien");
                }
            }
            case 2 : {
                showEmployee();
                boolean isSuccess = employeeService.deleteEmployeeByName(getString("Nhap ten nhan vien muon xoa : "));
                if (isSuccess) {
                    System.out.println("Xoa nhan vien thanh cong.");
                } else {
                    System.out.println("Khong tim thay Id nhan vien");
                }
            }
        }
    }

    private static void createEmployee() {
        List<Employee> employeeList = employeeService.getAll();
        int type;

        Employee employee = new Employee();
        Experience experience = new Experience();
        Fresher fresher = new Fresher();
        Intern intern = new Intern();
        String name;
        Date dob;
        String phone;
        String email;
        int expInYear;
        String proSkill;
        Date graduationDate;
        String graduationRank;
        String education;
        String majors;
        int semester;
        String universityName;
        employeeList.add(employee);


        int id = 0;
        if (employeeList.size() == 0) {
            id = 1;
        } else id = employeeList.get(employeeList.size() - 1).getId() + 1;
        employee.setId(id);

        do {
            name = getString("Nhap ten nhan vien : ");
            employee.setName(name);
            dob = getDate("Nhap ngay sinh nhan vien : ");
            employee.setDob(dob);
            phone = getString("Nhap so dien thoai nhan vien :");
            employee.setPhone(phone);
            email = getString("Nhap email nhan vien : ");
            employee.setEmail(email);
        } while (name == "");

        try {
            boolean checkTypeEmployee = false;
            do {
                System.out.println("Chon loai nhan vien : ");
                System.out.println("1. Nhan vien kinh nghiem.");
                System.out.println("2. Nhan vien moi ra truong.");
                System.out.println("3. Nhan vien thuc tap.");
                String input = EmployeeService.sc.nextLine();

                if (checkNumber(input)) {
                    type = Integer.parseInt(input);
                } else {
                    continue;
                }
                switch (type) {
                    case 1 : {
                        employee.setEmployeeType(Employee_type.EXPERIENCE);
                        experience.setName(name);
                        experience.setDob(dob);
                        experience.setPhone(phone);
                        experience.setEmail(email);
                        expInYear = getNumber("Nhap so nam kinh nghiem : ");
                        experience.setExpInYear(expInYear);
                        proSkill = getString("Nhap ki nang chuyen mon : ");
                        experience.setProSkill(proSkill);
                        checkTypeEmployee = true;
                        break;
                    }
                    case 2 : {
                        employee.setEmployeeType(Employee_type.FRESHER);
                        fresher.setName(name);
                        fresher.setDob(dob);
                        fresher.setPhone(phone);
                        fresher.setEmail(email);
                        graduationDate = getDate("Nhap ngay tot nghiep : ");
                        fresher.setGraduationDate(graduationDate);
                        graduationRank = getString("Nhap hang tot nghiep : ");
                        fresher.setGraduationRank(graduationRank);
                        education = getString("Nhap truong tot nghiep : ");
                        fresher.setEducation(education);
                        checkTypeEmployee = true;
                        break;
                    }
                    case 3 : {
                        employee.setEmployeeType(Employee_type.INTERN);
                        intern.setName(name);
                        intern.setDob(dob);
                        intern.setPhone(phone);
                        intern.setEmail(email);
                        majors = getString("Nhap chuyen nganh dang hoc : ");
                        intern.setMajors(majors);
                        semester = getNumber("Nhap hoc ki dang hoc : ");
                        intern.setSemester(semester);
                        universityName = getString("Nhap truong dang hoc : ");
                        intern.setUniversityName(universityName);
                        checkTypeEmployee = true;
                        break;
                    }
                    default: {
                        System.out.println("Vui long chon dung loai nhan vien : ");
                        checkTypeEmployee = false;
                        break;
                    }
                }
            } while (!checkTypeEmployee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void showEmployee() {
        List<Employee> employeeList = employeeService.getAll();
        System.out.println("------------------------------- Danh sach nhan vien -------------------------------");
        System.out.println(String.format("| %-5s | %-15s | %-10s | %-10s | %-20s | %-10s |", "Id", "Name", "Birth", "Phone", "Email", "Type"));
        System.out.println("|-------*------------*------------*------------*------------*----------|");
        for (Employee employee : employeeList) {
            System.out.println(String.format("| %-5s | %-15s | %-10s | %-10s | %-20s | %-10s |",
                    employee.getId(), employee.getName(), employee.getDob(), employee.getPhone(), employee.getEmail(), employee.getEmployeeType()));
            System.out.println("|------------*------------*------------*------------*------------*-------------|");
        }
    }


    public static int getNumberMinMax(String str, int min, int max) throws IndexOutOfBoundsException {
        System.out.println(str);
        int num;
        try {
            num = Integer.parseInt(EmployeeService.sc.nextLine());
            if (num < min || num > max) {
                System.err.println("Chọn từ khoảng " + min + " và " + max);
                return getNumberMinMax(str, min, max);
            }
            return num;
        } catch (Exception e) {
            System.err.println("Khong dung dinh dang");
            return getNumberMinMax(str, min, max);
        }
    }

    public static String getString(String str) {
        try {
            System.out.println(str);
            String data = EmployeeService.sc.nextLine();
            if (data.equals("")) {
                throw new Exception();
            }
            return data;
        } catch (Exception e) {
            System.out.println("Du lieu trong--Vui long nhap lai:");
            return getString(str);
        }
    }

    public static Date getDate(String str) {
        try {
            System.out.println("Vui long nhap ngay theo mau : yyyy-mm-dd");
            return Date.valueOf(getString(str));
        } catch (Exception e) {
            System.out.println("Du lieu nhap vao khong dung!");
            return getDate(str);
        }
    }

    public static boolean checkNumber(String str) {
        if (str.matches(REGEX_NUMBER)) {
            return true;
        } else {
            System.out.println("");
            System.out.println("Nhap vao khong dung! Vui long nhap lai:");
            return false;
        }
    }

    public static int getNumber(String str) {
        try {
            return Integer.parseInt(getString(str));
        } catch (Exception e) {
            System.out.println("Du lieu nhap vao khong dung!");
            return getNumber(str);
        }
    }

}
