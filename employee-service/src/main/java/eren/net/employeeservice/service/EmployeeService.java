package eren.net.employeeservice.service;


import eren.net.employeeservice.dto.APIResponseDto;
import eren.net.employeeservice.dto.EmployeeDto;
import eren.net.employeeservice.entitiy.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
    Employee getEmployeeByCode(String employeeCode);
    List<Employee> findAllEmployees();
    void deleteEmployeeById(Long employeeId);
    Employee updateEmployee(EmployeeDto employeeDto);

}
