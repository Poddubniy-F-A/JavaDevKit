package HW4;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.addEmployee(new Employee("1", "Alex", 1));
        directory.addEmployee(new Employee("2", "Bob", 2));
        directory.addEmployee(new Employee("3", "Carl", 3));
        directory.addEmployee(new Employee("4", "Bob", 2));
        directory.addEmployee(new Employee("5", "David", 4));

        for (Employee e : directory.getEmployeesByExperience(3)) {
            System.out.println(e);
        }
        for (String phoneNumber : directory.getPhoneNumbersByName("Bob")) {
            System.out.println(phoneNumber);
        }
        System.out.println(directory.getEmployeeByNumber(1));
    }
}
