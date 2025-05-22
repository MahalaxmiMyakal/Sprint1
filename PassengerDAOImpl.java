package daoImplementation;

import dao.PassengerDAO;
import models.Admin;
import models.Bus;
import models.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import utils.HibernateUtil;
import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {
	
	@Override
	public void savePassenger(Passenger passenger) {
	    Transaction transaction = null;
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        transaction = session.beginTransaction();
	        session.save(passenger);
	        transaction.commit();
	        
	    } catch (Exception e) {
	        if (transaction != null && transaction.getStatus().canRollback()) {
	            transaction.rollback();
	        }
	        System.out.println("Error while saving passenger: " + e.getMessage());
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}



	@Override
	public Passenger getPassengerByEmailAndPassword(String email, String password) {
        Passenger passenger = null;
        Transaction tx = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Query<Passenger> query = session.createQuery("from Passenger where passenger_email = :email and passenger_password = :password", Passenger.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            passenger = query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return passenger;
    }


	@Override
	public Passenger getPassengerById(int Passenger_ID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Passenger.class, Passenger_ID);
		}
	}

	@Override
	public List<Passenger> getAllPassengers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Passenger", Passenger.class).list();
		}
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.update(passenger);
			transaction.commit();
			System.out.println("Passenger updated successfully.");
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deletePassenger(int Passenger_ID) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Passenger passenger = session.get(Passenger.class, Passenger_ID);
			if (passenger != null) {
				session.delete(passenger);
				System.out.println("Passenger deleted successfully.");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}
}