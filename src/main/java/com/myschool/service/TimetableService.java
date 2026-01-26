package com.myschool.service;

import com.myschool.dto.ClassSubjectDto;
import com.myschool.dto.TimeSlotDto;
import com.myschool.dto.TimetableDto;
import java.util.List;

public interface TimetableService {
    void assignSubjectToClass(ClassSubjectDto dto);
    void createTimeSlot(TimeSlotDto dto);
    void createTimetableEntry(TimetableDto dto);

    List<TimetableDto> getTimetableByClass(Integer classId);
    List<ClassSubjectDto> getSubjectsByClass(Integer classId);
}