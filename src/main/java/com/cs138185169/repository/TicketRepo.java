package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

import com.cs138185169.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t from Ticket t WHERE t.pid = ?1")
    Optional<List<Ticket>> getAllTicketsByPid(int pid);
}