package serviceImplementation;

import dao.RouteDAO;
import daoImplementation.RouteDAOImpl;
import models.Route;
import service.RouteService;
import serviceImplementation.RouteServiceImpl;
import java.util.List;

public class RouteServiceImpl implements RouteService {
	
    private RouteDAO routeDAO = new RouteDAOImpl();

    @Override
    public void addRoute(Route route) {
        routeDAO.addRoute(route);
    }

    @Override
    public Route getRouteById(int Route_ID) {
        return routeDAO.getRouteById(Route_ID);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeDAO.getAllRoutes();
    }

    @Override
    public void updateRoute(Route route) {
        routeDAO.updateRoute(route);
    }

    @Override
    public void deleteRoute(int Route_ID) {
        routeDAO.deleteRoute(Route_ID);
    }
}