package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.FacilityDto;
import com.myschool.entity.*;
import com.myschool.repository.*;
import com.myschool.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final HostelRepository hostelRepository;
    private final TransportRepository transportRepository;
    private final CanteenRepository canteenRepository;
    private final ClubRepository clubRepository;

    private final SchoolRepository schoolRepository;
    private final TeacherRepository teacherRepository;

    private final ObjectMapper mapper;

    @Override
    public void addHostel(FacilityDto dto) {
        HostelEntity entity = new HostelEntity();
        entity.setType(dto.getHostelType());
        entity.setCapacity(dto.getCapacity());
        entity.setSchool(schoolRepository.findById(dto.getSchoolId()).orElse(null));
        hostelRepository.save(entity);
    }

    @Override
    public void addTransport(FacilityDto dto) {
        TransportEntity entity = new TransportEntity();
        entity.setBusNo(dto.getBusNo());
        entity.setRoute(dto.getRoute());
        entity.setDriverName(dto.getDriverName());
        entity.setSchool(schoolRepository.findById(dto.getSchoolId()).orElse(null));
        transportRepository.save(entity);
    }

    @Override
    public void addCanteen(FacilityDto dto) {
        CanteenEntity entity = new CanteenEntity();
        entity.setType(dto.getCanteenType());
        entity.setOpeningHours(dto.getOpeningHours());
        entity.setSchool(schoolRepository.findById(dto.getSchoolId()).orElse(null));
        canteenRepository.save(entity);
    }

    @Override
    public void addClub(FacilityDto dto) {
        ClubEntity entity = new ClubEntity();
        entity.setName(dto.getClubName());
        entity.setTeacherInCharge(teacherRepository.findById(dto.getTeacherInChargeId()).orElse(null));
        clubRepository.save(entity);
    }

    @Override
    public List<FacilityDto> getAllHostels() {
        List<HostelEntity> list = hostelRepository.findAll();
        List<FacilityDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            FacilityDto dto = new FacilityDto();
            dto.setId(e.getHostelId());
            dto.setHostelType(e.getType());
            dto.setCapacity(e.getCapacity());
            dtos.add(dto);
        });
        return dtos;
    }

    @Override public List<FacilityDto> getAllTransports() { return new ArrayList<>(); } // Placeholder
    @Override public List<FacilityDto> getAllCanteens() { return new ArrayList<>(); } // Placeholder
    @Override public List<FacilityDto> getAllClubs() { return new ArrayList<>(); } // Placeholder
}