package daoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.RouteDAO;
import models.Route;
import utils.HibernateUtil;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {
	
	@Override
	public void addRoute(Route route) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(route);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Route getRouteById(int Route_ID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Route.class, Route_ID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Route> getAllRoutes() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Route", Route.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateRoute(Route route) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.update(route);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRoute(int Route_ID) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Route route = session.get(Route.class, Route_ID);
			if (route != null) {
				session.delete(route);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}
}