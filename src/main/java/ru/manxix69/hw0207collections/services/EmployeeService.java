package ru.manxix69.hw0207collections.services;

import ru.manxix69.hw0207collections.domain.EmployeeBook;
import ru.manxix69.hw0207collections.exceptions.EmployeeAlreadyAddedException;
import ru.manxix69.hw0207collections.exceptions.EmployeeNotFoundException;
import ru.manxix69.hw0207collections.exceptions.EmployeeStorageIsFullException;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName, Integer department, Double salary) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    String deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    String showAll();

    EmployeeBook getEmployees();
}
