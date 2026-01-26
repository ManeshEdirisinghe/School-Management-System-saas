package com.myschool.dto;
import lombok.Data;
import java.time.LocalTime;

@Data
public class TimeSlotDto {
    private Integer timeSlotId;
    private Integer schoolId;
    private LocalTime startTime;
    private LocalTime endTime;
}