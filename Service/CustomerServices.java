package Service;


import Database2.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;

public class CustomerServices {
	
	public static boolean customerRegister(String name, String email, String password, int age) {
		if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$") == false) {
		    System.out.println("Invalid email");
		    return false;
		}
		
		if(password.length() < 3) {
			System.out.println("Password must have atleast 4 characters");
			return false;
		}
		
		if(age < 18) {
			System.out.println();
			System.out.println("You can't book a room. Minimum age 18 is required");
			System.out.println();
			return false;
		}
		
		Iterator<Customer> itr = Database2.HotelDatabase.customers.iterator();

        while(itr.hasNext()) {
        	Customer c = itr.next();
        	
        	if(c.email.equals(email)) {
        		System.out.println("User already exists");
        		return false;
        		
        	}
        }
        
        HotelDatabase.customers.add(new Customer(name, email, password, age));
      	System.out.println("\nRegistration successful\n");
        return true;
		
		
	}
	
	
	public static Customer loginCustomer(String email, String password) {
		
		Iterator<Customer> itr = HotelDatabase.customers.iterator();

        while(itr.hasNext()) {
        	Customer c = itr.next();
        	if(c.email.equals(email)) {
        		if(c.password.equals(password)) {
        			System.out.println();
        			System.out.println("Login Successful");
        			System.out.println();
        			return c;

        		}
        		else {
        			System.out.println();
        			System.out.println("Incorrect password");
        			System.out.println();
        			return null;
        		}
        	}
	
        }
        System.out.println();
        System.out.println("User not exists");
        System.out.println();
        return null;


		
	}


	public static void showAvailableRooms() {

		System.out.println("Single bed: " + HotelDatabase.singleRoomsCount);
		System.out.println("Double bed: " + HotelDatabase.doubleRoomsCount);
		System.out.println("Triplet bed: " + HotelDatabase.tripletRoomsCount);
	}
	
	
	public static void showRoomPricesList() {
		
		System.out.println();
		System.out.println("Single Room Price: " + Room.singleRoomPrice);
		System.out.println("Double Room Price: " + Room.doubleRoomPrice);
		System.out.println("Triplet Room Price: " + Room.tripletRoomPrice);
		System.out.println();
	}
	
	public boolean isRoomAvailable(String roomType) {

		
		if(roomType.toLowerCase().equals("single")){
			return HotelDatabase.singleRoomsCount > 0;
		}
		if(roomType.toLowerCase().equals("double")){
			return HotelDatabase.doubleRoomsCount > 0;
		}
		if(roomType.toLowerCase().equals("triplet")){
			return HotelDatabase.tripletRoomsCount > 0;
		}
		
		return false;
		
	}
	
	
	public void addRoomToCart(String roomType, Customer customer) {
		
		switch(roomType) {
			
			case "single" :{
				
//				HotelDatabase hotelDB = new HotelDatabase(); 
				
				for(Entry<Room, Boolean> room : HotelDatabase.singleRooms.entrySet()) {
					
					if(room.getValue() == true) {
						customer.myCart.customersCart.add(room.getKey());
//						hotelDB.cart.add(room.getKey());
						room.setValue(false);
						HotelDatabase.singleRoomsCount--;
						System.out.println("Room added to cart, check your cart!");
						return;
					}
					
				}
				
			}break;
			
			case "double" : {
				
				
				HotelDatabase hotelDB = new HotelDatabase(); 
				
				for(Entry<Room, Boolean> room : HotelDatabase.doubleRooms.entrySet()) {
					
					if(room.getValue() == true) {
						customer.myCart.customersCart.add(room.getKey());
//						hotelDB.cart.add(room.getKey());
						room.setValue(false);
						HotelDatabase.doubleRoomsCount--;
						System.out.println("Room added to cart, check your cart!");
						return;
					}
					
				}
		
			}break;
			
			case "triplet" :{
				
				HotelDatabase hotelDB = new HotelDatabase(); 
				
				for(Entry<Room, Boolean> room : HotelDatabase.tripletRooms.entrySet()) {
					
					if(room.getValue() == true) {
						customer.myCart.customersCart.add(room.getKey());
//						hotelDB.cart.add(room.getKey());
						room.setValue(false);
						HotelDatabase.tripletRoomsCount--;
						System.out.println("Room added to cart, check your cart!");
						return;
					}
					
				}
				
			}break;

		default : {
			return;
		}
		
		}
		
		
	}
	
	
	public void showCart(Customer customer) {
		
		System.out.println(customer.myCart);

	}
	
	public void makePayement(Customer customer) {
		
		if(customer.myCart.customersCart.isEmpty()) {
			System.out.println("Your cart is empty");
			return;
		}

		HotelDatabase.bookings.add(new Booking(customer, new ArrayList<Room> (customer.myCart.customersCart), 1));
		
		System.out.println();
		System.out.println("Payement Confirmed, Thankyou");
		
		System.out.println("Your rooms are: " + customer.myCart.customersCart);
		System.out.println();
		customer.myCart.customersCart.clear();
	}
	
	public void clearCart(Customer customer) {
		
		if(customer.myCart.customersCart.isEmpty()) {
			System.out.println("Your cart is empty");
			return;
		}
		
		Iterator<Room> itr = customer.myCart.customersCart.iterator();
		
		while(itr.hasNext()) {
			
			Room room = itr.next();
			
			if(room.type.equals("single")) {
				if(HotelDatabase.singleRooms.containsKey(room)) {
					HotelDatabase.singleRoomsCount++;
//					customer.myCart.customersCart.remove(room);
					itr.remove();
					continue;
				}
				else {
					System.out.println("GADBAD HAI BIDHU");
				}
			}
			
			
			else if(room.type.equals("double")) {
				if(HotelDatabase.doubleRooms.containsKey(room)) {
					HotelDatabase.doubleRoomsCount++;
//					customer.myCart.customersCart.remove(room);
					itr.remove();
					continue;
				}
				else {
					System.out.println("GADBAD HAI BIDHU");
				}
			}
			
			else if(room.type.equals("triplet")) {
				if(HotelDatabase.tripletRooms.containsKey(room)) {
					HotelDatabase.tripletRoomsCount++;
					
//					customer.myCart.customersCart.remove(room);
					itr.remove();
					continue;
				}
				else {
					System.out.println("GADBAD HAI BIDHU");
				}
			}
		}
		
	}
	

	
	public void checkOut(Customer customer) {
		
		Iterator<Booking> itr = HotelDatabase.bookings.iterator();
		
		boolean f = false;
		
		while(itr.hasNext()) {
			
			Booking booking = itr.next();
			if(booking.customer.equals(customer)) {
				
//				System.out.println("Customer to mil gaya bhai!!");
				
				f = true;
				
//				System.out.println(booking.bookedRooms);
				
				Iterator<Room> roomItr = booking.bookedRooms.iterator();
		
				while(roomItr.hasNext()) {
					
					Room room = roomItr.next();
//					System.out.println("Room hai: " + room);
					
					if(room.type.equals("single")) {
//						System.out.println("Yes, it's a single room");
						if(HotelDatabase.singleRooms.containsKey(room)) {

							HotelDatabase.singleRoomsCount++;
							HotelDatabase.singleRooms.put(room, true);
							
							continue;
						}
						else {
							System.out.println("GADBAD HAI BIDHU");
						}
					}
					
					else if(room.type.equals("double")) {
//						System.out.println("Yes, it's a double room");
						if(HotelDatabase.doubleRooms.containsKey(room)) {

							HotelDatabase.doubleRoomsCount++;
							HotelDatabase.doubleRooms.put(room, true);
							
							continue;
						}
						else {
							System.out.println("GADBAD HAI BIDHU");
						}
					}
					
					else if(room.type.equals("triplet")) {
//						System.out.println("Yes, it's a triplet room");
						if(HotelDatabase.tripletRooms.containsKey(room)) {
							
							HotelDatabase.tripletRoomsCount++;
							HotelDatabase.tripletRooms.put(room, true);
							
							continue;
						}
						else {
							System.out.println("GADBAD HAI BIDHU");
						}					}	 			
				}
				
				System.out.println("Checkout Confirmed"); 
				HotelDatabase.bookingHistory.add(booking);
				HotelDatabase.bookings.remove(booking);
				break;
			}
				
			
		}
		if(!f){
			System.out.println("You have't booked a room!!");
		}
	
	}
	
	public void showCurrentBookings(Customer customer) {
		
		Iterator<Booking> bookingItr = HotelDatabase.bookings.iterator();
		while(bookingItr.hasNext()) {
			Booking booking = bookingItr.next();
			if(booking.customer.equals(customer)) {
				System.out.println("Your booked rooms are: ");
				System.out.println(booking.bookedRooms);
				return;
			}
			
		}
		System.out.println("You don't have any booked rooms");
		return;
//		if(HotelDatabase.bookings.contains()) {
//			
//		}
//		else {
//			System.out.println("You don't have any current booking");
//		}
		
	}
}
