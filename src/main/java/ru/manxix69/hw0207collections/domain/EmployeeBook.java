package ru.manxix69.hw0207collections.domain;

import ru.manxix69.hw0207collections.exceptions.EmployeeAlreadyAddedException;
import ru.manxix69.hw0207collections.exceptions.EmployeeNotFoundException;
import ru.manxix69.hw0207collections.exceptions.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {

    private Map<String, Employee> employees = new HashMap<>();
    private int maxEmployees;

    private Map<String, Employee> initialDataEmployees() {
        employees.put("Кипятков Алексей", new Employee("Кипятков", "Алексей"));
        employees.put("Иванов Иван", new Employee("Иванов", "Иван"));
        employees.put("Иванов Петр", new Employee("Иванов", "Петр"));
        employees.put("Веселов Андрей", new Employee("Веселов", "Андрей"));
        employees.put("Иванов Сергей", new Employee("Иванов", "Сергей"));
        return employees;
    }

    public EmployeeBook(int maxEmployees) {
        this.employees = initialDataEmployees();
        this.maxEmployees = maxEmployees;
    }

    public String showAllEmployees() {
        StringBuilder builder = new StringBuilder("");
        for (Map.Entry<String, Employee> pair : employees.entrySet()) {
            builder.append(pair.getKey() + "\n");
        }
        return new String(builder);
    }


    public void addEmployee(Employee employee) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме!");
        } else if (employees.containsKey(employee.getLastName() + " " + employee.getFirstName())) {
            throw new EmployeeAlreadyAddedException("В фирме уже есть такой сотрудник!");
        }
        employees.put(employee.getLastName() + " " + employee.getFirstName(), employee);
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        if (!employees.containsKey(lastName + " " + firstName)) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return employees.get(lastName + " " + firstName);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee.getLastName() + " " + employee.getFirstName());
    }
}