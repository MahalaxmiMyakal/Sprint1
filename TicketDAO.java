package dao;

import java.util.List;
import models.Ticket;

public interface TicketDAO {
    void bookTicket(Ticket ticket);
    void cancelTicket(int Ticket_Number);
    Ticket getTicketByTicketNumber(int ticketNumber);
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByPassengerId(int Passenger_ID);
}