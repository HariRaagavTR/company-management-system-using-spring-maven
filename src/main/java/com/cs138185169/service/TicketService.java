package com.cs138185169.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs138185169.entity.Ticket;
import com.cs138185169.repository.TicketRepo;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    public void addTicket(Ticket newTicket) {
        ticketRepo.save(newTicket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Ticket getTicketById(int id) {
        Optional<Ticket> returnedTicket = ticketRepo.findById(id);
        if (returnedTicket.isPresent()) {
            return returnedTicket.get();
        }
        return null;
    }

    public void deleteTicket(int id) {
        ticketRepo.deleteById(id);
    }

    public List<Ticket> getTicketByPid(int pid) {
        Optional<List<Ticket>> returnedTickets = ticketRepo.getAllTicketsByPid(pid);
        if (returnedTickets.isPresent()) {
            return returnedTickets.get();
        }
        return null;
    }

    public List<Ticket> getTicketBySeid(int seid) {
        Optional<List<Ticket>> returnedTickets = ticketRepo.getAllTicketsBySeid(seid);
        if (returnedTickets.isPresent()) {
            return returnedTickets.get();
        }
        return null;
    }
}