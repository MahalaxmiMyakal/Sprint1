package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Admin_ID;
	private String Name;
	private String Contact;
	private String Admin_Email;
	private String Admin_Password;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Route> routes;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Bus> buses;

	public Admin() {}

	public Admin(int admin_ID, String name, String contact, String admin_Email, String admin_Password,
			List<Route> routes, List<Bus> buses) {
		super();
		Admin_ID = admin_ID;
		Name = name;
		Contact = contact;
		Admin_Email = admin_Email;
		Admin_Password = admin_Password;
		this.routes = routes;
		this.buses = buses;
	}

	public int getAdmin_ID() {
		return Admin_ID;
	}

	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getAdmin_Email() {
		return Admin_Email;
	}

	public void setAdmin_Email(String admin_Email) {
		Admin_Email = admin_Email;
	}

	public String getAdmin_Password() {
		return Admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return "Admin [Admin_ID=" + Admin_ID + ", Name=" + Name + ", Contact=" + Contact + ", Admin_Email="
				+ Admin_Email + ", Admin_Password=" + Admin_Password + ", routes=" + routes + ", buses=" + buses + "]";
	}
}