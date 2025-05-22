package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Route_ID;
	private String Pick_up_Point;
	private String Route_Point;

	@ManyToOne
	@JoinColumn(name = "Admin_ID")
	private Admin admin; 

	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Bus> buses;

	public Route() {}

	public Route(int route_Id, String pick_up_Point, String route_Point, List<Bus> bus) {
		super();
		Route_ID = route_Id;
		Pick_up_Point = pick_up_Point;
		Route_Point = route_Point;
		this.buses = bus;
		this.admin = admin;
	}

	public int getRoute_Id() {
		return Route_ID;
	}

	public void setRoute_Id(int route_Id) {
		Route_ID = route_Id;
	}

	public String getPick_up_Point() {
		return Pick_up_Point;
	}

	public void setPick_up_Point(String pick_up_Point) {
		Pick_up_Point = pick_up_Point;
	}

	public String getRoute_Point() {
		return Route_Point;
	}

	public void setRoute_Point(String route_Point) {
		Route_Point = route_Point;
	}

	public List<Bus> getBus() {
		return buses;
	}

	public void setBus(List<Bus> bus) {
		this.buses = bus;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Route [Route_ID=" + Route_ID + ", Pick_up_Point=" + Pick_up_Point + ", Route_Point=" + Route_Point
				+ ", admin=" + admin + ", buses=" + buses + "]";
	}
}