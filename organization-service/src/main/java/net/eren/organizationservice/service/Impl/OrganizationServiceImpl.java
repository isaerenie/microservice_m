package net.eren.organizationservice.service.Impl;

import lombok.AllArgsConstructor;
import net.eren.organizationservice.dto.OrganizationDto;
import net.eren.organizationservice.entity.Organization;
import net.eren.organizationservice.repo.OrganizationRepository;
import net.eren.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {
   private final OrganizationRepository organizationRepository;
   private final ModelMapper mapper;
    @Override
    public Organization save(OrganizationDto organizationDto) {
        Organization organization = mapper.map(organizationDto, Organization.class);
        Organization organization1 = organizationRepository.findByOrganizationCode(organization.getOrganizationCode());
        if (organization1 != null) {
            throw new RuntimeException("Organization already exists");
        } else {
            Organization organization2 = organizationRepository.save(organization);
            return organization2;
        }
    }

    @Override
    public List<Organization> findAll() {
       return organizationRepository.findAll();
    }

    @Override
    public Organization findById(Long id) {
        return null;
    }

    @Override
    public Organization findByOrganizationCode(String organizationCode) {
        return organizationRepository.findByOrganizationCode(organizationCode);
    }
}
