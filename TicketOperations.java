package operations;

import java.util.List;
import java.util.Scanner;

import models.Bus;
import models.Passenger;
import models.Ticket;
import models.Passenger;
import service.TicketService;
import service.BusService;
import serviceImplementation.BusServiceImpl;
import serviceImplementation.TicketServiceImpl;
import service.PassengerService;
import serviceImplementation.PassengerServiceImpl;

public class TicketOperations {

    static Scanner scanner = new Scanner(System.in);
    static TicketService ticketService = new TicketServiceImpl();
    static BusService busService = new BusServiceImpl();
    static PassengerService passengerService = new PassengerServiceImpl();

    public static void ticketMenu(TicketOperations ticketOops, Passenger loggedInPassenger) {
        while (true) {
            System.out.println("---------- Ticket Management ----------");
            System.out.println("1. View Ticket By Number ");
            System.out.println("2. View All Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                	viewTicketByNumber(loggedInPassenger);
                    break;
                case 2:
                	viewAllTickets();
                    break;
                case 3:
                	cancelTicket(loggedInPassenger);
                    break;
                case 4:
                	return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void bookTicket(Passenger passenger) {
        

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String Date = scanner.nextLine();
        System.out.print("Enter Time (HH:MM): ");
        String Time = scanner.nextLine();
        System.out.print("Enter Source: ");
        String Source = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String Destination = scanner.nextLine();
        System.out.print("Enter Number of Passengers: ");
        int num = scanner.nextInt();

        System.out.print("Enter Ticket Price per passenger: ");
        int price = scanner.nextInt();
        
        int totalPrice = num * price;
        System.out.println(totalPrice);
        System.out.print("Enter Bus Number to book: ");
        int busId = scanner.nextInt();
        Bus bus = busService.getBusByNumber(busId);

        if (bus == null) {
            System.out.println("Bus not found.");
            return;
        }
        Ticket ticket = new Ticket();
        
        ticket.setDate(Date);
        ticket.setTime(Time);
        ticket.setSource(Source);
        ticket.setDestination(Destination);
        ticket.setNumberOfPassengers(num);
        ticket.setTicket_Price(price);
        ticket.setFinal_Price(totalPrice);

        ticket.setBus(bus);
        ticket.setPassenger(passenger);

        ticketService.bookTicket(ticket);
        System.out.println("Ticket booked successfully. Ticket Number: " + ticket.getTicket_Number());
    }

    public static void cancelTicket(Passenger passenger) {
        System.out.print("Enter Ticket Number to cancel: ");
        int ticketNumber = scanner.nextInt();

        // Fetch ticket by ticket number
        Ticket ticket = ticketService.getTicketByTicketNumber(ticketNumber);

        // Check if ticket exists
        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        // Check if this ticket belongs to the logged-in passenger
        if (ticket.getPassenger().getPassenger_ID() != passenger.getPassenger_ID()) {
            System.out.println("You are not authorized to cancel this ticket.");
            return;
        }

        // Proceed to cancel
        ticketService.cancelTicket(ticketNumber);
        System.out.println("Ticket cancelled successfully.");
    }


    public static void viewTicketByNumber(Passenger passenger) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Ticket Number: ");
        int ticketNumber = sc.nextInt();

        Ticket ticket = ticketService.getTicketByTicketNumber(ticketNumber);

        if (ticket == null || ticket.getPassenger().getPassenger_ID() != passenger.getPassenger_ID()) {
            System.out.println("Ticket not found or does not belong to you.");
            return;
        }

        System.out.println("Ticket Number: " + ticket.getTicket_Number());
        System.out.println("Date: " + ticket.getDate());
        System.out.println("Time: " + ticket.getTime());
        System.out.println("Source: " + ticket.getSource());
        System.out.println("Destination: " + ticket.getDestination());
        System.out.println("Passengers: " + ticket.getNumberOfPassengers());
        System.out.println("Price: " + ticket.getFinal_Price());
        System.out.println("Bus No: " + ticket.getBus().getBus_Number());
        System.out.println("---------------");
    }

    
    public static void viewAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
        } else {
            System.out.println("\nAll Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println("Ticket ID: " + ticket.getTicket_Number()
                    + ", Passenger: " + ticket.getPassenger().getName()
                    + ", Bus No: " + ticket.getBus().getBus_Number()
                    + ", From: " + ticket.getSource()
                    + ", To: " + ticket.getDestination()
                    + ", Date: " + ticket.getDate()
                    + ", Time: " + ticket.getTime()
                    + ", Passengers: " + ticket.getNumberOfPassengers()
                    + ", Final Price: " + ticket.getFinal_Price());
            }
        }
    }

}
