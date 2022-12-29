package com.firstspring.learnspring.service;

import com.firstspring.learnspring.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartment(Long departmentId);

    String deleteDepartment(Long id);
}
