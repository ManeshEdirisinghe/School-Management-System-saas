package com.myschool.controller;

import com.myschool.dto.*;
import com.myschool.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
@CrossOrigin
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeService;

    @PostMapping("/create-category")
    public void createCategory(@RequestBody FeeCategoryDto dto) {
        financeService.createFeeCategory(dto);
    }

    @PostMapping("/create-structure")
    public void createStructure(@RequestBody FeeStructureDto dto) {
        financeService.createFeeStructure(dto);
    }

    @PostMapping("/assign-fee")
    public void assignFee(@RequestBody StudentFeeDto dto) {
        financeService.assignFeeToStudent(dto);
    }

    @PutMapping("/pay/{studentFeeId}/{amount}")
    public void makePayment(@PathVariable Integer studentFeeId, @PathVariable Double amount) {
        financeService.makePayment(studentFeeId, amount);
    }

    @GetMapping("/get-by-student/{studentId}")
    public List<StudentFeeDto> getByStudent(@PathVariable Integer studentId) {
        return financeService.getFeesByStudent(studentId);
    }
}