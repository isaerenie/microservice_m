package net.eren.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.eren.organizationservice.dto.OrganizationDto;
import net.eren.organizationservice.entity.Organization;
import net.eren.organizationservice.service.Impl.OrganizationServiceImpl;
import net.eren.organizationservice.utils.ResponseMap;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private final OrganizationServiceImpl organizationService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseMap save(@RequestBody OrganizationDto organization) {
        Organization organization1 = organizationService.save(organization);
        return ResponseMap.builder()
                .message("Organization created")
                .code("200")
                .details(Map.of("organization", mapper.map(organization1, OrganizationDto.class)))
                .build();
    }

    @GetMapping
    public ResponseMap findAll() {
        List<Organization> organizations = organizationService.findAll();
        List<OrganizationDto> organizationDtos = mapper.map(organizations, List.class);
        return ResponseMap.builder()
                .message("Organizations found")
                .code("200")
                .details(Map.of("organizations", organizationDtos))
                .build();
    }
    @GetMapping("/{organizationCode}")
    public ResponseMap findByCode(@PathVariable("organizationCode") String organizationCode) {
        Organization organization = organizationService.findByOrganizationCode(organizationCode);
        return ResponseMap.builder()
                .message("Organization found")
                .code("200")
                .details(Map.of("organization", mapper.map(organization, OrganizationDto.class)))
                .build();
    }
}
