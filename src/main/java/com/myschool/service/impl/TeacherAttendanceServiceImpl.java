package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.TeacherAttendanceDto;
import com.myschool.entity.TeacherAttendanceEntity;
import com.myschool.repository.TeacherAttendanceRepository;
import com.myschool.repository.TeacherRepository;
import com.myschool.service.TeacherAttendanceService;
import com.myschool.util.AttendanceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherAttendanceServiceImpl implements TeacherAttendanceService {

    private final TeacherAttendanceRepository attendanceRepository;
    private final TeacherRepository teacherRepository;
    private final ObjectMapper mapper;

    @Override
    public void markAttendance(TeacherAttendanceDto dto) {
        TeacherAttendanceEntity entity = new TeacherAttendanceEntity();

        if (dto.getAttendanceId() != null) {
            entity = attendanceRepository.findById(dto.getAttendanceId())
                    .orElse(new TeacherAttendanceEntity());
        }

        entity.setDate(dto.getDate());
        entity.setStatus(AttendanceStatus.valueOf(dto.getStatus()));
        entity.setRemarks(dto.getRemarks());

        entity.setTeacher(teacherRepository.findById(dto.getTeacherId()).orElse(null));

        attendanceRepository.save(entity);
    }

    @Override
    public List<TeacherAttendanceDto> getAttendanceByTeacher(Integer teacherId) {
        List<TeacherAttendanceEntity> list = attendanceRepository.findByTeacherTeacherId(teacherId);
        return convertToDtoList(list);
    }

    @Override
    public List<TeacherAttendanceDto> getAttendanceByDate(LocalDate date) {
        List<TeacherAttendanceEntity> list = attendanceRepository.findByDate(date);
        return convertToDtoList(list);
    }

    private List<TeacherAttendanceDto> convertToDtoList(List<TeacherAttendanceEntity> list) {
        List<TeacherAttendanceDto> dtos = new ArrayList<>();
        for (TeacherAttendanceEntity entity : list) {
            TeacherAttendanceDto dto = mapper.convertValue(entity, TeacherAttendanceDto.class);
            dto.setTeacherId(entity.getTeacher().getTeacherId());
            dtos.add(dto);
        }
        return dtos;
    }
}