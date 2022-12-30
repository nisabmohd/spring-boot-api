package com.firstspring.learnspring.controller;

import com.firstspring.learnspring.entity.Department;
import com.firstspring.learnspring.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;
    private final Logger LOGGER= LoggerFactory.getLogger(Department.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info(department.toString());
        return service.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return service.getDepartments();
    }
    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId){
        return service.getDepartment(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        return service.deleteDepartment(departmentId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,@RequestBody Department  department){
        return service.updateDepartment(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String deptName){
        return service.getDepartmentByName(deptName);
    }
}
