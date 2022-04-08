package com.cs138185169.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs138185169.entity.ProjectManager;
import com.cs138185169.repository.ProjectManagerRepo;

@Service
public class ProjectManagerService {
    @Autowired
    private ProjectManagerRepo projectManagerRepo;

    public void addProjectManager(ProjectManager newProjectManager) {
        projectManagerRepo.save(newProjectManager);
    }

    public List<ProjectManager> getAllProjectManagers() {
        return projectManagerRepo.findAll();
    }

    public ProjectManager getProjectManagerById(int id) {
        Optional<ProjectManager> returnedProjectManager = projectManagerRepo.findById(id);
        if (returnedProjectManager.isPresent()) {
            return returnedProjectManager.get();
        }
        return null;
    }

    public void deleteProjectManager(int id) {
        projectManagerRepo.deleteById(id);
    }
}