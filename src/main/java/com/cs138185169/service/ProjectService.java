package com.cs138185169.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs138185169.entity.Project;
import com.cs138185169.repository.ProjectRepo;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public void addProject(Project newProject) {
        projectRepo.save(newProject);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(int id) {
        Optional<Project> returnedProject = projectRepo.findById(id);
        if (returnedProject.isPresent()) {
            return returnedProject.get();
        }
        return null;
    }

    public void deleteProject(int id) {
        projectRepo.deleteById(id);
    }
}