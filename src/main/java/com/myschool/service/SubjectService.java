package com.myschool.service;

import com.myschool.dto.SubjectDto;
import java.util.List;

public interface SubjectService {
    void addSubject(SubjectDto subjectDto);
    List<SubjectDto> getAllSubjects();
}