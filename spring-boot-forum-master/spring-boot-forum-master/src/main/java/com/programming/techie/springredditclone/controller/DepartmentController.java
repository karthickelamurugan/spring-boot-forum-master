package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.dto.DepartmentDto;
import com.programming.techie.springredditclone.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService DepartmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto DepartmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(DepartmentService.save(DepartmentDto));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DepartmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DepartmentService.getDepartment(id));
    }
}
