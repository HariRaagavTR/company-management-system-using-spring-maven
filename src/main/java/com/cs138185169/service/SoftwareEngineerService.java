package com.cs138185169.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs138185169.entity.SoftwareEngineer;
import com.cs138185169.repository.SoftwareEngineerRepo;

@Service
public class SoftwareEngineerService {
    @Autowired
    private SoftwareEngineerRepo softwareEngineerRepo;

    public void addSoftwareEngineer(SoftwareEngineer newSoftwareEngineer) {
        softwareEngineerRepo.save(newSoftwareEngineer);
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepo.findAll();
    }

    public List<Integer> getAllSeid() {
        Optional<List<Integer>> allSeids = softwareEngineerRepo.getAllSeid();
        if (allSeids.isPresent()) {
            return allSeids.get();
        }
        return null;
    }

    public SoftwareEngineer getSoftwareEngineerById(int id) {
        Optional<SoftwareEngineer> returnedSoftwareEngineer = softwareEngineerRepo.findById(id);
        if (returnedSoftwareEngineer.isPresent()) {
            return returnedSoftwareEngineer.get();
        }
        return null;
    }

    public void deleteSoftwareEngineer(int id) {
        softwareEngineerRepo.deleteById(id);
    }
}