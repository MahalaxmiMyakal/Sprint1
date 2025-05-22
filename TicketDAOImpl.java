package daoImplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.TicketDAO;
import daoImplementation.TicketDAOImpl;

import models.Ticket;
import utils.HibernateUtil;

public class TicketDAOImpl implements TicketDAO {

    @Override
    public void bookTicket(Ticket ticket) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(ticket);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void cancelTicket(int ticketId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            if (ticket != null) {
                session.delete(ticket);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Ticket getTicketByTicketNumber(int ticketNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Ticket ticket = null;
        try {
            ticket = session.get(Ticket.class, ticketNumber);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getTicketsByPassengerId(int passengerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ticket WHERE passenger.id = :pid", Ticket.class)
                    	  .setParameter("pid", passengerId)
                          .list();
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ticket", Ticket.class).list();
        }
    }
}