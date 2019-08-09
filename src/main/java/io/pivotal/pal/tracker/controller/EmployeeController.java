package io.pivotal.pal.tracker.controller;

import io.pivotal.pal.tracker.model.Employee;
import io.pivotal.pal.tracker.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployeeList()
    {
        List<Employee> employeeList = employeeService.getEmployeeList();

        return employeeList;
    }
    @GetMapping("/employees/{id}")
    private Employee getPerson(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PostMapping("/employees")
    private int savePerson(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
        return employee.getEmpid();
    }
}
