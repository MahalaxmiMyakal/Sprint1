package daoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.AdminDAO;
import models.Admin;
import models.Passenger;
import utils.HibernateUtil;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
	
	@Override
	public void saveAdmin(Admin admin) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(admin);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
	
	@Override
	public Admin getAdminByEmailAndPassword(String email, String password) {
        Admin admin = null;
        Transaction tx = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession(); 
            tx = session.beginTransaction();

            Query<Admin> query = session.createQuery("from Admin where Admin_Email = :email and Admin_Password = :password", Admin.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            admin = query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return admin;
    }
	
	@Override
	public Admin getAdminById(int Admin_ID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Admin.class, Admin_ID);
		}
	}

	@Override
	public List<Admin> getAllAdmins() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Admin", Admin.class).list();
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.update(admin);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAdmin(int Admin_ID) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Admin admin = session.get(Admin.class, Admin_ID);
			if (admin != null) {
				session.delete(admin);
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}
}