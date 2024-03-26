package ru.manxix69.hw0207collections.services;

import ru.manxix69.hw0207collections.domain.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(int department);
    Employee getEmployeeWithMinSalary(int department);
    List<Employee> getAllEmployees(int department);
    List<Employee> getAllEmployees();
}
