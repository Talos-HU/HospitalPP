package com.talos.hospital.Controller;

import com.talos.hospital.Model.Employee;
import com.talos.hospital.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public List<Employee> listAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Optional<Employee> updatePatient(@RequestBody Employee employee, @PathVariable("id") UUID employeeUUID) {
        return employeeService.updateEmployee(employee, employeeUUID);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") UUID employeeUUID) {
        employeeService.deleteEmployee(employeeUUID);
    }
}
