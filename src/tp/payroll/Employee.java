package tp.payroll;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class Employee {

    private final String name;

    private Optional<Employee> manager;

    Employee(String name, Employee manager) {
        this(name, Optional.of(manager));
    }

    Employee(String name) {
        this(name, Optional.empty());
    }

    private Employee(String name, Optional<Employee> manager) {
        checkNotNull(name);
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public Optional<Employee> getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = Optional.ofNullable(manager);
    }

    public String toString() {
        return "Employee {" + name + "}";
    }
}
