package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs138185169.entity.ProjectManager;

@Repository
public interface ProjectManagerRepo extends JpaRepository<ProjectManager, Integer> {

}