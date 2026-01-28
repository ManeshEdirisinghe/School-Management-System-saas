package com.myschool.controller;

import com.myschool.dto.FacilityAllocationDto; // අලුත් DTO එක Import කරන්න
import com.myschool.dto.FacilityDto;
import com.myschool.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility")
@CrossOrigin
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    // --- ADD FACILITIES (Admin Side) ---

    @PostMapping("/add-hostel")
    public void addHostel(@RequestBody FacilityDto dto) {
        facilityService.addHostel(dto);
    }

    @PostMapping("/add-transport")
    public void addTransport(@RequestBody FacilityDto dto) {
        facilityService.addTransport(dto);
    }

    @PostMapping("/add-canteen")
    public void addCanteen(@RequestBody FacilityDto dto) {
        facilityService.addCanteen(dto);
    }

    @PostMapping("/add-club")
    public void addClub(@RequestBody FacilityDto dto) {
        facilityService.addClub(dto);
    }

    // --- GET FACILITIES (View Lists) ---

    @GetMapping("/get-hostels")
    public List<FacilityDto> getHostels() {
        return facilityService.getAllHostels();
    }

    @GetMapping("/get-transports")
    public List<FacilityDto> getTransports() {
        return facilityService.getAllTransports();
    }

    @GetMapping("/get-canteens")
    public List<FacilityDto> getCanteens() {
        return facilityService.getAllCanteens();
    }

    @GetMapping("/get-clubs")
    public List<FacilityDto> getClubs() {
        return facilityService.getAllClubs();
    }

    // --- ALLOCATION (Assign Students) ---

    @PostMapping("/assign-hostel")
    public void assignHostel(@RequestBody FacilityAllocationDto dto) {
        facilityService.assignStudentToHostel(dto);
    }

    @PostMapping("/assign-transport")
    public void assignTransport(@RequestBody FacilityAllocationDto dto) {
        facilityService.assignStudentToTransport(dto);
    }

    @PostMapping("/assign-club")
    public void assignClub(@RequestBody FacilityAllocationDto dto) {
        facilityService.assignStudentToClub(dto);
    }
}