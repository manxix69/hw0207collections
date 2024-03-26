package ru.manxix69.hw0207collections.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.manxix69.hw0207collections.services.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String greeting() {
        return "Укажи метод и укажи параметры." + "\n\n" +
                "На примере сотрудника 'Ivan Ivanov' :" + "\n\n" +
                "добавить:" + "\n" +
                "/add?firstName=Ivan&lastName=Ivanov" + "\n\n" +
                "удалить:" + "\n" +
                "/remove?firstName=Ivan&lastName=Ivanov" + "\n\n" +
                "найти:" + "\n" +
                "/find?firstName=Ivan&lastName=Ivanov"
                
                ;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam Integer department,
                      @RequestParam Double salary) {
        return employeeService.addEmployee(firstName, lastName ,department,  salary);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/showAll")
    public String showAll() {
        return employeeService.showAll();
    }

}
