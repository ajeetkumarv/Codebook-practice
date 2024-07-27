package code.feature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordTest {
    public static void main(String[] args) {

        // records are meant to be immutable
        record Employee(String id, double salary, int yearsOfService) { // imlicitly final
            public static String data = "data"; // no instance member allowed
            void test() {
                System.out.println("Test: " + data);
            }
            void setData(String d) {
                if ( d == null) throw new IllegalArgumentException("data can not be null");
                data = d;
            }
        };

        Employee emp = new Employee("123", 1000, 5);
        Employee emp2 = new Employee("456", 1000, 5);
        emp2.data = "updated data";
        emp.test();
        emp.setData("restored data");
        System.out.println(emp.id() + " " + emp.id);
        System.out.println(emp); // toString
        System.out.println(Employee.data);

        emp.id(); // implicitly created getter

        record Sample (int a, int b){
            public int sum() {
                return a + b;
            }
        };

        Sample s = new Sample(5,6);
        System.out.println(s.sum());
    }
}
