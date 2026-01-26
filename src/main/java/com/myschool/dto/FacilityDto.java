package com.myschool.dto;
import lombok.Data;

@Data
public class FacilityDto {
    private Integer id;
    private Integer schoolId;

    private String hostelType;
    private Integer capacity;

    private String busNo;
    private String route;
    private String driverName;

    private String canteenType;
    private String openingHours;

    private String clubName;
    private Integer teacherInChargeId;
}