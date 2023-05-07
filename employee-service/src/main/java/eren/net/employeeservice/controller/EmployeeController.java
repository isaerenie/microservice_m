package eren.net.employeeservice.controller;

import eren.net.employeeservice.dto.APIResponseDto;
import eren.net.employeeservice.dto.EmployeeDto;
import eren.net.employeeservice.entitiy.Employee;
import eren.net.employeeservice.service.EmployeeService;
import eren.net.employeeservice.utils.ResponseMap;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private ModelMapper mapper;
    //Build save employee REST API
    @PostMapping
    public ResponseMap saveEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee=employeeService.saveEmployee(employeeDto);
        return ResponseMap.builder()
                .message("Employee created")
                .code("200")
                .details(Map.of("employee", mapper.map(employee, EmployeeDto.class)))
                .build();
    }
    @GetMapping("/{employeeId}")
    public ResponseMap getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        APIResponseDto apiResponseDto =employeeService.getEmployeeById(employeeId);
        return ResponseMap.builder()
                .message("Employee found")
                .code("200")
                .details(Map.of("employee", apiResponseDto))
                .build();
    }
    @GetMapping
    public ResponseMap getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        List<EmployeeDto> employeeDtos = mapper.map(employees, List.class);
        return ResponseMap.builder()
                .message("Employees found")
                .code("200")
                .details(Map.of("employees", employeeDtos))
                .build();
    }
}
