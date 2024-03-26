package ru.manxix69.hw0207collections.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.manxix69.hw0207collections.domain.Employee;
import ru.manxix69.hw0207collections.services.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public List<Employee> all(@RequestParam(required = false) Integer department) {
        return departmentService.getAllEmployees(department);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam Integer department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam Integer department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }
}
