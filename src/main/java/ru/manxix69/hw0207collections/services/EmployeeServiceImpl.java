package ru.manxix69.hw0207collections.services;

import org.springframework.stereotype.Service;
import ru.manxix69.hw0207collections.EmployeeService;
import ru.manxix69.hw0207collections.domain.Employee;
import ru.manxix69.hw0207collections.domain.EmployeeBook;
import ru.manxix69.hw0207collections.exceptions.EmployeeAlreadyAddedException;
import ru.manxix69.hw0207collections.exceptions.EmployeeNotFoundException;
import ru.manxix69.hw0207collections.exceptions.EmployeeStorageIsFullException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private int maxEmployees = 10;
    private EmployeeBook employees = new EmployeeBook(maxEmployees);

    public String addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(lastName, firstName);
        employees.addEmployee(employee);
        return employee.toString();
    }

    public String deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = employees.findEmployee(firstName, lastName);
        employees.removeEmployee(employee);
        return employee.toString();
    }

    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        return employees.findEmployee(firstName, lastName).toString();
    }

    @Override
    public String showAll() {
        return employees.showAllEmployees();
    }

}
