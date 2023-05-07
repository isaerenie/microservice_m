package eren.net.employeeservice.service.Impl;


import eren.net.employeeservice.dto.APIResponseDto;
import eren.net.employeeservice.dto.DepartmentDto;
import eren.net.employeeservice.dto.EmployeeDto;
import eren.net.employeeservice.dto.OrganizationDto;
import eren.net.employeeservice.entitiy.Employee;
import eren.net.employeeservice.exception.employee.EmployeeAlreadyExist;
import eren.net.employeeservice.exception.employee.EmployeeNotFound;
import eren.net.employeeservice.repo.EmployeeRepository;
import eren.net.employeeservice.service.DepartmentClient;
import eren.net.employeeservice.service.OrganizationClient;
import eren.net.employeeservice.service.EmployeeService;
import eren.net.employeeservice.utils.ResponseMap;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
    // private  RestTemplate restTemplate;
    // private final WebClient webClient;
    private DepartmentClient departmentClient;
    private OrganizationClient organizationClient;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.map(employeeDto, Employee.class);
        Employee employee1 = employeeRepository.findByEmail(employee.getEmail());
        if (employee1 != null) {
            throw new EmployeeAlreadyExist();
        } else {
            Employee employee2 = employeeRepository.save(employee);
            return employee2;
        }
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFound::new);
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        System.out.println(employee.getDepartmentCode() + "geldiiiiiiiiiiiiiiiiiiiii");
        ResponseMap responseMap = departmentClient.getDepartmentByCode(employee.getDepartmentCode());
        DepartmentDto departmentDto = mapper.map(responseMap.getDetails().get("department"), DepartmentDto.class);
        System.out.println(departmentDto.getDepartmentName()+"geldiiiiiiiiiiiiiiiiiiiii");
        ResponseMap responseMap1 = organizationClient.getOrganizationByCode(employee.getOrganizationCode());
        OrganizationDto organizationDto = mapper.map(responseMap1.getDetails().get("organization"), OrganizationDto.class);
/*
        ResponseMap responseMap = webClient.get()
                .uri("http://localhost:8090/api/departments/" + employee.getDepartmentCode())
                .retrieve().bodyToMono(ResponseMap.class)
                .block();
        DepartmentDto departmentDto = mapper.map(responseMap.getDetails().get("department"), DepartmentDto.class);
*/
/*
        ResponseMap responseMap = restTemplate.getForEntity("http://localhost:8090/api/departments/" + employee.getDepartmentCode(), ResponseMap.class).getBody();
        DepartmentDto departmentDto = mapper.map(responseMap.getDetails().get("department"), DepartmentDto.class);
*/
    /*    ResponseMap responseMap1 = webClient.get()
                .uri("http://localhost:8080/api/organizations/" + employee.getOrganizationCode())
                .retrieve().bodyToMono(ResponseMap.class)
                .block();*/
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }

    @Override
    public Employee getEmployeeByCode(String employeeCode) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        return null;
    }

}
