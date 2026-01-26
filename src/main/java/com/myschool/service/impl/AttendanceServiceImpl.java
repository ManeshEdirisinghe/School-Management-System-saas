package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.StudentAttendanceDto;
import com.myschool.entity.StudentAttendanceEntity;
import com.myschool.repository.ClassRepository;
import com.myschool.repository.StudentAttendanceRepository;
import com.myschool.repository.StudentRepository;
import com.myschool.service.AttendanceService;
import com.myschool.util.AttendanceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentAttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final ObjectMapper mapper;

    @Override
    public void markAttendance(StudentAttendanceDto dto) {
        StudentAttendanceEntity entity = new StudentAttendanceEntity();

        if (dto.getAttendanceId() != null) {
            entity = attendanceRepository.findById(dto.getAttendanceId())
                    .orElse(new StudentAttendanceEntity());
        }

        entity.setDate(dto.getDate());
        entity.setStatus(AttendanceStatus.valueOf(dto.getStatus()));
        entity.setRemarks(dto.getRemarks());

        entity.setStudent(studentRepository.findById(dto.getStudentId()).orElse(null));
        entity.setCurrentClass(classRepository.findById(dto.getClassId()).orElse(null));

        attendanceRepository.save(entity);
    }

    @Override
    public List<StudentAttendanceDto> getStudentAttendance(Integer studentId) {
        List<StudentAttendanceEntity> list = attendanceRepository.findByStudentStudentId(studentId);
        return convertToDtoList(list);
    }

    @Override
    public List<StudentAttendanceDto> getClassAttendanceByDate(Integer classId, LocalDate date) {
        List<StudentAttendanceEntity> list = attendanceRepository.findByCurrentClassClassIdAndDate(classId, date);
        return convertToDtoList(list);
    }

    private List<StudentAttendanceDto> convertToDtoList(List<StudentAttendanceEntity> list) {
        List<StudentAttendanceDto> dtos = new ArrayList<>();
        for (StudentAttendanceEntity entity : list) {
            StudentAttendanceDto dto = mapper.convertValue(entity, StudentAttendanceDto.class);
            dto.setStudentId(entity.getStudent().getStudentId());
            dto.setClassId(entity.getCurrentClass().getClassId());
            dtos.add(dto);
        }
        return dtos;
    }
}