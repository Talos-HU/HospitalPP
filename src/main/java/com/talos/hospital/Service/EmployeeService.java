package com.talos.hospital.Service;

import com.talos.hospital.Model.Employee;
import com.talos.hospital.Model.EmployeeDTO;
import com.talos.hospital.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }


    public void saveEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    public Optional<Employee> findEmployeeById(UUID employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public void deleteEmployeeById(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    public Optional<Employee> updateEmployee(Employee employee, UUID employeeUUID) {
        return employeeRepository.findById(employeeUUID).map(employeeToBeUpdated -> {
            employeeToBeUpdated.setFirstName(employee.getFirstName());
            employeeToBeUpdated.setLastName(employee.getLastName());
            employeeToBeUpdated.setBirthDate(employee.getBirthDate());
            employeeToBeUpdated.setGender(employee.getGender());
            employeeToBeUpdated.setPosition(employee.getPosition());
            employeeToBeUpdated.setAge(employee.getAge());
            employeeToBeUpdated.setAddress(employee.getAddress());
            employeeToBeUpdated.setPhoneNumber(employee.getPhoneNumber());
            employeeRepository.save(employeeToBeUpdated);
            return employeeToBeUpdated;
        });
    }

    public void deleteEmployee(UUID employeeUUID) {
        employeeRepository.deleteById(employeeUUID);
    }

    public EmployeeDTO getEmployeeDTOById(UUID employeeUuid) {
        Employee employee = findEmployeeById(employeeUuid).get();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setPosition(employee.getPosition());
        return employeeDTO;
    }
}
