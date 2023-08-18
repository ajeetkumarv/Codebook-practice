package code.feature;

public class RecordTest {
    public static void main(String[] args) {
        record Employee(String id, double salary, int yearsOfService) {
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
        System.out.println(emp.id());
        System.out.println(emp); // toString
        System.out.println(Employee.data);
    }
}
