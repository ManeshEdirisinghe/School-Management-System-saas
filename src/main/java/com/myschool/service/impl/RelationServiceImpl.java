package com.myschool.service.impl;

import com.myschool.dto.StudentParentDto;
import com.myschool.entity.ParentEntity;
import com.myschool.entity.StudentEntity;
import com.myschool.entity.StudentParentEntity;
import com.myschool.entity.key.StudentParentKey;
import com.myschool.repository.ParentRepository;
import com.myschool.repository.StudentParentRepository;
import com.myschool.repository.StudentRepository;
import com.myschool.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelationServiceImpl implements RelationService {

    private final StudentParentRepository relationRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @Override
    public void addStudentParentRelation(StudentParentDto dto) {
        // 1. Key එක හදාගන්නවා
        StudentParentKey key = new StudentParentKey();
        key.setStudentId(dto.getStudentId());
        key.setParentId(dto.getParentId());

        // 2. Entity එක හදලා Data පුරවනවා
        StudentParentEntity entity = new StudentParentEntity();
        entity.setId(key);
        entity.setRelationship(dto.getRelationship());
        entity.setIsEmergencyContact(dto.getIsEmergencyContact());

        // 3. Student සහ Parent Objects හොයලා set කරනවා (JPA වලට ඕන නිසා)
        StudentEntity student = studentRepository.findById(dto.getStudentId()).orElse(null);
        ParentEntity parent = parentRepository.findById(dto.getParentId()).orElse(null);

        if (student != null && parent != null) {
            entity.setStudent(student);
            entity.setParent(parent);
            // 4. Save කරනවා
            relationRepository.save(entity);
        }
    }
}