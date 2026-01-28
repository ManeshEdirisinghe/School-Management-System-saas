package com.myschool.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class FacilityAllocationDto {
    private Integer id;
    private Integer studentId;

    private Integer hostelId;
    private Integer transportId;
    private Integer clubId;

    private String role; // For clubs
    private LocalDate assignedDate;
    private Boolean isActive;
}