package HW4;

public class Employee {
    private static int employeesNumber = 0;

    private final String phoneNumber, name;
    private final int employeeID, experience;

    public Employee(String phoneNumber, String name, int experience) {
        employeeID = ++employeesNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return employeeID + ". Name: " + name + ", phone number: " + phoneNumber + ", experience: " + experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getExperience() {
        return experience;
    }
}
