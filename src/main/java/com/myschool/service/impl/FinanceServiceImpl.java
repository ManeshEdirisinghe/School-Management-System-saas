package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.*;
import com.myschool.entity.*;
import com.myschool.repository.*;
import com.myschool.service.FinanceService;
import com.myschool.util.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {

    private final FeeCategoryRepository feeCategoryRepository;
    private final FeeStructureRepository feeStructureRepository;
    private final StudentFeeRepository studentFeeRepository;

    private final SchoolRepository schoolRepository;
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    private final ObjectMapper mapper;

    @Override
    public void createFeeCategory(FeeCategoryDto dto) {
        FeeCategoryEntity entity = mapper.convertValue(dto, FeeCategoryEntity.class);
        entity.setSchool(schoolRepository.findById(dto.getSchoolId()).orElse(null));
        feeCategoryRepository.save(entity);
    }

    @Override
    public void createFeeStructure(FeeStructureDto dto) {
        FeeStructureEntity entity = new FeeStructureEntity();
        entity.setAmount(dto.getAmount());
        entity.setCurrentClass(classRepository.findById(dto.getClassId()).orElse(null));
        entity.setFeeCategory(feeCategoryRepository.findById(dto.getFeeCategoryId()).orElse(null));
        feeStructureRepository.save(entity);
    }

    @Override
    public void assignFeeToStudent(StudentFeeDto dto) {
        StudentFeeEntity entity = new StudentFeeEntity();
        entity.setDueDate(dto.getDueDate());
        entity.setAmountPaid(0.0);
        entity.setStatus(PaymentStatus.UNPAID);

        entity.setStudent(studentRepository.findById(dto.getStudentId()).orElse(null));
        entity.setFeeStructure(feeStructureRepository.findById(dto.getFeeStructureId()).orElse(null));

        studentFeeRepository.save(entity);
    }

    @Override
    public void makePayment(Integer studentFeeId, Double amount) {
        StudentFeeEntity fee = studentFeeRepository.findById(studentFeeId).orElse(null);
        if (fee != null) {
            double totalPaid = fee.getAmountPaid() + amount;
            fee.setAmountPaid(totalPaid);

            Double totalAmount = fee.getFeeStructure().getAmount();

            if (totalPaid >= totalAmount) {
                fee.setStatus(PaymentStatus.PAID);
            } else {
                fee.setStatus(PaymentStatus.PARTIALLY_PAID);
            }
            studentFeeRepository.save(fee);
        }
    }

    @Override
    public List<FeeStructureDto> getFeesByClass(Integer classId) {
        List<FeeStructureEntity> list = feeStructureRepository.findByCurrentClassClassId(classId);
        List<FeeStructureDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            FeeStructureDto dto = mapper.convertValue(e, FeeStructureDto.class);
            dto.setClassId(e.getCurrentClass().getClassId());
            dto.setFeeCategoryId(e.getFeeCategory().getFeeCategoryId());
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    public List<StudentFeeDto> getFeesByStudent(Integer studentId) {
        List<StudentFeeEntity> list = studentFeeRepository.findByStudentStudentId(studentId);
        List<StudentFeeDto> dtos = new ArrayList<>();
        list.forEach(e -> {
            StudentFeeDto dto = mapper.convertValue(e, StudentFeeDto.class);
            dto.setStudentId(e.getStudent().getStudentId());
            dto.setFeeStructureId(e.getFeeStructure().getFeeStructureId());
            dtos.add(dto);
        });
        return dtos;
    }
}