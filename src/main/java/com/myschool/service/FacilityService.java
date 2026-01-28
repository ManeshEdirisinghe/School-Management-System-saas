package com.myschool.service;

import com.myschool.dto.FacilityDto;
import com.myschool.dto.FacilityAllocationDto; // New Import
import java.util.List;

public interface FacilityService {
    void addHostel(FacilityDto dto);
    void addTransport(FacilityDto dto);
    void addCanteen(FacilityDto dto);
    void addClub(FacilityDto dto);

    List<FacilityDto> getAllHostels();
    List<FacilityDto> getAllTransports();
    List<FacilityDto> getAllCanteens();
    List<FacilityDto> getAllClubs();

    void assignStudentToHostel(FacilityAllocationDto dto);
    void assignStudentToTransport(FacilityAllocationDto dto);
    void assignStudentToClub(FacilityAllocationDto dto);
}