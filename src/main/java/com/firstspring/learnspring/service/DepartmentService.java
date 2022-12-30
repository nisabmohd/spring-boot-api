package com.firstspring.learnspring.service;

import com.firstspring.learnspring.entity.Department;

import java.util.List;

public interface DepartmentService {
     Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartment(Long departmentId);

    String deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String deptName);
}
