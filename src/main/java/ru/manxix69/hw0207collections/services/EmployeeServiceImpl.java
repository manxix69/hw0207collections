package ru.manxix69.hw0207collections.services;

import org.springframework.stereotype.Service;
import ru.manxix69.hw0207collections.EmployeeService;
import ru.manxix69.hw0207collections.domain.Employee;
import ru.manxix69.hw0207collections.exceptions.EmployeeAlreadyAddedException;
import ru.manxix69.hw0207collections.exceptions.EmployeeNotFoundException;
import ru.manxix69.hw0207collections.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();
    private int maxEmployees = 3;

    public String addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() < maxEmployees) {
            try {
                if (findIndexEmployee(firstName, lastName) >= 0) {
                    throw new EmployeeAlreadyAddedException("В фирме уже есть такой сотрудник!");
                }
            } catch (EmployeeNotFoundException e) {
                employees.add(employee);
            }
        } else {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме!");
        }
        return employee.toString();
    }

    public String deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        int index = findIndexEmployee(firstName, lastName);
        String result = employees.get(index).toString();
        employees.remove(index);
        return result;
    }

    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        return employees.get(findIndexEmployee(firstName,lastName)).toString();
    }

    @Override
    public String showAll() {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < employees.size(); i++) {
            builder.append(employees.get(i).toString() + ((i < employees.size() -1) ? "\n" : ""));
        }
        return new String(builder);
    }

    private int findIndexEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        int indexEmployee = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                indexEmployee = i;
                break;
            }
        }
        if (indexEmployee == -1) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return indexEmployee;
    }
}
