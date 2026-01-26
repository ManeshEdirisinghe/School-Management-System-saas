package com.myschool.dto;
import lombok.Data;

@Data
public class FacilityDto {
    // Common ID field (can be hostelId, transportId etc.)
    private Integer id;
    private Integer schoolId;

    // For Hostel
    private String hostelType;
    private Integer capacity;

    // For Transport
    private String busNo;
    private String route;
    private String driverName;

    // For Canteen
    private String canteenType;
    private String openingHours;

    // For Club
    private String clubName;
    private Integer teacherInChargeId;
}