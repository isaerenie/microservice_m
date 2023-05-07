package eren.net.employeeservice.service;

import eren.net.employeeservice.utils.ResponseMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081", name = "DEPARTMENT-SERVICE")

public interface DepartmentClient {
    @GetMapping("api/departments/{departmentCode}")
    ResponseMap getDepartmentByCode(@PathVariable String departmentCode);

}
