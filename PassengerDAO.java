package dao;

import models.Passenger;
import java.util.List;

public interface PassengerDAO {
	void savePassenger(Passenger passenger);
	Passenger getPassengerById(int Passenger_ID);
	List<Passenger> getAllPassengers();
	void updatePassenger(Passenger passenger);
	void deletePassenger(int Passenger_ID);
	Passenger getPassengerByEmailAndPassword(String email, String password);
}