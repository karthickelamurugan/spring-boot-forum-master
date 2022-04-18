package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.dto.DepartmentDto;
import com.programming.techie.springredditclone.exceptions.SpringRedditException;
import com.programming.techie.springredditclone.mapper.DepartmentMapper;
import com.programming.techie.springredditclone.model.Department;
import com.programming.techie.springredditclone.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository DepartmentRepository;
    private final DepartmentMapper DepartmentMapper;

    @Transactional
    public DepartmentDto save(DepartmentDto DepartmentDto) {
        Department save = DepartmentRepository.save(DepartmentMapper.mapDtoToDepartment(DepartmentDto));
        DepartmentDto.setId(save.getId());
        return DepartmentDto;
    }

    @Transactional(readOnly = true)
    public List<DepartmentDto> getAll() {
        return DepartmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::mapDepartmentToDto)
                .collect(toList());
    }

    public DepartmentDto getDepartment(Long id) {
        Department Department = DepartmentRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No Department found with ID - " + id));
        return DepartmentMapper.mapDepartmentToDto(Department);
    }
}
