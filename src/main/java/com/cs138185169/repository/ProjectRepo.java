package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.cs138185169.entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    @Query("SELECT p FROM Project p WHERE p.did = ?1")
    Optional<List<Project>> findAllProjectsByDid(int did);
}