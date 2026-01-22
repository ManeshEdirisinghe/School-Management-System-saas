package com.myschool.service;

import com.myschool.dto.SchoolDto;
import java.util.List;

public interface SchoolService {
    void addSchool(SchoolDto schoolDto);
    List<SchoolDto> getAllSchools();
}