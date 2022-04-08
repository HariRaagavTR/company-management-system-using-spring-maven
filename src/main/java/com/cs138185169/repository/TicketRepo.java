package com.cs138185169.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs138185169.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}