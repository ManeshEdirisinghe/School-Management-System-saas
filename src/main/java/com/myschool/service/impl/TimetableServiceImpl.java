package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.*;
import com.myschool.entity.*;
import com.myschool.repository.*;
import com.myschool.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {

    private final ClassSubjectRepository classSubjectRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final TimetableRepository timetableRepository;

    private final ClassRepository classRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;

    private final ObjectMapper mapper;

    @Override
    public void assignSubjectToClass(ClassSubjectDto dto) {
        ClassSubjectEntity entity = new ClassSubjectEntity();
        entity.setCurrentClass(classRepository.findById(dto.getClassId()).orElse(null));
        entity.setSubject(subjectRepository.findById(dto.getSubjectId()).orElse(null));
        entity.setTeacher(teacherRepository.findById(dto.getTeacherId()).orElse(null));
        classSubjectRepository.save(entity);
    }

    @Override
    public void createTimeSlot(TimeSlotDto dto) {
        TimeSlotEntity entity = mapper.convertValue(dto, TimeSlotEntity.class);
        entity.setSchool(schoolRepository.findById(dto.getSchoolId()).orElse(null));
        timeSlotRepository.save(entity);
    }

    @Override
    public void createTimetableEntry(TimetableDto dto) {
        TimetableEntity entity = new TimetableEntity();
        entity.setDayOfWeek(dto.getDayOfWeek());

        entity.setCurrentClass(classRepository.findById(dto.getClassId()).orElse(null));
        entity.setTimeSlot(timeSlotRepository.findById(dto.getTimeSlotId()).orElse(null));
        entity.setClassSubject(classSubjectRepository.findById(dto.getClassSubjectId()).orElse(null));

        timetableRepository.save(entity);
    }

    @Override
    public List<TimetableDto> getTimetableByClass(Integer classId) {
        List<TimetableEntity> list = timetableRepository.findByCurrentClassClassId(classId);
        List<TimetableDto> dtos = new ArrayList<>();
        for (TimetableEntity entity : list) {
            TimetableDto dto = mapper.convertValue(entity, TimetableDto.class);
            dto.setClassId(entity.getCurrentClass().getClassId());
            dto.setTimeSlotId(entity.getTimeSlot().getTimeSlotId());
            dto.setClassSubjectId(entity.getClassSubject().getClassSubjectId());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<ClassSubjectDto> getSubjectsByClass(Integer classId) {
        List<ClassSubjectEntity> list = classSubjectRepository.findByCurrentClassClassId(classId);
        List<ClassSubjectDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            ClassSubjectDto dto = mapper.convertValue(e, ClassSubjectDto.class);
            dto.setClassId(e.getCurrentClass().getClassId());
            dto.setSubjectId(e.getSubject().getSubjectId());
            dto.setTeacherId(e.getTeacher().getTeacherId());
            dtos.add(dto);
        });
        return dtos;
    }
}