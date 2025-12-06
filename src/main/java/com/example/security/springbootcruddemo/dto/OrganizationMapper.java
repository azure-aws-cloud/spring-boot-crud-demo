package com.example.security.springbootcruddemo.mapper;

import com.example.security.springbootcruddemo.dto.ManagerDto;
import com.example.security.springbootcruddemo.dto.OrganizationDto;
import com.example.security.springbootcruddemo.dto.SubordinateDto;
import com.example.security.springbootcruddemo.model.Organization;

import java.util.stream.Collectors;

public class OrganizationMapper {

    public static OrganizationDto toDto(Organization org) {
        if (org == null) {
            return null;
        }

        OrganizationDto dto = new OrganizationDto();
        dto.setEmployeeId(org.getEmployeeId());
        dto.setName(org.getName());

        // Manager mapping
        if (org.getManager() != null) {
            ManagerDto managerDto = new ManagerDto();
            managerDto.setEmployeeId(org.getManager().getEmployeeId());
            managerDto.setName(org.getManager().getName());
            dto.setManager(managerDto);
        }

        // Subordinates mapping
        if (org.getSubordinates() != null && !org.getSubordinates().isEmpty()) {
            dto.setSubordinates(org.getSubordinates().stream().map(sub -> {
                SubordinateDto subDto = new SubordinateDto();
                subDto.setEmployeeId(sub.getEmployeeId());
                subDto.setName(sub.getName());
                return subDto;
            }).collect(Collectors.toSet()));
        }

        return dto;
    }
}
