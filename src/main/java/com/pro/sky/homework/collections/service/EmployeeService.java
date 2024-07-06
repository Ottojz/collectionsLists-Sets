package com.pro.sky.homework.collections.service;

import com.pro.sky.homework.collections.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

//    employeeList.set.size =15;


//Метод добавить сотрудника
    Employee add(String fistName, String lastName);

//Метод удалить сотрудника
    Employee remove(String fistName, String lastName);


//Метод найти сотрудника
    Employee find(String fistName, String lastName);

    //Метод для получения списка
    List<Employee> getAll();
}
