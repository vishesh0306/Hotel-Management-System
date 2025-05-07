
import java.util.*;
import java.util.Map.Entry;

import Entity.Customer;
import Entity.Room;
import Service.AdminServices;
import Service.CustomerServices;
import Database2.HotelDatabase ;


public class CustomerDriver {

	

    public static void customerPortal(Scanner scanner) {
    	
    	boolean flag = true;
    	

    	
    	while(flag) {
    		
    		System.out.println("-------------------- Welcome to User Portal --------------------");

	        System.out.println("Press 1: Register \nPress 2: Login \nPress 3: Exit");
	
	        String choice = scanner.next();
	
	        switch(choice) {
	        
		        case "1":{
		        	System.out.print("Enter name: ");
			        String name = scanner.next();
			        
		        	System.out.print("Enter email: ");
			        String email = scanner.next();
			        
			        System.out.println("Enter password");
			        String password = scanner.next();
			        
			        System.out.println("Enter age");
			        int age = scanner.nextInt();
			        
			        CustomerServices.customerRegister(name, email, password, age);

			        
		        }break;
	        
	            case "2" :{
	            	
	            	System.out.print("Enter email: ");
			        String email = scanner.next();
			        
			        System.out.println("Enter password");
			        String password = scanner.next();
			        
			        Customer customer = CustomerServices.loginCustomer(email, password);
			        if(customer != null) {
			        	CustomerDriver.customerDriver(scanner, customer);
			        }

	            }break;
	            
	            case "3": {
	            	
	            	flag = false;
	            
	            }break;
	            
	            default:{
	            	System.out.println("Incorrect Choice");
	            }    	
	            
	        }
	    }
 	
    }
    
    public static void customerDriver(Scanner scanner, Customer customer) {
    	
    	boolean flag = true;
		
		while(flag) {
			
			System.out.println();
			System.out.println("Press 1: Show Available Rooms \nPress 2: Show Room Price List \nPress 3: Add Rooms to cart \nPress 4: Show cart \nPress 5: Make Payement \nPress 6: Clear Cart \nPress 7: CheckOut \nPress 8: show My Booked Rooms \nPress 9: Exit");
	        String choice = scanner.next();
	        System.out.println();
	        
	        switch (choice) {
				case "1": {
					
					CustomerServices.showAvailableRooms();
					
					
				}break;
				
				
				case "2": {
					
					CustomerServices.showRoomPricesList();
					
				}break;
				
				case "3": {
					
					System.out.println("Press 1: Book single room \nPress 2: Book double room \nPress 3: Book Triplet room");
					
					int ch = scanner.nextInt();
					CustomerServices service = new CustomerServices();
					
					String roomType = ch == 1? "single" : ch == 2? "double" : ch == 3 ? "triplet" : null;
					
					if(roomType == null) {
						System.out.println("Invalid Input");
						break;
					}
					
					if(service.isRoomAvailable(roomType)) {
						service.addRoomToCart(roomType, customer);
					}
					else {
						System.out.println("Room not available");
					}
					
					
					
						
				}break;
				
				case "4": {
					
					CustomerServices service = new CustomerServices();
					service.showCart(customer);
					
				}break;
				
				case "5" : {
					CustomerServices service = new CustomerServices();
					service.makePayement(customer);
					
				}break;
				
				
				
				case "6" : {
					CustomerServices service = new CustomerServices();
					service.clearCart(customer);
					
				}break;
				
				case "7": {
					
					CustomerServices service = new CustomerServices();
					service.checkOut(customer);
					
				}break;
				
				
				case "8":{
					
					CustomerServices service = new CustomerServices();
					service.showCurrentBookings(customer);
					
				}break;
				
				
				case "9": {
					
					flag = false;
					
				}break;
				
				
				
				default:{
					System.out.println("Incorrect choice");
				}
	
			}
 
		}
    	
    }
    
}
