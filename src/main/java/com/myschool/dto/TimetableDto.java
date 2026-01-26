package com.myschool.dto;
import lombok.Data;

@Data
public class TimetableDto {
    private Integer timetableId;
    private Integer classId;
    private String dayOfWeek;
    private Integer timeSlotId;
    private Integer classSubjectId;
}