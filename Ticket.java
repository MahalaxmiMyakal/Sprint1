package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Ticket_Number;
    private String Date;
    private String Time;
    private String source;
    private String destination;
    private int Number_Of_Passengers;
    private int Ticket_Price;
    private int Final_Price;

    @ManyToOne
    @JoinColumn(name = "Passenger_ID")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "Bus_Number")
    private Bus bus;

    public Ticket() {}
    
	public Ticket(int ticket_Number, String date, String time, String source, String destination,
			int numberOfPassengers, int ticket_Price, int final_Price, Passenger passenger, Bus bus) {
		super();
		Ticket_Number = ticket_Number;
		Date = date;
		Time = time;
		this.source = source;
		this.destination = destination;
		this.Number_Of_Passengers = numberOfPassengers;
		Ticket_Price = ticket_Price;
		Final_Price = final_Price;
		this.passenger = passenger;
		this.bus = bus;
	}

	public int getTicket_Number() {
		return Ticket_Number;
	}

	public void setTicket_Number(int ticket_Number) {
		Ticket_Number = ticket_Number;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumberOfPassengers() {
		return Number_Of_Passengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.Number_Of_Passengers = numberOfPassengers;
	}

	public int getTicket_Price() {
		return Ticket_Price;
	}

	public void setTicket_Price(int ticket_Price) {
		Ticket_Price = ticket_Price;
	}

	public int getFinal_Price() {
		return Final_Price;
	}

	public void setFinal_Price(int final_Price) {
		Final_Price = final_Price;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Ticket [Ticket_Number=" + Ticket_Number + ", Date=" + Date + ", Time=" + Time + ", source=" + source
				+ ", destination=" + destination + ", NumberOfPassengers=" + Number_Of_Passengers + ", Ticket_Price="
				+ Ticket_Price + ", Final_Price=" + Final_Price + ", passenger=" + passenger + ", bus=" + bus + "]";
	}
}