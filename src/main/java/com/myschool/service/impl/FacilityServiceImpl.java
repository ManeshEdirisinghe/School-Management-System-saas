package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.FacilityAllocationDto;
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

    private final StudentHostelRepository studentHostelRepo;
    private final StudentTransportRepository studentTransportRepo;
    private final StudentClubRepository studentClubRepo;
    private final StudentRepository studentRepo;

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

    @Override
    public List<FacilityDto> getAllTransports() {
        List<TransportEntity> list = transportRepository.findAll();
        List<FacilityDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            FacilityDto dto = new FacilityDto();
            dto.setId(e.getTransportId());
            dto.setBusNo(e.getBusNo());
            dto.setRoute(e.getRoute());
            dto.setDriverName(e.getDriverName());
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    public List<FacilityDto> getAllCanteens() {
        List<CanteenEntity> list = canteenRepository.findAll();
        List<FacilityDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            FacilityDto dto = new FacilityDto();
            dto.setId(e.getCanteenId());
            dto.setCanteenType(e.getType());
            dto.setOpeningHours(e.getOpeningHours());
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    public List<FacilityDto> getAllClubs() {
        List<ClubEntity> list = clubRepository.findAll();
        List<FacilityDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            FacilityDto dto = new FacilityDto();
            dto.setId(e.getClubId());
            dto.setClubName(e.getName());
            if(e.getTeacherInCharge() != null) {
                dto.setTeacherInChargeId(e.getTeacherInCharge().getTeacherId());
            }
            dtos.add(dto);
        });
        return dtos;
    }


    @Override
    public void assignStudentToHostel(FacilityAllocationDto dto) {
        StudentHostelEntity entity = new StudentHostelEntity();
        entity.setStudent(studentRepo.findById(dto.getStudentId()).orElse(null));
        entity.setHostel(hostelRepository.findById(dto.getHostelId()).orElse(null));
        entity.setAssignedDate(dto.getAssignedDate());
        entity.setIsActive(true);
        studentHostelRepo.save(entity);
    }

    @Override
    public void assignStudentToTransport(FacilityAllocationDto dto) {
        StudentTransportEntity entity = new StudentTransportEntity();
        entity.setStudent(studentRepo.findById(dto.getStudentId()).orElse(null));
        entity.setTransport(transportRepository.findById(dto.getTransportId()).orElse(null));
        entity.setAssignedDate(dto.getAssignedDate());
        entity.setIsActive(true);
        studentTransportRepo.save(entity);
    }

    @Override
    public void assignStudentToClub(FacilityAllocationDto dto) {
        StudentClubEntity entity = new StudentClubEntity();
        entity.setStudent(studentRepo.findById(dto.getStudentId()).orElse(null));
        entity.setClub(clubRepository.findById(dto.getClubId()).orElse(null));
        entity.setRole(dto.getRole());
        entity.setJoinedDate(dto.getAssignedDate());
        studentClubRepo.save(entity);
    }
}