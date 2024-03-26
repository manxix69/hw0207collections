package ru.manxix69.hw0207collections.services;

import org.springframework.stereotype.Service;
import ru.manxix69.hw0207collections.domain.Employee;
import ru.manxix69.hw0207collections.domain.EmployeeBook;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private EmployeeService employeeService;
    private EmployeeBook employees;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.employees = employeeService.getEmployees();
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.getEmployeeWithMaxSalary(department);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.getEmployeeWithMinSalary(department);
    }

    @Override
    public List<Employee> getAllEmployees(int department) {
        return employees.getAllEmployees(department);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees.getAllSortedEmployeesByDepartments();
    }
}
