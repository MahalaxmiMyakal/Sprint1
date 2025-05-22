package daoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.BusDAO;
import models.Bus;
import utils.HibernateUtil;
import java.util.List;

public class BusDAOImpl implements BusDAO {
	
	@Override
	public void addBus(Bus bus) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction(); 
			session.save(bus); 
			transaction.commit();  
	
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();  
			}
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();  
			}
		}
	}

	@Override
	public Bus getBusByNumber(int Bus_Number) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Bus.class, Bus_Number);
		}
	}

	@Override
	public List<Bus> getAllBuses() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Bus", Bus.class).list();
		}
	}

	@Override
	public void updateBus(Bus bus) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.update(bus);
			transaction.commit();
			System.out.println("✅ Bus Updated Successfully!");
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBus(int Bus_Number) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Bus bus = session.get(Bus.class, Bus_Number);
			if (bus != null) {
				session.delete(bus);
				System.out.println("✅ Bus Deleted Successfully!");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}
}