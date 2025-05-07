package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import Database2.HotelDatabase;
import Entity.Booking;
import Entity.Customer;
import Entity.HotelManager;
public class AdminServices {
	
	
	
	public static boolean adminLogin(String email, String password) {
		
		if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$") == false) {
		    System.out.println("Invalid email");
		    return false;
		}
		
		if(password.length() < 3) {
			System.out.println("Password must have atleast 4 characters");
			return false;
		}
		
		if(HotelDatabase.admin.email.equals(email)) {
        	if(HotelDatabase.admin.password.equals(password)) {
        		System.out.println("----------------------------Login Successful------------------------------------");
        		return true;
        	}
        	else {
        		System.out.println("Incorrect Password");
        		return false;
        	}
        }
        else {
        	System.out.println("Email not found");
        	return false;
        }
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

    public static void seeAllHotelManager(){
  
    	if(HotelDatabase.hotelManagers.size() == 0) {
    		System.out.println("No Managers");
    		return;
    	}
    	
        Iterator<HotelManager> i =Database2.HotelDatabase.hotelManagers.iterator();
        while (i.hasNext()) {
            
            System.out.println(i.next());
            
        }
    }
    

    public static void addHotelManager(String name, String email, String password){
    	if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$") == false) {
		    System.out.println("Invalid email");
		    return;
		}
		
		if(password.length() < 3) {
			System.out.println("Password must have atleast 4 characters");
			return;
		}
		
    	HotelManager manager = new HotelManager(name, email, password);
		
		if(HotelDatabase.hotelManagers.contains(manager)) {
			System.out.println("Manager already present");
		}
		else {
			HotelDatabase.hotelManagers.add(manager);
		}

    }

    
    public static boolean removeHotelManager(String email){
        
    	Iterator<HotelManager> manager = HotelDatabase.hotelManagers.iterator();
		while(manager.hasNext()) {
			HotelManager m = manager.next();
			
			if(m.email.equals(email)) {
				HotelDatabase.hotelManagers.remove(m);
				System.out.println("Manager Removed successfully");
				return true;
				
			}
			
		}
		
		return false;

    }

    
    public static boolean removeCustomer(String email, String password){
        
    	Iterator<Customer> cus = HotelDatabase.customers.iterator();
		while(cus.hasNext()) {
			Customer customer = cus.next();
			
			if(customer.email.equals(email)) {
				HotelDatabase.customers.remove(customer);
				System.out.println("Customer Removed successfully");
				return true;
			}
			
		}
		return false;

    }



    public static void seeAllBookings(){
    	
    	if(HotelDatabase.bookingHistory.size() == 0) {
    		System.out.println("No Bookings till now");
    		return;
    	}
    	
    	Iterator<Booking> i = Database2.HotelDatabase.bookingHistory.iterator();
        while (i.hasNext()) {
            
            System.out.println(i.next());
            
        }

    }

    public static void generateReport() throws IOException{
    	
    	File file = new File("Booking Reports.csv");
    	file.createNewFile();
    	FileWriter fw = new FileWriter(file);
    	
    	
    	

    	System.out.println("Under Developement");
    	
    }





}
