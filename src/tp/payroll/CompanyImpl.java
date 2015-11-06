package tp.payroll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.*;

public class CompanyImpl implements Company {

    private Employee ceo;
    private List<Employee> employees = new ArrayList<>();

    public Employee nominateCEO(String name) {
        this.ceo = new Employee(name);
        employees.add(ceo);
        return ceo;
    }

    public Employee getCEO() {
        if (ceo == null) throw new NullPointerException("No CEO");
        return ceo;
    }

    public Employee hireEmployee(String name, Employee manager) {
        Employee e = new Employee(name, manager);
        employees.add(e);
        return e;
    }

    public Optional<Employee> findEmployeeByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    public void fire(Employee employee) {
        checkArgument(employee.getManager().isPresent());
        Optional<Employee> toFire = Optional.of(employee);
        employees.stream()
                .filter(e -> e.getManager().equals(toFire))
                .forEach(e -> e.setManager(employee.getManager().get()));
        employees.remove(employee);
    }

    public void promote(Employee employee) {
        Optional<Employee> maybeManagerOfManager =
                employee.getManager().flatMap(Employee::getManager);
        checkArgument(maybeManagerOfManager.isPresent(), employee);
        employee.setManager(maybeManagerOfManager.get());
    }

    public boolean isManager(Employee employee) {
        return employees.stream()
                .map(Employee::getManager)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .anyMatch(e -> e.equals(employee));
    }

    public Collection<Employee> getManagers() {
        return employees.stream()
                .filter(e -> isManager(e))
                .collect(toSet());
    }

    public Collection<Employee> getNonManagers() {
        return employees.stream()
                .filter(e -> !isManager(e))
                .collect(toSet());
    }

    public Collection<Employee> getDirectSubordinates(Employee manager) {
        return null;
    }

    public Collection<Employee> getSubordinates(Employee manager) {
        return null;
    }

    public Collection<Employee> getIndirectSubordinates(Employee manager) {
        return null;
    }

    public int computeSalary(Employee employee) {
        return 0;
    }

    public Collection<Employee> getOverpaidSubordinates() {
        return null;
    }

    public Collection<Employee> getUnderpaidSubordinates() {
        return null;
    }

    public Collection<Employee> getWellPaidEmployees() {
        return null;
    }
}
