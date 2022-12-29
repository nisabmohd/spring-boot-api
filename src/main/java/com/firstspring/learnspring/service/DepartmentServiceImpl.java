package com.firstspring.learnspring.service;

import com.firstspring.learnspring.entity.Department;
import com.firstspring.learnspring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public String deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return "Deleted";
    }


}
