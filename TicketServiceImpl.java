package serviceImplementation;

import java.util.List;

import service.TicketService;
import dao.TicketDAO;
import daoImplementation.TicketDAOImpl;
import models.Ticket;

public class TicketServiceImpl implements TicketService {

    private TicketDAO ticketDAO = new TicketDAOImpl();

    @Override
    public void bookTicket(Ticket ticket) {
        ticketDAO.bookTicket(ticket);
    }

    @Override
    public void cancelTicket(int Ticket_Number) {
        ticketDAO.cancelTicket(Ticket_Number);
    }

    @Override
    public Ticket getTicketByTicketNumber(int ticketNumber) {
        return ticketDAO.getTicketByTicketNumber(ticketNumber);
    }

    @Override
    public List<Ticket> getTicketsByPassengerId(int Passenger_ID) {
        return ticketDAO.getTicketsByPassengerId(Passenger_ID);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }
}