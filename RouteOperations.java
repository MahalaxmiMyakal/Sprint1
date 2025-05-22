package operations;

import service.RouteService;
import serviceImplementation.RouteServiceImpl;
import dao.AdminDAO;
import dao.RouteDAO;
import daoImplementation.RouteDAOImpl;
import daoImplementation.AdminDAOImpl;
import java.util.List;
import java.util.Scanner;
import models.Admin;
import models.Route;

public class RouteOperations {

	private static RouteService routeService = new RouteServiceImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void routeMenu(RouteOperations routeOps) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("---------- Route Management ----------");
			System.out.println("1️. Add Route");
			System.out.println("2️. View Route by ID");
			System.out.println("3️. View All Routes");
			System.out.println("4️. Update Route");
			System.out.println("5️. Delete Route");
			System.out.println("6️. Back to Main Menu");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				routeOps.addRoute();
				break;
			case 2:
				routeOps.viewRoute();
				break;
			case 3:
				routeOps.viewAllRoutes();
				break;
			case 4:
				routeOps.updateRoute();
				break;
			case 5:
				routeOps.deleteRoute();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}

	public static void addRoute() {
		AdminDAO adminDAO = new AdminDAOImpl();
		RouteDAO routeDAO = new RouteDAOImpl();

		System.out.print("Enter Admin ID: ");
		int adminId = scanner.nextInt();
		scanner.nextLine();

		Admin admin = adminDAO.getAdminById(adminId); 
		if (admin == null) {
			System.out.println("Admin ID not found! Please enter a valid Admin ID.");
			return; 
		}

		System.out.print("Enter Pickup Point : ");
		String pickupPoint = scanner.nextLine();

		System.out.print("Enter Route Point : ");
		String routePoint = scanner.nextLine();

		Route route = new Route();

		route.setPick_up_Point(pickupPoint);
		route.setRoute_Point(routePoint);
		route.setAdmin(admin);
		
		routeDAO.addRoute(route);
		System.out.println("Route added successfully!");
	}

	public static void viewRoute() {
		System.out.print("Enter Route ID: ");
		int id = scanner.nextInt();

		Route route = routeService.getRouteById(id);
		if (route != null) {
			System.out.println("\n🔹 Route Found:");
			System.out.println("ID: " + route.getRoute_Id());
			System.out.println("Pickup Point: " + route.getPick_up_Point());
			System.out.println("Route Point: " + route.getRoute_Point());
		} else {
			System.out.println("Route not found.");
		}
	}

	public static void viewAllRoutes() {
		List<Route> routes = routeService.getAllRoutes();
		if (routes.isEmpty()) {
			System.out.println("No Route records found.");
		} else {
			System.out.println("All Routes");
			for (Route route : routes) {
				System.out.println(route.getRoute_Id() + " | Pickup: " + route.getPick_up_Point() + " → Route: " + route.getRoute_Point());
			}
		}
	}

	public static void updateRoute() {
		System.out.print("Enter Route ID to update : ");
		int id = scanner.nextInt();

		Route route = routeService.getRouteById(id);
		if (route != null) {
			System.out.print("Enter New Pickup Point : ");
			route.setPick_up_Point(scanner.next());

			System.out.print("Enter New Route Point : ");
			route.setRoute_Point(scanner.next());

			routeService.updateRoute(route);
			System.out.println("Route updated successfully!");
		} else {
			System.out.println("Route not found.");
		}
	}

	public static void deleteRoute() {
		System.out.print("Enter Route ID to delete : ");
		int id = scanner.nextInt();

		routeService.deleteRoute(id);
		System.out.println("Route deleted successfully!");
	}
}