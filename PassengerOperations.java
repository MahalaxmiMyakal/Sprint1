package operations;

import models.Bus;
import models.Passenger;
import service.PassengerService;
import serviceImplementation.PassengerServiceImpl;
import dao.PassengerDAO;
import dao.BusDAO;
import daoImplementation.BusDAOImpl;
import daoImplementation.PassengerDAOImpl;
import java.util.List;
import java.util.Scanner;

public class PassengerOperations {

	private static PassengerService passengerService = new PassengerServiceImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void passengerMenu(PassengerOperations passengerOps) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("---------- Passenger Management ----------");
			System.out.println("1. View Passenger by ID");
			System.out.println("2. View All Passengers");
			System.out.println("3. Update Passenger");
			System.out.println("4. Delete Passenger");
			System.out.println("5. Back to Main Menu");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				passengerOps.viewPassengerById();
				break;
			case 2:
				passengerOps.viewAllPassengers();
				break;
			case 3:
				passengerOps.updatePassenger();
				break;
			case 4:
				passengerOps.deletePassenger();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}

	public static void viewPassengerById() {
		System.out.print("Enter Passenger ID : ");
		int id = scanner.nextInt();
		scanner.nextLine(); 

		Passenger passenger = passengerService.getPassengerById(id);
		if (passenger != null) {
			System.out.println("Passenger Details");
			System.out.println("Name : " + passenger.getName());
			System.out.println("Contact : " + passenger.getContact());
			System.out.println("Gender : " + passenger.getGender());
			System.out.println("Age : " + passenger.getAge());
			System.out.println("Address : " + passenger.getAddress());
			System.out.println("Card : " + passenger.getCard());
		} else {
			System.out.println("Passenger not found!");
		}
	}

	public static void viewAllPassengers() {
		List<Passenger> passengers = passengerService.getAllPassengers();
		if (passengers.isEmpty()) {
			System.out.println("No passengers found!");
		} else {
			System.out.println("All Passengers");
			for (int i = 0; i < passengers.size(); i++) {
				Passenger passenger = passengers.get(i);
				System.out.println("Name : " + passenger.getName());
				System.out.println("Contact : " + passenger.getContact());
				System.out.println("Gender : " + passenger.getGender());
				System.out.println("Age : " + passenger.getAge());
				System.out.println("Address : " + passenger.getAddress());
				System.out.println("Card : " + passenger.getCard());
			}
		}
	}

	public static void updatePassenger() {
		System.out.print("Enter Passenger ID to update : ");
		int id = scanner.nextInt();
		scanner.nextLine(); 

		Passenger passenger = passengerService.getPassengerById(id);
		if (passenger == null) {
			System.out.println("Passenger not found!");
			return;
		}

		System.out.print("Enter New Name : ");
		passenger.setName(scanner.nextLine());

		System.out.print("Enter New Contact : ");
		passenger.setContact(scanner.nextLine());

		System.out.print("Enter New Gender : ");
		passenger.setGender(scanner.nextLine());

		System.out.print("Enter New Age : ");
		passenger.setAge(scanner.nextInt());
		scanner.nextLine();  

		System.out.print("Enter New Address : ");
		passenger.setAddress(scanner.nextLine());

		passengerService.updatePassenger(passenger);
		System.out.println("Passenger updated successfully!");
	}

	public static void deletePassenger() {
		System.out.print("Enter Passenger ID to delete : ");
		int id = scanner.nextInt();
		scanner.nextLine();  

		passengerService.deletePassenger(id);
		System.out.println("Passenger deleted successfully!");
	}
}