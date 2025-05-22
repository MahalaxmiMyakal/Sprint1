package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@Column(name = "Bus_Number")
	private int Bus_Number; 
	@Column(name = "Total_Seat")
	private int Total_Seat;
	@Column(name = "Available_Seat")
	private int Available_Seat;
	@Column(name = "Departure_Location")
	private String departureLocation;
	@Column(name = "Departure_Time")
	private String DepartureTime;
	@Column(name = "Departure_Date")
	private String DepartureDate;
	@Column(name = "Source")
	private String Source;
	@Column(name = "Destination")
	private String Destination;
	@Column(name = "Arrival_Time")
	private String ArrivalTime;
	

	@ManyToOne
	@JoinColumn(name = "Admin_ID", nullable = false) 
	private Admin admin;

	@ManyToOne
	@JoinColumn(name = "Route_ID", nullable = false) 
	private Route route;

	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Passenger> passengers;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ticket> tickets;

	public Bus() {}

	public Bus(int bus_Number, int totalSeat, int availableSeat, String departureLocation, String departureTime,
			String departureDate, String source, String destination, String arrivalTime) {
		super();
		Bus_Number = bus_Number;
		Total_Seat = totalSeat;
		Available_Seat = availableSeat;
		this.departureLocation = departureLocation;
		DepartureTime = departureTime;
		DepartureDate = departureDate;
		Source = source;
		Destination = destination;
		ArrivalTime = arrivalTime;
		this.admin = admin;
		this.route = route;
	}

	public int getBus_Number() {
		return Bus_Number;
	}

	public void setBus_Number(int bus_Number) {
		Bus_Number = bus_Number;
	}

	public int getTotalSeat() {
		return Total_Seat;
	}

	public void setTotalSeat(int totalSeat) {
		Total_Seat = totalSeat;
	}

	public int getAvailableSeat() {
		return Available_Seat;
	}

	public void setAvailableSeat(int availableSeat) {
		Available_Seat = availableSeat;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public String getDepartureDate() {
		return DepartureDate;
	}

	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Bus [Bus_Number=" + Bus_Number + ", TotalSeat=" + Total_Seat + ", AvailableSeat=" + Available_Seat
				+ ", departureLocation=" + departureLocation + ", DepartureTime=" + DepartureTime + ", DepartureDate="
				+ DepartureDate + ", Source=" + Source + ", Destination=" + Destination + ", ArrivalTime=" + ArrivalTime
				+ ", admin=" + admin + ", route=" + route + "]";
	}
}