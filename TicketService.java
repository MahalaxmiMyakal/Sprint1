package service;

import java.util.List;
import models.Ticket;

public interface TicketService {
    void bookTicket(Ticket ticket);
    void cancelTicket(int Ticket_Number);
    Ticket getTicketByTicketNumber(int ticketNumber);
    List<Ticket> getTicketsByPassengerId(int Passenger_ID);
    List<Ticket> getAllTickets();
}