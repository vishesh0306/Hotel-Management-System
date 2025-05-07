
import java.util.*;

import Service.AdminServices;

public class AdminDriver {

    
    public static void adminPortal(Scanner scanner) {
    	
    	boolean flag = true;

        System.out.println("------------- Welcome to Admin Portal -----------");
        
        while(flag) {
        
	        System.out.println("Press 1: To Login as admin \nPress 2: Exit");
	        String choice = scanner.next();
	        System.out.println();
	        
	        switch (choice) {
			case "1": {
				System.out.print("Enter email: ");
		        String email = scanner.next();
		        
		        System.out.println("Enter password");
		        String password = scanner.next();
		        
		        boolean isAdmin = AdminServices.adminLogin(email, password);
		       
		        if(isAdmin) {
		        	AdminDriver.adminDriver(scanner);
		        }
		       	
			}break;
			
			case "2": {
				flag = false;
				
				
			}break;
			
			default:
				System.out.println("Invalid choice");
			}
	        
	    }
    }
    


	public static void adminDriver(Scanner scanner){
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println();
			System.out.println("Press 1: See all customers \nPress 2: See all Managers \nPress 3: Add new Manager \nPress 4: Remove Manager \nPress 5: Remove Customer \nPress 6: See all Bookings \nPress 7: Generate Report \nPress 8: Exit");
	        String choice = scanner.next();
	        System.out.println();
	        
	        switch (choice) {
			case "1" :{
				
				AdminServices.seeAllCustomers();
				
			}break;
			
			case "2" :{
				
				AdminServices.seeAllHotelManager();
				
			}break;
			
			case "3" :{
				
			
				System.out.print("Enter manager's name: ");
				String name = scanner.next();
				System.out.print("Enter manager's email: ");
				String email = scanner.next();
				System.out.print("Enter manager's pass: ");
				String pass = scanner.next();
				
				AdminServices.addHotelManager(name, email, pass);
				
				
				
			} break;
			
			case "4" :{
				
				System.out.print("Enter manager's email: ");
				String email = scanner.next();
				
				boolean f = AdminServices.removeHotelManager(email);
				
				if(!f) {
					System.out.println("Manager doesnot exist");
				}

			}break;
			
			
			case "5" :{
				
				System.out.print("Enter customer's email: ");
				String email = scanner.next();
				boolean f = AdminServices.removeCustomer(email, email);
				
				if(!f) {
					System.out.println("Customer doesnot exist");
				}
				
				
			}break;
			
			case "6" :{
				
				AdminServices.seeAllBookings();
				
			}break;
			
			case "7" :{
				
				System.out.println("Under developement");
//				AdminServices.generateReport();
				
			}break;
			
			case "8" : {
				
				flag = false;
				
			}break;
			
			default : System.out.println("Incorrect Password");
			
	        
			
		}
		
		
    }
    
}
	}
