package Entity;

import java.util.ArrayList;

public class Booking {
	public Customer customer;
    public ArrayList<Room> bookedRooms;
    public int durationHours;
    
    public Booking(Customer customer, ArrayList<Room> rooms, int duration){
    	this.customer = customer;
    	this.bookedRooms = rooms;
    	this.durationHours = duration;
    }
    
    public String toString() {
    	String rooms = "";
    	for(Room room : this.bookedRooms) {
    		rooms += room + "\n";
    	}
    	return this.customer + "\n" + rooms + "\n" + "Duration: " + durationHours + " days" + "\n\n";
    }
    
    
    
}
