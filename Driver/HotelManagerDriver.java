import java.util.*;

import Entity.HotelManager;
import Entity.Room;
import Service.HotelManagerServices;
import Database2.*;
public class HotelManagerDriver {
	
	


    public static void managerPortal(Scanner scanner) {
    	
    	boolean flag = true;
    	
        System.out.println("---------------- Welcome to Hotel Manager Portal --------------------------");
        
        while(flag) {
        	
        	
        	System.out.println("Press 1: To Login as Manager \nPress 2: Exit");
	        String choice = scanner.next();
	        System.out.println();
	        
	        switch (choice) {
			case "1": {
				
				System.out.print("Enter email: ");
		        String email = scanner.next();
		        
		        System.out.println("Enter password");
		        String password = scanner.next();
		        
		        Boolean f = HotelManagerServices.managerLogin(email, password);
		        
		        if(f) {
		        	HotelManagerDriver.managerDriver(scanner);
		        }
		        
				
			}break;
			
			case "2": {
				flag = false;
				return;
			}
			default:

				System.out.println("Incorrect Input");

			}

	    }
    }

	public static void managerDriver(Scanner scanner) {
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println();
			System.out.println("Press 1: See available rooms \nPress 2: Add a room in Hotel \nPress 3: Remove a room from Room's Availability \nPress 4: Change room price \nPress 5: Exit");
	        String choice = scanner.next();
	        System.out.println();
	        
	        switch(choice) {
	        
	        	case "1":{
	        		HotelManagerServices.showAvailableRooms();
	        	}break;
	        	
	        	case "2":{
	        		System.out.print("Enter room number: ");
	        		String roomNumber = scanner.next();
	        		
	        		System.out.print("Enter room type: ");
	        		String roomType = scanner.next();
	        		

	        		HotelManagerServices.addRoom(roomNumber, roomType);

	        	}break;
	        	
	        	case "3":{
	        		
	        		System.out.print("Enter room number: ");
	        		String roomNumber = scanner.next();
	        		System.out.print("Enter room type: ");
	        		String roomType = scanner.next();
	        		
	        		HotelManagerServices.deleteRoom(roomNumber, roomType);
	        		
	        	}break;
	        	
	        	case "4":{
	        		System.out.print("Enter roomType: ");
	        		String roomType = scanner.next();
	        		System.out.println("Enter new price: ");
	        		double newPrice = scanner.nextDouble();

	        		HotelManagerServices.changePrice(roomType, newPrice);
	        	}break;
	        	
	        	case "5":{
	        		flag = false;
	        	}break;
	        	
	        	default:{
	        		System.out.println("Incorrect choice");
	        	}
	        }
	        
	        
			
		}
		
	}


}
