package Service;

import java.util.Iterator;

import Database2.HotelDatabase;
import Entity.Customer;
import Entity.HotelManager;
import Entity.Room;

public class HotelManagerServices {

	
	public static boolean managerLogin(String email, String password) {
		
		if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$") == false) {
		    System.out.println("Invalid email");
		    return false;
		}
		
		if(password.length() < 3) {
			System.out.println("Password must have atleast 4 characters");
			return false;
		}
		
		Iterator<HotelManager> managerIterator = HotelDatabase.hotelManagers.iterator();
        
        while(managerIterator.hasNext()) {
        	HotelManager manager = managerIterator.next();
        	if(manager.email.equals(email)) {
        		if(manager.password.equals(password)) {
        			System.out.println("----------------------------Login Successful------------------------------------");
        			return true;
        		}
        		else {
        			System.out.println("Incorrect Password");
        			return false;
        		}
        	}
        }
        System.out.println("Manager not found");
        return false;
		
	}
	
	public static void showAvailableRooms() {

		System.out.println("Single bed: " + HotelDatabase.singleRoomsCount);
		System.out.println("Double bed: " + HotelDatabase.doubleRoomsCount);
		System.out.println("Triplet bed: " + HotelDatabase.tripletRoomsCount);
	}
	
	public static void seeAllCustomers(){
    	
    	if(HotelDatabase.customers.size() == 0) {
    		System.out.println("No Customers");
    		return;
    	}
    	
    	Iterator<Customer> customer = HotelDatabase.customers.iterator();
		while(customer.hasNext()) {
			System.out.println(customer.next());
		}
		System.out.println();

    }
	
	public static boolean addRoom(String roomNumber, String roomType) {
		
		switch(roomType) {
		
		case "single" :{
			Room room = new Room(roomNumber , roomType);
			
			if(HotelDatabase.singleRooms.containsKey(room)) {

				System.out.println("Room already present");
				return false;
			}
			HotelDatabase.singleRooms.put(room, true);
			HotelDatabase.singleRoomsCount++;
			System.out.println("Room added successfully");
			return true;
		}
		
		case "double" :{
			Room room = new Room(roomNumber , roomType);
			
			if(HotelDatabase.doubleRooms.containsKey(room)) {
				System.out.println("Room already present");
				return  false;
			}
			HotelDatabase.doubleRooms.put(room, true);
			HotelDatabase.doubleRoomsCount++;
			System.out.println("Room added successfully");
			return true;
		}
		
		case "triplet" :{
			Room room = new Room(roomNumber , roomType);
			
			if(HotelDatabase.tripletRooms.containsKey(room)) {
				System.out.println("Room already present");
				return false;
			}
			HotelDatabase.tripletRooms.put(room, true);
			HotelDatabase.doubleRoomsCount++;
			System.out.println("Room added successfully");
			return true;
		}
		
		default:{
			System.out.println("Incorrect choice");
			return false;
		}
		
		
		
		}
		
		
		
	}
	
public static boolean deleteRoom(String roomNumber, String roomType) {
		
		switch(roomType) {
		
		case "single" :{
			Room room = new Room(roomNumber , roomType);
			
			if(HotelDatabase.singleRooms.containsKey(room)) {
				
				System.out.println("Room mil gaya oyeeee");
				
				if(HotelDatabase.singleRooms.get(room) == false) {
					System.out.println("Room is booked, you can't delete the room now");
					return false;
				}
				
				HotelDatabase.singleRooms.remove(room);
				System.out.println("Room removed successfully");
				HotelDatabase.singleRoomsCount--;
				return true;
			}
			
			System.out.println("Room not present");
			return false;
		}
		
		case "double" :{
			Room room = new Room(roomNumber , roomType);
			
			if(HotelDatabase.doubleRooms.containsKey(room)) {
				
				if(HotelDatabase.doubleRooms.get(room) == false) {
					System.out.println("Room is booked, you can't delete the room now");
					return false;
				}
				
				HotelDatabase.doubleRooms.remove(room);
				System.out.println("Room removed successfully");
				HotelDatabase.doubleRoomsCount--;
				return true;
			}
			
			System.out.println("Room not present");
			return false;
		}
		
		case "triplet" :{
			Room room = new Room(roomNumber , roomType);
			
			if(HotelDatabase.tripletRooms.containsKey(room)) {
				
				if(HotelDatabase.tripletRooms.get(room) == false) {
					System.out.println("Room is booked, you can't delete the room now");
					return false;
				}
				
				HotelDatabase.tripletRooms.remove(room);
				System.out.println("Room removed successfully");
				HotelDatabase.tripletRoomsCount--;
				return true;
			}
			
			System.out.println("Room not present");
			return false;
		}
		
		default:{
			System.out.println("Incorrect choice");
			return false;
		}
		
		
		
		}
		
		
		
	}


	public static void changePrice(String roomType, double newPrice) {
		
		if(newPrice < 0) {
			System.out.println("Room price can't be negative");
			return;
		}
		
		switch (roomType) {
		
		case "single": {
			
			Room.singleRoomPrice = newPrice;
			
		}break;
		
		case "double": {
			
			Room.doubleRoomPrice = newPrice;
		}break;
		
		case "triplet": {
			
			Room.tripletRoomPrice = newPrice;
		}break;
		
		default:
			System.out.println("Incorrect input");
			
		}
		
	}


	
	
}
