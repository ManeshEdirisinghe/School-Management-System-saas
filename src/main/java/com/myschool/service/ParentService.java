package com.myschool.service;

import com.myschool.dto.ParentDto;
import java.util.List;

public interface ParentService {
    void addParent(ParentDto parentDto);
    List<ParentDto> getAllParents();
}