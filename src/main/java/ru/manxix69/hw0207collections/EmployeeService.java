package ru.manxix69.hw0207collections;

import ru.manxix69.hw0207collections.exceptions.EmployeeAlreadyAddedException;
import ru.manxix69.hw0207collections.exceptions.EmployeeNotFoundException;
import ru.manxix69.hw0207collections.exceptions.EmployeeStorageIsFullException;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    String deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    String showAll();
}
