package eren.net.employeeservice.service;

import eren.net.employeeservice.utils.ResponseMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8082", value = "ORGANIZATION-SERVICE")

public interface OrganizationClient {
    @GetMapping("api/organizations/{organizationCode}")
    ResponseMap getOrganizationByCode(@PathVariable String organizationCode);

}
