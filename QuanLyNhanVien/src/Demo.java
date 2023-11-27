import java.io.IOException;


public class Demo {
    public static void main(String[] args) throws IOException {
//        EmployeeView.employeeViewMenu();


        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[4]); // Gây ra ArrayIndexOutOfBoundsException
            String str = null;
            System.out.println(str.length()); // Gây ra NullPointerException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Lỗi: ArrayIndexOutOfBoundsException đã xảy ra!");
        } catch (NullPointerException e) {
            System.out.println("Lỗi: NullPointerException đã xảy ra!");
        } catch (Exception e) {
            System.out.println("Lỗi: Exception đã xảy ra!");
        }
    }
}
