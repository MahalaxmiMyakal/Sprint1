package operations;

import java.util.List;
import java.util.Scanner;
import dao.AdminDAO;
import dao.BusDAO;
import dao.RouteDAO;
import daoImplementation.AdminDAOImpl;
import daoImplementation.BusDAOImpl;
import daoImplementation.RouteDAOImpl;
import models.Admin;
import models.Bus;
import models.Route;
import service.BusService;
import serviceImplementation.BusServiceImpl;

public class BusOperations {
	
	private static BusService busService = new BusServiceImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void busMenu(BusOperations busOps) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("---------- Bus Management ----------");
			System.out.println("1️. Add Bus");
			System.out.println("2️. View Bus by ID");
			System.out.println("3️. View All Buses");
			System.out.println("4️. Update Bus");
			System.out.println("5️. Delete Bus");
			System.out.println("6️. Back to Main Menu");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				busOps.addBus();
				break;
			case 2:
				busOps.viewBusByNumber();
				break;
			case 3:
				busOps.viewAllBuses();
				break;
			case 4:
				busOps.updateBus();
				break;
			case 5:
				busOps.deleteBus();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}

	public static void addBus() {
		Scanner sc = new Scanner(System.in);
		BusDAO busDAO = new BusDAOImpl();
		AdminDAO adminDAO = new AdminDAOImpl();
		RouteDAO routeDAO = new RouteDAOImpl();

		System.out.print("Enter Admin ID : ");
		int adminId = sc.nextInt();

		Admin admin = adminDAO.getAdminById(adminId); 
		if (admin == null) {
			System.out.println("Admin ID not found! Please enter a valid Admin ID.");
			return; 
		}

		System.out.print("Enter Route ID : ");
		int routeId = sc.nextInt();

		Route route = routeDAO.getRouteById(routeId); 
		if (route == null) {
			System.out.println("Route ID not found! Please enter a valid Route ID.");
			return;
		}

		System.out.print("Enter Bus Number : ");
		int busNumber = sc.nextInt();

		System.out.print("Enter Total Seats : ");
		int totalSeat = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Available Seats : ");
		int availableSeat = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Departure Location : ");
		String departureLocation = sc.nextLine();

		System.out.print("Enter Departure Time : ");
		String departureTime = sc.nextLine();

		System.out.print("Enter Departure Date (YYYY-MM-DD) : ");
		String departureDate = sc.nextLine();

		System.out.print("Enter Source : ");
		String source = sc.nextLine();

		System.out.print("Enter Destination : ");
		String destination = sc.nextLine();

		System.out.print("Enter Arrival Time : ");
		String arrivalTime = sc.nextLine();

		Bus bus = new Bus();
		bus.setBus_Number(busNumber);
		bus.setTotalSeat(totalSeat);
		bus.setAvailableSeat(availableSeat);
		bus.setDepartureLocation(departureLocation);
		bus.setDepartureTime(departureTime);
		bus.setDepartureDate(departureDate);
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setArrivalTime(arrivalTime);
		bus.setAdmin(admin);  
		bus.setRoute(route);
		busDAO.addBus(bus);
		System.out.println("Bus added successfully!");
	}

	public static void viewBusByNumber() {
		System.out.print("Enter Bus Number to View : ");
		int busNumber = scanner.nextInt();
		Bus bus = busService.getBusByNumber(busNumber);

		if (bus != null) {
			System.out.println("Bus Details: ");
			System.out.println("Bus Number: " + bus.getBus_Number());
			System.out.println("Total Seats: " + bus.getTotalSeat());
			System.out.println("Available Seats: " + bus.getAvailableSeat());
			System.out.println("Departure Location: " + bus.getDepartureLocation());
			System.out.println("Departure Time: " + bus.getDepartureTime());
			System.out.println("Departure Date: " + bus.getDepartureDate());
			System.out.println("Source: " + bus.getSource());
			System.out.println("Destination: " + bus.getDestination());
			System.out.println("Arrival Time: " + bus.getArrivalTime());
		} else {
			System.out.println("No Bus Found with Bus Number: ");
		}
	}

	public static void viewAllBuses() {
		List<Bus> buses = busService.getAllBuses();
		if (buses.isEmpty()) {
			System.out.println("No Buses Available!");
		} else {
			System.out.println("List of All Buses:");
			for (int i = 0; i < buses.size(); i++) {
				Bus bus = buses.get(i);
				System.out.println("Bus Number: " + bus.getBus_Number());
				System.out.println("Total Seats: " + bus.getTotalSeat());
				System.out.println("Available Seats: " + bus.getAvailableSeat());
				System.out.println("Departure Location: " + bus.getDepartureLocation());
				System.out.println("Departure Time: " + bus.getDepartureTime());
				System.out.println("Departure Date: " + bus.getDepartureDate());
				System.out.println("Source: " + bus.getSource());
				System.out.println("Destination: " + bus.getDestination());
				System.out.println("Arrival Time: " + bus.getArrivalTime());
			}
		}
	}

	public static void updateBus() {
		System.out.print("Enter Bus Number to Update : ");
		int busNumber = scanner.nextInt();
		scanner.nextLine(); 

		Bus existingBus = busService.getBusByNumber(busNumber);
		if (existingBus == null) {
			System.out.println("No Bus Found with Bus Number: ");
			return;
		}

		System.out.print("Enter New Total Seats : ");
		existingBus.setTotalSeat(scanner.nextInt());

		System.out.print("Enter New Available Seats : ");
		existingBus.setAvailableSeat(scanner.nextInt());
		scanner.nextLine(); 

		System.out.print("Enter New Departure Location : ");
		existingBus.setDepartureLocation(scanner.nextLine());

		System.out.print("Enter New Departure Time : ");
		existingBus.setDepartureTime(scanner.nextLine());

		System.out.print("Enter New Departure Date : ");
		existingBus.setDepartureDate(scanner.nextLine());

		System.out.print("Enter New Source : ");
		existingBus.setSource(scanner.nextLine());

		System.out.print("Enter New Destination: ");
		existingBus.setDestination(scanner.nextLine());

		System.out.print("Enter New Arrival Time : ");
		existingBus.setArrivalTime(scanner.nextLine());

		busService.updateBus(existingBus);
		System.out.println("Bus Updated Successfully!");
	}

	public static void deleteBus() {
		System.out.print("Enter Bus Number to Delete : ");
		int busNumber = scanner.nextInt();

		Bus existingBus = busService.getBusByNumber(busNumber);
		if (existingBus == null) {
			System.out.println("No Bus Found with Bus Number: ");
			return;
		}

		busService.deleteBus(busNumber);
		System.out.println("Bus Deleted Successfully!");
	}	
}