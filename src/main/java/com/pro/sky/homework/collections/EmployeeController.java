package com.pro.sky.homework.collections;

import com.pro.sky.homework.collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname) {
        return employeeService.add(firstname, lastname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname) {
        return employeeService.remove(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstname,
            @RequestParam("lastName") String lastname) {
        return employeeService.find(firstname, lastname);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}