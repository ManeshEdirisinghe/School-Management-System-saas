package com.myschool.controller;

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

    @GetMapping("/get-hostels")
    public List<FacilityDto> getHostels() {
        return facilityService.getAllHostels();
    }
}