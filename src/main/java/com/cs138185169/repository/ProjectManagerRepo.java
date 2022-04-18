package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.cs138185169.entity.ProjectManager;

@Repository
public interface ProjectManagerRepo extends JpaRepository<ProjectManager, Integer> {
    @Query("SELECT pm from ProjectManager pm WHERE pm.pid = ?1")
    Optional<List<ProjectManager>> getAllProjectManagersByPid(int pid);
}