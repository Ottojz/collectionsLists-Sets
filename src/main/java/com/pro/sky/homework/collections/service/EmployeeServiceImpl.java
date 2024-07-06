package com.pro.sky.homework.collections.service;

import com.pro.sky.homework.collections.Employee;
import com.pro.sky.homework.collections.exceptions.EmployeeAlreadyAddedException;
import com.pro.sky.homework.collections.exceptions.EmployeeNotFoundException;
import com.pro.sky.homework.collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Петр", "Иванов"),
            new Employee("Иван", "Сидоров")));
    private final int maxSize = 5;

    @Override
    public Employee add(String fistName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(fistName, lastName);
        if (employeeList.size() > maxSize){
            throw new EmployeeNotFoundException("Достигнут лимит количества сотрудников в фирме");
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже зарегистрирован");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String fistName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(fistName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Данный сотрудник не найден");
        }
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        return null;
    }

    @Override
    public Employee find(String fistName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(fistName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Данный сотрудник не найден");
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }
}