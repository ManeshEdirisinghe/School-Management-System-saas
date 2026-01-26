package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "timetables")
public class TimetableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timetableId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity currentClass;

    private String dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "timeslot_id")
    private TimeSlotEntity timeSlot;

    @ManyToOne
    @JoinColumn(name = "class_subject_id")
    private ClassSubjectEntity classSubject;
}