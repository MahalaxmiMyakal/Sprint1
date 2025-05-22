package main;

import java.util.Scanner;
import dao.PassengerDAO;
import models.Passenger;
import operations.BusOperations;
import operations.TicketOperations;
import daoImplementation.PassengerDAOImpl;

public class PassengerLogin {
	
	public static void passengerMenu(Passenger passenger) {
	    Scanner scanner = new Scanner(System.in);
	    TicketOperations ticketOps = new TicketOperations();
	    BusOperations busOps = new BusOperations();

	    while (true) {
	        System.out.println("---------- Passenger Dashboard ----------");
	        System.out.println("1️. View Available Buses");
	        System.out.println("2️. Book a Ticket");
	        System.out.println("3️. View My Tickets");
	        System.out.println("4️. Cancel a Ticket");
	        System.out.println("5️. Logout");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();

	        switch (choice) {
	            case 1:
	                BusOperations.viewAllBuses();
	                break;
	            case 2:
	                TicketOperations.bookTicket(passenger);
	                break;
	            case 3:
	                TicketOperations.viewTicketByNumber(passenger);
	                break;
	            case 4:
	                TicketOperations.cancelTicket(passenger);
	                break;
	            case 5:
	                System.out.println("Logging out...");
	                return;  
	            default:
	                System.out.println("Invalid choice. Try again.");
	        }
	    }
	}

    public static void registerNewPassenger() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Card: ");
        String card = sc.nextLine();
        
        

        Passenger passenger = new Passenger();
        passenger.setName(name);
        passenger.setPassenger_email(email);
        passenger.setPassenger_password(password);
        passenger.setContact(contact);
        passenger.setGender(gender);
        passenger.setAge(age);
        passenger.setAddress(address);
        passenger.setCard(card);

        PassengerDAO passengerDAO = new PassengerDAOImpl();
        passengerDAO.savePassenger(passenger);

        System.out.println("Passenger registered successfully.");
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        PassengerDAO passengerDAO = new PassengerDAOImpl();
        Passenger passenger = passengerDAO.getPassengerByEmailAndPassword(email, password);

        if (passenger != null) {
            System.out.println("Login successful. Welcome, " + passenger.getName() + "!");
            passengerMenu(passenger);
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}