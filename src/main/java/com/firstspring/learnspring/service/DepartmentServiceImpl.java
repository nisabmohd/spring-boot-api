package com.firstspring.learnspring.service;

import com.firstspring.learnspring.entity.Department;
import com.firstspring.learnspring.error.DepartmentNotFoundException;
import com.firstspring.learnspring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

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
    public Department getDepartment(Long departmentId) throws Exception {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException("No such department found"));
    }

    @Override
    public String deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentFromDb = departmentRepository.findById(id).get();
        if (department.getDepartmentName() != null) {
            departmentFromDb.setDepartmentName(department.getDepartmentName());
        }
        if (department.getDepartmentAddress() != null) {
            departmentFromDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (department.getDepartmentCode() != null) {
            departmentFromDb.setDepartmentCode(department.getDepartmentCode());
        }
        departmentRepository.save(departmentFromDb);
        return departmentFromDb;
    }

    @Override
    public Department getDepartmentByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }


}
