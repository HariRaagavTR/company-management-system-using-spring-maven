package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs138185169.entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}