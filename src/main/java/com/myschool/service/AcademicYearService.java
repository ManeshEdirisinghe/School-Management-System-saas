package com.myschool.service;

import com.myschool.dto.AcademicYearDto;
import java.util.List;

public interface AcademicYearService {
    void addYear(AcademicYearDto dto);
    List<AcademicYearDto> getAllYears();
}