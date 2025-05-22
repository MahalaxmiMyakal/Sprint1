package dao;

import java.util.List;
import models.Route;

public interface RouteDAO {
	void addRoute(Route route);
	Route getRouteById(int Route_ID);
	List<Route> getAllRoutes();
	void updateRoute(Route route);
	void deleteRoute(int Route_ID);
}