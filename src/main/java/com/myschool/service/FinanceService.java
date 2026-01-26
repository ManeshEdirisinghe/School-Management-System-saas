package com.myschool.service;

import com.myschool.dto.*;
import java.util.List;

public interface FinanceService {
    void createFeeCategory(FeeCategoryDto dto);
    void createFeeStructure(FeeStructureDto dto);
    void assignFeeToStudent(StudentFeeDto dto);
    void makePayment(Integer studentFeeId, Double amount);

    List<FeeStructureDto> getFeesByClass(Integer classId);
    List<StudentFeeDto> getFeesByStudent(Integer studentId);
}