package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Passenger_ID;
	private String Name;
	@Column(name = "passenger_email")
    private String Passenger_Email;
    private String Passenger_Password;
	private String Contact;
	private String Gender;
	private int Age;
	private String Address;
	private String card;
	

	@ManyToOne
	@JoinColumn(name = "Bus_Number", nullable = true)
	private Bus bus;

	@OneToOne(mappedBy = "passenger",  fetch = FetchType.EAGER)
	private Ticket ticket;

	public Passenger() {}

	public Passenger(int passenger_ID, String name, String passenger_email, String passenger_password, String contact,
			String gender, int age, String address, String card, Bus bus, Ticket ticket) {
		super();
		Passenger_ID = passenger_ID;
		Name = name;
		this.Passenger_Email = passenger_email;
		this.Passenger_Password = passenger_password;
		Contact = contact;
		Gender = gender;
		Age = age;
		Address = address;
		this.card = card;
		this.bus = bus;
		this.ticket = ticket;
	}

	public int getPassenger_ID() {
		return Passenger_ID;
	}

	public void setPassenger_ID(int passenger_ID) {
		Passenger_ID = passenger_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassenger_email() {
		return Passenger_Email;
	}

	public void setPassenger_email(String passenger_email) {
		this.Passenger_Email = passenger_email;
	}

	public String getPassenger_password() {
		return Passenger_Password;
	}

	public void setPassenger_password(String passenger_password) {
		this.Passenger_Password = passenger_password;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Passenger [Passenger_ID=" + Passenger_ID + ", Name=" + Name + ", passenger_email=" + Passenger_Email
				+ ", passenger_password=" + Passenger_Password + ", Contact=" + Contact + ", Gender=" + Gender
				+ ", Age=" + Age + ", Address=" + Address + ", card=" + card + ", bus=" + bus + ", ticket=" + ticket
				+ "]";
	}
}