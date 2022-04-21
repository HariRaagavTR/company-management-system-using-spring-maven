package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.cs138185169.entity.SoftwareEngineer;

@Repository
public interface SoftwareEngineerRepo extends JpaRepository<SoftwareEngineer, Integer> {
    @Query("SELECT se.seid from SoftwareEngineer se")
    Optional<List<Integer>> getAllSeid();
}