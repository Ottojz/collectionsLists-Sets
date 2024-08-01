package com.pro.sky.homework.collections.service;

import com.pro.sky.homework.collections.Employee;
import com.pro.sky.homework.collections.exceptions.EmployeeAlreadyAddedException;
import com.pro.sky.homework.collections.exceptions.EmployeeNotFoundException;
import com.pro.sky.homework.collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final int maxSize = 5;

    @Override
    public Employee add(String fistName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(fistName, lastName);
        if (employees.size() > maxSize){
            throw new EmployeeNotFoundException("Достигнут лимит количества сотрудников в фирме");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже зарегистрирован");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String fistName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(fistName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Данный сотрудник не найден");
        }
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        return null;
    }

    @Override
    public Employee find(String fistName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(fistName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Данный сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}