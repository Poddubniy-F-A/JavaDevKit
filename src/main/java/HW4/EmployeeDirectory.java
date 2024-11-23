package HW4;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDirectory {
    private final Set<Employee> employees = new HashSet<>();

    public Set<Employee> getEmployeesByExperience(int experience) {
        Set<Employee> res = new HashSet<>();
        for (Employee e : employees) {
            if (e.getExperience() >= experience) {
                res.add(e);
            }
        }
        return res;
    }

    public Set<String> getPhoneNumbersByName(String name) {
        Set<String> res = new HashSet<>();
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                res.add(e.getPhoneNumber());
            }
        }
        return res;
    }

    public Employee getEmployeeByNumber(int id) {
        for (Employee e : employees) {
            if (e.getEmployeeID() == id) {
                return e;
            }
        }
        return null;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }
}
