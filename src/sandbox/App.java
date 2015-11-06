package sandbox;

import tp.payroll.Company;
import tp.payroll.CompanyImpl;
import tp.payroll.Employee;

import java.util.Optional;

public class App {

    public static void main(String[] args) {
        Company company = new CompanyImpl();

        Employee john = company.nominateCEO("John");
        Employee bob = company.hireEmployee("Bob", john);
        Employee steve = company.hireEmployee("Steve", bob);

//        company.findEmployeeByName("John")
//                .ifPresent(System.out::println);
//        company.findEmployeeByName("Bob")
//                .ifPresent(System.out::println);
//        company.findEmployeeByName("Steve")
//                .ifPresent(System.out::println);

//        company.fire(bob);
//        company.findEmployeeByName("Steve")
//                .map(Employee::getManager)
//                .ifPresent(System.out::println);

//        company.promote(steve);
//        steve.getManager().ifPresent(System.out::println);

//        System.out.println(company.isManager(steve));
//        System.out.println(company.isManager(bob));
//        System.out.println(company.isManager(john));
//
//        company.promote(steve);
//        System.out.println(company.isManager(bob));

//        System.out.println("Managers");
//        company.getManagers().forEach(System.out::println);
//        System.out.println("Non Managers");
//        company.getNonManagers().forEach(System.out::println);

//        company.getDirectSubordinates(john).forEach(System.out::println);
//        company.getDirectSubordinates(bob).forEach(System.out::println);
//        company.getDirectSubordinates(steve).forEach(System.out::println);

//        System.out.println("John");
//        company.getSubordinates(john).forEach(System.out::println);
//        System.out.println("Bob");
//        company.getSubordinates(bob).forEach(System.out::println);
//        System.out.println("Steve");
//        company.getSubordinates(steve).forEach(System.out::println);

        System.out.println("John");
        company.getIndirectSubordinates(john).forEach(System.out::println);
        System.out.println("Bob");
        company.getIndirectSubordinates(bob).forEach(System.out::println);
        System.out.println("Steve");
        company.getIndirectSubordinates(steve).forEach(System.out::println);

//        System.out.println((int) (Math.random() * 44));

    }


}
