package io.pivotal.pal.tracker.services;

import io.pivotal.pal.tracker.model.Employee;
import io.pivotal.pal.tracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeList()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).get();
    }
    public void saveOrUpdate(Employee employee)
    {
        employeeRepository.save(employee);
    }
    public void delete(int id)
    {
        employeeRepository.deleteById(id);
    }
}
