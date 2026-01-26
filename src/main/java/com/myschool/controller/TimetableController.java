package com.myschool.controller;

import com.myschool.dto.*;
import com.myschool.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetable")
@CrossOrigin
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @PostMapping("/assign-subject")
    public void assignSubject(@RequestBody ClassSubjectDto dto) {
        timetableService.assignSubjectToClass(dto);
    }

    @PostMapping("/create-timeslot")
    public void createTimeSlot(@RequestBody TimeSlotDto dto) {
        timetableService.createTimeSlot(dto);
    }

    @PostMapping("/create-entry")
    public void createTimetableEntry(@RequestBody TimetableDto dto) {
        timetableService.createTimetableEntry(dto);
    }

    @GetMapping("/get-by-class/{classId}")
    public List<TimetableDto> getTimetable(@PathVariable Integer classId) {
        return timetableService.getTimetableByClass(classId);
    }

    @GetMapping("/get-subjects-by-class/{classId}")
    public List<ClassSubjectDto> getSubjectsByClass(@PathVariable Integer classId) {
        return timetableService.getSubjectsByClass(classId);
    }
}