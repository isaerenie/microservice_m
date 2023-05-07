package net.eren.organizationservice.service;

import net.eren.organizationservice.dto.OrganizationDto;
import net.eren.organizationservice.entity.Organization;

import java.util.List;

public interface OrganizationService {
    Organization save(OrganizationDto organizationDto);
    List<Organization> findAll();
    Organization findById(Long id);
    Organization findByOrganizationCode(String organizationCode);

}
