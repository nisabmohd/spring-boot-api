package com.firstspring.learnspring.controller;

import com.firstspring.learnspring.entity.Department;
import com.firstspring.learnspring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
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
}
