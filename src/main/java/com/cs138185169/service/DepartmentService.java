package com.cs138185169.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs138185169.entity.Department;
import com.cs138185169.repository.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public void addDepartment(Department newDepartment) {
        departmentRepo.save(newDepartment);
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(int id) {
        Optional<Department> returnedDepartment = departmentRepo.findById(id);
        if (returnedDepartment.isPresent()) {
            return returnedDepartment.get();
        }
        return null;
    }

    public void deleteDepartment(int id) {
        departmentRepo.deleteById(id);
    }
}